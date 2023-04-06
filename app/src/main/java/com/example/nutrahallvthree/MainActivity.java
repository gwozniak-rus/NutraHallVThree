package com.example.nutrahallvthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutrahallvthree.responseclass.ResponseClass;
import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;
import com.example.nutrahallvthree.retrofit.RetrofitService;
import com.example.nutrahallvthree.retrofit.UserApi;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText firstName,lastName,userName,passWord;
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
            @Override
            public void onClick(View view) {
                if (validateFields()){
                    ResponseRegisterClass responseRegisterClass =
                            new ResponseRegisterClass(firstName.getText().toString(),lastName.getText().toString(),
                                    userName.getText().toString(),passWord.getText().toString());


                UserApi userApi = RetrofitService.getInstance().create(UserApi.class);

                userApi.addUser(responseRegisterClass).enqueue(new Callback<ResponseClass>(){
                    @Override
                    public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                        if (response.body() != null){
                            Toast.makeText(MainActivity.this, "Registered User", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(MainActivity.this, "Something went wrong, make sure" +
                                    "all field are filled!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseClass> call, Throwable t) {

                    }
                });

               ;
                }

            }

        });

        //private void register the user if credentials are valid
    }
    private boolean validateFields(){
        if (TextUtils.isEmpty(firstName.getText().toString())
                && TextUtils.isEmpty(lastName.getText().toString())
                && TextUtils.isEmpty(userName.getText().toString())
                && TextUtils.isEmpty(passWord.getText().toString())){
            Toast.makeText(MainActivity.this, "Please fill in all required fields!", Toast.LENGTH_SHORT).show();
    }return true;
}
    private void initializeListeners(){
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);
        userName=findViewById(R.id.userName);
        passWord=findViewById(R.id.passWord);
        signBTN=findViewById(R.id.signBTN);
        toLoginBTN=findViewById(R.id.toLoginBTN);
    }
}