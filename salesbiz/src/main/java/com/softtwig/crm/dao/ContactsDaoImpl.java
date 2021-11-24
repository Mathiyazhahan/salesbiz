package com.softtwig.crm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtwig.crm.exception.SalesBizException;
import com.softtwig.crm.exception.SalesBizLogger;

public class ContactsDaoImpl implements ContactsDao{
	
	public ContactsDaoImpl() throws SalesBizException {
		super();
	}
	private static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(ContactsDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {

		return sessionFactory.getCurrentSession();

	}
}
