package com.example.biologygame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quest4_lvl3 extends AppCompatActivity {
    private List<String> words;
    private String correctWord;
    private String currentGuess = "";
    private TextView wordDescriptionTextView;
    private TextView currentGuessTextView;
    private LinearLayout lettersLayout;
    private CountDownTimer timer;
    private final long TIMER_DURATION = 120000; // 2 minutes in milliseconds
    private int correctGuesses = 0;
    private boolean isDescriptionDisplayed = false; // Flag to track if word description is displayed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest4_lvl3); // Inflate the layout file

        wordDescriptionTextView = findViewById(R.id.word_description);
        currentGuessTextView = findViewById(R.id.current_guess);
        lettersLayout = findViewById(R.id.letters_layout);

        // Initialize words list
        initializeWordsList();

        // Start the game
        startGame();
    }

    private void initializeWordsList() {
        // Initialize the list of words
        words = new ArrayList<>();
        words.add("mitosis");
        words.add("eukaryotic");
        words.add("prokaryotic");
        words.add("cell");
        // Add more biology terms as needed
    }

    private void startGame() {
        // Reset correctGuesses count
        correctGuesses = 0;

        // Start the timer
        startTimer();

        // Get a random word from the list
        correctWord = getRandomWord();

        // If description is not displayed, display word description
        if (!isDescriptionDisplayed) {
            displayWordDescription();
            isDescriptionDisplayed = true;
        }

        // Scramble the word
        scrambleWord();

        // Generate letter buttons
        generateLetterButtons();
    }

    private void displayWordDescription() {
        // Display the description of the current word
        String wordDescription = "";
        switch (correctWord) {
            case "mitosis":
                wordDescription = "A process of cell division that results in two genetically identical daughter cells.";
                break;
            case "eukaryotic":
                wordDescription = "Organisms whose cells have a nucleus enclosed within membranes.";
                break;
            case "prokaryotic":
                wordDescription = "Single-celled organisms that lack a nucleus and other membrane-bound organelles.";
                break;
            case "cell":
                wordDescription = "The basic structural, functional, and biological unit of all known organisms.";
                break;
            // Add more descriptions for other words
        }
        wordDescriptionTextView.setText(wordDescription);
    }

    private String getRandomWord() {
        // Get a random word from the words list
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    private void scrambleWord() {
        // Implementation of word scrambling
        // This code is similar to the previous implementation
        // I'll assume you already have this logic
    }

    private void generateLetterButtons() {
        // Create letter buttons for the current word
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
            correctGuesses++;
        } else {
            currentGuessTextView.setText("Wrong guess. Try again!");
        }
        // Display a new word description if not already displayed
        if (!isDescriptionDisplayed) {
            displayWordDescription();
            isDescriptionDisplayed = true;
        }
    }

    private void startTimer() {
        // Start the 2-minute timer
        timer = new CountDownTimer(TIMER_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update UI with remaining time if needed
            }

            @Override
            public void onFinish() {
                // Show total score or handle timeout event
                showScore();
            }
        }.start();
    }

    private void showScore() {
        // Calculate and show total score
        int score = calculateScore();
        Toast.makeText(this, "Your total score: " + score, Toast.LENGTH_SHORT).show();

        // Start a new game after showing the score
        startGame();
    }

    private int calculateScore() {
        // Calculate the score based on correct guesses and time taken
        int score = (correctGuesses * 10) + (int) (TIMER_DURATION / 1000); // Each correct guess gives 10 points, and each second left adds 1 point
        return score;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}

