package com.example.one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name;
    private Button btn_register;
    private Spinner spinner_year, spinner_gender;  // 원래는 생일을 다 받아야하나, 일단 편의 상 년도만 받는 것을 기준으로 작업 수행함.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);

        spinner_year = findViewById(R.id.spinner_year);
        spinner_gender = findViewById(R.id.spinner_gender);

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String userID = et_id.getText().toString();
               String userPass = et_pass.getText().toString();
               String userName = et_name.getText().toString();
               int userBirth = Integer.parseInt(spinner_year.getSelectedItem().toString());
               String userGender = spinner_gender.getSelectedItem().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>()  {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success) {  // 회원 가입이 성공한 경우

                                //알림상자를 만들어서 보여줌
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                builder.setMessage("회원가입에 성공했습니다.")
                                     .setPositiveButton("ok", null)
                                     .create()
                                     .show();

                                Intent intent = new Intent(JoinActivity.this, WelcomeActivity.class);
                                startActivity(intent);
                            }
                            else {  // 회원 가입이 실패한 경우

                                //알림상자를 만들어서 보여줌
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                builder.setMessage("회원가입이 실패했습니다. 입력하신 정보를 확인해주세요.")
                                        .setPositiveButton("ok", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                JoinRequest joinRequest = new JoinRequest(userID, userPass, userName, userBirth, userGender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(joinRequest);

            }

        });
    }
}