package com.example.softwareproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fragment4 extends Fragment {

    //변수 목록
    Context ct;

    ViewGroup viewGroup;

    TextView mTxtDate;

    Button nowBtn, input4, output4;

    LineChart lineChart1, lineChart2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment4,container,false);
        ct = container.getContext();

        //할당
        mTxtDate = viewGroup.findViewById(R.id.text);

        nowBtn = viewGroup.findViewById(R.id.btnNow);
        input4 = viewGroup.findViewById(R.id.input4);
        output4 = viewGroup.findViewById(R.id.output4);

        //DatePicker
        Calendar c = Calendar.getInstance();

        nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ct, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // TODO Auto-generated method stub

                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year+"-"+(month+1)+"-"+dayOfMonth);
                            mTxtDate.setText(" " + year +"/" + (month+1) + "/" + dayOfMonth);
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();

                if (nowBtn.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });

        //input
        lineChart1 = (LineChart) viewGroup.findViewById(R.id.chart);

        input4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Entry> entries1 = new ArrayList<>();
                entries1.add(new Entry(1, 1));
                entries1.add(new Entry(2, 2));
                entries1.add(new Entry(3, 0));
                entries1.add(new Entry(4, 4));
                entries1.add(new Entry(5, 3));

                LineDataSet lineDataSet1 = new LineDataSet(entries1, "속성명1");
                lineDataSet1.setLineWidth(2);
                lineDataSet1.setCircleRadius(6);
                lineDataSet1.setCircleColor(Color.parseColor("#FF0000"));
                lineDataSet1.setCircleColorHole(Color.BLUE);
                lineDataSet1.setColor(Color.parseColor("#FF0000"));
                lineDataSet1.setDrawCircleHole(true);
                lineDataSet1.setDrawCircles(true);
                lineDataSet1.setDrawHorizontalHighlightIndicator(false);
                lineDataSet1.setDrawHighlightIndicators(false);
                lineDataSet1.setDrawValues(false);

                LineData lineData1 = new LineData(lineDataSet1);
                lineChart1.setData(lineData1);

                XAxis xAxis1 = lineChart1.getXAxis();
                xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis1.setTextColor(Color.BLACK);
                xAxis1.enableGridDashedLine(8, 24, 0);

                YAxis yLAxis1 = lineChart1.getAxisLeft();
                yLAxis1.setTextColor(Color.BLACK);

                YAxis yRAxis1 = lineChart1.getAxisRight();
                yRAxis1.setDrawLabels(false);
                yRAxis1.setDrawAxisLine(false);
                yRAxis1.setDrawGridLines(false);

                Description description1 = new Description();
                description1.setText("");

                lineChart1.setDoubleTapToZoomEnabled(false);
                lineChart1.setDrawGridBackground(false);
                lineChart1.setDescription(description1);
                lineChart1.animateY(2000, Easing.EasingOption.EaseInCubic);
                lineChart1.invalidate();

                MyMarkerView marker1 = new MyMarkerView(ct,R.layout.markerviewtext);
                marker1.setChartView(lineChart1);
                lineChart1.setMarker(marker1);
            }
        });


        //output
        lineChart2 = (LineChart) viewGroup.findViewById(R.id.chart);

        output4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Entry> entries2 = new ArrayList<>();
                entries2.add(new Entry(1, 8));
                entries2.add(new Entry(2, 4));
                entries2.add(new Entry(3, 5));
                entries2.add(new Entry(4, 0));
                entries2.add(new Entry(5, 7));

                LineDataSet lineDataSet2 = new LineDataSet(entries2, "속성명1");
                lineDataSet2.setLineWidth(2);
                lineDataSet2.setCircleRadius(6);
                lineDataSet2.setCircleColor(Color.parseColor("#0000FF"));
                lineDataSet2.setCircleColorHole(Color.RED);
                lineDataSet2.setColor(Color.parseColor("#0000FF"));
                lineDataSet2.setDrawCircleHole(true);
                lineDataSet2.setDrawCircles(true);
                lineDataSet2.setDrawHorizontalHighlightIndicator(false);
                lineDataSet2.setDrawHighlightIndicators(false);
                lineDataSet2.setDrawValues(false);

                LineData lineData2 = new LineData(lineDataSet2);
                lineChart2.setData(lineData2);

                XAxis xAxis2 = lineChart2.getXAxis();
                xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis2.setTextColor(Color.BLACK);
                xAxis2.enableGridDashedLine(8, 24, 0);

                YAxis yLAxis2 = lineChart2.getAxisLeft();
                yLAxis2.setTextColor(Color.BLACK);

                YAxis yRAxis2 = lineChart2.getAxisRight();
                yRAxis2.setDrawLabels(false);
                yRAxis2.setDrawAxisLine(false);
                yRAxis2.setDrawGridLines(false);

                Description description2 = new Description();
                description2.setText("");

                lineChart2.setDoubleTapToZoomEnabled(false);
                lineChart2.setDrawGridBackground(false);
                lineChart2.setDescription(description2);
                lineChart2.animateY(2000, Easing.EasingOption.EaseInCubic);
                lineChart2.invalidate();

                MyMarkerView marker2 = new MyMarkerView(ct,R.layout.markerviewtext);
                marker2.setChartView(lineChart2);
                lineChart2.setMarker(marker2);
            }
        });

        return viewGroup;
    }
}
