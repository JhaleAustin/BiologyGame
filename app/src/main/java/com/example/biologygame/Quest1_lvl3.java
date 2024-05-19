package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Quest1_lvl3 extends AppCompatActivity {
    private ImageView imageView4,imageView;
    private Handler handler;


    private Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest1_lvl3);

        imageView4 = findViewById(R.id.imageView4);
        imageView = findViewById(R.id.imageView);

        // Create a handler to handle the delay
        handler = new Handler();

        // Set the new image and enable the button after 10 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.quest1_lvl3_next); // Replace with your new image resource

            }
        }, 5000); // 10000 milliseconds = 10 seconds


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.quest1_lvl3_blank); // Replace with your new image resource

                btn1.setEnabled(true);

                btn2.setEnabled(true);

                imageView.setVisibility(View.VISIBLE);

            }
        }, 5000); // 10000 milliseconds = 10 seconds




    }
}
