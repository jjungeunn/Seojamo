package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReservationStore extends AppCompatActivity {

    Button buttonEvent3;



    TextView receiveView1, receiveView2, receiveView3, receiveView4, receiveView5, receiveView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_store);

        Intent intent = getIntent();

        String receiveStr1 = intent.getExtras().getString("sendData1");// 전달한 값을 받을 때
        receiveView1 = (TextView) findViewById(R.id.receiveText1);
        receiveView1.setText(receiveStr1);

        String receiveStr2 = intent.getExtras().getString("sendData2");// 전달한 값을 받을 때
        receiveView2 = (TextView) findViewById(R.id.receiveText2);
        receiveView2.setText(receiveStr2);

        String receiveStr3 = intent.getExtras().getString("sendData3");// 전달한 값을 받을 때
        receiveView3 = (TextView) findViewById(R.id.receiveText3);
        receiveView3.setText(receiveStr3);

        String receiveStr4 = intent.getExtras().getString("sendData4");// 전달한 값을 받을 때
        receiveView4 = (TextView) findViewById(R.id.receiveText4);
        receiveView4.setText(receiveStr4);

        String receiveStr5 = intent.getExtras().getString("sendData5");// 전달한 값을 받을 때
        receiveView5 = (TextView) findViewById(R.id.receiveText5);
        receiveView5.setText(receiveStr5);

        String receiveStr6 = intent.getExtras().getString("sendData6");// 전달한 값을 받을 때
        receiveView6 = (TextView) findViewById(R.id.receiveText6);
        receiveView6.setText(receiveStr6);

        //취소버튼불러오기
        buttonEvent3 = (Button) findViewById(R.id.buttonEvent3);
        buttonEvent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationStore.this, ppt34MainActivity.class);
                startActivity(intent);

            }
        });


    }
}