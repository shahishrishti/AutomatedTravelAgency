package com.cgtravelagency.json;

import java.util.Date;

import org.springframework.util.RouteMatcher.Route;

public class Booking {

	private Long bookingId;
	private Date journeyDate;
	private Date bookingDate;
	private Date cancelDate;
	private double fare;
	private String bookingStatus;
	private String vehicleType;
	private Route route;
	private User user;
	
	public Booking() {
		super();
	}
	
	public Booking(Date journeyDate, Date bookingDate, Date cancelDate, double fare, String bookingStatus,
			String vehicleType, Route route, User user) {
		super();
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.vehicleType = vehicleType;
		this.route = route;
		this.user = user;
	}
	
	public Booking(Long bookingId, Date journeyDate, Date bookingDate, Date cancelDate, double fare,
			String bookingStatus, String vehicleType, Route route, User user) {
		super();
		this.bookingId = bookingId;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.vehicleType = vehicleType;
		this.route = route;
		this.user = user;
	}
	
	public Long getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
	public Date getJourneyDate() {
		return journeyDate;
	}
	
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	public Date getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Date getCancelDate() {
		return cancelDate;
	}
	
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	public double getFare() {
		return fare;
	}
	
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate
				+ ", cancelDate=" + cancelDate + ", fare=" + fare + ", bookingStatus=" + bookingStatus
				+ ", vehicleType=" + vehicleType + ", route=" + route + ", user=" + user + "]";
	}
	
}
