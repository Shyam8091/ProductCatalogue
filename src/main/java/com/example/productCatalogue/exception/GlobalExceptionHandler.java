package com.example.productCatalogue.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleRespourseNotFoundException(ResourceNotFoundException exception,WebRequest request){
		FormateException formateException=new FormateException(new Date(), exception.getMessage(), request.getDescription(false),false);
		return new ResponseEntity<>(formateException,HttpStatus.NOT_FOUND);
	}
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request){
		System.out.println("GlobalExceptionHandler.handleGlobalException()");
		FormateException formateException=new FormateException(new Date(), exception.getMessage(), request.getDescription(false),false);
		return new ResponseEntity<>(formateException,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidation(MethodArgumentNotValidException exception){
		System.out.println("GlobalExceptionHandler.customValidation()");
		FormateException formateException=new FormateException(new Date(),"Validation Failed", exception.getBindingResult().getFieldError().getDefaultMessage(),false);
		return new ResponseEntity<>(formateException,HttpStatus.BAD_REQUEST);
		
	}
}
