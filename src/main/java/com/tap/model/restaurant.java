package com.tap.model;

public class restaurant {
  private int r_id;
  private String r_name;
  private String owner_name;
  private String email;
  private Long phoneno;
  private String address;
  private Double rating;
  
  public restaurant() {
	  
  }

public restaurant(int r_id, String r_name, String owner_name, String email, Long phoneno, String address, Double rating) {
	super();
	this.r_id = r_id;
	this.r_name = r_name;
	this.owner_name = owner_name;
	this.email = email;
	this.phoneno = phoneno;
	this.address = address;
	this.rating = rating;
}

public int getR_id() {
	return r_id;
}

public void setR_id(int r_id) {
	this.r_id = r_id;
}

public String getR_name() {
	return r_name;
}

public void setR_name(String r_name) {
	this.r_name = r_name;
}

public String getOwner_name() {
	return owner_name;
}

public void setOwner_name(String owner_name) {
	this.owner_name = owner_name;
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

public Double getRating() {
	return rating;
}

public void setRating(Double rating) {
	this.rating = rating;
}
  
}
