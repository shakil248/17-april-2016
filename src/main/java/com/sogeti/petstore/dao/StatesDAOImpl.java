package com.sogeti.petstore.dao;

import java.util.List;

import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.stereotype.Repository;

import com.sogeti.petstore.model.States;

@Repository
public class StatesDAOImpl extends BaseDAO implements StatesDAO {
	
	@Override
	public List<States> getStates(){
		return getAll(States.class);
	}

	@Override
	public void createStates(States states) {
				persist(states);
	}

}
