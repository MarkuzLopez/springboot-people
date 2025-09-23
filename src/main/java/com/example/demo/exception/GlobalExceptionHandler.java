package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// manejo de validaciones @Valid
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
				errors.put(error.getField(), error.getDefaultMessage())
		);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	//Manejo de runTimeException (ej: Persona no encontrada)
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException ex, WebRequest request) { 
		ErrorResponse error =  new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				"Not  Found",
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Manejo de excepciones genericas 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request){
		ErrorResponse error =  new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Internal Server Error",
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
