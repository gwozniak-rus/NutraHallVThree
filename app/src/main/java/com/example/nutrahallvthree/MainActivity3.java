package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Stack;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        final Random randomCode = new Random();

        Button generateButton = (Button) findViewById(R.id.codeGenerate);

        final TextView textGenerate = (TextView) findViewById(R.id.generated);
        generateButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  //this will create the random code when the random code button is clicked
                                                  textGenerate.setText(String.valueOf(randomCode.nextInt(10000)));

                                              }

                                              //need something to start the timer on this application

                                              //then, will complete the time loop and send to database
                                              //total time will be compiled at end of week and shown to user
                                          }
        );
    }
}