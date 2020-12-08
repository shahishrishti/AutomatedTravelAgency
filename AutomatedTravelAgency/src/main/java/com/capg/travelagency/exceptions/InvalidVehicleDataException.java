package com.capg.travelagency.exceptions;

public class InvalidVehicleDataException extends Exception{

	private String message;
	
	public InvalidVehicleDataException() {
		this.message = "";
	}
	public InvalidVehicleDataException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid vehicle data " + this.message;
	}
}
