package com.softtwig.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.exception.SalesBizLogger;

@Service("campaignsService")
@Transactional
public class CampaignsServiceImpl implements CampaignsService {
	
	static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(CampaignsServiceImpl.class);

}
