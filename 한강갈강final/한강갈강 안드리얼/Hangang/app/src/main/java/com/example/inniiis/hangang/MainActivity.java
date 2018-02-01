package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static String id;
    private AlertDialog dialog;
    private boolean validate = false;
    String res_120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText idText = (EditText) findViewById(R.id.loginid);
        final EditText passwordText = (EditText) findViewById(R.id.loginpw);

        Button btnologin = (Button)findViewById(R.id.nologin);
        btnologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("!!!! : ", "ok");
                Intent loginIntent = new Intent(MainActivity.this, List2Activity.class);
                MainActivity.this.startActivity(loginIntent);

                /*MyApplication myApp = (MyApplication)getApplication();
                myApp.setmGlobalString(id);

                Log.e("GlobalVariablesActivity", myApp.getmGlobalString());*/
                finish();
            }
        });

        Button btregister = (Button)findViewById(R.id.register);
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        Button btlogin = (Button) findViewById(R.id.login);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = idText.getText().toString();
                String password = passwordText.getText().toString();

                RequestBody body = new FormBody.Builder()
                        .add("id", id)
                        .add("password", password)
                        .build();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://13.124.128.229:3100/login/login")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(new Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        finish();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String responseData = response.body().string();
                        Log.v("BK-201 URL: " , responseData);


                        // wanna save the result to update UI

                        JSONObject Jobject = null;
                        try {
                            Jobject = new JSONObject(responseData);
                            res_120 = Jobject.get("message").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        updateUI(responseData);
                    }
                });
            }

            void updateUI(String string) {
                Log.i("BK-111 : " , res_120);
                Handler mHandler = new Handler(Looper.getMainLooper());
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 내용
                        if(res_120.equals("1")){
                            Toast.makeText(MainActivity.this, "네트워크가 연결되지 않았습니다.", Toast.LENGTH_LONG).show();
                        }
                        if(res_120.equals("2")){
                            Toast.makeText(MainActivity.this, "빈칸 없이 입력해주세요.", Toast.LENGTH_LONG).show();
                        }
                        if(res_120.equals("3")){
                            Toast.makeText(MainActivity.this, "아이디가 조회되지 않습니다.", Toast.LENGTH_LONG).show();
                        }
                        if(res_120.equals("4")){
                            Toast.makeText(MainActivity.this, "회원이 아닙니다.", Toast.LENGTH_LONG).show();
                        }
                        if(res_120.equals("5")){
                            /*MyApplication myApp = (MyApplication)getApplication();
                            myApp.setmGlobalString(id);

                            Log.e("GlobalVariablesActivity", myApp.getmGlobalString());*/
/*
                            CookieSyncManager.createInstance(MainActivity.this);
                            CookieManager cookieManager = CookieManager.getInstance();
                            cookieManager.setCookie("http://13.124.128.229:3100", "cookieKey = value");
                            cookieManager.setCookie("http://13.124.128.229:3100", "cookieKey2 = value2");
                            CookieSyncManager.getInstance().sync();
*/
                            Toast.makeText(MainActivity.this, "로그인 되었습니다.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, ListActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(res_120.equals("6")){
                            Toast.makeText(MainActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 0);
            }
        });
    }
}
