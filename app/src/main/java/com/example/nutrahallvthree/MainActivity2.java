package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//setting the username and password entries with entries
        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.passwd);

        MaterialButton login =(MaterialButton) findViewById(R.id.loginBTN);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("testuser") && password.getText().toString().equals("testpass")){
                    //login successful
                    //intentOne will go to sign in page when proper credentials are entered
                    Intent intentOne = new Intent(getApplicationContext(),MainActivity3.class);
                    startActivity(intentOne);


                }else
                    //login unsuccessful message
                    Toast.makeText(MainActivity2.this,"login unsuccessful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}