package com.kang.part_1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConstraintActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "ConstraintActivity";
    private InputMethodManager imm;

    // View Object
    private Button btn_left;
    private TextView text_meg;

    private ConstraintLayout layout_con;
    private CheckBox checkBox;

    private RadioGroup radio_group;
    private RadioButton radio_red;
    private RadioButton radio_blue;

    private EditText edit_enter;
    private Button button_enter;

    // data
    private long initTime;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //뷰 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_constraint);

        init();

        if(D) Log.i(TAG, "onCreate()");
    }

    // Member Method - Custom
    public void init() {
        // View
        imm = (InputMethodManager)this.getSystemService(INPUT_METHOD_SERVICE);

        btn_left = findViewById(R.id.button_left);
        text_meg = findViewById(R.id.textView_msg);

        layout_con = findViewById(R.id.layout_con);
        checkBox = findViewById(R.id.check_item);

        radio_group = findViewById(R.id.radio_group);
        radio_red = findViewById(R.id.radio_red);
        radio_blue = findViewById(R.id.radio_blue);

        edit_enter = findViewById(R.id.edit_enter);
        button_enter = findViewById(R.id.button_enter);

        // View Event Listener

        text_meg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "text_msg - onClick()");
            }
        });

        btn_left.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG, "btn_left - onLongClick()");
                return true;
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "checkBox - CheckedChange : " + isChecked);
                layout_con.setBackgroundColor((isChecked)? Color.CYAN : Color.WHITE);
            }
        });

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i(TAG, "radionGroup = checkedId : " + ((RadioButton)findViewById(checkedId)).getText());
            }
        });

        radio_red.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, "radioButton - CheckedId : " + buttonView.getText());
            }
        });

        edit_enter.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d(TAG, "onEditorAction actionId : " + actionId);
                if(actionId == EditorInfo.IME_ACTION_DONE)
                    imm.hideSoftInputFromWindow(edit_enter.getWindowToken(), 0);
                return true;
            }
        });
    }

    // Member Method - Custom
    public void onClick(View v) {
        imm.hideSoftInputFromWindow(edit_enter.getWindowToken(), 0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "KEY DOWN : " + keyCode);
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_BACK :
                if (System.currentTimeMillis() - initTime > 3000 ) {
                    Log.d(TAG, "Press again to exit.");
                    // 현재시간 저장
                    initTime = System.currentTimeMillis();
                } else {
                    // 3초 이내 두번 눌린 경우 Activity 종료
                    finish();
                }
                return true;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "TOUCH DOWN ( " + event.getX() + "," + event.getY() + ")");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "TOUCH MOVE ( " + event.getX() + "," + event.getY() + ")");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "TOUCH UP ( " + event.getX() + "," + event.getY() + ")");
                break;
        }
        return true;
    }
}