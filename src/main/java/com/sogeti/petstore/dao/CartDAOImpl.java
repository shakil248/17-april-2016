package com.sogeti.petstore.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;

@Repository
public class CartDAOImpl extends BaseDAO implements CartDAO {

	

	@Override
	public Cart getCart(String emailId) {
		Criteria cr = getSession().createCriteria(Cart.class);
		cr.add(Restrictions.eq("emailId", emailId));
		if(cr.list().size()>0){
			return (Cart) cr.list().get(0);
		}
		return null;
	}

	@Override
	public void saveCart(Cart cart) {
		persist(cart);
		
	}

	@Override
	public void updateCart(Cart cart) {
		saveOrUpdate(cart);
		
	}

	@Override
	public void removeCartItem(CartDetail cartDetail) {
		delete(cartDetail);
		
	}

	@Override
	public void deleteCart(Cart cart) {
		delete(cart);
		
	}

	

}
