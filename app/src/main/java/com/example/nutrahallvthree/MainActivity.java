package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText userName;
    EditText passWord;

    MaterialButton login;

    MaterialButton signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        userName = findViewById(R.id.username);
        passWord = findViewById(R.id.passwd);
        login = findViewById(R.id.loginBTN);
        signup = findViewById(R.id.signBTN);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}