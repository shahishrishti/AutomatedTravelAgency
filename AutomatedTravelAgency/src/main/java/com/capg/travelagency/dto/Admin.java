package com.capg.travelagency.dto;

public class Admin {
	
	//data members
	private int userId;
	private String username;
	private String password;
	private String name;
	
	//default constructor
	public Admin() {
		super();
	}

	//parameterized constructors
	public Admin(int userId, String username, String password, String name) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
	}

	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//toString
	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name + "]";
	}
	
}
