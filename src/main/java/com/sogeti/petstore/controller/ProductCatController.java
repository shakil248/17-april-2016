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

import com.sogeti.petstore.model.ProductCategory;
import com.sogeti.petstore.service.ProductCatService;

@Controller
public class ProductCatController {
	
	@Autowired
	ProductCatService productCatService;
	
	@RequestMapping(value = "/getproductcat", method = RequestMethod.GET)
    public ResponseEntity<ProductCategory> getProduct(@RequestParam(value = "productCatId") String productCatId) {
	ProductCategory productCat = productCatService.getProductCat(productCatId);
    return new ResponseEntity<ProductCategory>(productCat, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getallproductcat", method = RequestMethod.GET)
    public ResponseEntity<List<ProductCategory>> getProduct() {
	List<ProductCategory> productCatList = productCatService.getProductCategories();
	return new ResponseEntity<List<ProductCategory>>(productCatList, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/createproductcat", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Void> createProduct(@RequestBody ProductCategory productCat) {
	productCatService.createOrUpdateProductCat(productCat);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
