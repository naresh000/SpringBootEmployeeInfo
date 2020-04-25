package com.employee.testscotia.models;

import java.util.List;

public class ErrorMessage {
	
	private String message;
	private List<String> errorDetail;
	
	public ErrorMessage() {	}

	public ErrorMessage(String message, List<String> errorDetail) {
		super();
		this.message = message;
		this.errorDetail = errorDetail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(List<String> errorDetail) {
		this.errorDetail = errorDetail;
	}
	
}
