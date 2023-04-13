package com.example.nutrahallvthree.responseclass;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseRegisterClass{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("password")
	private String password;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("username")
	private String username;

	public ResponseRegisterClass(String firstname, String lastname, String username, String password) {
	}


	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRegisterClass{" + 
			"firstname = '" + firstname + '\'' + 
			",password = '" + password + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}