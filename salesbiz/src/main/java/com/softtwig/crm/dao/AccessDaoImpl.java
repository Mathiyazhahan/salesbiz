package com.softtwig.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.vo.AccessVo;

@Repository
public class AccessDaoImpl implements AccessDao {

	@Autowired
	
	private SessionFactory sessionfac;
	
	@Override
	public AccessVo AccessCreateValue(AccessVo acccessVo) {
		// TODO Auto-generated method stub
		
		AccessVo accessVo=new AccessVo();
		Session session=sessionfac.getCurrentSession();
		session.save(acccessVo);
		
		return acccessVo;
	}

	@Override
	public List<AccessBo> viewAccessDao() {
		// TODO Auto-generated method stub
		AccessBo bo=null;
		
		 List<AccessBo> accessbo=new ArrayList<AccessBo>();
		 List<AccessVo> accessVo=new ArrayList<AccessVo>();
		
		 Session session=sessionfac.getCurrentSession();
		 Criteria criteria=session.createCriteria(AccessVo.class);
		 accessVo=criteria.list();
		 for(AccessVo accessvo:accessVo ) {
			 bo=new AccessBo();
			 bo.setAccessId(accessvo.getAccessId());
			 bo.setAccessName(accessvo.getAccessName());
			 accessbo.add(bo);
			 
			 
		 }
		return accessbo;
	}

	@Override
	public AccessVo updateDao(AccessVo accessVo) {
		// TODO Auto-generated method stub
		AccessBo accessbo=new AccessBo();
		Session session=sessionfac.getCurrentSession();
		session.saveOrUpdate(accessVo);
		
		
		return accessVo;
	}

	@Override
	public AccessVo deleteAccess(AccessVo accessvo) {
		// TODO Auto-generated method stub
		
		
		Session session=sessionfac.getCurrentSession();
		session.delete(accessvo);
		
		
		return accessvo;
	}

	@Override
	public List<AccessVo> searchAccessValue(AccessVo accessvo) {
		// TODO Auto-generated method stub
		
		List<AccessVo>accesslistVo=new ArrayList<AccessVo>();
		
		
		Session session = sessionfac.getCurrentSession();
		Criteria criteria = session.createCriteria(AccessVo.class);
		if(null !=accessvo.getAccessName() && !accessvo.getAccessName().isEmpty()) {
			criteria.add(Restrictions.ilike("accessName", accessvo.getAccessName(), MatchMode.ANYWHERE));
			
		}
		
		
		accesslistVo=criteria.list();
		
		return accesslistVo;
		
		
	}
	

}
