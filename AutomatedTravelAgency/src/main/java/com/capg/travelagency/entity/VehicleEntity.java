package com.capg.travelagency.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vehicle")
public class VehicleEntity {

	@Id
	@GeneratedValue
	@Column(name = "vehicle_no")
	private int vehicleNo;
	
	@Column(name = "vehicle_name")
	private String vehicleName;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "fare_per_km")
	private double farePerKm;
	
	@Column(name = "seating_capacity")
	private int seatingCapacity;

	@OneToOne(cascade = {CascadeType.PERSIST},
			fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "driver_id")
	private DriverEntity driverEntity;
	
	public VehicleEntity() {
		super();
	}

	public VehicleEntity(int vehicleNo, String vehicleName, String vehicleType, double farePerKm, int seatingCapacity,
			DriverEntity driverEntity) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.farePerKm = farePerKm;
		this.seatingCapacity = seatingCapacity;
		this.driverEntity = driverEntity;
	}
	

	public VehicleEntity(String vehicleName, String vehicleType, double farePerKm, int seatingCapacity,
			DriverEntity driverEntity) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.farePerKm = farePerKm;
		this.seatingCapacity = seatingCapacity;
		this.driverEntity = driverEntity;
	}
	
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

	public DriverEntity getDriverEntity() {
		return driverEntity;
	}

	public void setDriverEntity(DriverEntity driverEntity) {
		this.driverEntity = driverEntity;
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicleNo=" + vehicleNo + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", farePerKm=" + farePerKm + ", seatingCapacity=" + seatingCapacity + ", driverEntity=" + driverEntity
				+ "]";
	}


}
