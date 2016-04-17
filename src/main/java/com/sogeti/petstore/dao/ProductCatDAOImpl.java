package com.sogeti.petstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.model.ProductCategory;

@Repository
public class ProductCatDAOImpl extends BaseDAO implements ProductCatDAO {

	@Override
	public void createOrUpdateProductCat(ProductCategory productCategory) {
		saveOrUpdate(productCategory);
		
	}

	@Override
	public ProductCategory getProductCat(String productCatId) {
		return get(ProductCategory.class, productCatId);
	}

	@Override
	public List<ProductCategory> getProductCategories() {
		Criteria cr = getSession().createCriteria(ProductCategory.class);
		cr.add(Restrictions.eq("isActive", true));
		if(cr.list().size()>0){
			return (List<ProductCategory>) cr.list();
		}
		return null;
	}

	

	

	

}
