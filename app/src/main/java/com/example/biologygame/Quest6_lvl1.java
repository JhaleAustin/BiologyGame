package com.example.biologygame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Quest6_lvl1 extends AppCompatActivity {
    private ImageView imageView4;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest6_lvl1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        imageView4 = findViewById(R.id.imageView4);
        handler = new Handler();

        // Set the new image and enable the button after 10 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.quest6_lvl1_1); // Replace with your new image resource

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.quest6_lvl1_2); // Replace with your new image resource
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imageView4.setImageResource(R.drawable.quest6_lvl1_3); // Replace with your new image resource
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView4.setImageResource(R.drawable.quest6_lvl1_4); // Replace with your new image resource

                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                imageView4.setImageResource(R.drawable.quest6_lvl1_5); // Replace with your new image resource
                                                handler.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        imageView4.setImageResource(R.drawable.quest6_lvl1_6); // Replace with your new image resource
                                                        handler.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                imageView4.setImageResource(R.drawable.quest6_lvl1_7); // Replace with your new image resource


                                                                handler.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        imageView4.setImageResource(R.drawable.quest6_lvl1_8); // Replace with your new image resource


                                                                    }
                                                                }, 10000); // 10000 milliseconds = 10 seconds


                                                            }
                                                        }, 10000); // 10000 milliseconds = 10 seconds

                                                    }
                                                }, 10000); // 10000 milliseconds = 10 seconds


                                            }
                                        }, 10000); // 10000 milliseconds = 10 seconds


                                    }
                                }, 10000); // 10000 milliseconds = 10 seconds

                            }
                        }, 10000); // 10000 milliseconds = 10 seconds

                    }
                }, 10000); // 10000 milliseconds = 10 seconds

            }
        }, 10000); // 10000 milliseconds = 10 seconds






    }
}