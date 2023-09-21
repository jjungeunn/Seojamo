package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Reservation extends AppCompatActivity {

    Button buttonEvent;
    Button buttonEvent2; //취소버튼
    EditText sendData1,sendData2,sendData3, sendData4,sendData5,sendData6; //edit관련

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        buttonEvent = (Button)findViewById(R.id.buttonEvent);
        buttonEvent2 = (Button)findViewById(R.id.buttonEvent2);

        sendData1 = (EditText)findViewById(R.id.edit1);
        sendData2 = (EditText)findViewById(R.id.edit2);
        sendData3 = (EditText)findViewById(R.id.edit3);
        sendData4 = (EditText)findViewById(R.id.edit4);
        sendData5 = (EditText)findViewById(R.id.edit5);
        sendData6 = (EditText)findViewById(R.id.edit6);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Reservation.this, ReservationStore.class);

                intent.putExtra("sendData1",sendData1.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.
                intent.putExtra("sendData2",sendData2.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.
                intent.putExtra("sendData3",sendData3.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.
                intent.putExtra("sendData4",sendData4.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.
                intent.putExtra("sendData5",sendData5.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.
                intent.putExtra("sendData6",sendData6.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.
                startActivity(intent);
            }
        });

        buttonEvent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();


            }
        });

    }
}