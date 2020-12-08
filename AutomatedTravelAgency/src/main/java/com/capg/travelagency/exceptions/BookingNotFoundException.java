package com.capg.travelagency.exceptions;

public class BookingNotFoundException extends Exception {
	private String message;
	
	public BookingNotFoundException() {
		this.message = "";
	}
	public BookingNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "No such booking " + this.message;
	}
}
