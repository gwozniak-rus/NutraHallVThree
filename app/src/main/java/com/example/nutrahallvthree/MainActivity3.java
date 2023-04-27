package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity3 extends AppCompatActivity {

    TextView timeView;
    Button startBTN, stopBTN, resetBTN, sendBTN;

    LocalTime startTime, endTime, totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initializeListeners();

        final Random randomCode = new Random();
        Button generateButton = (Button) findViewById(R.id.codeGenerate);
        final TextView textGenerate = (TextView) findViewById(R.id.generated);


        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will create the random code when the random code button is clicked
                textGenerate.setText(String.valueOf(randomCode.nextInt(10000)));
            }



            //this is where the timer will start and stop.
            //will have a send button that will send the time to database
                                          });

        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //system keep track of the system time when this btn is pressed
                startTime = LocalTime.now();
                String strt = startTime.toString();
                Toast.makeText(MainActivity3.this, "start time" + strt, Toast.LENGTH_SHORT).show();
                //make start say "time has started"
            }
        });
        stopBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                endTime = LocalTime.now();
                String nd = endTime.toString();;
                Toast.makeText(MainActivity3.this, "end time" + nd, Toast.LENGTH_SHORT).show();

            }
        });
        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sendBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

}

//initialize listeners
    private void initializeListeners(){
        startBTN=findViewById(R.id.startBTN);
        stopBTN=findViewById(R.id.stopBTN);
        resetBTN=findViewById(R.id.resetBTN);
        sendBTN=findViewById(R.id.sendBTN);
    }

}