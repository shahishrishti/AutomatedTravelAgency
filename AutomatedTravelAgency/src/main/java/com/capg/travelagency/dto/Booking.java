package com.capg.travelagency.dto;

import java.util.Date;

public class Booking {

	//data members
	private int bookingId;
	private Date bookingDate;
	private String username;
	private double fare;
	private String bookingStatus;
	private int vehicleNo;
	private long mobileNo;
	private int numOfPassenger;
	private Date journeyDate;
	private String dropPoint;
	private String boardingPoint;
	
	//default constructor
	public Booking() {
		super();
	}
	
	//parameterized constructor
	public Booking(int bookingId, Date bookingDate, String username, double fare, String bookingStatus, int vehicleNo,
			long mobileNo, int numOfPassenger, Date journeyDate, String dropPoint, String boardingPoint) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.username = username;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.vehicleNo = vehicleNo;
		this.mobileNo = mobileNo;
		this.numOfPassenger = numOfPassenger;
		this.journeyDate = journeyDate;
		this.dropPoint = dropPoint;
		this.boardingPoint = boardingPoint;
	}


	public Booking(Date bookingDate, String username, double fare, String bookingStatus, int vehicleNo, long mobileNo,
			int numOfPassenger, Date journeyDate, String dropPoint, String boardingPoint) {
		super();
		this.bookingDate = bookingDate;
		this.username = username;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.vehicleNo = vehicleNo;
		this.mobileNo = mobileNo;
		this.numOfPassenger = numOfPassenger;
		this.journeyDate = journeyDate;
		this.dropPoint = dropPoint;
		this.boardingPoint = boardingPoint;
	}

	//getter and setters
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getNumOfPassenger() {
		return numOfPassenger;
	}

	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	//toString
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", username=" + username + ", fare="
				+ fare + ", bookingStatus=" + bookingStatus + ", vehicleNo=" + vehicleNo + ", mobileNo=" + mobileNo
				+ ", numOfPassenger=" + numOfPassenger + ", journeyDate=" + journeyDate + ", dropPoint=" + dropPoint
				+ ", boardingPoint=" + boardingPoint + "]";
	}
		
}
