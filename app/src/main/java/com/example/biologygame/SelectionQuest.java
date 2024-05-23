package com.example.biologygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionQuest extends AppCompatActivity {

    private Button btnLevel1, btnLevel2,btnLevel3, btnLevel4,btnLevel5,btnLevel6,btnLevel7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_selection_quest);
        btnLevel1 = findViewById(R.id.btnLevel1);

        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Quest1.class);
                startActivity(intent);
            }
        });

        btnLevel2 = findViewById(R.id.btnLevel2);

        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Quest2.class);
                startActivity(intent);
            }
        });

        btnLevel3 = findViewById(R.id.btnLevel3);

        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Quest3.class);
                startActivity(intent);
            }
        });


        btnLevel4 = findViewById(R.id.btnLevel4);

        btnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Quest4.class);
                startActivity(intent);
            }
        });

//        btnLevel5 = findViewById(R.id.btnLevel5);

        btnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionQuest.this, Quest4.class);
                startActivity(intent);
            }
        });


//        btnLevel6 = findViewById(R.id.btnLevel6);

//        btnLevel6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SelectionQuest.this, Quest6.class);
//                startActivity(intent);
//            }
//        });


//        btnLevel7 = findViewById(R.id.btnLevel7);

//        btnLevel7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SelectionQuest.this, Quest7.class);
//                startActivity(intent);
//            }
//        });

    }
}