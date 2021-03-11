package com.kang.part_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RelativeActivity extends AppCompatActivity {
    // Member Variable

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_relative);
    }
}