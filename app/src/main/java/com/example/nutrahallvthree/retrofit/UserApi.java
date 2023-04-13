package com.example.nutrahallvthree.retrofit;

import com.example.nutrahallvthree.responseclass.ResponseClass;
import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface UserApi {


    @POST(value = "/api/user/add")
    Call<ResponseRegisterClass> addUser(@Body ResponseRegisterClass responseRegisterClass);

    @GET(value = "/api/user/get/{id}")
    Call<ResponseRegisterClass> getUser(@Body ResponseRegisterClass responseRegisterClass);


}
