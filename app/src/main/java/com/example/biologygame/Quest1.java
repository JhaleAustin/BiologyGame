package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quest1 extends AppCompatActivity {
    private Button btnLevel1, btnLevel2,btnLevel3, btnLevel4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_quest1);

        btnLevel1 = findViewById(R.id.btnLevel1);

        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quest1.this, Quest1_lvl1.class);
                startActivity(intent);
            }
        });

        btnLevel3 = findViewById(R.id.btnLevel3);

        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quest1.this, Quest1_lvl2.class);
                startActivity(intent);
            }
        });


        btnLevel4 = findViewById(R.id.btnLevel4);

        btnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quest1.this, Quest1_lvl3.class);
                startActivity(intent);
            }
        });
    }
}