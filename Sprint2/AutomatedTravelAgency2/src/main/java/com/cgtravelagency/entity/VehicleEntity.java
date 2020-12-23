package com.cgtravelagency.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

	@Id
	@GeneratedValue
	@Column(name = "vehicleId")
	private Long vehicleId;
	
	@Column(name = "vehicleName")
	private String vehicleName;
	
	@Column(name = "vehicleType")
	private String vehicleType;
	
	@Column(name = "seatingCapacity")
	private int seatingCapacity;
	
	@Column(name = "farePerKm")
	private double farePerKm;
	
	@Column(name = "vehicleNo")
	private String vehicleNo;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="routeId")
	private RouteEntity route;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vehicle_driver", 
				joinColumns = { @JoinColumn(name = "vehicleId") }, 
				inverseJoinColumns = { @JoinColumn(name = "driverId") })
	private Set<DriverEntity> drivers = new HashSet<>();
	
	public VehicleEntity() {
		super();
	}

	public VehicleEntity(String vehicleName, String vehicleType, int seatingCapacity, double farePerKm,
			String vehicleNo) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
	}

	public VehicleEntity(String vehicleName, String vehicleType, int seatingCapacity, double farePerKm,
			String vehicleNo, RouteEntity route) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
		this.route = route;
	}

	public VehicleEntity(String vehicleName, String vehicleType, int seatingCapacity, double farePerKm,
			String vehicleNo, RouteEntity route, Set<DriverEntity> drivers) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
		this.route = route;
		this.drivers = drivers;
	}

	public VehicleEntity(String vehicleName, String vehicleType, int seatingCapacity, double farePerKm,
			String vehicleNo, Set<DriverEntity> drivers) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.seatingCapacity = seatingCapacity;
		this.farePerKm = farePerKm;
		this.vehicleNo = vehicleNo;
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", seatingCapacity=" + seatingCapacity + ", farePerKm=" + farePerKm + ", vehicleNo=" + vehicleNo
				+ ", route=" + route + ", drivers=" + drivers + "]";
	}
	
}
