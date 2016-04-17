package com.sogeti.petstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.petstore.dao.UserDAO;
import com.sogeti.petstore.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void createOrUpdateUser(User user) {
		userDAO.createOrUpdateUser(user);
	}


	@Override
	public User getUser(String id) {
		return userDAO.getUser(id);		
	}

	@Override
	public User getUserByEmailId(String emailId) {
		return userDAO.getUserByEmailId(emailId);
	}
	
	@Override
	public boolean doLogin(String emailId, String password) {
			User user = userDAO.getUserByEmailId(emailId);
			if (null!=user &&  null!=password ){
				if(password.equals(user.getPassword())){
						return true;
				}
			}
		return false;
	}
	
}