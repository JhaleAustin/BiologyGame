package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Quest6_lvl2 extends AppCompatActivity {
    private ImageView cellImageView;
    private TextView scoreTextView;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest6_lvl2);

        cellImageView = findViewById(R.id.cellImageView);
        scoreTextView = findViewById(R.id.scoreTextView);

        cellImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate a random position for the object
                int objectX = new Random().nextInt(cellImageView.getWidth());
                int objectY = new Random().nextInt(cellImageView.getHeight());

                // Check if the object is inside the cell
                boolean isInCell = isInsideCell(objectX, objectY);

                // Increment score based on user's guess
                if (isInCell) {
                    score++;
                    Toast.makeText(Quest6_lvl2.this, "Correct! Endocytosis", Toast.LENGTH_SHORT).show();
                } else {
                    score--;
                    Toast.makeText(Quest6_lvl2.this, "Incorrect! Exocytosis", Toast.LENGTH_SHORT).show();
                }

                // Update score display
                scoreTextView.setText("Score: " + score);
            }
        });
    }

    // Method to determine if the object is inside the cell
    private boolean isInsideCell(int x, int y) {
        // Get the boundaries of the cell image
        int[] cellLocation = new int[2];
        cellImageView.getLocationOnScreen(cellLocation);
        int cellX = cellLocation[0];
        int cellY = cellLocation[1];
        int cellWidth = cellImageView.getWidth();
        int cellHeight = cellImageView.getHeight();

        // Check if the object's coordinates are within the boundaries of the cell image
        return x >= cellX && x <= cellX + cellWidth && y >= cellY && y <= cellY + cellHeight;
    }
}
