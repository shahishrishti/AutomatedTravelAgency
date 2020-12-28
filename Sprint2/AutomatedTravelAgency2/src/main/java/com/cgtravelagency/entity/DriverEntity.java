package com.cgtravelagency.entity;

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
@Table(name = "driver")
public class DriverEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "driverid")
	private Long driverId;
	
	@Column(name = "drivername")
	private String driverName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "licenseno")
	private String licenseNo;
	
	@Column(name = "contact")
	private Long contact;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.EAGER)
	@JoinColumn(name="vehicleno")
	private VehicleEntity vehicle;

	public DriverEntity() {
		super();
	}

	public DriverEntity(String driverName, String address, String licenseNo, Long contact) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.licenseNo = licenseNo;
		this.contact = contact;
	}

	public DriverEntity(String driverName, String address, String licenseNo, Long contact, VehicleEntity vehicle) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.licenseNo = licenseNo;
		this.contact = contact;
		this.vehicle = vehicle;
	}

	public DriverEntity(Long driverId, String driverName, String address, String licenseNo, Long contact,
			VehicleEntity vehicle) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.address = address;
		this.licenseNo = licenseNo;
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

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "DriverEntity [driverId=" + driverId + ", driverName=" + driverName + ", address=" + address
				+ ", licenseNo=" + licenseNo + ", contact=" + contact + ", vehicle=" + vehicle + "]";
	}
	
}
