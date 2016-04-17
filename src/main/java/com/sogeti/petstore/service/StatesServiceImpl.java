package com.sogeti.petstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.petstore.dao.StatesDAO;
import com.sogeti.petstore.model.States;

@Service
@Transactional
public class StatesServiceImpl implements StatesService {

	@Autowired
	StatesDAO statesDAO;
	
	@Override
	public List<States> getStates() {
		return statesDAO.getStates();
	}

	@Override
	public void populateStates() {
		if (null!= statesDAO.getStates() && statesDAO.getStates().size()>0){
			return;
		}
		States states1 = new States();
		States states2 = new States();
		States states3 = new States();
		States states4 = new States();
		states1.setStateName("Karnataka");
		states2.setStateName("Chhattisgarh");
		states3.setStateName("Maharastra");
		states4.setStateName("Delhi");
		statesDAO.createStates(states1);
		statesDAO.createStates(states2);
		statesDAO.createStates(states3);
		statesDAO.createStates(states4);
		
	}

}
