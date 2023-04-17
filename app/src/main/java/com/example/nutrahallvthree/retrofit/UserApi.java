package com.example.nutrahallvthree.retrofit;

import com.example.nutrahallvthree.responseclass.ResponseClass;
import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface UserApi {


    @POST(value = "/api/user/add")
    Call<ResponseRegisterClass> addUser(@Body ResponseRegisterClass responseRegisterClass);

    //@GET(value = "/api/user/get/{username}")
    //Call<ResponseClass> getUser(@Path("username") ResponseRegisterClass responseRegisterClass);

    @PUT(value = "/api/user/add/User")
    Call<ResponseClass>getUser(@Body ResponseRegisterClass responseRegisterClass);

}
