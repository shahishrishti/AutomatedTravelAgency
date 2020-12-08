package com.capg.travelagency.exceptions;

public class InvalidRouteDataException extends Exception{

	private String message;
	
	public InvalidRouteDataException() {
		this.message = "";
	}
	public InvalidRouteDataException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid route data " + this.message;
	}
}
