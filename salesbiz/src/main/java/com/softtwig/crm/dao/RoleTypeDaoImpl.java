package com.softtwig.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolesVO;

@Repository
public class RoleTypeDaoImpl implements RoleTypeDao {

	@Autowired
	SessionFactory sessionfac;

	@Override
	public RolesVO getroletype(RolesVO roleVOobj) {
		// TODO Auto-generated method stub

		try {
			Session session=sessionfac.getCurrentSession();
			session.save(roleVOobj);	
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return roleVOobj;
	}

	@Override
	public List<RoleBO> viewrole() {
		// TODO Auto-generated method stub

		RoleBO roleBOobj=null;
		int count=1;
		List<RoleBO> viewBOobj=new ArrayList<>();
		List<RolesVO> viewVOobj=new ArrayList<>();

		Session session=sessionfac.getCurrentSession();

		try {
			Criteria crit=session.createCriteria(RolesVO.class);
			viewVOobj=crit.list();

			for (RolesVO roleTypeVO : viewVOobj) {
				int data;
				data=count++;
				roleBOobj =new RoleBO();
				roleBOobj.setRoleId(roleTypeVO.getRoleId());
				roleBOobj.setRoleName(roleTypeVO.getRoleName());
				roleBOobj.setsNo(data);
				viewBOobj.add(roleBOobj);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);	
		}

		return viewBOobj;
	}
	/*
	 * @Override public RoleTypeVO geteditrole(long id) { // TODO Auto-generated
	 * method stub
	 * 
	 * RoleTypeVO roleVOobj=new RoleTypeVO(); Session
	 * session=sessionfac.getCurrentSession(); Criteria
	 * crit=session.createCriteria(RoleTypeVO.class);
	 * crit.add(Restrictions.eq("roleId",id )); roleVOobj=(RoleTypeVO)
	 * crit.uniqueResult(); return roleVOobj; }
	 */

	@Override
	public RolesVO posteditrole(RolesVO roleVOobj) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionfac.getCurrentSession();
			session.saveOrUpdate(roleVOobj);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return roleVOobj;
	}

	@Override
	public RolesVO deletepost(RolesVO roleVOobj) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionfac.getCurrentSession();
			session.delete(roleVOobj);
		}
		catch (Exception e) {

			System.out.println(e);
		}

		return roleVOobj;
	}

	@Override
	public RolesVO getroleid(RolesVO roletypevo) {
		RolesVO roleTypeVO = new RolesVO();
		Session session = sessionfac.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(RolesVO.class);
			criteria.add(Restrictions.eq("roleName",roletypevo.getRoleName()));
			roleTypeVO=(RolesVO) criteria.uniqueResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return roleTypeVO;
	}

	@Override
	public RolesVO getRolelist(RolesVO rolevo) {
		RolesVO roleTypeVO = new RolesVO();
		Session session = sessionfac.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(RolesVO.class);
			criteria.add(Restrictions.eq("roleId",rolevo.getRoleId()));
			roleTypeVO=(RolesVO) criteria.uniqueResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return roleTypeVO;
	}

	@Override
	public RolesVO createRolePrivileges(RolesVO rolevo) {
		Session session = sessionfac.getCurrentSession();
		session.saveOrUpdate(rolevo);
		return rolevo;
	}

	@Override
	public List<RolesVO> viewrole(List<RolesVO> rolesvo) {

		List<RolesVO> viewVOobj=new ArrayList<>();

		Session session=sessionfac.getCurrentSession();

		try {
			Criteria crit=session.createCriteria(RolesVO.class);
			crit.add(Restrictions.eq("isActive",true));
			viewVOobj=crit.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return viewVOobj;
	}

	@Override
	public RolesVO deleteRolePrivileges(RolesVO rolevo) {
		Session session=sessionfac.getCurrentSession();
		session.update(rolevo);
		return rolevo;
	}

	@Override
	public List<RolesVO> searchRoleName(RolesVO roleVO) {
		// TODO Auto-generated method stub

		List<RolesVO> roleVOList=new ArrayList<>();

		try {
			Session session=sessionfac.getCurrentSession();
			Criteria creteria=session.createCriteria(RolesVO.class);
			creteria.add(Restrictions.ilike("roleName", roleVO.getRoleName(), MatchMode.ANYWHERE));
			roleVOList=creteria.list();			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return roleVOList;

	}

	@Override
	public List<Long> getPrivelegeIdList(RolesVO rolevo) {
		List<Long> priviledgeIdList=new ArrayList<Long>();
		Session session = sessionfac.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(RolesVO.class);
			criteria.createCriteria("listPrivilegesvo","ref");
			criteria.setProjection(Projections.groupProperty("ref.privilegeId"));
			criteria.add(Restrictions.eq("roleId",rolevo.getRoleId()));
			priviledgeIdList=(List<Long>) criteria.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return priviledgeIdList;
	}

	@Override
	public PrivilegesVO getPrivilegelist(PrivilegesVO privilegesVO) {
		PrivilegesVO privilegesVo = new PrivilegesVO();
		Session session = sessionfac.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(PrivilegesVO.class);
			criteria.add(Restrictions.eq("privilegeId",privilegesVO.getPrivilegeId()));
			privilegesVo= (PrivilegesVO) criteria.uniqueResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return privilegesVo;
	}
	@Override
	public List<Long> getPrivelegeIdList(PrivilegesVO privilegesVO) {
		List<Long> accessIdIdList=new ArrayList<Long>();
		Session session = sessionfac.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(PrivilegesVO.class);
			criteria.createCriteria("accessList","ref");
			criteria.setProjection(Projections.groupProperty("ref.accessId"));
			criteria.add(Restrictions.eq("privilegeId",privilegesVO.getPrivilegeId()));
			accessIdIdList=(List<Long>) criteria.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return accessIdIdList;
	}

}
