package com.cgtravelagency.json;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Vehicle {
	
	@NotNull
	@NotBlank
	@Pattern(regexp="^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$", message = "Vehicle Number should be of a valid format")
	private String vehicleNo;
	
	@NotNull
	@NotBlank
	private String vehicleName;
	
	@Min(value = 20, message = "Minimum Fare Per Km should be 20.")
	private double fare;
	
	@NotNull
	private VehicleType vehicleType;
	
	private Route route;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vehicleName, double fare, VehicleType vehicleType) {
		super();
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
	}

	public Vehicle(String vehicleName, double fare, VehicleType vehicleType, Route route) {
		super();
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
		this.route = route;
	}

	public Vehicle(String vehicleNo, String vehicleName, double fare, VehicleType vehicleType, Route route) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
		this.route = route;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", vehicleName=" + vehicleName + ", fare=" + fare + ", vehicleType="
				+ vehicleType + ", route=" + route + "]";
	}
	
}
