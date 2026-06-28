package com.tap.model;

import java.sql.Date;

public class orders {
	 private int o_id;
	 private int userid;
	 private Date order_date;
	 private int t_amt;
	 private String status;
	 private String delivery_address;
	 private String customer_name;
	 private Long phone;
	 
	 public orders() {
		 
	 }

	public orders(int o_id, int userid, Date order_date, int t_amt, String status, String delivery_address,String customer_name ,long phone) {
		super();
		this.o_id = o_id;
		this.userid = userid;
		this.order_date = order_date;
		this.t_amt = t_amt;
		this.status = status;
		this.delivery_address = delivery_address;
		this.customer_name = customer_name;
		this.phone =phone ;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getT_amt() {
		return t_amt;
	}

	public void setT_amt(int t_amt) {
		this.t_amt = t_amt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	
	public String getCustomer_name() {
		
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public Long getPhone() {
		
		return phone;
		
	}
 public void setPhone(Long phone) {
     this.phone =phone ;	 
 }
 }
