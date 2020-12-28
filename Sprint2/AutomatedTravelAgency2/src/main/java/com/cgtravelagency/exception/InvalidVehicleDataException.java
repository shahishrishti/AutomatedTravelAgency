package com.cgtravelagency.exception;

public class InvalidVehicleDataException extends Exception {
	
	private String message;
	
	public InvalidVehicleDataException() {
		this.message = "";
	}
	public InvalidVehicleDataException(String message) {
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
