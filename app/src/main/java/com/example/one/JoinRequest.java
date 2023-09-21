package com.example.one;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class JoinRequest extends StringRequest {

    // 서버 URL 설정 (PHP 연동)
    final static private String URL = "http://seojamo.dothome.co.kr/Register.php";
    private Map<String, String> map;

    // 실제로 가입 요청 패킷을 보내는 부분
    public JoinRequest(String userID, String userPassword, String userName, int userBirth, String userGender, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userBirth",userBirth + "");
        map.put("userGender",userGender);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
