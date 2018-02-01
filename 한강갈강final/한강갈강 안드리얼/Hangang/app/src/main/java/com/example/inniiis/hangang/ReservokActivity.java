package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

/**
 * Created by inniiis on 2017-06-08.
 */

public class ReservokActivity extends AppCompatActivity {
    TextView etuse;
    String druse, area, date, adult, baby, res_120;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservok);

        druse = getIntent().getStringExtra("use");
        area = getIntent().getStringExtra("area");
        date = getIntent().getStringExtra("date");
        adult = getIntent().getStringExtra("adult");
        baby = getIntent().getStringExtra("baby");
        Log.d("check",druse);

        Toast.makeText(this, druse+ area + date + adult + baby, Toast.LENGTH_SHORT).show();

        final TextView etuse = (TextView) findViewById(R.id.use);
        etuse.setText(druse);
        final TextView etarea = (TextView) findViewById(R.id.area);
        etarea.setText(area);
        final TextView etdate = (TextView) findViewById(R.id.date);
        etdate.setText(date);
        final TextView etadult = (TextView) findViewById(R.id.adult);
        etadult.setText(adult);
        final TextView etbaby = (TextView) findViewById(R.id.baby);
        etbaby.setText(baby);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String id = etarea.getText().toString();
                String name = etuse.getText().toString();
                String password = etdate.getText().toString();
                String password2 = etadult.getText().toString();
                String phone = etbaby.getText().toString();

                String user_id = MainActivity.id;
                Log.d("check",user_id);

              //  Toast.makeText(ReservokActivity.this, id + "//" + name + "//" + password + "//" + password2 + "//" + phone, Toast.LENGTH_SHORT).show();

                RequestBody body = new FormBody.Builder()
                        .add("river", id)
                        .add("facility", name)
                        .add("date", password)
                        .add("adult", password2)
                        .add("baby", phone)
                        .add("id", user_id)
                        .build();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://13.124.128.229:3100/book/book")
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
                        Log.v("BK-201 URL: ", responseData);

                        // wanna save the result to update UI

                        JSONObject Jobject = null;
                        try {
                            Jobject = new JSONObject(responseData);
                            res_120 = Jobject.get("message").toString();
                            Log.d("check2", res_120);
                            //Log.d("id" , id);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        updateUI(responseData);
                    }
                });
            }

            void updateUI(String string) {

                Log.i("BK-111 : ", res_120);
                Handler mHandler = new Handler(Looper.getMainLooper());
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 내용
                        if (res_120.equals("1")) {
                            Toast.makeText(ReservokActivity.this, "네트워크가 연결되지 않았습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("2")) {
                            Toast.makeText(ReservokActivity.this, "이용하실 장소를 선택하지 않으셨습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("3")) {
                            Toast.makeText(ReservokActivity.this, "이용하실 시설을 선택하지 않으셨습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("4")) {
                            Toast.makeText(ReservokActivity.this, "날짜를 선택하지 않으셨습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("5")) {
                            Toast.makeText(ReservokActivity.this, "인원 선택을 하지 않으셨습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("7")) {
                            Toast.makeText(ReservokActivity.this, "예약에 실패했습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("8")) {
                            Toast.makeText(ReservokActivity.this, "예약에 성공했습니다. 마이페이지에서 확인해주세요.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ReservokActivity.this, ListActivity.class);
                            finish();
                        }
                        if (res_120.equals("10")) {
                            Toast.makeText(ReservokActivity.this, "이미 예약하셨습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("11")) {
                            Toast.makeText(ReservokActivity.this, "날짜에 해당하는 시설이 없습니다.", Toast.LENGTH_LONG).show();
                        }
                        if (res_120.equals("13")) {
                            Toast.makeText(ReservokActivity.this, "user_id 조회실패.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 0);
            }
        });
    }
}