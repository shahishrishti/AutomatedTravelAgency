package com.capg.travelagency.dto;

public class Route {
	
	private int routeId;
	private int vehicleNo;
	private String source;
	private String destination;
	private  int distance;
	private int duration;
	
	//default constructor
	public Route() {
		super();
	}

	//parameterized constructor
	public Route(int routeId, int vehicleNo, String source, String destination, int distance, int duration) {
		super();
		this.routeId = routeId;
		this.vehicleNo = vehicleNo;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}

	public Route(int vehicleNo, String source, String destination, int distance, int duration) {
		super();
		this.vehicleNo = vehicleNo;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}

	//getters and setters
	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", vehicleNo=" + vehicleNo + ", source=" + source + ", destination="
				+ destination + ", distance=" + distance + ", duration=" + duration + "]";
	}	
	
}
