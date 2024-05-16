package com.example.biologygame;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Menu extends AppCompatActivity {

    private Button btnPlay, btnSelectMale,btnNext, btnCancel;
    private ImageButton btnShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enforce landscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_menu);


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
}
