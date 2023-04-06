package com.example.nutrahallvthree.responseclass;

import com.google.gson.annotations.SerializedName;

public class ResponseRegisterClass{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("password")
	private String password;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("username")
	private String username;

	public ResponseRegisterClass(String toString, String toString1, String toString2, String toString3) {
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