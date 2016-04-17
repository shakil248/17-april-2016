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

import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.model.User;
import com.sogeti.petstore.service.ProductService;
import com.sogeti.petstore.service.StatesService;
import com.sogeti.petstore.service.UserService;

@Controller
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	
	
	@RequestMapping(value = "/getproduct", method = RequestMethod.GET)
	    public ResponseEntity<Product> getProduct(@RequestParam(value = "productId") String productId) {
		Product product = productService.getProduct(productId);
		  return new ResponseEntity<Product>(product, HttpStatus.OK);
	    }
	
	@RequestMapping(value = "/getproductbycat", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductByCat(@RequestParam(value = "productCatId") String productCatId) {
	List<Product> products = productService.getProducts(productCatId);
	  return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getallproducts", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
	List<Product> products = productService.getAllProducts();
	  return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/createproduct", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productService.createOrUpdateProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
