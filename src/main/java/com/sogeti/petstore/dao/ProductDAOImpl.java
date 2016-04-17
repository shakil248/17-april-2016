package com.sogeti.petstore.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.Product;
import com.sogeti.petstore.model.User;

@Repository
public class ProductDAOImpl extends BaseDAO implements ProductDAO {
	

	@Override
	public List<Product> getProducts(String productCatId) {
		
			Criteria cr = getSession().createCriteria(Product.class);
			cr.add(Restrictions.eq("productCatId", productCatId));
			cr.add(Restrictions.eq("isActive", true));
			if(cr.list().size()>0){
				return (List<Product>) cr.list();
			}
			return null;
	}

	@Override
	public void createOrUpdateProduct(Product product) {
		saveOrUpdate(product);
		
	}

	@Override
	public Product getProduct(String productId) {
		return get(Product.class, productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return getAll(Product.class);
	}

	
}
