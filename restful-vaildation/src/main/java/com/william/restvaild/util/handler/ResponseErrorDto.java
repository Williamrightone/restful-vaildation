package com.william.restvaild.util.handler;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseErrorDto {

	private HttpStatus httpStatus;
	
	private String customErrorCode;
	
	private String errMessage;
	
}
