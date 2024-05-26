package com.example.biologygame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quest1_lvl4 extends AppCompatActivity {
    private ImageView imageView4, imageView;
    private Handler handler;
    private int[] randomImg = new int[]{
            R.drawable.animal1, R.drawable.animal2, R.drawable.animal3,
            R.drawable.animal4, R.drawable.animal5, R.drawable.animal6, R.drawable.animal7
    };

    private String[] categories = new String[]{
            "Animal", "Animal", "Protist",
            "Plant", "Fungi", "Protist", "Plant"
    };

    private List<Integer> imageIndexList;
    private int currentIndex = 0;
    private int score = 0;

    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest1_lvl4);
        imageView4 = findViewById(R.id.imageView4);
        imageView = findViewById(R.id.imageView);

        btn1 = findViewById(R.id.btnLevel1);
        btn2 = findViewById(R.id.btnLevel2);
        btn3 = findViewById(R.id.btnLevel3);
        btn4 = findViewById(R.id.btnLevel4);

        // Create a handler to handle the delay
        handler = new Handler();

        // Set the new image and enable the button after 5 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView4.setImageResource(R.drawable.quest4_lvl4_next); // Replace with your new image resource

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView4.setImageResource(R.drawable.quest4_lvl4_blank); // Replace with your new image resource

                        btn1.setEnabled(true);
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);

                        imageView.setVisibility(View.VISIBLE);

                        imageIndexList = new ArrayList<>();
                        for (int i = 0; i < randomImg.length; i++) {
                            imageIndexList.add(i);
                        }
                        Collections.shuffle(imageIndexList);

                        displayNextImage();

                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer("Fungi");
                            }
                        });

                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer("Animal");
                            }
                        });

                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer("Protist");
                            }
                        });

                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer("Plant");
                            }
                        });
                    }
                }, 5000); // 5000 milliseconds = 5 seconds
            }
        }, 5000); // 5000 milliseconds = 5 seconds
    }

    private void displayNextImage() {
        if (currentIndex < imageIndexList.size()) {
            int imageIndex = imageIndexList.get(currentIndex);
            imageView.setImageResource(randomImg[imageIndex]);
            imageView.setVisibility(View.VISIBLE);

            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
        } else {
            showScore();
        }
    }

    private void checkAnswer(String selectedCategory) {
        int imageIndex = imageIndexList.get(currentIndex);
        if (categories[imageIndex].equals(selectedCategory)) {
            score++;
        }

        currentIndex++;
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);

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
