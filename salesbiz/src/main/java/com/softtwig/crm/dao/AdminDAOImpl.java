package com.softtwig.crm.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtwig.crm.bo.AdminLoginBO;
import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.exception.SalesBizException;
import com.softtwig.crm.exception.SalesBizLogger;
import com.softtwig.crm.utils.EncryptAndDecrypt;
import com.softtwig.crm.utils.ErrorCodes;
import com.softtwig.crm.vo.AccessLogVO;
import com.softtwig.crm.vo.AccessVo;
import com.softtwig.crm.vo.EmailAccess;
import com.softtwig.crm.vo.LoginStatusVO;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolePrivileges;
import com.softtwig.crm.vo.RolePrivilegesVO;
import com.softtwig.crm.vo.RolesVO;
import com.softtwig.crm.vo.User;


@Repository("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO {

	public AdminDAOImpl() throws SalesBizException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {

		return sessionFactory.getCurrentSession();

	}

	private static final SalesBizLogger LOGGER = SalesBizLogger.getLogger(AdminDAOImpl.class);

	@Override
	public User authendicate(String string, String emailAddress) throws SalesBizException {
		AdminDAOImpl.LOGGER.entry();
		User user = null;
		final String loginQuery = "FROM User E WHERE E.emailAddress = :emailAddress";
		try {
			Session session = getSession();
			final Query query = session.createQuery(loginQuery);
			session.flush();
			query.setParameter("emailAddress", emailAddress);
			if (null != query.list() && query.list().size() > 0) {
				user = (User) query.list().get(0);
			}

		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(ErrorCodes.ENTITY_CRE_FAIL + he);
			}
			throw new SalesBizException(ErrorCodes.ENTITY_CRE_FAIL, ErrorCodes.ENTITY_CRE_FAIL_MSG);
		} finally {

			AdminDAOImpl.LOGGER.exit();
		}

		return user;

	}

	@Override
	public User authendicate(String emailAddress) throws SalesBizException {
		AdminDAOImpl.LOGGER.entry();
		User user = null;
		final String loginQuery = "FROM User E WHERE E.emailAddress = :emailAddress";
		try {
			Session session = getSession();
			final Query query = session.createQuery(loginQuery);
			session.flush();
			query.setParameter("emailAddress", emailAddress);
			if (null != query.list() && query.list().size() > 0) {
				user = (User) query.list().get(0);
			}

		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(ErrorCodes.ENTITY_CRE_FAIL + he);
			}
			throw new SalesBizException(ErrorCodes.ENTITY_CRE_FAIL, ErrorCodes.ENTITY_CRE_FAIL_MSG);
		} finally {

			AdminDAOImpl.LOGGER.exit();
		}

		return user;

	}

	@Override
	public LoginStatusVO editLoginStatus(LoginStatusVO loginStatusVO) {

		Criteria criteria = getSession().createCriteria(LoginStatusVO.class);
		criteria.add(Restrictions.eq("userName", loginStatusVO.getUserName()));
		criteria.add(Restrictions.eq("status", true));
		if (null != criteria.list() && criteria.list().size() > 0) {
			LoginStatusVO statusvo = (LoginStatusVO) criteria.list().get(0);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			Date date = cal.getTime();
			statusvo.setEndTime(date);
			statusvo.setStatus(false);
			statusvo.setActivity("logout");
			getSession().update(statusvo);
			return statusvo;
		}
		return new LoginStatusVO();
	}

	@Override
	public long addLoginStatus(LoginStatusVO loginStatus) {

		long id = 0;
		try {

			Session session = getSession();
			session.saveOrUpdate(loginStatus);
			session.flush();
		} catch (Exception he) {
			he.printStackTrace();
			LOGGER.debug(he.getMessage() + he);
		}

		return id;
	}

	@Override
	public boolean createAccessLog(AccessLogVO logVO) {

		AdminDAOImpl.LOGGER.entry();
		boolean accessLogStatus = false;
		try {
			Session session = getSession();
			long logId = (Long) session.save(logVO);
			session.flush();
			if (0 != logId) {
				accessLogStatus = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();

		} finally {
			AdminDAOImpl.LOGGER.exit();
		}

		return accessLogStatus;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#createuser(com.softtwig.crm.vo.AdminUserVO)
	 */
	@Override
	public long createuser(User adminVO) {
		AdminDAOImpl.LOGGER.entry();

		try {
			Session session = getSession();
			long logId = (Long) session.save(adminVO);
			session.flush();
			if (0 != logId) {
				return logId;
			}
		} catch (HibernateException he) {
			he.printStackTrace();

		} finally {
			AdminDAOImpl.LOGGER.exit();
		}
		return 0;
	}


	@Override
	public List<AdminUserBO> retrieveUser() {
		AdminUserBO adminuserBO = new AdminUserBO();
		List<AdminUserBO> BOList = new ArrayList<AdminUserBO>();
		List<User> VOList = new ArrayList<User>();
		try {
			int count = 1;
			Criteria cr = getSession().createCriteria(User.class);
			cr.add(Restrictions.eq("isDelete", false));
			if (null != adminuserBO.getName() && !adminuserBO.getName().isEmpty()) {
				cr.add(Restrictions.ilike("name", adminuserBO.getName(), MatchMode.ANYWHERE));
			}
			if (null != adminuserBO.getEmailAddress() && !adminuserBO.getEmailAddress().isEmpty()) {
				cr.add(Restrictions.ilike("emailAddress", adminuserBO.getEmailAddress(), MatchMode.ANYWHERE));
			}
			if (null != adminuserBO.getUserType() && !adminuserBO.getUserType().isEmpty()) {
				cr.add(Restrictions.ilike("userType", adminuserBO.getUserType(), MatchMode.ANYWHERE));
			}
			// cr.add(Restrictions.eq("isActive", true));
			cr.addOrder(Order.desc("created"));
			VOList = cr.list();

			if (null != VOList && !VOList.isEmpty()) {
				int data;
				for (User vo : VOList) {
					data = count++;
					adminuserBO = new AdminUserBO();
					adminuserBO.setId(vo.getId());
					adminuserBO.setActive(vo.isActive());
					adminuserBO.setsNo(data);
					adminuserBO.setName(vo.getName());
					adminuserBO.setMobileNo(vo.getMobileNo());
					//adminuserBO.setUserType(vo.getUserType());
					adminuserBO.setPassword(vo.getPassword());
					adminuserBO.setEmailAddress(vo.getEmailAddress());
					adminuserBO.setConfirmPassword(vo.getConfirmpassword());
					if (vo.isActive()) {
						adminuserBO.setStatus("Active");
					} else {
						adminuserBO.setStatus("De-Active");
					}
					BOList.add(adminuserBO);
				}
			}
		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Retrieve user has failed:" + ex.getMessage());
			}
			LOGGER.info("Retrieve user has failed:" + ex.getMessage());
		}
		return BOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#userStatus(com.softtwig.crm.vo.AdminUserVO)
	 */
	@Override
	public User userStatus(User userVO) {
		final String changeLoginQuery = "UPDATE User E set E.isActive = :isActive WHERE E.id= :id";
		try {
			// session = getSession();
			final Query query = getSession().createQuery(changeLoginQuery);
			query.setParameter("isActive", userVO.isActive());
			query.setParameter("id", userVO.getId());
			final int result = query.executeUpdate();
			if (0 != result) {
				return userVO;
			}
		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(he.getMessage() + he);
			}
		} finally {

			AdminDAOImpl.LOGGER.exit();
		}
		return null;

	}


	@Override
	public User deleteProfile(User vo) {
		AdminDAOImpl.LOGGER.entry();
		int result = 0;

		/*final String deleteQuery = "UPDATE User S set" + " S.isDelete = :isDelete" + " WHERE S.id = :id";*/
		try {

			/*final Query query = getSession().createQuery(deleteQuery);
			query.setParameter("isDelete", vo.isDelete());
			query.setParameter("id", vo.getId());
			result = query.executeUpdate();*/

			Session session=getSession();
			if(0<vo.getId()){
				session.delete(vo);
			}

		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(ErrorCodes.ENTITY_DELETE_FAIL + he);
			}

		}

		return vo;
	}


	@Override
	public User updateuser(User loginVO) throws SalesBizException {

		AdminDAOImpl.LOGGER.entry();
		try {
			Session session = getSession();
			session.merge(loginVO);
			getSession().flush();
		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(ErrorCodes.ENTITY_UPDATE_FAIL + he);
			}
			throw new SalesBizException(ErrorCodes.ENTITY_UPDATE_FAIL, ErrorCodes.ENTITY_UPDATE_FAIL_MSG);
		} finally {

			AdminDAOImpl.LOGGER.exit();
		}
		return loginVO;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#retrieveusers(long)
	 */
	@Override
	public AdminUserBO retrieveusers(long userId) {
		AdminUserBO adminuserBO = new AdminUserBO();
		List<AdminUserBO> BOList = new ArrayList<AdminUserBO>();
		List<User> VOList = new ArrayList<User>();
		try {
			int count = 0;
			Criteria cr = getSession().createCriteria(User.class);
			cr.add(Restrictions.eq("isDelete", false));
			// cr.add(Restrictions.eq("isActive", true));
			cr.add(Restrictions.eq("id", userId));
			cr.addOrder(Order.desc("created"));
			VOList = cr.list();

			if (null != VOList && !VOList.isEmpty()) {
				for (User vo : VOList) {
					count = count++;
					adminuserBO = new AdminUserBO();
					adminuserBO.setId(vo.getId());
					adminuserBO.setActive(vo.isActive());
					adminuserBO.setName(vo.getName());
					adminuserBO.setMobileNo(vo.getMobileNo());
					adminuserBO.setPassword(EncryptAndDecrypt.decrypt(vo.getPassword()));
					adminuserBO.setEmailAddress(vo.getEmailAddress());
					//adminuserBO.setUserType(vo.getUserType());
					adminuserBO.setConfirmPassword(EncryptAndDecrypt.decrypt(vo.getConfirmpassword()));
					if (vo.isActive()) {
						adminuserBO.setStatus("Active");
					} else {
						adminuserBO.setStatus("De-Active");
					}
					BOList.add(adminuserBO);
				}
			}
		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Retrieve user has failed:" + ex.getMessage());
			}
			LOGGER.info("Retrieve user has failed:" + ex.getMessage());
		}

		return adminuserBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#getuserId(com.softtwig.crm.vo.User)
	 */
	@Override
	public User getuserId(AdminUserBO loginBO) {
		Session session = getSession();

		User user = (User) session.get(User.class, loginBO.getId());
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#findByEmail(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User findByEmail(String string, String emailAddress) {
		AdminDAOImpl.LOGGER.entry();
		User loginVO = null;
		final String loginQuery = "FROM User E WHERE E.emailAddress = :emailAddress";
		try {
			Session session = getSession();
			final Query query = session.createQuery(loginQuery);
			query.setParameter("emailAddress", emailAddress);
			if (null != query.list() && query.list().size() > 0) {
				loginVO = (User) query.list().get(0);
			}
		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(he, he.getMessage());
			}
		} finally {

			AdminDAOImpl.LOGGER.exit();
		}
		return loginVO;
	}


	@Override
	public List<String> getImageName() {
		List<String> imageNameList = new ArrayList<String>();
		try {
			String imageName = null;
			String sqlQuery = "SELECT imageName,companiesId FROM company WHERE isDeleted = false and adminChecked=true"
					+ " ORDER BY rank ASC LIMIT 60";
			Query query = getSession().createSQLQuery(sqlQuery);
			List<Object[]> rows = query.list();
			if (null != rows && !rows.isEmpty()) {
				for (Object[] obj : rows) {
					if (null != obj) {
						imageName = obj[0].toString() + "," + obj[1];
					} else {
						imageName = "companylogo.jpg";
					}

					if (null != imageName && !imageName.isEmpty()) {
						imageNameList.add(imageName);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return imageNameList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#saveEmailList(java.util.List)
	 */
	@Override
	public EmailAccess saveEmailList(List<EmailAccess> accessVOList) {
		AdminDAOImpl.LOGGER.entry();
		EmailAccess accessVO = new EmailAccess();
		try {
			long sendId = 0;
			Session session = getSession();
			for (EmailAccess emailaccessVO : accessVOList) {
				sendId = (Long) session.save(emailaccessVO);
				session.flush();
				session.clear();
			}
			accessVO.setSendId(sendId);
		} catch (Exception e) {
			e.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Email Tracking History failed:" + e.getMessage());
			}
			LOGGER.info("Email Tracking History failed:" + e.getMessage());

		} finally {
			AdminDAOImpl.LOGGER.exit();
		}
		return accessVO;
	}


	@Override
	public List<User> searchEmployeeList(AdminUserBO adminBO) {
		List<User> VOList = new ArrayList<User>();
		try {
			int count = 1;
			Criteria cr = getSession().createCriteria(User.class);
			cr.add(Restrictions.eq("isDelete", false));
			cr.setFirstResult(adminBO.getRecordIndex());
			cr.setMaxResults(adminBO.getMaxRecord());
			if (null != adminBO.getName() && !adminBO.getName().isEmpty()) {
				cr.add(Restrictions.ilike("name", adminBO.getName(), MatchMode.ANYWHERE));
			}
			if (null != adminBO.getEmailAddress() && !adminBO.getEmailAddress().isEmpty()) {
				cr.add(Restrictions.ilike("emailAddress", adminBO.getEmailAddress(), MatchMode.ANYWHERE));
			}
			if (null != adminBO.getUserType() && !adminBO.getUserType().isEmpty()) {
				cr.add(Restrictions.ilike("userType", adminBO.getUserType(), MatchMode.ANYWHERE));
			}
			// cr.add(Restrictions.eq("isActive", true));
			cr.addOrder(Order.desc("created"));
			VOList = cr.list();


		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(ErrorCodes.ENTITY_DELETE_FAIL + he);
			}
		}
		return VOList;
	}


	@Override
	public boolean findByMobilenoEmployee(User userVO) {
		User user = new User();
		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("mobileNo", userVO.getMobileNo()));
			userVO=(User)criteria.uniqueResult();
			if(null!=userVO.getMobileNo()){
				return true;
			}
			/*
			 * long recordCount= (long) criteria.uniqueResult(); if(0!=recordCount ) {
			 * return true; }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("MobileNo Tracking History failed:" + e.getMessage());
			}
			LOGGER.info("MobileNo Tracking History failed:" + e.getMessage());

		} finally {
			AdminDAOImpl.LOGGER.exit();
		}
		return false;
	}


	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.dao.AdminDAO#employeesCount(com.softtwig.crm.bo.AdminUserBO)
	 */
	@Override
	public long employeesCount(AdminLoginBO adminLoginBO) {

		long employeeCount = 0;
		try {
			Session session = getSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("isDelete", false));
			criteria.add(Restrictions.eq("isActive", true));
			criteria.setProjection(Projections.rowCount());
			employeeCount = (long) criteria.uniqueResult();
		} catch (final HibernateException he) {
			he.printStackTrace();
			if (AdminDAOImpl.LOGGER.isDebugEnabled()) {
				AdminDAOImpl.LOGGER.debug(ErrorCodes.ENTITY_DELETE_FAIL + he);
			}
		}
		return employeeCount;
	}

	@Override
	public boolean findEmployerEmail(String emailAddress) {

		return false;
	}

	@Override
	public boolean mobileNoVerification(String mobileNo) {

		return false;
	}
	
	public static Date getDateWithoutTime(Date date) { 
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return  cal.getTime(); 
	}

	
	@Override
	public PrivilegesVO savePrivileges(PrivilegesVO privilegesvo) {
		Session session = getSession();
		session.save(privilegesvo);
		return privilegesvo;
	}

	@Override
	public List<PrivilegesBO> retrivePrivileges(List<PrivilegesBO> privilegesbolist) {
		List<PrivilegesBO> bolist = new ArrayList<PrivilegesBO>();
		PrivilegesVO privilegesVo = new PrivilegesVO();
		List<PrivilegesVO> volist = new ArrayList<PrivilegesVO>();
		Session session = getSession();
		int count = 1;
		Criteria criteria = session.createCriteria(PrivilegesVO.class);
		criteria.add(Restrictions.eq("isDeleted", false));	
		volist=criteria.list();

		if(volist!=null&&volist.size()>0){
			int data;
			for(PrivilegesVO vo2 : volist){
				data=count++;
				PrivilegesBO bo = new PrivilegesBO();
				bo.setPrivilegeId(vo2.getPrivilegeId());
				bo.setPrivilegename(vo2.getPrivilegesName());
				bo.setsNo(data);
				bolist.add(bo);
			}

		}
		return bolist;

	}

	@Override
	public int deletePrivilege(PrivilegesVO vo) {
		int result = 0;

		final String deleteQuery = "UPDATE PrivilegesVO S set S.isDeleted = :isDeleted   WHERE S.privilegeId = :privilegeId";
		final Query query = getSession().createQuery(deleteQuery);
		query.setParameter("isDeleted", vo.getisDeleted());
		query.setParameter("privilegeId", vo.getPrivilegeId());
		result=query.executeUpdate();
		return result;
	}

	@Override
	public PrivilegesVO editPrivileges(PrivilegesVO vo) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(PrivilegesVO.class);
		criteria.add(Restrictions.eq("privilegeId",vo.getPrivilegeId()));
		vo=(PrivilegesVO) criteria.uniqueResult();
		return vo;
	}

	@Override
	public PrivilegesVO updatePrivileges(PrivilegesVO vo) {
		Session session = getSession();
		session.update(vo);
		return vo;
	}

	@Override
	public List<PrivilegesVO> searchPrivileges(PrivilegesVO vo) {
		PrivilegesBO bo = new PrivilegesBO();
		List<PrivilegesVO> volist = new ArrayList<PrivilegesVO>();
		int count =1;
		Session session = getSession();
		Criteria criteria = session.createCriteria(PrivilegesVO.class);
		criteria.add(Restrictions.eq("isDeleted", false));
		criteria.setFirstResult(bo.getRecordIndex());
		criteria.setMaxResults(bo.getMaxRecord());
		if(null!=vo.getPrivilegesName()&&!vo.getPrivilegesName().isEmpty()){
			criteria.add(Restrictions.ilike("privilegesName", vo.getPrivilegesName(), MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.desc("created"));
		volist=criteria.list();

		return volist;
	}

	@Override
	public List<RoleBO> retriveRolePrivilege(List<RoleBO> roleboolist) {
		RolePrivilegesVO roleprivilegevo = new RolePrivilegesVO();
		List<RolePrivilegesVO> listroleprivilegevo = new ArrayList<RolePrivilegesVO>();
		int count =1;
		List<RolesVO> listrolevo = new ArrayList<RolesVO>();
		List<RoleBO> listrolebo = new ArrayList<RoleBO>();
		if(null!=roleboolist&&roleboolist.size()>0){
			for(RoleBO bo : roleboolist){
				RoleBO rolebo = new RoleBO();
				RolesVO vo = new RolesVO();
				vo.setRoleId(bo.getRoleId());
				int roleid = (int) vo.getRoleId();
				RolePrivileges roleprivilege = new RolePrivileges();
				roleprivilege.setRoleId(roleid);
				roleprivilegevo.setId(roleprivilege);

				Session session= getSession();

				Criteria criteria = session.createCriteria(RolePrivilegesVO.class);
				criteria.add(Restrictions.eq("id.roleId", roleprivilegevo.getId().getRoleId()));
				listroleprivilegevo=criteria.list();



				for(RolePrivilegesVO assignvo :listroleprivilegevo ){
					RoleBO role = new RoleBO();
					RolesVO rolevo = new RolesVO();
					PrivilegesVO voprivilege = new PrivilegesVO();
					int data=count++;
					long roleId= (long) assignvo.getId().getRoleId();
					long priviilegeId = (long) assignvo.getId().getPrivilegeId();
					role.setRoleId(roleId);
					role.setPrivilegeId(priviilegeId);
					role.setsNo(data);
					listrolebo.add(role);

				}

			}
		}
		return listrolebo;

	}

	@Override
	public PrivilegesVO getprivilege(PrivilegesVO privilegevo) {
		Session session = getSession();
		List<PrivilegesVO> list= new ArrayList<PrivilegesVO>();
		PrivilegesVO privilegesvo = new PrivilegesVO();
		Criteria criteria = session.createCriteria(PrivilegesVO.class);
		criteria.add(Restrictions.eq("isDeleted", false));
		criteria.add(Restrictions.eq("privilegesName",privilegevo.getPrivilegesName()));
		privilegesvo=(PrivilegesVO) criteria.uniqueResult();


		return privilegesvo;
	}

	@Override
	public RolePrivilegesVO assignRolePrivilege(RolePrivilegesVO vo) {
		Session session = getSession();
		session.saveOrUpdate(vo);
		return vo;
	}

	@Override
	public RolePrivilegesVO getroleprivilege(RolePrivilegesVO roleprivilegevo) {

		RolePrivilegesVO assignvo = new RolePrivilegesVO();
		Session session = getSession();
		Criteria criteria = session.createCriteria(RolePrivilegesVO.class);
		criteria.add(Restrictions.eq("id.roleId",roleprivilegevo.getId().getRoleId())).add(Restrictions.eq("id.privilegeId", roleprivilegevo.getId().getPrivilegeId()));
		assignvo=(RolePrivilegesVO) criteria.uniqueResult();

		return assignvo;
	}

	@Override
	public RolePrivilegesVO removeRole(RolePrivilegesVO assignvo) {
		int roleId = (int) assignvo.getId().getRoleId();
		 Session session = getSession();
		 String hql = "delete from roles_privileges where roleId = :roleId";
		 Query query = session.createSQLQuery(hql);
		 query.setParameter("roleId", roleId);
		 query.executeUpdate();

		 return assignvo;
	}



	@Override
	public List<AdminUserBO> retrieveUser(List<AdminUserBO> bOList) {

		AdminUserBO adminuserBO = new AdminUserBO();
		List<AdminUserBO> BOList = new ArrayList<AdminUserBO>();
		List<User> VOList = new ArrayList<User>();
		try {
			int count = 1;
			Criteria cr = getSession().createCriteria(User.class);
			cr.add(Restrictions.eq("isDelete", false));
			cr.add(Restrictions.eq("isActive",true));
			if (null != adminuserBO.getName() && !adminuserBO.getName().isEmpty()) {
				cr.add(Restrictions.ilike("name", adminuserBO.getName(), MatchMode.ANYWHERE));
			}
			if (null != adminuserBO.getEmailAddress() && !adminuserBO.getEmailAddress().isEmpty()) {
				cr.add(Restrictions.ilike("emailAddress", adminuserBO.getEmailAddress(), MatchMode.ANYWHERE));
			}
			if (null != adminuserBO.getUserType() && !adminuserBO.getUserType().isEmpty()) {
				cr.add(Restrictions.ilike("userType", adminuserBO.getUserType(), MatchMode.ANYWHERE));
			}
			// cr.add(Restrictions.eq("isActive", true));
			cr.addOrder(Order.desc("created"));
			VOList = cr.list();

			if (null != VOList && !VOList.isEmpty()) {
				int data;
				for (User vo : VOList) {
					List<RoleBO> listrole = new ArrayList<RoleBO>();					
					data = count++;
					User uservo = new User();
					uservo.setListRoletypeVo(vo.getListRoletypeVo());
					adminuserBO = new AdminUserBO();
					adminuserBO.setId(vo.getId());
					adminuserBO.setActive(vo.isActive());
					adminuserBO.setsNo(data);
					adminuserBO.setName(vo.getName());
					adminuserBO.setMobileNo(vo.getMobileNo());
					//adminuserBO.setUserType(vo.getUserType());
					adminuserBO.setPassword(vo.getPassword());
					adminuserBO.setEmailAddress(vo.getEmailAddress());
					adminuserBO.setConfirmPassword(vo.getConfirmpassword());
					adminuserBO.setListrlebo(listrole);
					if (vo.isActive()) {
						adminuserBO.setStatus("Active");
					} else {
						adminuserBO.setStatus("De-Active");
					}
					BOList.add(adminuserBO);
				}
			}
		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Retrieve user has failed:" + ex.getMessage());
			}
			LOGGER.info("Retrieve user has failed:" + ex.getMessage());
		}
		return BOList;


	}

	@Override
	public User retriveUserByname(User user) {
		User uservo = new User();
		Session session = getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("isDelete", false));
		criteria.add(Restrictions.eq("name", user.getName()));
		user=(User) criteria.uniqueResult();

		return user;
	}

	@Override
	public User retriveuserById(User user) {
		User uservo = new User();
		Session session= getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("isDelete", false));
		criteria.add(Restrictions.eq("id", user.getId()));
		uservo=(User) criteria.uniqueResult();

		return uservo;
	}

	@Override
	public PrivilegesVO getprivilegeById(PrivilegesVO privilegesvo) {
		Session session = getSession();
		List<PrivilegesVO> list= new ArrayList<PrivilegesVO>();
		PrivilegesVO privilegevo = new PrivilegesVO();
		Criteria criteria = session.createCriteria(PrivilegesVO.class);
		criteria.add(Restrictions.eq("isDeleted", false));
		criteria.add(Restrictions.eq("privilegeId",privilegesvo.getPrivilegeId()));
		privilegevo=(PrivilegesVO) criteria.uniqueResult();


		return privilegevo;
	}

	@Override
	public List<PrivilegesVO> listOfPrivileges(List<PrivilegesVO> privilegeListVO) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.getCurrentSession();

		try{
			if(null!=privilegeListVO){
				Criteria cr=session.createCriteria(PrivilegesVO.class);
				privilegeListVO=cr.list();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return privilegeListVO;
	}

	@Override
	public List<AccessVo> listOfAccess() {
		// TODO Auto-generated method stub

		List<AccessVo> accessVOList=new ArrayList<>();

		Session session=sessionFactory.getCurrentSession();
		try{
			Criteria cr=session.createCriteria(AccessVo.class);
			accessVOList=cr.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return accessVOList;
	}

	@Override
	public PrivilegesVO privilegeAccess(PrivilegesVO privilegeVo) {
		// TODO Auto-generated method stub
		Session session=getSession();	
		try{
			session.saveOrUpdate(privilegeVo);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return privilegeVo;
	}

	@Override
	public List<PrivilegesVO> listOfPrivilegeAccess() {
		// TODO Auto-generated method stub

		List<PrivilegesVO> privilegeList=new ArrayList<>();

		Session session=getSession();
		try{
			Criteria cr=session.createCriteria(PrivilegesVO.class);
			cr.add(Restrictions.eq("isDeleted",false));
			privilegeList=cr.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return privilegeList;
	}

	@Override
	public List<PrivilegesVO> editPrivilegeAccess(PrivilegesVO privilegeVO) {
		// TODO Auto-generated method stub

		List<PrivilegesVO> privilegeVOList=new ArrayList<>();

		Session session=getSession();
		try{
			if(0<privilegeVO.getPrivilegeId()){
				Criteria cr=session.createCriteria(PrivilegesVO.class);
				cr.add(Restrictions.eq("privilegeId", privilegeVO.getPrivilegeId()));
				privilegeVO=(PrivilegesVO)cr.uniqueResult();

				if(null!=privilegeVO){
					privilegeVOList.add(privilegeVO);
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return privilegeVOList;
	}

	@Override
	public PrivilegesVO updatePrivilegeAccess(PrivilegesVO privilegeVO) {
		// TODO Auto-generated method stub

		Session session=getSession();
		try{
			if(null!=privilegeVO){
				session.update(privilegeVO);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return privilegeVO;
	}

	@Override
	public PrivilegesVO deletePrivilegeAccess(PrivilegesVO privilegeVO) {
		// TODO Auto-generated method stub
		
		Session session=getSession();
		if(0<privilegeVO.getPrivilegeId()){
			session.delete(privilegeVO);
		}
		
		return privilegeVO;
	}
	@Override
	public List<Long> geAccessIdListIdList(PrivilegesVO privilegeVO) {
		List<Long> priviledgeIdList=new ArrayList<Long>();
		Session session=getSession();
		try {
			Criteria criteria = session.createCriteria(PrivilegesVO.class);
			criteria.createCriteria("accessList","ref");
			criteria.setProjection(Projections.groupProperty("ref.privilegeId"));
			criteria.add(Restrictions.eq("privilegeId",privilegeVO.getPrivilegeId()));
			priviledgeIdList=(List<Long>) criteria.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return priviledgeIdList;
}

	@Override
	public List<RolesVO> getUserRoles(long userId) {
		Session session=sessionFactory.getCurrentSession();
		List<RolesVO> accessVOList=null;
		try{
			Criteria cr=session.createCriteria(User.class);
			cr.createAlias("listRoletypeVo", "roles");
			cr.add(Restrictions.eq("roles.id", userId));
			 accessVOList = cr.list();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return accessVOList;
	}

	
}
