package com.sogeti.petstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public <T> void persist(T entity) {
    	getSession().persist(entity);
    }
    
    public <T> void saveOrUpdate(T entity) {
        	getSession().saveOrUpdate(entity);
    }
 
    public <T> void update(T entity) {
        getSession().merge(entity);
    }
    
    public <T> void delete(T entity) {
        getSession().delete(entity);
    }
    
    public <T,V extends String> T get(Class<T> type, V id){
    	return (T) getSession().get(type, id);
    }
    
    public <T> List<T> getAll(Class<T> type){
    	return  getSession().createCriteria(type).list();
    }
    
    
   

}
