package com.dbrand.store.exception;

public class ProductServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	int code;
	String errorMessage;
	
	public ProductServiceException(int code, String errorMessage) {
		super();
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
}
