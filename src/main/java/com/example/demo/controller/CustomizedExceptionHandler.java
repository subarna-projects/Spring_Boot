package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.UserNotFoundException;
@RestController
@ControllerAdvice("com.example.demo.controller")
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest req)
	{
		ExceptionResponse exResponse= new ExceptionResponse(ex.getMessage(),req.getDescription(false) );
		return new ResponseEntity(exResponse, HttpStatus.NOT_FOUND);
	}
	@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid (MethodArgumentNotValidException ex,
HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse exResponse= new ExceptionResponse(ex.getMessage(),request.getDescription(false));
		 return new ResponseEntity(exResponse, HttpStatus.BAD_REQUEST);}
}
