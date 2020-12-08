package com.capg.travelagency.exceptions;

public class InvalidDriverDataException extends Exception{

	private String message;
	
	public InvalidDriverDataException() {
		this.message = "";
	}
	public InvalidDriverDataException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid vehicle data " + this.message;
	}
}
