package com.example.inniiis.hangang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by inniiis on 2017-06-08.
 */

public class DtinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtinfo);

        Button call = (Button) findViewById(R.id.call);
        Button enjoy = (Button) findViewById(R.id.enjoy);

        Intent intent = getIntent();
        int infocheck = intent.getIntExtra("infocheck", 0);

        ImageView info = (ImageView) findViewById(R.id.infoimage);
        if (infocheck == 1) {
            info.setImageResource(R.drawable.info1);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-2666-8290")); //강서
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S1Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 2) {
            info.setImageResource(R.drawable.info2);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-306-0276")); //난지
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S2Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 3) {
            info.setImageResource(R.drawable.info3);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-2631-8290")); //양화
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S3Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 4) {
            info.setImageResource(R.drawable.info4);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-333-4125")); //망원
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S4Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 5) {
            info.setImageResource(R.drawable.info5);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-782-2895")); //여의도
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S5Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 6) {
            info.setImageResource(R.drawable.info6);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-790-1891")); //이촌
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S6Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 7) {
            info.setImageResource(R.drawable.info7);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-591-5943")); //반포
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S7Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 8) {
            info.setImageResource(R.drawable.info8);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-534-3263")); //잠원
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S8Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 9) {
            info.setImageResource(R.drawable.info9);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-3780-0521")); //뚝섬
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S9Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 10) {
            info.setImageResource(R.drawable.info10);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-417-1348")); //잠실
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S10Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 11) {
            info.setImageResource(R.drawable.info11);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-485-3091")); //광나루
                    startActivity(intent);
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S11Activity.class);
                    startActivity(intent);
                }
            });
        }

    }
}
