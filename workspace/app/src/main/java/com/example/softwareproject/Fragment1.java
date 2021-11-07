package com.example.softwareproject;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fragment1 extends Fragment {

    //변수 목록
    Context ct;
    EditText log, coast;

    ViewGroup viewGroup;
    RadioGroup choice;

    TextView mTxtDate;
    ListView listView;

    String inputStr, state;

    Button nowBtn, kindBtn, saveBtn;
    RadioButton input1, output1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);
        ct = container.getContext();

        //할당
        choice = viewGroup.findViewById(R.id.choice);

        mTxtDate = viewGroup.findViewById(R.id.text);
        listView = viewGroup.findViewById(R.id.listView);

        nowBtn = viewGroup.findViewById(R.id.btnNow);
        kindBtn = viewGroup.findViewById(R.id.kindBtn);
        saveBtn = viewGroup.findViewById(R.id.saveBtn);

        input1 = viewGroup.findViewById(R.id.input1);
        output1 = viewGroup.findViewById(R.id.output1);

        log = viewGroup.findViewById(R.id.log);
        coast = viewGroup.findViewById(R.id.coast);

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

        //라디오 버튼
        choice.clearCheck();    //클릭된 것이 있다면 지우기.
        choice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if( i == R.id.input1) state = "입금";
                else if( i == R.id.output1) state = "출금";
            }
        });

        //종류 버튼
        kindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[]{"교통비","문화비","식비","쇼핑","정기지출","기타"};
                final int[] selectedIndex = {0};
                AlertDialog.Builder dialog = new AlertDialog.Builder(ct);
                dialog.setTitle("당신이 돈 쓴 이유는?").setSingleChoiceItems(items, 0,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                selectedIndex[0] = which;
                            }
                        }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ct, items[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
            }
        });

        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList) ;

        listView.setAdapter(adapter);

        //저장버튼
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((state == "입금" || state == "출금") && (mTxtDate.length() != 0) && (log.getText() != null) && (coast.getText() != null)){
                    Toast.makeText(getContext(), "사용 내역 갱신", Toast.LENGTH_SHORT).show();
                    inputStr = state + mTxtDate.getText().toString() + " | " +  log.getText().toString() + " | " + coast.getText().toString() + " 원";
                    arrayList.add(inputStr);
                }
                else{
                    Toast.makeText(getContext(), "갱신 오류! 입력 정보를 확인해 주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //지우면 안됨!!
        return viewGroup;
    }
}


