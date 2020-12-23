package com.cgtravelagency.json;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.RouteMatcher.Route;

import io.swagger.annotations.ApiModelProperty;

public class Booking {

	
	@Max(value=8)
	@ApiModelProperty(value="Booking ID")
	private int bookingId;
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Username")
	private String username;
	
	@Min(value=10)
	@ApiModelProperty(value="Contact Number")
	private long contactNo;
	
	@ApiModelProperty(value="Number Of Passengers")
	private int noOfPassengers;
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Boarding Point")
	private String boardingPoint;
	
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Drop Point")
	private String dropPoint;
	
	
	@ApiModelProperty(value="Journey Date")
	private Date journeyDate;
	
	@ApiModelProperty(value="Booking Date")
	private Date bookingDate;
	
	@ApiModelProperty(value="Cancel Date")
	private Date cancelDate;
	
	@ApiModelProperty(value="Fare")
	private double fare;
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Booking Status")
	private String bookingStatus;
	
	@Max(value=8)
	@ApiModelProperty(value="Route ID")
	private int routeId;
	
	@ApiModelProperty(value="Booking Route")
	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Booking(int bookingId, String username, long contactNo, int noOfPassengers,
			 String boardingPoint,String dropPoint, Date journeyDate,
			Date bookingDate, Date cancelDate, double fare,  String bookingStatus, int routeId,
			Route route) {
		super();
		this.bookingId = bookingId;
		this.username = username;
		this.contactNo = contactNo;
		this.noOfPassengers = noOfPassengers;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.routeId = routeId;
		this.route = route;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
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

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	

	public Booking(int bookingId, String username, long contactNo, int noOfPassengers,
			 String boardingPoint,  String dropPoint, Date journeyDate,
			Date bookingDate, Date cancelDate, double fare, String bookingStatus, int routeId) {
		super();
		this.bookingId = bookingId;
		this.username = username;
		this.contactNo = contactNo;
		this.noOfPassengers = noOfPassengers;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.routeId = routeId;
	}

	public Booking( String username, long contactNo, int noOfPassengers,
			 String boardingPoint,  String dropPoint, Date journeyDate,
			Date bookingDate, Date cancelDate, double fare,  String bookingStatus, int routeId) {
		super();
		this.username = username;
		this.contactNo = contactNo;
		this.noOfPassengers = noOfPassengers;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.cancelDate = cancelDate;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", username=" + username + ", contactNo=" + contactNo
				+ ", noOfPassengers=" + noOfPassengers + ", boardingPoint=" + boardingPoint + ", dropPoint=" + dropPoint
				+ ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate + ", cancelDate=" + cancelDate
				+ ", fare=" + fare + ", bookingStatus=" + bookingStatus + ", routeId=" + routeId + ", route=" + route
				+ "]";
	}
	
	
	
	
}
