package com.sogeti.petstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.petstore.dao.ProductCatDAO;
import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.model.ProductCategory;

@Service
@Transactional
public class ProductCatServiceImpl implements ProductCatService {

	@Autowired
	ProductCatDAO productCatDAO;

	@Override
	public void createOrUpdateProductCat(ProductCategory productCategory) {
		productCatDAO.createOrUpdateProductCat(productCategory);
		
	}

	@Override
	public ProductCategory getProductCat(String productCatId) {
		return productCatDAO.getProductCat(productCatId);
	}

	@Override
	public List<ProductCategory> getProductCategories() {
		return productCatDAO.getProductCategories();
	} 

}
