package com.tap.model;

import java.sql.Timestamp;


public class User {
  

	private int userid;
	private String name;
	private String username;
	private String password;
	private String email;
	private Long phoneno;
	private String address;
	private String role;
    private Timestamp createddate ;
	private Timestamp  lastlogindate;
	
	public User() {
		
		
	}

	public User(int userid, String name, String username, String password, String email, Long phoneno, String address,
			String role, Timestamp createddate, Timestamp lastlogindate) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.address = address;
		this.role = role;
		this.createddate = createddate;
		this.lastlogindate = lastlogindate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public Timestamp getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(Timestamp lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	
}
