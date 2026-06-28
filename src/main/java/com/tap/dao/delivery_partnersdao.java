package com.tap.dao;

import java.util.List;

import com.tap.model.delivery_partners;

public interface delivery_partnersdao {

	 void adddelivery_partner(delivery_partners delivery_partners);
	delivery_partners getdelivery_partners(int pat_id);
	void updatedelivery_partner(delivery_partners delivery_partners);
	void deletedelivery_partner(int pat_id);
	List<delivery_partners> getalldeliverypartner();
}
