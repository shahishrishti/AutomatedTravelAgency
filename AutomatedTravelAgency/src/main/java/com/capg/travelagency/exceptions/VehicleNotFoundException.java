package com.capg.travelagency.exceptions;

public class VehicleNotFoundException extends Exception {
	private String message;
	
	public VehicleNotFoundException() {
		this.message = "";
	}
	public VehicleNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid vehicle data " + this.message;
	}
}