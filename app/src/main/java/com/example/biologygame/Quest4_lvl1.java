package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Quest4_lvl1 extends AppCompatActivity {

    private ViewGroup container;
    private ImageView cellImage;
    private Handler handler;
    private Runnable circleSpawnRunnable;
    private Random random;
    private int lives = 3;
    private TextView livesTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest4_lvl1);

        container = findViewById(R.id.container);
        cellImage = findViewById(R.id.cell_image);
        livesTextView = findViewById(R.id.lives_text_view);
        handler = new Handler();
        random = new Random();

        // Display initial lives count
        updateLives();

        startSpawningCircles();
    }

    private void updateLives() {
        livesTextView.setText("Lives: " + lives);
    }

    private void startSpawningCircles() {
        circleSpawnRunnable = new Runnable() {
            @Override
            public void run() {
                spawnCircle();
                handler.postDelayed(this, 2000); // Adjust spawn frequency as needed
            }
        };
        handler.post(circleSpawnRunnable);
    }

    private void spawnCircle() {
        // Create a new circle ImageView
        ImageView circleImage = new ImageView(this);

        // Set image resource
        int circleType = random.nextInt(4); // 0 for d1, 1 for d2, 2 for bacteria, 3 for d3
        switch (circleType) {
            case 0:
                circleImage.setImageResource(R.drawable.d1);
                break;
            case 1:
                circleImage.setImageResource(R.drawable.d2);
                break;
            case 2:
                circleImage.setImageResource(R.drawable.bacteria);
                // Set a click listener for bacteria circles
                circleImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handleBacteriaClick(circleImage);
                    }
                });
                break;
            case 3:
                circleImage.setImageResource(R.drawable.d3);
                break;
        }

        // Set layout parameters for the circle image
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        // Set initial position to be on the right side of the screen
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        params.topMargin = random.nextInt(container.getHeight() - 100); // Subtract 100 to ensure the circle is fully visible

        // Add circleImage to the container
        container.addView(circleImage, params);

        // Move the circle towards the cells
        moveCircle(circleImage);
    }

    private void moveCircle(final ImageView circleImage) {
        final int moveSpeed = 10; // Adjust the speed of movement

        TranslateAnimation animation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f);

        animation.setDuration(5000); // Adjust the duration of the animation
        animation.setFillAfter(true);
        animation.setRepeatCount(0);

        circleImage.startAnimation(animation);

        // Post a delayed action to check for collision when the animation ends
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isColliding(circleImage, cellImage)) {
                    handleCollision(circleImage);
                } else {
                    container.removeView(circleImage);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    // Method to handle click on bacteria circles
    private void handleBacteriaClick(ImageView circleImage) {
        Toast.makeText(this, "Boo!", Toast.LENGTH_SHORT).show();
        container.removeView(circleImage);
    }

    // Method to handle collision between two ImageViews
    private boolean isColliding(ImageView imageView1, ImageView imageView2) {
        int[] location1 = new int[2];
        int[] location2 = new int[2];

        imageView1.getLocationOnScreen(location1);
        imageView2.getLocationOnScreen(location2);

        int imageView1X = location1[0];
        int imageView1Y = location1[1];
        int imageView2X = location2[0];
        int imageView2Y = location2[1];

        return imageView1X < imageView2X + imageView2.getWidth() &&
                imageView1X + imageView1.getWidth() > imageView2X &&
                imageView1Y < imageView2Y + imageView2.getHeight() &&
                imageView1Y + imageView1.getHeight() > imageView2Y;
    }

    // Method to handle collision between circles and cells
    private void handleCollision(ImageView circleImage) {
        // Remove the collided circle
        container.removeView(circleImage);

        // Check if the collided circle is a bacteria
        if (circleImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.bacteria).getConstantState()) {
            // Decrease lives
            lives--;
            updateLives();

            if (lives <= 0) {
                // Display "Game Over" message
                Toast.makeText(this, "Game Over!", Toast.LENGTH_SHORT).show();
                // Optionally, you can take further actions here like restarting the game
            } else {
                // Display "Dead!" message with the current lives count
                Toast.makeText(this, "Dead! Lives: " + lives, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Quest4_lvl1.this, "Yehey!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove callbacks to prevent memory leaks
        handler.removeCallbacks(circleSpawnRunnable);
    }


    }
