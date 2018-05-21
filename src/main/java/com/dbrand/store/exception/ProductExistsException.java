package com.dbrand.store.exception;

public class ProductExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	int code;
	String errorMessage;
	

	public ProductExistsException() {
		super();
		
	}


	public ProductExistsException(int code, String errorMessage) {
		super();
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
}
