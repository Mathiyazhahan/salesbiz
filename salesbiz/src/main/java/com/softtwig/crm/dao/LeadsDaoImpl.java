package com.softtwig.crm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtwig.crm.exception.SalesBizException;
import com.softtwig.crm.exception.SalesBizLogger;

public class LeadsDaoImpl implements LeadsDao{
	
	public LeadsDaoImpl() throws SalesBizException {
		super();
	}
	private static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(LeadsDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {

		return sessionFactory.getCurrentSession();

	}
}
