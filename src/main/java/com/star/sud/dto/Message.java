package com.star.sud.dto;

public class Message {

	protected String message;

	protected Boolean isSuccess;

	protected String errorCode;

	protected String errorDetails;

	public Message() {

	}

	public Message(String message, Boolean isSuccess) {
		this.message = message;
		this.isSuccess = isSuccess;
	}

	public Message(String message, Boolean isSuccess, String errorCode, String errorDetails) {
		this.message = message;
		this.isSuccess = isSuccess;
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}

	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

}
