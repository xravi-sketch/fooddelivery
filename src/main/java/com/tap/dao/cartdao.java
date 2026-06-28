package com.tap.dao;

import java.util.List;

import com.tap.model.cart;


public interface cartdao {

	void addcart(cart cart);
	cart getcart(int cart_id);
	void  updatecart(cart cart);
	void deletecart(int cart_id);
	List<cart> getallcart();
	List<cart> getCartByUser(int userId);
	
	
}
