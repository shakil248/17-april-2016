package com.sogeti.petstore.service;

import com.sogeti.petstore.model.User;

public interface UserService {
	
	public void createOrUpdateUser(User user);
	public User getUser(String id);
	public User getUserByEmailId(String emailId);
	public boolean doLogin(String emailId, String password);

}
