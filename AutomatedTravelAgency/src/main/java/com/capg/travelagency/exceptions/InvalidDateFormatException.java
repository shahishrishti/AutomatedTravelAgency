package com.capg.travelagency.exceptions;

public class InvalidDateFormatException extends Exception {
	private String message;
	
	public InvalidDateFormatException() {
		this.message = "";
	}
	public InvalidDateFormatException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Date Format " + this.message;
	}
}
