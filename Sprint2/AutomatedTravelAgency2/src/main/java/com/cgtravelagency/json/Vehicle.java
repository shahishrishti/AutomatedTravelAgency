package com.cgtravelagency.json;

import java.util.Set;

public class Vehicle {

	private Long vehicleId;
	private String vehicleName;
	private String vehicleType;
	private int seatingCapacity;
	private double farePerKm;
	private String vehicleNo;
	private Set<Driver> drivers;
	
	public Vehicle(String vehicleName, String vehicleType, int seatingCapacity, double farePerKm, String vehicleNo) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
	}

	public Vehicle(String vehicleName, String vehicleType, int seatingCapacity, double farePerKm, String vehicleNo,
			Set<Driver> drivers) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
		this.drivers = drivers;
	}

	public Vehicle(Long vehicleId, String vehicleName, String vehicleType, int seatingCapacity, double farePerKm,
			String vehicleNo, Set<Driver> drivers) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
		this.drivers = drivers;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
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

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public double getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Set<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", seatingCapacity=" + seatingCapacity + ", farePerKm=" + farePerKm + ", vehicleNo=" + vehicleNo
				+ ", drivers=" + drivers + "]";
	}
	
}
