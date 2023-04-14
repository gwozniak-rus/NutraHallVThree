package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutrahallvthree.responseclass.ResponseClass;
import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;
import com.example.nutrahallvthree.retrofit.RetrofitService;
import com.example.nutrahallvthree.retrofit.UserApi;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    EditText firstName,lastName,userName,passWord;
    MaterialButton loginBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()){
                    ResponseRegisterClass responseRegisterClass = new ResponseRegisterClass(firstName.getText().toString(),
                            lastName.getText().toString(),userName.getText().toString(),passWord.getText().toString());

                    RetrofitService retrofitService = new RetrofitService();
                    UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
                    userApi.getUser(responseRegisterClass).enqueue(new Callback<ResponseRegisterClass>() {
                        @Override
                        public void onResponse(Call<ResponseRegisterClass> call, Response<ResponseRegisterClass> response) {
                            if (response.body() != null){
                                Toast.makeText(MainActivity2.this, "Login Successful",
                                        Toast.LENGTH_SHORT).show();
                                Intent intentOne = new Intent(getApplicationContext(),MainActivity3.class);
                                startActivity(intentOne);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseRegisterClass> call, Throwable t) {
                            Toast.makeText(MainActivity2.this, "Invalid Credentials",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
  private boolean validateFields() {
      if (TextUtils.isEmpty (firstName.getText().toString())
              && TextUtils.isEmpty( lastName.getText().toString())
              && TextUtils.isEmpty( userName.getText().toString())
              && TextUtils.isEmpty( passWord.getText().toString())) {
          Toast.makeText(MainActivity2.this, "Please fill in all required fields!", Toast.LENGTH_SHORT).show();
      }
      return true;
  }
  private void initializeListeners(){
        userName=findViewById(R.id.userName);
        passWord=findViewById(R.id.passWord);
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);
        loginBTN=findViewById(R.id.loginBTN);
  }
}