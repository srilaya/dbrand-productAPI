package com.dbrand.store.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	
public class CustomException extends Exception {
		
	private static final long serialVersionUID = 1L;
	private int code;
	private String errorMessage;
	
	
	public CustomException() {
	}

	public CustomException(int code, String errorMessage) {
		super();
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
