package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quest4_lvl3 extends AppCompatActivity {
    private String correctWord = "apple";
    private String currentGuess = "";
    private TextView wordDescriptionTextView;
    private TextView currentGuessTextView;
    private LinearLayout lettersLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        wordDescriptionTextView = findViewById(R.id.word_description);
        currentGuessTextView = findViewById(R.id.current_guess);
        lettersLayout = findViewById(R.id.letters_layout);

        displayWordDescription();
        scrambleWord();
        generateLetterButtons();
    }

    private void displayWordDescription() {
        String wordDescription = "A fruit that is commonly red or green and grows on trees.";
        wordDescriptionTextView.setText(wordDescription);
    }

    private void scrambleWord() {
        // Implementation of word scrambling
        // This code is similar to the previous implementation
        // I'll assume you already have this logic
    }

    private void generateLetterButtons() {
        // Create a list of all letters including correct and wrong ones
        List<Character> letters = new ArrayList<>();
        for (char letter : correctWord.toCharArray()) {
            letters.add(letter);
        }
        // Add 2-5 wrong letters
        Random random = new Random();
        for (int i = 0; i < random.nextInt(4) + 2; i++) {
            char wrongLetter = (char) (random.nextInt(26) + 'a');
            letters.add(wrongLetter);
        }
        // Shuffle the letters
        Collections.shuffle(letters);

        // Calculate the number of rows and columns for the grid layout
        int numLetters = letters.size();
        int numRows = (int) Math.ceil(Math.sqrt(numLetters));
        int numCols = (int) Math.ceil((double) numLetters / numRows);

        // Create a circular layout with a grid
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(numRows);
        gridLayout.setColumnCount(numCols);
        gridLayout.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
        gridLayout.setPadding(16, 16, 16, 16);

        // Calculate the size of each button
        int buttonSize = 120;

        // Create buttons for each letter
        for (char letter : letters) {
            Button button = new Button(this);
            button.setLayoutParams(new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f),
                    GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f)));
            button.setText(String.valueOf(letter));
            button.setTextSize(24);
            button.setAllCaps(false);
            button.setBackground(null); // Remove background
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onLetterClicked(v);
                }
            });
            gridLayout.addView(button);
        }

        // Add the circular layout to the main layout
        lettersLayout.addView(gridLayout);
    }


    public void onLetterClicked(View view) {
        Button button = (Button) view;
        String letter = button.getText().toString();
        currentGuess += letter;
        currentGuessTextView.setText(currentGuess);
    }

    public void onDeleteClicked(View view) {
        if (currentGuess.length() > 0) {
            currentGuess = currentGuess.substring(0, currentGuess.length() - 1);
            currentGuessTextView.setText(currentGuess);
        }
    }

    public void onResetClicked(View view) {
        currentGuess = "";
        currentGuessTextView.setText("");
    }

    public void onSubmitClicked(View view) {
        if (currentGuess.equalsIgnoreCase(correctWord)) {
            currentGuessTextView.setText("Correct!");
        } else {
            currentGuessTextView.setText("Wrong guess. Try again!");
        }
    }

}