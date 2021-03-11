package com.kang.part_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ImageActivity extends AppCompatActivity {
    // Member Variable

    // View object
    private Button btn_click;
    private ImageView imageView;

    // Data
    private int[] img = {R.drawable.cock_image, R.drawable.duck_image, R.drawable.hedgehog_image,
            R.drawable.monkey_image, R.drawable.zebra_image};
    private Random rand = new Random();
    private int num;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_image);

        btn_click = (Button)findViewById(R.id.button_click);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    // Member Method - Custom
    public void onClick(View v) {
        num = rand.nextInt(img.length);
        imageView.setImageResource(img[num]);
    }
}