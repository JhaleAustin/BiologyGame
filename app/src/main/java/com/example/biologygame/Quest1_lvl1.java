package com.example.biologygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class Quest1_lvl1 extends AppCompatActivity {
    private Button btn1, btn2,btn3, btn4;

    private Button btn8, btn10,btn11, btn12,btn13;

    private Button btn19, btn20;

    private String selection="";

    private Button btn8_1, btn8_2,btn8_3,btn8_3_1;

    private Button btn10_1, btn10_2,btn10_3;

    private Button btn13_1, btn13_2,btn13_3;

    private Button btn12_1, btn12_2;

    private Button btn11_1, btn11_2;
    private int correctAnswers = 0;

    private ImageView img1, img2,img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_quest1_lvl1);



        btn1 = findViewById(R.id.button4);
        btn2  = findViewById(R.id.button5);
        btn3  = findViewById(R.id.button6);
        btn4  = findViewById(R.id.button7);



        btn8  = findViewById(R.id.button8);
        btn10  = findViewById(R.id.button10);
        btn11  = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn13  = findViewById(R.id.button13);



        btn8_1  = findViewById(R.id.button14);
        btn8_2 = findViewById(R.id.button15);
        btn8_3 = findViewById(R.id.button16);
        btn8_3_1 = findViewById(R.id.button22);


        btn10_1  = findViewById(R.id.button23);
        btn10_2 = findViewById(R.id.button24);
        btn10_3 = findViewById(R.id.button25);


        btn13_1  = findViewById(R.id.button30);
        btn13_2 = findViewById(R.id.button31);
        btn13_3 = findViewById(R.id.button32);


        btn19 = findViewById(R.id.button19);
        btn20 = findViewById(R.id.button20);


        btn12_1 = findViewById(R.id.button26);
        btn12_2 = findViewById(R.id.button27);

        btn11_1 = findViewById(R.id.button28);
        btn11_2 = findViewById(R.id.button29);


        // Timer implementation
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                // You can display a countdown on the UI if needed
            }

            public void onFinish() {
                // Calculate and show total score
                showResultDialog("Total Score", "Your score: " + correctAnswers);
            }
        }.start();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.q2);
                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.VISIBLE);

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.q3);
                btn2.setVisibility(View.INVISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d1);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);


                btn8.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                btn11.setVisibility(View.VISIBLE);
                btn12.setVisibility(View.VISIBLE);
                btn13.setVisibility(View.VISIBLE);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quest1_lvl1.this, Quest1.class);
                startActivity(intent);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d3);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);


                btn8.setVisibility(View.INVISIBLE);
                btn10.setVisibility(View.INVISIBLE);
                btn11.setVisibility(View.INVISIBLE);
                btn12.setVisibility(View.INVISIBLE);
                btn13.setVisibility(View.INVISIBLE);


                btn12_1.setVisibility(View.VISIBLE);
                btn12_2.setVisibility(View.VISIBLE);

            }
        });


        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d2);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);

                btn8.setVisibility(View.INVISIBLE);
                btn10.setVisibility(View.INVISIBLE);
                btn11.setVisibility(View.INVISIBLE);
                btn12.setVisibility(View.INVISIBLE);
                btn13.setVisibility(View.INVISIBLE);


                btn10_1.setVisibility(View.VISIBLE);
                btn10_2.setVisibility(View.VISIBLE);
                btn10_3.setVisibility(View.VISIBLE);



            }
        });


        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d5);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);

                btn8.setVisibility(View.INVISIBLE);
                btn10.setVisibility(View.INVISIBLE);
                btn11.setVisibility(View.INVISIBLE);
                btn12.setVisibility(View.INVISIBLE);
                btn13.setVisibility(View.INVISIBLE);


                btn13_1.setVisibility(View.VISIBLE);
                btn13_2.setVisibility(View.VISIBLE);
                btn13_3.setVisibility(View.VISIBLE);



            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d4);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);

                btn8.setVisibility(View.INVISIBLE);
                btn10.setVisibility(View.INVISIBLE);
                btn11.setVisibility(View.INVISIBLE);
                btn12.setVisibility(View.INVISIBLE);
                btn13.setVisibility(View.INVISIBLE);


                btn11_1.setVisibility(View.VISIBLE);
                btn11_2.setVisibility(View.VISIBLE);



            }
        });

        btn13_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });
        btn13_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="eukaryotic cell";
            }
        });
        btn13_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });
        btn11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="eukaryotic cell";
            }
        });
        btn11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });
        btn10_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="eukaryotic cell";
            }
        });



        btn12_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });



        btn12_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });

        btn10_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });

        btn10_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.q3);
                btn2.setVisibility(View.INVISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);

            }
        });




        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d1_1);
                btn8.setVisibility(View.INVISIBLE);
                btn8_1.setVisibility(View.VISIBLE);
                btn8_2.setVisibility(View.VISIBLE);
                btn8_3.setVisibility(View.VISIBLE);
                btn19.setVisibility(View.VISIBLE);
                btn20.setVisibility(View.VISIBLE);

            }
        });


        btn8_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1 = findViewById(R.id.imageView3);
                img1.setImageResource(R.drawable.d1_1_1);
                btn8_3.setVisibility(View.INVISIBLE);
                btn8_3_1.setVisibility(View.VISIBLE);

            }
        });

        btn8_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="eukaryotic cell";
            }
        });

        btn8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";

            }
        });

        btn8_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="prokaryotic cell";

            }
        });



        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selection.equals("prokaryotic cell")) {
                    correctAnswers++;
                    showResultDialog("Correct Answer", "The correct answer is: prokaryotic cell");
                } else {
                    showResultDialog("Wrong Answer", "Wrong Answer");
                }
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selection.equals("eukaryotic cell")) {
                    correctAnswers++;
                    showResultDialog("Correct Answer", "The correct answer is: eukaryotic cell");
                } else {
                    showResultDialog("Wrong Answer", "Wrong Answer");
                }
            }
        });



    }


    // Method to show dialog with result message
    private void showResultDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Quest1_lvl1.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}