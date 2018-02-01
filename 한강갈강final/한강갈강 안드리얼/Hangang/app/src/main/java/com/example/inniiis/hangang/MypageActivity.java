package com.example.inniiis.hangang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class MypageActivity extends AppCompatActivity {

    String res_120, river, facility, date, adult, baby;
   // String user_id = "22";

    private ListView mypageListView;
    MypageListAdapter mMypageListAdapter = new MypageListAdapter();
    final ArrayList<Mypage> mypageList = new ArrayList<>();
    //private NoticeListAdapter adapter;
    //private List<Notice> noticeList;

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        mypageListView = (ListView) findViewById(R.id.mypageListView);
        mypageListView.setAdapter(mMypageListAdapter);

        test = (TextView) findViewById(R.id.testText);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://13.124.128.229:3100/mypage/:user_id")
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

                        river = c.getString("river");
                        facility = c.getString("facility");
                        date = c.getString("date");
                        adult = c.getString("adult");
                        baby = c.getString("baby");
                        // Log.d("result", "result" +c);
                        //Log.d("result", "result" +writer);

                        //mNoticeListAdapter.addItem(title, writer, notice_date);
                        dataSetting(river, facility, date, adult, baby);
                        // Log.d("datasetting", "result");

                    }
                    mMypageListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                updateUI(responseData);
            }
        });
    }


    private void dataSetting(String river, String facility, String date, String adult, String baby) {

        mMypageListAdapter.addItem(river, facility, date, adult, baby);
        //noticeListView.setAdapter(mNoticeListAdapter);

    }

    void updateUI(String string) {
        Log.i("BK-111 : ", res_120);
    }
}