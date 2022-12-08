package com.william.restvaild.util.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public <T> ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException error) {

		List<FieldError> fieldErrors = error.getBindingResult().getFieldErrors();
		
		StringBuilder errorFields = new StringBuilder();
		
		for (FieldError fieldError : fieldErrors) {
			if (errorFields.length() > 0) {
				errorFields.append(", ");
			}
			errorFields.append(fieldError.getDefaultMessage());
		}

		log.error("參數值驗證有誤 : " + errorFields.toString());
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Request parameter format error: " + errorFields.toString());

	}

}
