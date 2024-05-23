package com.example.biologygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Quest1_lvl3 extends AppCompatActivity {
    private ImageView imageView4,imageView;
    private Handler handler;

    private int[] randomImg = new int[]{
            R.drawable.eukaryote_1, R.drawable.eukaryote_5, R.drawable.eukaryote_7, R.drawable.prokaryote_3, R.drawable.prokaryote_11,
            R.drawable.prokaryote_6, R.drawable.prokaryote_8,
    };

    private boolean[] isProkaryotic = new boolean[]{
            false, false, false, true, true, true, true
    };

    private List<Integer> imageIndexList;
    private int currentIndex = 0;
    private int score = 0;

    private Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest1_lvl3);

        imageView4 = findViewById(R.id.imageView4);
        imageView = findViewById(R.id.imageView);



        btn1 = findViewById(R.id.btnLevel1);
        btn2 = findViewById(R.id.btnLevel2);
        // Create a handler to handle the delay
        handler = new Handler();

        // Set the new image and enable the button after 10 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.quest1_lvl3_next); // Replace with your new image resource

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.quest1_lvl3_blank); // Replace with your new image resource

                        btn1.setEnabled(true);

                        btn2.setEnabled(true);

                        imageView.setVisibility(View.VISIBLE);




                        imageIndexList = new ArrayList<>();
                        for (int i = 0; i < randomImg.length; i++) {
                            imageIndexList.add(i);
                        }
                        Collections.shuffle(imageIndexList);

                        handler = new Handler();

                        displayNextImage();

                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer(false);
                            }
                        });

                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer(true);
                            }
                        });
                    }








                }, 5000); // 10000 milliseconds = 10 seconds



            }
        }, 5000); // 10000 milliseconds = 10 seconds





    }


    private void displayNextImage() {
        if (currentIndex < imageIndexList.size()) {
            int imageIndex = imageIndexList.get(currentIndex);
            imageView.setImageResource(randomImg[imageIndex]);
            imageView.setVisibility(View.VISIBLE);

            btn1.setEnabled(true);
            btn2.setEnabled(true);
        } else {
            showScore();
        }
    }

    private void checkAnswer(boolean selectedProkaryotic) {
        int imageIndex = imageIndexList.get(currentIndex);
        if (isProkaryotic[imageIndex] == selectedProkaryotic) {
            score++;
        }

        currentIndex++;
        btn1.setEnabled(false);
        btn2.setEnabled(false);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayNextImage();
            }
        }, 2000); // 2-second delay between images
    }

    private void showScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz Finished");
        builder.setMessage("Your score: " + score + "/" + randomImg.length);
        builder.setPositiveButton("OK", null);
        builder.show();
    }




}
