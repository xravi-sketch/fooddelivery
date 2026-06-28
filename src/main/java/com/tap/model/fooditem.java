package com.tap.model;

public class fooditem {
   
	 private int f_id;
	 private int r_id;
	 private String food_name;
	 private int price;
	 private String category;
	 private String description;
	 private float availabilty;
	 private String image;
	 private String quantity;
	 
	 public fooditem() {
		 
	 }

	public fooditem(int f_id, int r_id, String food_name, int price, String category, String description,
			float availabilty ,String image ,String quantity) {
		super();
		this.f_id = f_id;
		this.r_id = r_id;
		this.food_name = food_name;
		this.price = price;
		this.category = category;
		this.description = description;
		this.availabilty = availabilty;
		this.setImage(image) ;
		this.quantity =quantity;	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(float availabilty) {
		this.availabilty = availabilty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	 
}
