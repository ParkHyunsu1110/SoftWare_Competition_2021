package com.example.software;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Document extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document);  //현재 사용 xml = calendar.xml

        //할당
        choice = findViewById(R.id.choice);

        mTxtDate = findViewById(R.id.text);
        listView = findViewById(R.id.listView);

        nowBtn = findViewById(R.id.btnNow);
        kindBtn = findViewById(R.id.kindBtn);
        saveBtn = findViewById(R.id.saveBtn);

        input1 = findViewById(R.id.input1);
        output1 = findViewById(R.id.output1);

        log = findViewById(R.id.log);
        coast = findViewById(R.id.coast);

        //DatePicker
        java.util.Calendar c = java.util.Calendar.getInstance();

        /*Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                c.set(year,month,dayOfMonth);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                nowBtn.setText(dateFormat.format(c.getTime()));
            }
        }, mYear, mMonth, mDay);

        nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowBtn.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });*/

        nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        try {
                            //Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year+"-"+(month+1)+"-"+dayOfMonth);
                            mTxtDate.setText(" " + year +"/" + (month+1) + "/" + dayOfMonth);
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }, c.get(java.util.Calendar.YEAR), c.get(java.util.Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

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
                AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
                dialog.setTitle("당신이 돈 쓴 이유는?").setSingleChoiceItems(items, 0,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                selectedIndex[0] = which;
                            }
                        }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(view.getContext(), items[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
            }
        });

        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList) ;

        listView.setAdapter(adapter);

        //저장버튼
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((state == "입금" || state == "출금") && (mTxtDate.length() != 0) && (log.getText() != null) && (coast.getText() != null)){
                    Toast.makeText(getApplicationContext(), "사용 내역 갱신", Toast.LENGTH_SHORT).show();
                    inputStr = state + mTxtDate.getText().toString() + " | " +  log.getText().toString() + " | " + coast.getText().toString() + " 원";
                    arrayList.add(inputStr);
                }
                else{
                    Toast.makeText(getApplicationContext(), "갱신 오류! 입력 정보를 확인해 주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}