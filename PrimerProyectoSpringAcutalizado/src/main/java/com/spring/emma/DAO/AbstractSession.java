package com.spring.emma.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



public abstract class AbstractSession {
	
	//este es un objeto sessionFactory , con el Autowired estoy llamando al objeto y diciendo que lo eprsista
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//aca devuelvo ese objeto , lo instancia automaticamente Spring
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	

}
