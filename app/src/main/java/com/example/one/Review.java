package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Review extends AppCompatActivity {

    Button store;
    Button delete;
    EditText sendData1;
    EditText sendData2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //저장,취소버튼과 원룸이름,내용에디트
        store = findViewById(R.id.store);
        delete = findViewById(R.id.delete);
        sendData1 = findViewById(R.id.setData1);
        sendData2 = findViewById(R.id.setData2);

        //스피너
        final Spinner spinner0 = (Spinner) findViewById(R.id.spinner0);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);

        ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(this, R.array.title, android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner0.setAdapter(adapter0);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.star, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);
        spinner3.setAdapter(adapter1);
        spinner4.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cost, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner5.setAdapter(adapter2);





        //저장 버튼 눌렀을태
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ppt5에서 6으로 보내려는 준비
                Intent intent1 = new Intent(Review.this, ReviewStore.class);

                //원룸이름 에디트
                intent1.putExtra("sendData1", sendData1.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.

                // 내용 에디트
                intent1.putExtra("sendData2", sendData2.getText().toString());// 이 메서드를 통해 데이터를 전달합니다.

                //스피너에서 선택한거 문자로 바꾸는
                String str_spinner0 = spinner0.getSelectedItem().toString();
                String str_spinner1 = spinner1.getSelectedItem().toString();
                String str_spinner2 = spinner2.getSelectedItem().toString();
                String str_spinner3 = spinner3.getSelectedItem().toString();
                String str_spinner4 = spinner4.getSelectedItem().toString();
                String str_spinner5 = spinner5.getSelectedItem().toString();

                intent1.putExtra("ch0", str_spinner0);
                intent1.putExtra("ch1", str_spinner1);
                intent1.putExtra("ch2", str_spinner2);
                intent1.putExtra("ch3", str_spinner3);
                intent1.putExtra("ch4", str_spinner4);
                intent1.putExtra("ch5", str_spinner5);

                //보내요
                startActivity(intent1);


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });
    }
}