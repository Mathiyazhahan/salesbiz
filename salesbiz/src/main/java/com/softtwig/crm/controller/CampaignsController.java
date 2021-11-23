package com.softtwig.crm.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;

import com.softtwig.crm.exception.SalesBizLogger;
import com.softtwig.crm.security.ControllerUtils;

@Controller
public class CampaignsController extends ControllerUtils implements Serializable{

	private static final long serialVersionUID = -7566828223244087438L;

	private static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(CampaignsController.class);
	
}
