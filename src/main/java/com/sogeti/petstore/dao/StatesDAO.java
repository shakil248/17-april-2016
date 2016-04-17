package com.sogeti.petstore.dao;

import java.util.List;

import com.sogeti.petstore.model.States;

public interface StatesDAO {
	public List<States> getStates();
	
	public void createStates(States states);
}
