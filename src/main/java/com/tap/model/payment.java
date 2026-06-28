package com.tap.model;

import java.sql.Date;

public class payment {
	 private int payment_id;
	 private int o_id;
	 private String payment_method;
	 private int amount;
	 private String payment_status;
	 private Date payment_date;
	 
	 public payment() {
		 
	 }

	public payment(int payment_id, int o_id, String payment_method, int amount, String payment_status,
			Date payment_date) {
		super();
		this.payment_id = payment_id;
		this.o_id = o_id;
		this.payment_method = payment_method;
		this.amount = amount;
		this.payment_status = payment_status;
		this.payment_date = payment_date;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	 
}
