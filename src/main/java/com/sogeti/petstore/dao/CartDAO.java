package com.sogeti.petstore.dao;

import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;


public interface CartDAO {
	
	public void saveCart(Cart cart);
	public void updateCart(Cart cart);
	public Cart getCart(String emailId);
	public void removeCartItem(CartDetail cartDetail);
	public void deleteCart(Cart cart);
	

}
