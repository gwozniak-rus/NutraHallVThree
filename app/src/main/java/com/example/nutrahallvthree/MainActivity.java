package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;
import com.example.nutrahallvthree.retrofit.RetrofitService;
import com.example.nutrahallvthree.retrofit.UserApi;
import com.google.android.material.button.MaterialButton;


import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText firstname,lastname,username,password;
    MaterialButton toLoginBTN,signBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeListeners();



        toLoginBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }
        });

        //signup handler
        signBTN.setOnClickListener(new View.OnClickListener() {
            //getting the text from the edit text boxes

            @Override
            public void onClick(View view) {
                if (validateFields()){
                    ResponseRegisterClass responseRegisterClass =
                            new ResponseRegisterClass(firstname.getText().toString(),
                                    lastname.getText().toString(),
                                    username.getText().toString(),
                                    password.getText().toString());

                    RetrofitService retrofitService = new RetrofitService();
                UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

                userApi.addUser(responseRegisterClass).enqueue(new Callback<ResponseRegisterClass>(){
                    @Override
                    public void onResponse(Call<ResponseRegisterClass> call, Response<ResponseRegisterClass> response) {
                        if (response.body() != null){
                            Toast.makeText(MainActivity.this, "Registered User", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, MainActivity2.class));
                            finish();
                        }else {
                            Toast.makeText(MainActivity.this, "Something went wrong, make sure" +
                                    "all field are filled!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"error occurred", response);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseRegisterClass> call, Throwable t) {

                    }
                });

               ;
                }

            }

        });

    }
   private boolean validateFields(){
        if (TextUtils.isEmpty(firstname.getText().toString())
                && TextUtils.isEmpty(lastname.getText().toString())
                && TextUtils.isEmpty(username.getText().toString())
                && TextUtils.isEmpty(password.getText().toString())){
            Toast.makeText(MainActivity.this, "Please fill in all required fields!", Toast.LENGTH_SHORT).show();
    }return true;
}
    private void initializeListeners(){
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signBTN=findViewById(R.id.signBTN);
        toLoginBTN=findViewById(R.id.toLoginBTN);
    }
}