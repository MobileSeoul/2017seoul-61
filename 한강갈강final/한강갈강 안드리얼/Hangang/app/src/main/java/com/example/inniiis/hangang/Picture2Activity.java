package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by inniiis on 2017-06-08.
 */

public class Picture2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture2);

        Button login = (Button) findViewById(R.id.login);
        //nologin 예약할때 로그인하세요
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Picture2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
