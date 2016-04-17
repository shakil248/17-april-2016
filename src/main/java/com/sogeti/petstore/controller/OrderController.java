package com.sogeti.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sogeti.petstore.model.Order;
import com.sogeti.petstore.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/getorder", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@RequestParam(value = "emailId") String emailId) {
		Order order =  orderService.getOrder(emailId);
	return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getallorders", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders =  orderService.getAllOrders();
	return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/createorder", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> createOrder(@RequestBody Order order) {
		 orderService.createOrder(order);
	 return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/updateorder", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<Void> updateOrder(@RequestBody Order order) {
		 orderService.updateOrder(order);
	 return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
