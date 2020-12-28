package com.cgtravelagency.json;

import com.cgtravelagency.entity.RouteEntity;
import com.cgtravelagency.entity.VehicleTypeEntity;

public class Vehicle {
	
	private String vehicleNo;
	private String vehicleName;
	private double fare;
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

	public Vehicle(String vehicleNo2, String vehicleName2, double fare2, VehicleTypeEntity vehicleType2,
			RouteEntity route2) {
		// TODO Auto-generated constructor stub
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
