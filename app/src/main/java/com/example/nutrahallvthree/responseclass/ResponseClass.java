package com.example.nutrahallvthree.responseclass;
import com.google.gson.annotations.SerializedName;

public class ResponseClass{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("password")
	private String password;

	@SerializedName("id")
	private Integer id;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("username")
	private String username;

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

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
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
			"ResponseClass{" + 
			"firstname = '" + firstname + '\'' + 
			",password = '" + password + '\'' + 
			",id = '" + id + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}