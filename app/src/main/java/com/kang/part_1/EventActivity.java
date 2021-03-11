package com.kang.part_1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class EventActivity extends AppCompatActivity {
    // Member Variable
    private final static String TAG = "BUTTON EVENT";
    private LinearLayout space;
    private TextView title;
    private Random rand = new Random();

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //뷰 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_event);

        //디버깅을 위한 로그 출력
        Log.i(TAG, "onCreate()");

        //간단한 메시지 창 출력
        Toast.makeText(EventActivity.this, "BUTTON EVENT", Toast.LENGTH_LONG).show();
        space = (LinearLayout)findViewById(R.id.space_color);
        title = (TextView)findViewById(R.id.textView_title);
    }

    // Member Method - Custom
    public void onClick(View v) {
        if(v.getId() == R.id.button_black) {
            //Toast.makeText(MainActivity.this, "BLACK", Toast.LENGTH_LONG).show();
            space.setBackgroundColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            title.setVisibility(View.GONE);

        } else if(v.getId() == R.id.button_white) {
            //Toast.makeText(MainActivity.this, "WHITE", Toast.LENGTH_LONG).show();
            space.setBackgroundColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            title.setVisibility(View.VISIBLE);
        }

        if(v.getId() == R.id.textView_title) {
            Log.i(TAG, "Title Click");
        }
    }
}