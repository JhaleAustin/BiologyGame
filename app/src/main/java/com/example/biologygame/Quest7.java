package com.example.biologygame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Quest7 extends AppCompatActivity {
    private Button btnLevel1, btnLevel2,btnLevel3, btnLevel4;
    private Handler handler;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest7);


        btnLevel1 = findViewById(R.id.btnLevel1);
        imageView4 = findViewById(R.id.imageView3);

        btnLevel1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                imageView4.setImageResource(R.drawable.quest7_intro_lvl1); // Replace with your new image resource

                handler = new Handler();

                // Set the new image and enable the button after 10 seconds
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Quest7.this, Quest7_lvl1.class);
                startActivity(intent);
                    }
                }, 10000); // 10000 milliseconds = 10 seconds

            }
        });

//        btnLevel2 = findViewById(R.id.btnLevel2);
//
//        btnLevel2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Quest6.this, Quest6_lvl2.class);
//                startActivity(intent);
//            }
//        });


    }
}