package com.kang.part_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
    // Member Variable
    private final static String TAG = "FIRST APP";

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //뷰 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view);

        //디버깅을 위한 로그 출력
        Log.i(TAG, "onCreate()");

        //간단한 메시지 창 출력
        Toast.makeText(ViewActivity.this, "My App Create", Toast.LENGTH_LONG).show();
    }

    // Member Method - Custom
    public void onClick(View v) {
        if(v.getId() == R.id.button_cancel)
            Toast.makeText(ViewActivity.this, "CANCEL", Toast.LENGTH_LONG).show();
        else if(v.getId() == R.id.button_ok)
            Toast.makeText(ViewActivity.this, "OK", Toast.LENGTH_LONG).show();
    }
}