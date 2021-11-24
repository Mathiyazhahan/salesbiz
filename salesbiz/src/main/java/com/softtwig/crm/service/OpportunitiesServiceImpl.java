package com.softtwig.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.exception.SalesBizLogger;

@Service("opportunitiesService")
@Transactional
public class OpportunitiesServiceImpl implements OpportunitiesService {
	
	static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(OpportunitiesServiceImpl.class);

}
