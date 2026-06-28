package com.tap.dao;

import java.util.List;

import com.tap.model.payment;

public interface paymentdao {
 
	void addpayment(payment payment);
	payment getpayment(int payment_id);
	void updatepayment(payment payment);
	void deletepayment(payment payment);
	List<payment> getallpayment();
}
