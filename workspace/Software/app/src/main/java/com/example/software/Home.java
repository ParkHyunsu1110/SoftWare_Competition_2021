package com.example.software;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Home extends Activity {
    //변수 모음
    Button document, calendar, circlegraph, graph;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);  //현재 사용 xml = home.xml

        //그래프 이동 버튼 할당
        document = findViewById(R.id.document);
        calendar = findViewById(R.id.calendar);
        circlegraph = findViewById(R.id.circlegraph);
        graph = findViewById(R.id.graph);

        //버튼 클릭 시 입출금 부분으로 이동
        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Document.class);
                startActivity(intent2);
            }
        });

        //버튼 클릭 시 캘린더 부분으로 이동
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent3);
            }
        });

        //버튼 클릭 시 원 그래프 부분으로 이동
        circlegraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), Circlegraph.class);
                startActivity(intent4);
            }
        });

        //버튼 클릭 시 그래프 부분으로 이동
        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), Graph.class);
                startActivity(intent5);
            }
        });
       
    }
}