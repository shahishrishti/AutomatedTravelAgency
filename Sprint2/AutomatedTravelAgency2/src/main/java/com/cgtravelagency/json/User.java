package com.cgtravelagency.json;

import java.util.Date;
import java.util.Set;

public class User {
	
	private Long userId;
	private String name;
	private String email;
	private String address;
	private Long contact;
	private String password;
	private String gender;
	private Date dob;
	private Set<Booking> bookings;
	
	public User(String name, String email, String address, Long contact, String password, String gender, Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
	}
	
	public User(String name, String email, String address, Long contact, String password, String gender, Date dob,
			Set<Booking> bookings) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.bookings = bookings;
	}
	
	public User(Long userId, String name, String email, String address, Long contact, String password, String gender,
			Date dob, Set<Booking> bookings) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.bookings = bookings;
	}

	public User(Long userId2, String name2, String email2, String address2, Long contact2, String password2,
			String gender2, Date dob2) {
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", address=" + address + ", contact="
				+ contact + ", password=" + password + ", gender=" + gender + ", dob=" + dob + ", bookings=" + bookings
				+ "]";
	}
	
}
