package com.dbrand.store.exception;

public class ProductDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	int code;
	String errorMessage;
	

	public ProductDoesNotExistException() {
		super();
		
	}


	public ProductDoesNotExistException(int code, String errorMessage) {
		super();
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
}
