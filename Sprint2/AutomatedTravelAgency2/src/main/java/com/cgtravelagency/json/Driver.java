package com.cgtravelagency.json;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class Driver {

	

	@Min(value = 1)
	@ApiModelProperty(value=" Driver Id")
	private Long driverId;
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value=" Driver Name")
	private String driverName;

	@NotBlank
	@NotNull
	@ApiModelProperty(value=" Driver Address")
	private String address;
	
	@Pattern(regexp="^[789]\\{9}$", message = "Contact Number should be of a valid format")
	@ApiModelProperty(value=" Driver ContactNo")
	private Long contact;
	
	
	@NotNull
	@NotBlank 
	@Pattern(regexp="^[A-Z]{2}\\s[0-9]{13}$", message = "License Number should be of a valid format")
	@ApiModelProperty(value=" Driver LicenseNo")
	private String licenseNo;
	
	@ApiModelProperty(value=" Driver Vehicle")
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


	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", address=" + address + ", contact="
				+ contact + ", licenseNo=" + licenseNo + ", vehicle=" + vehicle + "]";
	}



	


	
	
}
