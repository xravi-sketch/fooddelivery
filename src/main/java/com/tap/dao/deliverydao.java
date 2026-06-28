package com.tap.dao;

import java.util.List;

import com.tap.model.delivery;

public interface deliverydao {

	
	void adddelivery(delivery delivery);
	delivery getdelivery(int delivery_id);
	void  updatedelivery(delivery delivery);
	void deletedelivery(int delivery_id);
	List<delivery> getalldelivery();
}
