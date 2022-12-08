package com.william.restvaild.util.handler;

import lombok.Getter;

@Getter
public enum CustomErrorCode {
	
	INPUT_FORMAT_ERROR("8000");
	
	private CustomErrorCode(String customErrorCode) {
		this.customErrorCode = customErrorCode;
	}
	
	private String customErrorCode;

}
