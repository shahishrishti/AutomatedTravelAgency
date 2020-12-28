package com.cgtravelagency.json;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Booking {

	@Min(value=1)
	@ApiModelProperty(value="Booking ID")
	private Long bookingId;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Journey Date")
	private Date journeyDate;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Booking Date")
	private Date bookingDate;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Cancel Date")
	private Date cancelDate;
	@Min(value=100)
	@Max(value=1000)
	@ApiModelProperty(value="Fare")
	private double fare;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Booking Status")
	private String bookingStatus;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Vehicle Type")
	private String vehicleType;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Route")
	private Route route;
	@NotBlank
	@NotNull
	@ApiModelProperty(value="User")
	private User user;
	
	public Booking() {
		super();
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

	public Booking(Long bookingId, Date journeyDate, Date bookingDate, Date cancelDate, double fare,
			String bookingStatus, String vehicleType, Route route) {
		super();
		this.bookingId = bookingId;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.vehicleType = vehicleType;
		this.route = route;
	}

	public Booking(Long bookingId, Date journeyDate, Date bookingDate, Date cancelDate, double fare, String bookingStatus, String vehicleType) {
		super();
		this.bookingId = bookingId;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.vehicleType = vehicleType;
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
