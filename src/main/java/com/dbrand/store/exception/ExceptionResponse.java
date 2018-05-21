package com.dbrand.store.exception;

public class ExceptionResponse {
	
	private int errorCode;
	private String errorMessage;
	private String requestedURI;

	
	public ExceptionResponse(int errorCode, String errorMessage, String requestedURI) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.requestedURI = requestedURI;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
