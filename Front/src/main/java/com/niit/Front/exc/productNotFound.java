package com.niit.Front.exc;

import java.io.Serializable;

public class productNotFound extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public productNotFound(){
		this("Product is not Avilable!!!");
	}
	public productNotFound(String message){
		this.message = System.currentTimeMillis() + ":" + message;
	}
	public String getMessage() {
		return message;
	}
	

}
