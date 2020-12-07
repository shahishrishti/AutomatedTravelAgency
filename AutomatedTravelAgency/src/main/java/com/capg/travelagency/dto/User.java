package com.capg.travelagency.dto;

import java.util.Date;

public class User {
	
	//data members
	private int userId;
	private String name;
	private String username;
	private String gender;
	private String address;
	private String password;
	private long contactNo;
	private String email;
	private Date dob;
	
	//default constructor
	public User() {
		super();
	}
	
	//parameterized constructor
	public User(int userId, String name, String username, String gender, String address, String password,
			long contactNo, String email, Date dob) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.contactNo = contactNo;
		this.email = email;
		this.dob = dob;
	}

	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	//toString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", gender=" + gender
				+ ", address=" + address + ", password=" + password + ", contactNo=" + contactNo + ", email=" + email
				+ ", dob=" + dob + "]";
	}
	
}
