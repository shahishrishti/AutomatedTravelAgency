package com.capg.travelagency.dto;

public class Driver {
	
	//data members
	private int driverId;
	private String name;
	private String address;
	private long contactNo;
	private String licenseNo;
	
	//default constructor
	public Driver() {
		super();
	}
	
	//parameterized constructor
	public Driver(String name, String address, long contactNo, String licenseNo) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
	}
	
	//parameterized constructor
	public Driver(int driverId, String name, String address, long contactNo, String licenseNo) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
	}
	
	//getters and setters
	public int getDriverId() {
		return driverId;
	}
	
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getLicenseNo() {
		return licenseNo;
	}
	
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	//toString
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", licenseNo=" + licenseNo +"]";
	}
}
