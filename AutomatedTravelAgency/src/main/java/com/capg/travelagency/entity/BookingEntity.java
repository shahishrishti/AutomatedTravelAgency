package com.capg.travelagency.entity;

import java.util.Date;

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
@Table(name = "booking")
public class BookingEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "booking_date")
	private Date bookingDate;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "fare")
	private double fare;
	
	@Column(name = "booking_status")
	private String bookingStatus;
	
	@Column(name = "mobile_no")
	private long mobileNo;
	
	@Column(name = "num_passengers")
	private int numOfPassenger;
	
	@Column(name = "journey_date")
	private Date journeyDate;
	
	@Column(name = "drop_point")
	private String dropPoint;
	
	@Column(name = "boarding_point")
	private String boardingPoint;
	
	@OneToOne(cascade = {CascadeType.ALL},
			fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "vehicle_no")
	private VehicleEntity vehicleEntity;
	
	public BookingEntity() {
		super();
	}

	public BookingEntity(Date bookingDate, String username, double fare, String bookingStatus, long mobileNo,
			int numOfPassenger, Date journeyDate, String dropPoint, String boardingPoint, VehicleEntity vehicleEntity) {
		super();
		this.bookingDate = bookingDate;
		this.username = username;
		this.fare = fare;
		this.bookingStatus = bookingStatus;
		this.mobileNo = mobileNo;
		this.numOfPassenger = numOfPassenger;
		this.journeyDate = journeyDate;
		this.dropPoint = dropPoint;
		this.boardingPoint = boardingPoint;
		this.vehicleEntity = vehicleEntity;
	}

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

	public VehicleEntity getVehicleEntity() {
		return vehicleEntity;
	}

	public void setVehicleEntity(VehicleEntity vehicleEntity) {
		this.vehicleEntity = vehicleEntity;
	}

	@Override
	public String toString() {
		return "BookingEntity [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", username=" + username
				+ ", fare=" + fare + ", bookingStatus=" + bookingStatus + ", mobileNo=" + mobileNo + ", numOfPassenger="
				+ numOfPassenger + ", journeyDate=" + journeyDate + ", dropPoint=" + dropPoint + ", boardingPoint="
				+ boardingPoint + ", vehicleEntity=" + vehicleEntity + "]";
	}	
	
}
