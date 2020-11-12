package com.cognizant.truyum.dao;
import java.lang.Exception;

public class CartEmptyException extends Exception{
	public CartEmptyException(String msg) {
		super(msg);
	}
	public CartEmptyException() {
		
	}
	

}
