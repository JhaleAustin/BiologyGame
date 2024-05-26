package com.example.biologygame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Quest6_lvl2 extends AppCompatActivity {
    private ViewGroup container;
    private ViewGroup.LayoutParams circleParams;
    private Handler handler;
    private Runnable circleSpawnRunnable;
    private Random random;
    private int score = 0;
    private TextView timerTextView, scoreTextView;
    private long startTime;
    private final int gameTime = 3 * 60 * 1000; // 3 minutes in milliseconds
    private boolean isCurrentObjectEndocytosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest6_lvl2);
        container = findViewById(R.id.container);
        timerTextView = findViewById(R.id.timerTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        handler = new Handler();
        random = new Random();
        circleParams = new ViewGroup.LayoutParams(100, 100); // Circle dimensions

        // Start the game timer
        startTime = System.currentTimeMillis();
        startTimer();

        startSpawningCircles();

        // Set click listeners for Endocytosis and Exocytosis buttons
        Button endocytosisButton = findViewById(R.id.endocytosisButton);
        Button exocytosisButton = findViewById(R.id.exocytosisButton);

        endocytosisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(true); // True indicates Endocytosis
            }
        });

        exocytosisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(false); // False indicates Exocytosis
            }
        });
    }

    private void handleButtonClick(boolean isEndocytosis) {
        // Check if the displayed object type matches the button clicked
        if ((isEndocytosis && isCurrentObjectEndocytosis) || (!isEndocytosis && !isCurrentObjectEndocytosis)) {
            // Player clicked the correct button
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            // Player clicked the wrong button
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
        // Update score display
        scoreTextView.setText("Score: " + score);
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
        // Create a new circle
        View circleView = new View(this);
        circleView.setBackgroundResource(R.drawable.circular_background); // Set background as circle shape

        // Set layout parameters for the circle
        circleView.setLayoutParams(circleParams);

        // Set initial position to be on the right side of the screen
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(circleParams);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        params.topMargin = random.nextInt(container.getHeight() - 100); // Subtract 100 to ensure the circle is fully visible

        // Add circle to the container
        container.addView(circleView, params);

        // Move the circle towards the cells
        moveCircle(circleView);
    }

    private void moveCircle(final View circleView) {
        final int moveSpeed = 10; // Adjust the speed of movement

        TranslateAnimation animation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.0f);

        animation.setDuration(5000); // Adjust the duration of the animation
        animation.setFillAfter(true);
        animation.setRepeatCount(0);

        circleView.startAnimation(animation);

        // Post a delayed action to remove the circle when the animation ends
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                container.removeView(circleView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void startTimer() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                long elapsedTime = System.currentTimeMillis() - startTime;
                long remainingTime = gameTime - elapsedTime;

                if (remainingTime > 0) {
                    long minutes = (remainingTime / 1000) / 60;
                    long seconds = (remainingTime / 1000) % 60;
                    timerTextView.setText(String.format("Time: %02d:%02d", minutes, seconds));
                    handler.postDelayed(this, 1000);
                } else {
                    // Time's up, show victory message
                    Toast.makeText(Quest6_lvl2.this, "Victory! Score: " + score, Toast.LENGTH_SHORT).show();
                    stopGame();
                }
            }
        }, 1000);
    }

    private void stopGame() {
        handler.removeCallbacks(circleSpawnRunnable);
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove callbacks to prevent memory leaks
        handler.removeCallbacks(circleSpawnRunnable);
        handler.removeCallbacksAndMessages(null);
    }
}
