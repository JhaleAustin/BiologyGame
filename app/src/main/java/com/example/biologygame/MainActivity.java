package com.example.biologygame;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enforce landscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView);

        // Set the video file in the raw folder (assuming it's named "splash_2.mp4")
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_2);
        videoView.setVideoURI(videoUri);

        // Start the video
        videoView.setOnPreparedListener(mp -> mp.start());

        // Transition to menu activity after the video finishes
        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
            // Finish current activity to prevent returning back to splash screen
            finish();
        });
    }
}