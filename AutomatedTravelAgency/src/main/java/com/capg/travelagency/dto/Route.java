package com.capg.travelagency.dto;

public class Route {
	
	private int routeId;
	private String source;
	private String destination;
	private  double distance;
	private double duration;
	
	//default constructor
	public Route() {
		super();
	}

	//parameterized constructor
	public Route(int routeId, String source, String destination, double distance, double duration) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
	}

	public Route(String source, String destination, double distance, double duration) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.duration = duration;
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
