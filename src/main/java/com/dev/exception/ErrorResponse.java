package com.dev.exception;

public class ErrorResponse {
	
	public String name;
	public String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	
	

}
