package com.example.nutrahallvthree.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit(){
        //Retrofit builder = new Retrofit.Builder()
        retrofit = new Retrofit.Builder()
                .baseUrl("http://172.28.3.173:8080/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                //.client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
