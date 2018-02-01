package com.example.inniiis.hangang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by inniiis on 2017-06-08.
 */

public class NoticedetailActivity extends AppCompatActivity {
    String res_120, title, writer, date, content, num, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticedetail);

        position = getIntent().getStringExtra("number");
//        Toast.makeText(this, position, Toast.LENGTH_SHORT).show();

        final TextView tv_title = (TextView) findViewById(R.id.tv_title);
        final TextView tv_writer = (TextView) findViewById(R.id.tv_writer);
        final TextView tv_date = (TextView) findViewById(R.id.tv_date);
        final TextView tv_content = (TextView) findViewById(R.id.tv_content);


        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://13.124.128.229:3100/notice")
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

                    JSONObject Result = new JSONObject(responseData);
                    String result = Jobject.getString("result");
                    Log.d("result", "response 결과" + result);
                    JSONArray ResultArray = Result.getJSONArray("result");

                    for (int i = 0; i < ResultArray.length(); i++) {
                        JSONObject c = ResultArray.getJSONObject(i);

                        num = c.getString("notice_id");
                        if (num == position) {
                            title = c.getString("title");
                            writer = c.getString("writer");
                            date = c.getString("notice_date");
                            content = c.getString("content");
                            Log.d("result", "result" + c);
                            Log.d("result", "result" + writer);
                        }
                        tv_title.setText(title);
                        tv_writer.setText(writer);
                        tv_date.setText(date);
                        tv_content.setText(content);
//
//                        noticeList.add(notice);

                        //noticeList.add(new noticeInfo(""));

                        //mNoticeListAdapter.addItem(title, writer, notice_date);
//                        dataSetting(title, writer,date);
//                        Log.d("datasetting", "result");


                    }

                    // mNoticeListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                updateUI(responseData);
            }
        });
    }


    //    private void dataSetting(String title, String writer, String date) {
//
//        mNoticeListAdapter.addItem(title, writer, date);
//
//
//        //noticeListView.setAdapter(mNoticeListAdapter);
//
//    }
    void updateUI(String string) {
        Log.i("BK-111 : ", res_120);
    }
}