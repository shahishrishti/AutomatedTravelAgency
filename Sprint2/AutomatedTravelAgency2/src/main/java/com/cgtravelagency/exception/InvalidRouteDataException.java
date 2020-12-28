package com.cgtravelagency.exception;

public class InvalidRouteDataException extends Exception {
	
private String message;
	
	public InvalidRouteDataException() {
		this.message = "";
	}
	public InvalidRouteDataException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Vehicle Data " + this.message;
	}
	
	@Override
	public String getLocalizedMessage() {
		return this.message;
	}

}
