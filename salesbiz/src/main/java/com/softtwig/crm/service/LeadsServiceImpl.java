package com.softtwig.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.exception.SalesBizLogger;

@Service("leadsService")
@Transactional
public class LeadsServiceImpl implements LeadsService {
	
	static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(LeadsServiceImpl.class);

}
