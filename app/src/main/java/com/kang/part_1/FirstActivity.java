package com.kang.part_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    // Member Variable
    // View object
    private TextView tv;

    //멤버 메소드

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //뷰 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);
        tv = (TextView)findViewById(R.id.textView_main);
    }

    // Member Method - Custom
    public void onClick(View v) {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}