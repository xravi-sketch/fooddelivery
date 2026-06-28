package com.tap.model;

public class cart {
   private int cart_id;
   private int user_id;
   private int f_id;
   private String quantity;
   private int price;
   private int subtotal;
   
   
   public cart() {
	   
	   
   }


public cart(int cart_id, int user_id, int f_id, String quantity, int price, int subtotal) {
	super();
	this.cart_id = cart_id;
	this.user_id = user_id;
	this.f_id = f_id;
	this.quantity = quantity;
	this.price = price;
	this.subtotal = subtotal;
}


public int getCart_id() {
	return cart_id;
}


public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
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


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public int getSubtotal() {
	return subtotal;
}


public void setSubtotal(int subtotal) {
	this.subtotal = subtotal;
}

   
   
   
}
