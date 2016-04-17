package com.sogeti.petstore.service;

import java.util.List;

import com.sogeti.petstore.model.States;

public interface StatesService {
	
	public List<States> getStates();

	public void populateStates();

}
