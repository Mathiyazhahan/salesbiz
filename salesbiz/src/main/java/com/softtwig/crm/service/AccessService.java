package com.softtwig.crm.service;

import java.util.List;

import com.softtwig.crm.bo.AccessBo;

public interface AccessService {

	AccessBo createSaveAccess(AccessBo accessBo);
	List<AccessBo> viewAccess();
	AccessBo updateAccessValue(AccessBo accessBo);
	
	long deleteAccess(AccessBo accessBo);
	List<AccessBo> getAccessList(AccessBo accessbo);

	

}
