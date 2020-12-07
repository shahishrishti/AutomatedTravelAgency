package com.capg.travelagency.dto;

public class Vehicle {

	//data members
	private int vehicleNo;
	private String vehicleName;
	private String vehicleType;
	private double farePerKm;
	private int seatingCapacity;
	private int driverId;
	
	//default constructor
	public Vehicle() {
		super();
	}

	//parameterized constructor
	public Vehicle(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity,
			int driverId) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.farePerKm = farePerKm;
		this.seatingCapacity = seatingCapacity;
		this.driverId = driverId;
	}

	//getters and setters
	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	//toString
	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", farePerKm=" + farePerKm + ", seatingCapacity=" + seatingCapacity + ", driverId=" + driverId + "]";
	}
	
}
