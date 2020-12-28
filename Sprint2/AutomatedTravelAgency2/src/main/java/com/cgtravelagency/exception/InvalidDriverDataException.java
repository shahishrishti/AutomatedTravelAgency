package com.cgtravelagency.exception;

public class InvalidDriverDataException extends Exception {

	private String message;
	
	public InvalidDriverDataException() {
		this.message = "";
	}
	public InvalidDriverDataException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Driver not found " + this.message;
     }

	
	@Override
	public String getLocalizedMessage() {
		return this.message;
	}
}
