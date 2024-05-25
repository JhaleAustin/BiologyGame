package com.example.biologygame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quest7_lvl1 extends AppCompatActivity {

    private TextView timerTextView;
    private GridLayout gridLayout;
    private int score = 0;
    private final long timerDuration = 60000L; // 3 minutes in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest7_lvl1);

        timerTextView = findViewById(R.id.timerTextView);
        gridLayout = findViewById(R.id.gridLayout);




                setupGame();
        startTimer();

    }

    private void setupGame() {
        List<Integer> cellImages = new ArrayList<>();
        int cellCount = gridLayout.getColumnCount() * gridLayout.getRowCount();
        Random random = new Random();

        for (int i = 0; i < cellCount; i++) {
            cellImages.add(random.nextBoolean() ? R.drawable.cell_grown : R.drawable.cell_not_grown);
        }

        for (int i = 0; i < cellCount; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(cellImages.get(i));
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = 0;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            imageView.setLayoutParams(params);
            int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cellImages.get(finalI) == R.drawable.cell_not_grown) {
                        score++;
                        imageView.setVisibility(View.INVISIBLE); // or change image to indicate it's clicked
                    }
                }
            });
            gridLayout.addView(imageView);
        }
    }

    private void startTimer() {
        new CountDownTimer(timerDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished % 60000) / 1000;
                timerTextView.setText(String.format("%02d:%02d", minutes, seconds));
            }

            @Override
            public void onFinish() {
                timerTextView.setText("00:00");
                // End game logic, e.g., show score
                gridLayout.setVisibility(View.GONE);
                timerTextView.setText("Score: " + score);
            }
        }.start();
    }
}
