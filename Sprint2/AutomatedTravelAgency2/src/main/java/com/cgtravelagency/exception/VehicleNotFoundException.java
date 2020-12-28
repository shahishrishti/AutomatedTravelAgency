package com.cgtravelagency.exception;

public class VehicleNotFoundException extends Exception{
private String message;
	
	public VehicleNotFoundException() {
		this.message = "";
	}
	public VehicleNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Vehicle not found " + this.message;
	}

	@Override
	public String getLocalizedMessage() {
		return this.message;
	}
}
