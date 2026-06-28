package com.tap.model;

public class order_items {
	 private String o_details;
	 private int o_id;
	 private int f_id;
	 private String quantity;
	 private int subtotal;
	 
	 public order_items() {
		 
	 }

	public order_items(String o_details, int o_id, int f_id, String quantity, int subtotal) {
		super();
		this.o_details = o_details;
		this.o_id = o_id;
		this.f_id = f_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public String getO_details() {
		return o_details;
	}

	public void setO_details(String o_details) {
		this.o_details = o_details;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	 
}
