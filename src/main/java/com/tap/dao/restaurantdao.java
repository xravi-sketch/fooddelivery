package com.tap.dao;

import java.util.List;

import com.tap.model.restaurant;

public interface restaurantdao {

	void getrestaurant(restaurant restaurant);
	restaurant addrestaurant(int r_id);
	void updaterestaurant(restaurant restaurant);
	void deleterestaurant(int r_id);
	List<restaurant> getallrestaurant();
	
	
}
