package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReviewStore extends AppCompatActivity{

    //에디트에서 쓴것을 보는 거랑 뒤로 버튼
    TextView receivetextView1;
    TextView receivetextView2;
    Button back;

    TextView receiveView0, receiveView1, receiveView2, receiveView3, receiveView4, receiveView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_store);


        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ReviewStore.this, ppt34MainActivity.class);
                startActivity(intent);

            }
        });

        //내용에디트에서 작성한 글 보여주는 과정
        Intent intent1 = getIntent();
        String receiveStr1 = intent1.getExtras().getString("sendData1");// 전달한 값을 받을 때
        receivetextView1 = (TextView) findViewById(R.id.receiveText1);
        receivetextView1.setText(receiveStr1);

        //내용에디트에서 작성한 글 보여주는 과정
        Intent intent2 = getIntent();
        String receiveStr2 = intent2.getExtras().getString("sendData2");// 전달한 값을 받을 때
        receivetextView2 = (TextView) findViewById(R.id.receiveText2);
        receivetextView2.setText(receiveStr2);


        //스피너에서 선택한 값을 보여주는 과정
        Intent it = getIntent();

        String season_year0 = it.getStringExtra("ch0");
        receiveView0 = (TextView) findViewById(R.id.textstar0);
        receiveView0.setText(season_year0);

        String season_year1 = it.getStringExtra("ch1");
        receiveView1 = (TextView) findViewById(R.id.textstar1);
        receiveView1.setText(season_year1);

        String season_year2 = it.getStringExtra("ch2");
        receiveView2 = (TextView) findViewById(R.id.textstar2);
        receiveView2.setText(season_year2);

        String season_year3 = it.getStringExtra("ch3");
        receiveView3 = (TextView) findViewById(R.id.textstar3);
        receiveView3.setText(season_year3);

        String season_year4 = it.getStringExtra("ch4");
        receiveView4 = (TextView) findViewById(R.id.textstar4);
        receiveView4.setText(season_year4);

        String season_year5 = it.getStringExtra("ch5");
        receiveView5 = (TextView) findViewById(R.id.textstar5);
        receiveView5.setText(season_year5);


    }


    }
