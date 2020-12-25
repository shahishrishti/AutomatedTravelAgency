package com.cgtravelagency.json;

public class Driver {

	private Long driverId;
	private String driverName;
	private String address;
	private Long contact;
	private Vehicle vehicle;
	
	public Driver() {
		super();
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
				+ contact + ", vehicle=" + vehicle + "]";
	}
	
	
}
