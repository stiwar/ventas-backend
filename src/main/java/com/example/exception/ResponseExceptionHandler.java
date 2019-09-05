package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<ExceptionResponse> manejarExcepcionesDeModelo( ModelNotFoundException ex, WebRequest request ) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarOtrasExcepciones(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}