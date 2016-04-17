package com.sogeti.petstore.service;

import java.util.List;

import com.sogeti.petstore.model.Product;

public interface ProductService {
	
	public void createOrUpdateProduct(Product product);
	public Product getProduct(String productId);
	public List<Product> getProducts(String productCatId);
	public List<Product> getAllProducts();

}
