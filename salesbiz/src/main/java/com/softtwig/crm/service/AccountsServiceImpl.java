package com.softtwig.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.exception.SalesBizLogger;

@Service("accountsService")
@Transactional
public class AccountsServiceImpl implements AccountsService {
	
	static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(AccountsServiceImpl.class);

}
