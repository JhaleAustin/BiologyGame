package com.example.biologygame;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button btnPlay, btnSelectMale,btnNext, btnCancel;
    private ImageButton btnShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enforce landscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_menu);



        Intent musicServiceIntent = new Intent(this, MusicService.class);
        startService(musicServiceIntent);


        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, SelectionQuest.class);

                //      Intent intent = new Intent(Menu.this,   Quest4_lvl2.class);
                startActivity(intent);

            }
        });


        btnShop = this.<ImageButton>findViewById(R.id.imageButton);

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Menu.this, SelectionQuest.class);

                Intent intent = new Intent(Menu.this,   Shop.class);
                startActivity(intent);

            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop the music service when the main activity is destroyed
        Intent musicServiceIntent = new Intent(this, MusicService.class);
        stopService(musicServiceIntent);
    }
}
