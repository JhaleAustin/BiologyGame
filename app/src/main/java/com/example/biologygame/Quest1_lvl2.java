package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Quest1_lvl2 extends AppCompatActivity {

    private ImageView imageView4;
    private Button btnLevel1,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,
            guest1, guest2, guest3, guest4, guest5, guest6, guest7, guest8;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_quest1_lvl2);

        imageView4 = findViewById(R.id.imageView4);
        btnLevel1 = findViewById(R.id.btnLevel1);


        btn1 = findViewById(R.id.prokaryoticG1);
        btn2 = findViewById(R.id.prokaryoticG2);
        btn3 = findViewById(R.id.prokaryoticG3);
        btn4 = findViewById(R.id.prokaryoticG4);
        btn5 = findViewById(R.id.prokaryotic5);
        btn6 = findViewById(R.id.prokaryoticG6);
        btn7 = findViewById(R.id.prokaryoticG7);
        btn8 = findViewById(R.id.prokaryoticG8);

        guest1 = findViewById(R.id.Flagellum);
        guest2 = findViewById(R.id.Cytoplasm);
        guest3 = findViewById(R.id.Mesoome);
        guest4 = findViewById(R.id.plasmaMembrane);
        guest5 = findViewById(R.id.cellwall);
        guest6 = findViewById(R.id.ribosomes);
        guest7 = findViewById(R.id.capsule);
       guest8 = findViewById(R.id.dna);


        // Create a handler to handle the delay
        handler = new Handler();

        // Set the new image and enable the button after 10 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.q1_lvl1_next); // Replace with your new image resource
                btnLevel1.setEnabled(true);


                btnLevel1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        imageView4.setImageResource(R.drawable.prokaryotic); // Replace with your new image resource
                        btnLevel1.setEnabled(false);

                        // Create a handler to handle the delay
                        handler = new Handler();

                        // Set the new image and enable the button after 10 seconds
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imageView4.setImageResource(R.drawable.prokaryotic1); // Replace with your new image resource


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView4.setImageResource(R.drawable.prokaryotic2); // Replace with your new image resource






                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {


                                                imageView4.setImageResource(R.drawable.eukaryotic); // Replace with your new image resource
                                                handler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        imageView4.setImageResource(R.drawable.eukaryotic1); // Replace with your new image resource
                                                        handler.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                imageView4.setImageResource(R.drawable.eukaryotic2); // Replace with your new image resource
                                                            }
                                                        }, 5000); // 10000 milliseconds = 10 seconds
                                                    }
                                                }, 5000); // 10000 milliseconds = 10 seconds
                                            }
                                        }, 5000); // 10000 milliseconds = 10 seconds

                                        // Set the new image and enable the button after 10 seconds







                                    }
                                }, 2000); // 10000 milliseconds = 10 seconds



                            }
                        }, 5000); // 10000 milliseconds = 10 seconds





                    }});
            }
        }, 5000); // 10000 milliseconds = 10 seconds



    }
}
