package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutrahallvthree.responseclass.CodeRegisterClass;
import com.example.nutrahallvthree.retrofit.RetrofitService;
import com.example.nutrahallvthree.retrofit.UserApi;

import java.util.Random;
import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {
    TextView textGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        final Random code = new Random();


        Button generateButton = (Button) findViewById(R.id.codeGenerate);

        final TextView textGenerate = (TextView) findViewById(R.id.generated);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will create the random code when the random code button is clicked
                textGenerate.setText(String.valueOf(code.nextInt(10000)));
                if (textGenerate.getText().toString().isEmpty() != true){
                    CodeRegisterClass codeRegisterClass = new CodeRegisterClass(code.nextInt());

                    RetrofitService retrofitService = new RetrofitService();
                    UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

                    userApi.addCode(codeRegisterClass).enqueue(new Callback<CodeRegisterClass>() {
                        @Override
                        public void onResponse(Call<CodeRegisterClass> call, Response<CodeRegisterClass> response) {
                            Toast.makeText(MainActivity3.this, "Please enter code into sign-in station!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<CodeRegisterClass> call, Throwable t) {
                            Toast.makeText(MainActivity3.this, "Please generate a new code", Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }

                                          }
        );
    }

}