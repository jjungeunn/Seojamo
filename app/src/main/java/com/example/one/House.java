package com.example.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class House extends AppCompatActivity {

    private Intent intent;

    private ImageView imageView;
    private TextView textView1;
    private TextView textView2;

    private Button button1;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        intent = getIntent();
        imageView = (ImageView) findViewById(R.id.imageView1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.content1);

        imageView.setImageResource(intent.getIntExtra("imgRes", 0));
        textView1.setText(intent.getStringExtra("titleRes"));
        textView2.setText(intent.getStringExtra("contentRes"));


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(House.this, Review.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(House.this, Reservation.class);
                startActivity(intent);

            }
        });

    }
}