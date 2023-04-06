package com.example.nutrahallvthree.retrofit;

import com.example.nutrahallvthree.data.User;
import com.example.nutrahallvthree.responseclass.ResponseClass;
import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

    //@POST(value = "/add")
   // Call<User> save(@Body User user);
    @POST(value = "/add")
    Call<ResponseClass> addUser(@Body ResponseRegisterClass responseRegisterClass);

    @GET(value = "/get/{username}")
    Call<ResponseClass> getUser(@Body ResponseRegisterClass responseRegisterClass);


}
