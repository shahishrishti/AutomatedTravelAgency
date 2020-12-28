package com.cgtravelagency.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cgtravelagency.json.Route;
import com.cgtravelagency.json.VehicleType;

@Entity
@Table(name = "vehicle", schema="public")
public class VehicleEntity {

	@Id
	@Column(name = "vehicleno")
	private String vehicleNo;
	
	@Column(name = "vehiclename")
	private String vehicleName;
	
	@Column(name = "fare")
	private double fare;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name="typeid")
	private VehicleTypeEntity vehicleType;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY)
	@JoinColumn(name="routeid")
	private RouteEntity route;
	
	public VehicleEntity() {
		super();
	}

	public VehicleEntity(String vehicleName, double fare, VehicleTypeEntity vehicleType) {
		super();
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
	}

	public VehicleEntity(String vehicleName, double fare, VehicleTypeEntity vehicleType, RouteEntity route) {
		super();
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
		this.route = route;
	}

	public VehicleEntity(String vehicleNo, String vehicleName, double fare, VehicleTypeEntity vehicleType) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
	}

	public VehicleEntity(String vehicleNo, String vehicleName, double fare, VehicleTypeEntity vehicleType,
			RouteEntity route) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.fare = fare;
		this.vehicleType = vehicleType;
		this.route = route;
	}

	public VehicleEntity(String vehicleNo2, String vehicleName2, double fare2, VehicleType vehicleType2, Route route2) {
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

	public VehicleTypeEntity getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypeEntity vehicleType) {
		this.vehicleType = vehicleType;
	}

	public RouteEntity getRoute() {
		return route;
	}

	public void setRoute(RouteEntity route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicleNo=" + vehicleNo + ", vehicleName=" + vehicleName + ", fare=" + fare
				+ ", vehicleType=" + vehicleType + ", route=" + route + "]";
	}
}
