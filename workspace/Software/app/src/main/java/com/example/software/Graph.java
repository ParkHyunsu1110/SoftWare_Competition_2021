package com.example.software;

import android.app.Activity;
import androidx.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class Graph extends Activity{

    //변수 모음
    Button btnBack;

    private LineChart lineChart;
    private LineChart lineChart2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphshow);

        //입금
        lineChart = (LineChart)findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, (float) 24.5));
        entries.add(new Entry(2, (float) 15.6));
        entries.add(new Entry(3, (float) 16.4));
        entries.add(new Entry(4, (float) 27.0));
        entries.add(new Entry(5, (float) 17.5));
        entries.add(new Entry(6, (float) 14.2));
        entries.add(new Entry(7, (float) 18.3));
        entries.add(new Entry(8, (float) 10.0));
        entries.add(new Entry(9, (float) 28.9));
        entries.add(new Entry(10, (float) 19.2));

        LineDataSet lineDataSet = new LineDataSet(entries, "입금액");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(2);
        lineDataSet.setCircleColor(Color.parseColor("#FF0000"));
        lineDataSet.setCircleColorHole(Color.RED);
        lineDataSet.setColor(Color.parseColor("#FF0000"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);

        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.animateY(2000, Easing.EasingOption.EaseInCubic);
        lineChart.invalidate();

        MyMarkerView marker = new MyMarkerView(this,R.layout.markerview);
        marker.setChartView(lineChart);
        lineChart.setMarker(marker);

        //출금
        lineChart2 = (LineChart)findViewById(R.id.chart2);

        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(1, (float) 24.7));
        entries2.add(new Entry(2, (float) 18.4));
        entries2.add(new Entry(3, (float) 21.4));
        entries2.add(new Entry(4, (float) 6.9));
        entries2.add(new Entry(5, (float) 35.9));
        entries2.add(new Entry(6, (float) 7.6));
        entries2.add(new Entry(7, (float) 9.2));
        entries2.add(new Entry(8, (float) 20.6));
        entries2.add(new Entry(9, (float) 12.0));
        entries2.add(new Entry(10, (float) 23.3));
        entries2.add(new Entry(11, (float) 84.5));
        entries2.add(new Entry(12, (float) 55.7));
        entries2.add(new Entry(13, (float) 46.9));
        entries2.add(new Entry(14, (float) 58.0));
        entries2.add(new Entry(15, (float) 29.1));
        entries2.add(new Entry(16, (float) 10.2));
        entries2.add(new Entry(17, (float) 21.2));

        LineDataSet lineDataSet2 = new LineDataSet(entries2, "출금액");
        lineDataSet2.setLineWidth(2);
        lineDataSet2.setCircleRadius(2);
        lineDataSet2.setCircleColor(Color.parseColor("#0000FF"));
        lineDataSet2.setCircleColorHole(Color.BLUE);
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

        MyMarkerView marker2 = new MyMarkerView(this,R.layout.markerview);
        marker2.setChartView(lineChart2);
        lineChart2.setMarker(marker2);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

