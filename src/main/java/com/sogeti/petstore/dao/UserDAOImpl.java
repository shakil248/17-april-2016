package com.sogeti.petstore.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void createOrUpdateUser(User user) {
		saveOrUpdate(user);
		
	}

	@Override
	public User getUser(String id) {
		return get(User.class, id);		
	}
	
	@Override
	public User getUserByEmailId(String emailId){
		Criteria cr = getSession().createCriteria(User.class);
		cr.add(Restrictions.eq("emailId", emailId));
		if(cr.list().size()>0){
			return (User) cr.list().get(0);
		}
		return null;
		
	}

}
