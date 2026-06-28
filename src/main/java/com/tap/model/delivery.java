package com.tap.model;

public class delivery {
	 private int delivery_id;
	 private int order_id;
	 private int partner_id;
	 private String delivery_status;
	 private String delivery_item;
	 
	 public delivery() {
		 
	 }

	public delivery(int delivery_id, int order_id, int partner_id, String delivery_status, String delivery_item) {
		super();
		this.delivery_id = delivery_id;
		this.order_id = order_id;
		this.partner_id = partner_id;
		this.delivery_status = delivery_status;
		this.delivery_item = delivery_item;
	}

	public int getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getDelivery_item() {
		return delivery_item;
	}

	public void setDelivery_item(String delivery_item) {
		this.delivery_item = delivery_item;
	}
	 
	 
}
