package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

//setting the username and password entries with entries
        //EditText userName, passWord;
        //TextView username =(TextView) findViewById(R.id.username);
       // TextView password =(TextView) findViewById(R.id.passwd);
        //MaterialButton login =(MaterialButton) findViewById(R.id.loginBTN);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()){
                    ResponseRegisterClass responseRegisterClass = new ResponseRegisterClass(firstName.getText().toString(),
                            lastName.getText().toString(),userName.getText().toString(),passWord.getText().toString());

                    UserApi userApi = RetrofitService.getInstance().create(UserApi.class);
                    userApi.getUser(responseRegisterClass).enqueue(new Callback<ResponseClass>() {
                        @Override
                        public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                            if (response.body() != null){
                                Toast.makeText(MainActivity2.this, "Login Successful",
                                        Toast.LENGTH_SHORT).show();
                                Intent intentOne = new Intent(getApplicationContext(),MainActivity3.class);
                                startActivity(intentOne);
                            }

                        }
                        @Override
                        public void onFailure(Call<ResponseClass> call, Throwable t) {
                            Toast.makeText(MainActivity2.this, "Invalid Credentials",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                }












                /*if (username.getText().toString().equals("testuser") && password.getText().toString().equals("testpass")){
                    //login successful
                    //intentOne will go to sign in page when proper credentials are entered
                    Intent intentOne = new Intent(getApplicationContext(),MainActivity3.class);
                    startActivity(intentOne);
                    //here needs to check with database/firebase authenticator


                }else
                    //login unsuccessful message
                    Toast.makeText(MainActivity2.this,"login unsuccessful",Toast.LENGTH_SHORT).show();*/
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