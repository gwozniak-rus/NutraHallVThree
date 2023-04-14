package com.example.nutrahallvthree.responseclass;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseRegisterClass{


	private String firstname;


	private String password;

	private String lastname;

	private String username;

	//public ResponseRegisterClass(String toString, String toString1, String toString2, String toString3) {}
	//^^may have to try replacing toString's to firstname, etc.


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

	public ResponseRegisterClass(String firstname, String lastname,
								 String username, String password){
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;

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