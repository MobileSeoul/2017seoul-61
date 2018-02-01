package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NoticeActivity extends AppCompatActivity {

    String res_120,title, writer, date;
    int check;

    private ListView noticeListView;
    NoticeListAdapter mNoticeListAdapter = new NoticeListAdapter();
    final ArrayList<Notice> noticeList = new ArrayList<>();
    //private NoticeListAdapter adapter;
    //private List<Notice> noticeList;

    private TextView test;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeListView = (ListView)findViewById(R.id.listView);
        noticeListView.setAdapter(mNoticeListAdapter);

        test = (TextView) findViewById(R.id.testText);
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
                Log.v("BK-201 URL: " , responseData);


                // wanna save the result to update UI

                JSONObject Jobject = null;


                try {
                    Jobject = new JSONObject(responseData);
                    res_120 = Jobject.get("message").toString();

                    JSONObject Result = new JSONObject(responseData);
                    String result = Jobject.getString("result");
                    Log.d("result", "response 결과" + result);

                    JSONArray ResultArray = Result.getJSONArray("result");

                    for(int i =0; i<ResultArray.length(); i++) {
                        JSONObject c = ResultArray.getJSONObject(i);
                        title = c.getString("title");
                        writer = c.getString("writer");
                        date = c.getString("notice_date");
                        Log.d("result", "result" +c);
                        Log.d("result", "result" +writer);



//                        Notice notice = new Notice();
//                        notice.title = c.getString("title");
//                        notice.writer = c.getString("writer");
//                        notice.date = c.getString("notice_date");
//
//                        noticeList.add(notice);

                        //noticeList.add(new noticeInfo(""));

                        //mNoticeListAdapter.addItem(title, writer, notice_date);
                        dataSetting(title, writer,date);

                        Log.d("datasetting", "result");

                    }
                    mNoticeListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                updateUI(responseData);
            }
        });
        noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                /*
                 number = String.valueOf(position);
                // get TextView's Text.*/
                Intent intent = new Intent (NoticeActivity.this, WebviewActivity.class) ;
                intent.putExtra("number", number);
                startActivity(intent);

                // TODO : use strText
            }

        });
    }

    private void dataSetting(String title, String writer, String date) {

        mNoticeListAdapter.addItem(title, writer, date);
        //noticeListView.setAdapter(mNoticeListAdapter);
        //noticeListView.setAdapter(mNoticeListAdapter);

    }

    void updateUI(String string) {
        Log.i("BK-111 : " , res_120);
    }
}