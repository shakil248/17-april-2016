package com.sogeti.petstore.dao;

import com.sogeti.petstore.model.User;

public interface UserDAO {

	public void createOrUpdateUser(User user);
	public User getUser(String id);
	public User getUserByEmailId(String emailId);
	
}
