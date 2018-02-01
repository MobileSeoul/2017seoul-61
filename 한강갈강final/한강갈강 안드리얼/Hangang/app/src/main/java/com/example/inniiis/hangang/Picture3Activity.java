package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by inniiis on 2017-06-08.
 */

public class Picture3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture3);

        Button login = (Button) findViewById(R.id.login);
        //예약 경고사항
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Picture3Activity.this, ReservActivity.class);
                startActivity(intent);
            }
        });

    }
}
