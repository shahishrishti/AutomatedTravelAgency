package com.cgtravelagency.exception;

public class InvalidDriverDataException extends Exception {
<<<<<<< HEAD

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
=======
	private String message;
	
	public InvalidDriverDataException() {
		this.message = "";
	}
	public InvalidDriverDataException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid Vehicle Data " + this.message;
>>>>>>> branch 'master' of https://github.com/shahishrishti/AutomatedTravelAgency.git
	}
	
	@Override
	public String getLocalizedMessage() {
		return this.message;
	}
}
