package com.sogeti.petstore.dao;

import java.util.List;

import com.sogeti.petstore.model.Order;

public interface OrderDAO {
	
	public void createOrder(Order order);
	public void updateOrder(Order order);
	public Order getOrder(String emailId);
	public List<Order> getAllOrders();

}
