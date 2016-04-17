package com.sogeti.petstore.service;

import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;

public interface CartService {
	
	public void createOrUpdateCart(Cart cart);
	public Cart getCart(String emailId);
	public void removeCartItem(CartDetail cartDetail);
	public void deleteCart(Cart cart);

}
