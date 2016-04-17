package com.sogeti.petstore.dao;

import java.util.List;

import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.model.ProductCategory;

public interface ProductCatDAO {
	
	public void createOrUpdateProductCat(ProductCategory productCategory);
	
	public ProductCategory getProductCat(String productCatId);
	
	public List<ProductCategory> getProductCategories();

}
