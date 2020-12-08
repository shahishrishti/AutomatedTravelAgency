package com.capg.travelagency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class DriverEntity {
	@Id
	@GeneratedValue
	@Column(name = "driver_id")
	private int driverId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact_no")
	private long contactNo;
	
	@Column(name = "license_no")
	private String licenseNo;
		
	public DriverEntity(int driverId, String name, String address, long contactNo, String licenseNo) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
	}
	public DriverEntity(String name, String address, long contactNo, String licenseNo) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.licenseNo = licenseNo;
	}
	public DriverEntity() {
	}
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
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", licenseNo=" + licenseNo +"]";
	}
	
}
