package com.softtwig.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.exception.SalesBizLogger;

@Service("contactsService")
@Transactional
public class ContactsServiceImpl implements ContactsService {
	
	static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(ContactsServiceImpl.class);

}
