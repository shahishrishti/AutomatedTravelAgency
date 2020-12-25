package com.cgtravelagency.json;

import java.util.Set;

public class Route {
	
	private Long routeid;
	private String source;
	private String destination;
	private double distance;
	private Set<Booking> bookings;
	
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

	@Override
	public String toString() {
		return "Route [routeid=" + routeid + ", source=" + source + ", destination=" + destination + ", distance="
				+ distance + ", bookings=" + bookings + "]";
	}
	
}
