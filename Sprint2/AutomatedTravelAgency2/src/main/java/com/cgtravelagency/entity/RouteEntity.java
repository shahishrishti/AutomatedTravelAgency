package com.cgtravelagency.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cgtravelagency.json.Vehicle;

@Entity
@Table(name = "route")
public class RouteEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "routeid")
	private Long routeId;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "distance")
	private double distance;
	
	@OneToMany(cascade={CascadeType.PERSIST}, 
			fetch=FetchType.LAZY, mappedBy = "route")
	private Set<BookingEntity> booking;
	
	public RouteEntity() {
		super();
	}
	
	public RouteEntity(String source, String destination, double distance) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	
	public RouteEntity(Long routeId, String source, String destination, double distance) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	
	public RouteEntity(String source, String destination, double distance, Set<BookingEntity> booking) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.booking = booking;
	}
	
	public RouteEntity(Long routeId, String source, String destination, double distance, Set<BookingEntity> booking) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.booking = booking;
	}

//	public RouteEntity(Long routeId, String source, String destination, double distance, Vehicle vehicle,
//			Set<BookingEntity> booking) {
//		super();
//		this.routeId = routeId;
//		this.source = source;
//		this.destination = destination;
//		this.distance = distance;
//		this.vehicle = vehicle;
//		this.booking = booking;
//	}

	public Long getRouteId() {
		return routeId;
	}
	
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
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
	
	public Set<BookingEntity> getBooking() {
		return booking;
	}

	public void setBooking(Set<BookingEntity> booking) {
		this.booking = booking;
	}

//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}

	@Override
	public String toString() {
		return "RouteEntity [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", distance="
				+ distance  + ", booking=" + booking + "]";
	}
	
}
