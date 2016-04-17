package com.sogeti.petstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.Order;

@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

	@Override
	public void createOrder(Order order) {
		persist(order);
	}

	@Override
	public void updateOrder(Order order) {
		update(order);
	}

	@Override
	public Order getOrder(String emailId) {
		Criteria cr = getSession().createCriteria(Order.class);
		cr.add(Restrictions.eq("emailId", emailId));
		if(cr.list().size()>0){
			return (Order) cr.list().get(0);
		}
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		return getAll(Order.class);
	}
}
