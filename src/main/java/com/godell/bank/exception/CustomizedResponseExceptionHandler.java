package com.godell.bank.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	  @ExceptionHandler(Exception.class) 
	  public final ResponseEntity<Object>
	  handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		  ErrorDetails details=new ErrorDetails(ex.getMessage(), LocalDateTime.now(),request.getDescription(false)); 
		  return new ResponseEntity<Object>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	  
	  }
	 
	
	@ExceptionHandler(AccountNotFoundException.class)
	public final ResponseEntity<Object> handlelAccountNotFoundExceptions(Exception ex, WebRequest request) throws Exception{
		ErrorDetails details=new ErrorDetails(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InsufficinetBalanaceException.class)
	
	public final ResponseEntity<Object> handlelInsufficientBalanaceException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails details=new ErrorDetails(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.NOT_ACCEPTABLE);
		
	}
	

}
