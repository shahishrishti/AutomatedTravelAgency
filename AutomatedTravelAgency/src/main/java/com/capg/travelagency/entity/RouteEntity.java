package com.capg.travelagency.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class RouteEntity {
	
	@Id
	@GeneratedValue
	@Column(name="route_id")
	private int routeId;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="distance")
	private  double distance;
	
	@Column(name="duration")
	private double duration;
	
	@OneToOne(cascade = {CascadeType.PERSIST},
			fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "vehicle_no")
	private VehicleEntity vehicleEntity;
	 	
	
	//default constructor
	public RouteEntity() {
		super();
	}

	//parameterized constructor
	public RouteEntity(int routeId, String source, String destination, double distance, double duration) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}

	public RouteEntity(String source, String destination, double distance, double duration) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}
	

	public RouteEntity(String source, String destination, double distance, double duration,
			VehicleEntity vehicleEntity) {
		super();
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

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return this.destination;
	}

	public VehicleEntity getVehicleEntity() {
		return vehicleEntity;
	}

	public void setVehicleEntity(VehicleEntity vehicleEntity) {
		this.vehicleEntity = vehicleEntity;
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
		return "Route [routeId=" + routeId + ", source=" + source + ", destination="
				+ destination + ", distance=" + distance + ", duration=" + duration + "]";
	}	
}
