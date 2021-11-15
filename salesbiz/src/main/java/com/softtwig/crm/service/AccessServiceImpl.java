package com.softtwig.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.dao.AccessDao;
import com.softtwig.crm.vo.AccessVo;

@Service

@Transactional
public class AccessServiceImpl implements AccessService {
	@Autowired
	
	private AccessDao accessdao;

	@Override
	public AccessBo createSaveAccess(AccessBo accessBo) {
		// TODO Auto-generated method stub
		
		
		
		AccessVo acccessVo=new AccessVo();
		
		acccessVo.setAccessName(accessBo.getAccessName());
		
		acccessVo=accessdao.AccessCreateValue(acccessVo);
		if(0 <acccessVo.getAccessId() ) {
			accessBo.setAccessId(acccessVo.getAccessId());
			
			
		}
		
		
		
		return accessBo;
	}

	

	@Override
	public List<AccessBo> viewAccess() {
		// TODO Auto-generated method stub
		
		
         List<AccessBo> listAccess=new ArrayList<AccessBo>();
		
		
		listAccess=accessdao.viewAccessDao();
		
		
		return listAccess;
	}



	@Override
	public AccessBo updateAccessValue(AccessBo accessBo) {
		// TODO Auto-generated method stub
		AccessVo accessVo=new AccessVo();
		
		accessVo.setAccessId(accessBo.getAccessId());
		accessVo.setAccessName(accessBo.getAccessName());
		accessVo=accessdao.updateDao(accessVo);
		if(0 <accessVo.getAccessId() ) {
			accessVo.setAccessId(accessBo.getAccessId());
		}
		
		
		return accessBo;
	}



	@Override
	public long deleteAccess(AccessBo accessBo) {
		// TODO Auto-generated method stub
		int count=0;
		
		AccessVo accessvo=new AccessVo();
		accessvo.setAccessId(accessBo.getAccessId());
		accessvo.setAccessName(accessBo.getAccessName());
		accessvo=accessdao.deleteAccess(accessvo);
		
		if(0 <accessvo.getAccessId()) {
			accessBo.setAccessId(accessvo.getAccessId());
		}
		
		return count;
	}



	@Override
	public List<AccessBo> getAccessList(AccessBo accessbo) {
		
		AccessVo accessvo=new AccessVo();
		List<AccessVo> listVo=new ArrayList<AccessVo>();
		List<AccessBo> listBo=new ArrayList<AccessBo>();
		accessvo.setAccessId(accessbo.getAccessId());
		accessvo.setAccessName(accessbo.getAccessName());
		
		
		listVo=accessdao.searchAccessValue(accessvo);
		
		if(null!=listVo && listVo.size()>0 && !listVo.isEmpty()) {
			
			for (AccessVo accessVo : listVo) {
				
				AccessBo access=new AccessBo();
				access.setAccessId(accessVo.getAccessId());
				access.setAccessName(accessVo.getAccessName());
				listBo.add(access);
			}
		}
		
		
		
		
		return listBo;
		
		
	}



	



	
	

}
