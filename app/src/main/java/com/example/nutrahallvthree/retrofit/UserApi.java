package com.example.nutrahallvthree.retrofit;

import com.example.nutrahallvthree.responseclass.CodeRegisterClass;
import com.example.nutrahallvthree.responseclass.ResponseClass;
import com.example.nutrahallvthree.responseclass.ResponseRegisterClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface UserApi {


    @POST(value = "/api/user/add")
    Call<ResponseRegisterClass> addUser(@Body ResponseRegisterClass responseRegisterClass);

    //@GET(value = "/api/user/get/{username}")
    //Call<ResponseClass> getUser(@Path("username") ResponseRegisterClass responseRegisterClass);

    @PUT(value = "/api/user/add/User")
    Call<ResponseClass>getUser(@Body ResponseRegisterClass responseRegisterClass);
    //need post method for posting the method
    //and need a class for the sening and receving of the responses
    @POST(value = "/api/user/addCode")
    Call<CodeRegisterClass>addCode(@Body CodeRegisterClass codeRegisterClass);

}
