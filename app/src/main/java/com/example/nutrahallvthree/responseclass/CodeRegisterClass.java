package com.example.nutrahallvthree.responseclass;

import com.google.gson.annotations.SerializedName;

public class CodeRegisterClass {

	@SerializedName("code")
	private int code;

	public CodeRegisterClass(int code) {
		this.code = code;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	@Override
 	public String toString(){
		return 
			"CodeResponseClass{" + 
			"code = '" + code + '\'' + 
			"}";
		}
}