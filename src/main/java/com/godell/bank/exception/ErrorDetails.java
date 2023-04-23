package com.godell.bank.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private String message;
	private LocalDateTime timeOccurred;
	private String errorDetails;
	public ErrorDetails(String message, LocalDateTime timeOccurred, String errorDetails) {
		super();
		this.message = message;
		this.timeOccurred = timeOccurred;
		this.errorDetails = errorDetails;
	}
	public String getMessage() {
		return message;
	}
	public LocalDateTime getTimeOccurred() {
		return timeOccurred;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	
	
	

}
