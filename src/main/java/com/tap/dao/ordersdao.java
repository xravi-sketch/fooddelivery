package com.tap.dao;

import java.util.List;

import com.tap.model.orders;

public interface ordersdao {
    void addorders(orders orders);
    orders getorders(int o_id);
    void updateorders(orders orders);
    void deleteorders(int o_id);
    List<orders> getallorders();
    List<orders> getOrdersByUserId(int userId);
}
