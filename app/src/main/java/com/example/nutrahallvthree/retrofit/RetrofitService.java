package com.example.nutrahallvthree.retrofit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitService {

    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    public static Retrofit getInstance(){
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://172.28.3.200:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build());
    return builder.build();
    }



   /* private Retrofit retrofit;

    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
               .baseUrl("http://192.168.0.179:8080")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(new OkHttpClient.Builder().build())
                .build();
    }

    //public Retrofit getRetrofit() {
        return retrofit;
    }*/
}
