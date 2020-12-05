package com.capg.travelagency.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class RouteEntity {
	
	@Id
	@GeneratedValue
	@Column(name="route_id")
	private int routeId;
	
	@Column(name="vehicle_no")
	private int vehicleNo;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="distance")
	private  double distance;
	
	@Column(name="duration")
	private double duration;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vehicle_route", 
				joinColumns = { @JoinColumn(name = "route_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "vehicle_no") })
	private Set<VehicleEntity> vehicleEntity = new HashSet<VehicleEntity>();
	 	
	
	//default constructor
	public RouteEntity() {
		super();
	}

	//parameterized constructor
	public RouteEntity(int routeId, int vehicleNo, String source, String destination, double distance, double duration) {
		super();
		this.routeId = routeId;
		this.vehicleNo = vehicleNo;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}

	public RouteEntity(int vehicleNo, String source, String destination, double distance, double duration) {
		this.vehicleNo = vehicleNo;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}
	

	public RouteEntity(int vehicleNo, String source, String destination, double distance, double duration,
			Set<VehicleEntity> vehicleEntity) {
		super();
		this.vehicleNo = vehicleNo;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
		this.vehicleEntity = vehicleEntity;
	}

	//getters and setters
	public int getRouteId() {
		return this.routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDuration() {
		return this.duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", vehicleNo=" + vehicleNo + ", source=" + source + ", destination="
				+ destination + ", distance=" + distance + ", duration=" + duration + "]";
	}	
}
