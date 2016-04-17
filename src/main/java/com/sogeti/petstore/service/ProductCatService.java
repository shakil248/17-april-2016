package com.sogeti.petstore.service;

import java.util.List;

import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.model.ProductCategory;

public interface ProductCatService {
	
	public void createOrUpdateProductCat(ProductCategory productCategory);
	public ProductCategory getProductCat(String productCatId);
	public List<ProductCategory> getProductCategories();

}
