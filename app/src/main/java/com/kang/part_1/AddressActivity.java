package com.kang.part_1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class AddressActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "AddressActivity";

    // View Object
    private EditText nameETXT, phoneETXT, emailETXT;
    private TextView addressTXT;

    // Data
    private ArrayList<Address> addressList = new ArrayList<>();

    //Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_address);

        //XML View
        nameETXT = findViewById(R.id.edit_name);
        phoneETXT = findViewById(R.id.edit_phone);
        emailETXT = findViewById(R.id.edit_email);
        addressTXT = findViewById(R.id.textView_address);

        if(D) Log.i(TAG, "onCreate()");
    }

    //Member Method - XML onClick Method
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button_add:
                if(nameETXT.getText().length()>0 && phoneETXT.getText().length()>0 && emailETXT.getText().length()>0) {
                    addressList.add(new Address(nameETXT.getText().toString(),
                            phoneETXT.getText().toString(),
                            emailETXT.getText().toString()));
                    Log.i(TAG, "add => "+ addressList.size());

                    // field reset
                    initEXIT();

                    //data output
                    displayAddress();
                }else {
                    Toast.makeText(this, R.string.add_address, Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.button_del:
                if(addressList.size()>0) {
                    int lastIdx = addressList.size() - 1;
                    addressList.remove(lastIdx);

                    //Address output
                    displayAddress();
                }else {
                    Toast.makeText(this, R.string.delete_address, Toast.LENGTH_LONG).show();
                }

                /*
                //Delete all
                if(addressList.size()>0) {
                    addressList.clear();
                    addressTXT.setText(R.string.nothing);
                }else{
                    Toast.makeText(this, R.string.del_msg, Toast.LENGTH_LONG).show();
                }
                */

                break;
        }
    }
    //Member Method - Custom
    //field reset
    private void initEXIT() {
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }

    // AddressList output
    private void displayAddress() {
        String datas = "";
        for (int idx = 0; idx < addressList.size(); idx++) {
            datas += addressList.get(idx).getInfo() + "\n"; //줄 바꿔서 출력
        }

        if(datas.length()>0)
            addressTXT.setText(datas);
        else
            addressTXT.setText(R.string.nothing_address);
    }
}