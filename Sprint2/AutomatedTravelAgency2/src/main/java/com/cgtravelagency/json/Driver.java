package com.cgtravelagency.json;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Driver {
	
	
	@Min(value=1)
	private Long driverId;
	
	@NotNull
	@NotBlank
	private String driverName;
	
	@NotNull
	@NotBlank
	private String address;
	
	@Max(value=10,message="Mobile number should be 10 digits")
	private Long contact;
	
	@NotNull
	@NotBlank 
	private String licenseNo;
	
	@NotNull
	@NotBlank
	private Vehicle vehicle;
	
	public Driver() {
		super();
	}
	
	
	
	public Driver(String driverName, String address, Long contact, String licenseNo) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
		this.licenseNo = licenseNo;
	}



	public Driver(Long driverId, String driverName, String address, Long contact, String licenseNo) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
		this.licenseNo = licenseNo;
	}



	public Driver(String driverName, String address, Long contact, String licenseNo, Vehicle vehicle) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
		this.licenseNo = licenseNo;
		this.vehicle = vehicle;
	}



	public Driver(Long driverId, String driverName, String address, Long contact, String licenseNo, Vehicle vehicle) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
		this.licenseNo = licenseNo;
		this.vehicle = vehicle;
	}



	public Driver(String driverName, String address, Long contact) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
	}
	
	public Driver(String driverName, String address, Long contact, Vehicle vehicle) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
		this.vehicle = vehicle;
	}

	public Driver(Long driverId, String driverName, String address, Long contact, Vehicle vehicle) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.address = address;
		this.contact = contact;
		this.vehicle = vehicle;
	}



	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", address=" + address + ", contact="
				+ contact + ", licenseNo=" + licenseNo + ", vehicle=" + vehicle + "]";
	}



	public Long getDriverId() {
		return driverId;
	}



	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}



	public String getDriverName() {
		return driverName;
	}



	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Long getContact() {
		return contact;
	}



	public void setContact(Long contact) {
		this.contact = contact;
	}



	public String getLicenseNo() {
		return licenseNo;
	}



	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}



	public Vehicle getVehicle() {
		return vehicle;
	}



	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}



	


	
	
}
