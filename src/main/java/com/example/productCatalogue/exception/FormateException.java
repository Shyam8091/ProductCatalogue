package com.example.productCatalogue.exception;

import java.util.Date;

public class FormateException {
	private boolean status;
	private Date timeStamp;
	private String message;
	private String details;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FormateException(Date timeStamp, String message, String details,boolean status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
		this.status=status;
	}

}
