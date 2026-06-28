package com.tap.dao;

import java.util.List;


import com.tap.model.order_items;

public interface order_itemsdao {

	void addorder_item(order_items order_item);
	order_items getorder_item(String o_detials);
	void  updateorder_item(order_items order_item);
	void deleteorder_item(String o_details);
	List<order_items> getallorder_items();
}
