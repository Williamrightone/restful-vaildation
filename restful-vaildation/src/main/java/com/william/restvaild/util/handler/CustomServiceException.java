package com.william.restvaild.util.handler;

public class CustomServiceException extends RuntimeException {

	private static final long serialVersionUID = 4896981274763511258L;

	public enum CustomServiceErrorType {
		
		INPUT_FORMAT_ERROR("00001", CustomErrorLevel.LOW.name()),
		
		USER_NOT_FOUND("10000", CustomErrorLevel.LOW.name()),
		
		EMAIL_PASSWORD_NOT_MATCH("10001", CustomErrorLevel.LOW.name());
		
		private String customErrorCode;
		
		private String customErrorLevel;
		
		CustomServiceErrorType(String customErrorCode, String customErrorLevel){
			this.customErrorCode = customErrorCode;
			this.customErrorLevel = customErrorLevel;
		}
		
		public String getCustomErrorCode() {
			return customErrorCode;
		}
		
		public String getCustomErrorLevel() {
			return customErrorLevel;
		}
		
	}
	
	private String errorCode;
	
	private String errorLevel;
	
	public CustomServiceException(CustomServiceErrorType customServiceErrorType, String exceptionMsg) {
		super(exceptionMsg);
		this.errorCode = customServiceErrorType.getCustomErrorCode();
		this.errorLevel = customServiceErrorType.getCustomErrorLevel();
	}
	
	public CustomServiceException(String errorCode, String exceptionMsg, Throwable cause) {
		super(exceptionMsg, cause);
		this.errorCode = errorCode;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorLevel() {
		return errorLevel;
	}
	
	
}
