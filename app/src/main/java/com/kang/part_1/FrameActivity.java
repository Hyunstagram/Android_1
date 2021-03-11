package com.kang.part_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {
    // Member Variable

    // View object
    private Button btn_one;
    private Button btn_two;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);

        btn_one = (Button)findViewById(R.id.button_one);
        btn_two = (Button)findViewById(R.id.button_two);
    }

    // Member Method - Custom
    public void onClickOne(View v) {
        btn_one.setVisibility(View.INVISIBLE);
    }

    public void onClickTwo(View v) {
        btn_two.setVisibility(View.INVISIBLE);
    }
}