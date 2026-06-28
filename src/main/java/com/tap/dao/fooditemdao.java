package com.tap.dao;

import java.util.List;


import com.tap.model.fooditem;

public interface fooditemdao {
	
	void addfooditem(fooditem fooditem);
	fooditem getfooditem(int f_id);
	void  updatefooditem(fooditem fooditem);
	void deletefooditem(int f_id);
	List<fooditem> getallfooditem();
	List<fooditem> getFoodByRestaurant(int r_id);
}
