package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Quest1_lvl2 extends AppCompatActivity {

    private ImageView imageView4;
    private Button btnLevel1;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest1_lvl2);

        imageView4 = findViewById(R.id.imageView4);
        btnLevel1 = findViewById(R.id.btnLevel1);

        // Create a handler to handle the delay
        handler = new Handler();

        // Set the new image and enable the button after 10 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.q1_lvl1_next); // Replace with your new image resource
                btnLevel1.setEnabled(true);
            }
        }, 10000); // 10000 milliseconds = 10 seconds


        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView4.setImageResource(R.drawable.prokaryotic); // Replace with your new image resource

                // Create a handler to handle the delay
                handler = new Handler();

                // Set the new image and enable the button after 10 seconds
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.prokaryotic1); // Replace with your new image resource
                    }
                }, 20000); // 10000 milliseconds = 10 seconds




                // Set the new image and enable the button after 10 seconds
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.prokaryotic2); // Replace with your new image resource
                    }
                }, 20000); // 10000 milliseconds = 10 seconds


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.eukaryotic); // Replace with your new image resource
                    }
                }, 2000000); // 10000 milliseconds = 10 seconds

                // Set the new image and enable the button after 10 seconds
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.eukaryotic1); // Replace with your new image resource
                    }
                }, 20000); // 10000 milliseconds = 10 seconds


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.eukaryotic2); // Replace with your new image resource
                    }
                }, 20000); // 10000 milliseconds = 10 seconds



            }
        });
    }
}
