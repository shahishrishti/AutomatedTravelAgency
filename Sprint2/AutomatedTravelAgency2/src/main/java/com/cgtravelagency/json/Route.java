package com.cgtravelagency.json;

import java.util.Set;

import com.cgtravelagency.entity.RouteEntity;

public class Route {
	
	private Long routeid;
	private String source;
	private String destination;
	private double distance;
	private Set<Booking> bookings;
	private String vehicleNo;
	
	public Route() {
		super();
	}

	public Route(String source, String destination, double distance) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	public Route(String source, String destination, double distance, Set<Booking> bookings) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.bookings = bookings;
	}

	public Route(Long routeid, String source, String destination, double distance) {
		super();
		this.routeid = routeid;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	
	public Route(Long routeid, String source, String destination, double distance, Set<Booking> bookings) {
		super();
		this.routeid = routeid;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.bookings = bookings;
	}

	public Route(String vehicleNo) {
		super();
		this.vehicleNo = vehicleNo;
	}

	public Long getRouteid() {
		return routeid;
	}

	public void setRouteid(Long routeid) {
		this.routeid = routeid;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public String toString() {
		return "Route [routeid=" + routeid + ", source=" + source + ", destination=" + destination + ", distance="
				+ distance + ", bookings=" + bookings + ", vehicleNo=" + vehicleNo + "]";
	}
	
}
