package com.capg.travelagency.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "mobile_no")
	private long contactNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dob")
	private Date dob;

	public UserEntity() {
		super();
	}

	public UserEntity(String name, String username, String gender, String address, String password, long contactNo,
			String email, Date dob) {
		super();
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.contactNo = contactNo;
		this.email = email;
		this.dob = dob;
	}

	public UserEntity(int userId, String name, String username, String gender, String address, String password,
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

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", username=" + username + ", gender=" + gender
				+ ", address=" + address + ", password=" + password + ", contactNo=" + contactNo + ", email=" + email
				+ ", dob=" + dob + "]";
	}
	
}
