package com.softtwig.crm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtwig.crm.vo.User;


@Repository
public class UserRoleDAOImpl implements UserRoleDAO{
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/*@Override
	public UserRoleVO createUserRole(UserRoleVO userRolevo) {
		UserRoleVO vo = new UserRoleVO();
		sessionFactory.getCurrentSession().save(userRolevo);
		vo.setUserRoleId(userRolevo.getUserRoleId());
		vo.setUserRoleName(userRolevo.getUserRoleName());
		return vo;
	}
*/
	/*@Override
	public List<UserRolesBO> retrieveUserRoles(List<UserRolesBO> listbo) {
		List<UserRolesBO> lisrbo = new ArrayList<UserRolesBO>();
		List<UserRoleVO> listrolevo = new ArrayList<UserRoleVO>();
		Session session = getSession();
		Criteria crit = session.createCriteria(UserRoleVO.class);
		crit.add(Restrictions.eq("isDeleted", false));
		listrolevo=crit.list();
		
		if(null!=listrolevo&&listrolevo.size()>0){
			for(UserRoleVO vo :listrolevo ){
				UserRolesBO bo = new UserRolesBO();
				bo.setUserRolesId(vo.getUserRoleId());
				bo.setUserRolesName(vo.getUserRoleName());
				lisrbo.add(bo);
				
			}
		}
		return lisrbo;
	}
*/
	@Override
	public User createUserRole(User uservo) {
		Session session = getSession();
		session.saveOrUpdate(uservo);
		return uservo;
	}
	@Override
	public User deleteUserRole(User user) {
		Session session = getSession();
		session.update(user);
		return null;
	}


}
