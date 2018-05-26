package net.kzm.onlineshopping.exception;

import java.io.Serializable;

public class productNotFoundException extends Exception implements Serializable {

	private String message;
	
	public productNotFoundException(){
		this("Product is not availbale");
		
	}
	public productNotFoundException(String message){
		this.message=System.currentTimeMillis()+": " +message;
		
	}
	
	public String getMessage(){
		return message;
	}
	
}
