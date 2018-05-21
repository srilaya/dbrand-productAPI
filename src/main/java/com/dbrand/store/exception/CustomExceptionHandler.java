package com.dbrand.store.exception;
	
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomExceptionHandler  {

	@ExceptionHandler(ProductServiceException.class)
	//@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleInternalServer( ProductServiceException exception, final HttpServletRequest request) {

		return new ExceptionResponse(500,"You cannot access this URL - An undefined mapping! ",request.getRequestURI());
	}

	@ExceptionHandler(ProductExistsException.class)
	public @ResponseBody ExceptionResponse handleProductExists( ProductExistsException exception,
																final HttpServletRequest request) {

		return new ExceptionResponse(500,"You cannot add this product. It already exists in the Database ! ",request.getRequestURI());
	}

	@ExceptionHandler(ProductDoesNotExistException.class)
	public @ResponseBody ExceptionResponse handleProductDoesNotExists( ProductDoesNotExistException exception,
																final HttpServletRequest request) {

		return new ExceptionResponse(500,"The product you want to delete , does NOT exists in the Database! ",request.getRequestURI());
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionResponse handleError(HttpServletRequest request, Exception e)   {
	        return new ExceptionResponse(100,"There was an unknown exception! ",request.getRequestURI());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public @ResponseBody ExceptionResponse handleError404(HttpServletRequest request, Exception e)   {
		return new ExceptionResponse(404,"This request source was not found in the application ! ",request.getRequestURI());
	}
	

}
