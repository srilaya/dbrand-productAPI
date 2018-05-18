package com.dbrand.store.exception;
	
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler  {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound( Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("The path you wanted to access , does not exist !");
		error.callerURL(request.getRequestURI());

		return error;
	}
	
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	public @ResponseBody ExceptionResponse handleException(final Exception exception,
//			final HttpServletRequest request) {
//
//		ExceptionResponse error = new ExceptionResponse();
//		error.setErrorMessage("There was some logical error! Please refer to your controller ");
//		error.callerURL(request.getRequestURI());
//
//		return error;
//	}
}
