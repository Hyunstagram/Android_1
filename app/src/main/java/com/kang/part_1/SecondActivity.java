package com.kang.part_1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //뷰 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
    }

    // Member Method - Custom
    public void onClick(View v) {
        finish();
    }
}