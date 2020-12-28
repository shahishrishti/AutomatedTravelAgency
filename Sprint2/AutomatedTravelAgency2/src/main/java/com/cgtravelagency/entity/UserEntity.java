package com.cgtravelagency.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema="public")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name = "userid")
	private Long userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact")
	private Long contact;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dob")
	private Date dob;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.LAZY, mappedBy = "user")
	private Set<BookingEntity> booking;

	public UserEntity() {
		super();
	}

	public UserEntity(String name, String email, String address, Long contact, String password, String gender,
			Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
	}

	public UserEntity(Long userId, String name, String email, String address, Long contact, String password,
			String gender, Date dob) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
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

	public Set<BookingEntity> getBooking() {
		return booking;
	}

	public void setBooking(Set<BookingEntity> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", contact=" + contact + ", password=" + password + ", gender=" + gender + ", dob=" + dob
				+ ", booking=" + booking + "]";
	}
	
}
