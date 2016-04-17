package com.sogeti.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sogeti.petstore.model.Cart;
import com.sogeti.petstore.model.CartDetail;
import com.sogeti.petstore.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/getcart", method = RequestMethod.GET)
    public ResponseEntity<Cart> getCart(@RequestParam(value = "emailId") String emailId) {
	  Cart cart =  cartService.getCart(emailId);
	return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> addToCart(@RequestBody Cart cart) {
		 cartService.createOrUpdateCart(cart);
	 return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/removecartitem", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> removeCartItem(@RequestBody CartDetail cartDetail) {
		 cartService.removeCartItem(cartDetail);
	 return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
