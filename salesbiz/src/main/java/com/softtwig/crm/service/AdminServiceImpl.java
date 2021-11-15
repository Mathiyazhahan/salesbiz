package com.softtwig.crm.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.bo.AccessLogBO;
import com.softtwig.crm.bo.AdminLoginBO;
import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.dao.AdminDAO;
import com.softtwig.crm.dao.RoleTypeDao;
import com.softtwig.crm.exception.MySalesException;
import com.softtwig.crm.exception.MySalesLogger;
import com.softtwig.crm.model.EmailModel;
import com.softtwig.crm.utils.EncryptAndDecrypt;
import com.softtwig.crm.utils.SendEmailServiceImpl;
import com.softtwig.crm.utils.SuccessMsg;
import com.softtwig.crm.vo.AccessLogVO;
import com.softtwig.crm.vo.AccessVo;
import com.softtwig.crm.vo.LoginStatusVO;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolePrivileges;
import com.softtwig.crm.vo.RolePrivilegesVO;
import com.softtwig.crm.vo.RolesVO;
import com.softtwig.crm.vo.User;

/**
 * Owner : Scube Technologies Created Date: Nov-22-2014 Created by :
 * Sathishkumar.s Description : JobSeekerServiceImpl Class is a Class which is
 * responsible for access the data from Controller then convert it into
 * persistent Object then sent it into DAO class. Reviewed by :
 * 
 * 
 */

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	static final MySalesLogger LOGGER = MySalesLogger.getLogger(AdminServiceImpl.class);
	// DAo layer annotations
	@Autowired
	private AdminDAO adminDAO;
	static boolean isApproval = true;
	EmailModel model = new EmailModel();

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SendEmailServiceImpl emailManager;

	@Autowired
	private RoleTypeService roleTypeService;

	@Autowired
	private RoleTypeDao roleTypeDAO;


	@Override
	public AdminLoginBO authendicate(AdminLoginBO adminLoginBO) throws MySalesException {
		AdminServiceImpl.LOGGER.entry();

		final AdminLoginBO adminLogin = new AdminLoginBO();
		try {
			final User user = this.adminDAO.authendicate("emailAddress", adminLoginBO.getEmailAddress());

			/*
			 * if (null != adminLoginVO) { final String password =
			 * EncryptAndDecrypt.decrypt( adminLoginVO.getPassword(),
			 * EncryptAndDecrypt.TOKEN);
			 */
			if (adminLoginBO.getPassword().equals(user.getPassword())) {
				if (user.isActive()) {
					BeanUtils.copyProperties(user, adminLogin);
					String userName = adminLoginBO.getEmailAddress();
					addLoginStatus(userName);
					adminLogin.setActive(true);
				} else {
					adminLogin.setActive(false);
				}
			} else {
				adminLogin.setActive(false);
			}
			// adminLogin.setPassword(password);

			/* */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return adminLogin;
	}

	@Override
	public boolean editLoginStatus(LoginStatusVO loginStatusVO) {
		adminDAO.editLoginStatus(loginStatusVO);
		return false;

	}

	@Override
	public boolean addLoginStatus(String username) throws MySalesException {

		LoginStatusVO loginStatus = new LoginStatusVO();
		loginStatus.setUserName(username);
		loginStatus.setType("Admin");
		loginStatus.setStatus(true);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date date = cal.getTime();
		loginStatus.setStartTime(date);
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.MONTH, 1);
		Date date1 = cal.getTime();
		loginStatus.setEndTime(date1);
		loginStatus.setActivity("login");
		adminDAO.addLoginStatus(loginStatus);

		return false;
	}

	@Override
	public boolean createAccessLog(AccessLogBO logBO) {
		boolean accessStatus = false;
		try {
			AccessLogVO logVO = new AccessLogVO();
			logVO.setAccessId(logBO.getAccessId());
			logVO.setAccessDate(logBO.getAccessDate());
			logVO.setClientIP(logBO.getClientIP());
			logVO.setSessionId(logBO.getSessionId());
			accessStatus = adminDAO.createAccessLog(logVO);
		} catch (Exception e) {

		}
		return accessStatus;
	}

	@Override
	public AdminUserBO createuser(AdminUserBO adminBO) throws MySalesException {

		User adminVO = new User();
		try {
			BeanUtils.copyProperties(adminBO, adminVO);
			adminVO.setActive(true);
			adminVO.setDelete(false);
			adminVO.setConfirmpassword(EncryptAndDecrypt.encrypt(adminBO.getConfirmPassword()));
			adminVO.setPassword(EncryptAndDecrypt.encrypt(adminBO.getPassword()));
			long id = adminDAO.createuser(adminVO);
			if (id > 0) {
				adminBO.setId(id);
			}

		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add user has failed:" + ex.getMessage());
			}
			LOGGER.info("Add user has failed:" + ex.getMessage());
		}

		return adminBO;

	}

	@Override
	public List<AdminUserBO> retrieveUser() throws MySalesException {
		List<AdminUserBO> BOList = new ArrayList<AdminUserBO>();
		BOList = adminDAO.retrieveUser();
		return BOList;
	}


	@Override
	public AdminUserBO updateuser(AdminUserBO adminBO) {
		try {
			User loginVO = new User();

			//	loginVO = adminDAO.getuserId(adminBO);

			loginVO.setMobileNo(adminBO.getMobileNo());
			loginVO.setName(adminBO.getName());
			loginVO.setEmailAddress(adminBO.getEmailAddress());
			loginVO.setPassword(EncryptAndDecrypt.encrypt(adminBO.getPassword()));
			loginVO.setConfirmpassword(EncryptAndDecrypt.encrypt(adminBO.getConfirmPassword()));
			//loginVO.setUserType(adminBO.getUserType());
			loginVO.setModified(new Date());
			loginVO.setModifiedBy(adminBO.getUserId());
			loginVO.setId(adminBO.getId());
			loginVO.setActive(true);
			loginVO.setListRoletypeVo(getUserRoles(adminBO.getUserId()));
			loginVO = adminDAO.updateuser(loginVO);

			if (0 != loginVO.getId()) {
				adminBO.setId(loginVO.getId());
			} else {
				adminBO = new AdminUserBO();
			}
		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Update user has failed:" + ex.getMessage());
			}
			LOGGER.info("Update user has failed:" + ex.getMessage());
		}
		return adminBO;

	}
	
	private List<RolesVO> getUserRoles(long userId){
		
		List<RolesVO> userRoles = adminDAO.getUserRoles(userId);
		return userRoles;
		
	}



	public static Date getDateWithoutTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softtwig.crm.service.AdminService#deleteCampaign(java.lang.String)
	 */


	@Override
	public boolean userStatus(AdminUserBO userBO) throws MySalesException {
		boolean loginChanged = false;

		User userVO = new User();

		if (0 != userBO.getId()) {
			userVO.setId(userBO.getId());
			userVO.setActive(userBO.isActive());
			userVO = adminDAO.userStatus(userVO);
			if (0 != userVO.getId()) {
				loginChanged = true;
			}
		}
		return loginChanged;

	}

	@Override
	public AdminUserBO deleteProfile(AdminUserBO deleteProfile) throws MySalesException {
		AdminServiceImpl.LOGGER.entry();

		User VO = new User();
		int result;
		try {
			VO.setId(deleteProfile.getId());
			VO.setDelete(true);
			VO = adminDAO.deleteProfile(VO);
			if (0<VO.getId()) {
				deleteProfile.setResponse(SuccessMsg.DELETE_SUCCESS);
			}
		} catch (MySalesException e) {

			e.printStackTrace();
		}

		return deleteProfile;
	}

	@Override
	public AdminUserBO retrieveusers(long userId) throws MySalesException {

		AdminUserBO adminBO = new AdminUserBO();

		adminBO = adminDAO.retrieveusers(userId);
		return adminBO;

	}

	@Override
	public boolean findByEmail(String emailAddress) {
		try {
			final User loginVO = adminDAO.findByEmail("emailAddress", emailAddress);

			if (loginVO != null) {
				return true;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override public boolean findByMobilenoEmployee(AdminUserBO adminBO) { 
		User userVO=new User();
		if(null!=adminBO.getMobileNo()){ 
			userVO.setMobileNo(adminBO.getMobileNo());
		}
		return adminDAO.findByMobilenoEmployee(userVO);
	}
	@Override public List<AdminUserBO> searchEmployeeList(AdminUserBO adminBO) {

		List<AdminUserBO> adminUserBOList = new ArrayList<AdminUserBO>();
		List<User>  adminUserList = new ArrayList<User>(); 
		adminUserList = adminDAO.searchEmployeeList(adminBO);
		int sno = 1; 
		for (User user : adminUserList) { 
			AdminUserBO adminUserBO = new AdminUserBO();
			adminUserBO.setAdminId(user.getId());
			adminUserBO.setEmailAddress(user.getEmailAddress());
			adminUserBO.setConfirmPassword(user.getConfirmpassword());
			adminUserBO.setPassword(user.getPassword());
			adminUserBO.setMobileNo(user.getMobileNo());
			//adminUserBO.setUserType(user.getUserType());
			adminUserBO.setsNo(sno++);

			AdminLoginBO adminLoginVO = null;
			/*
			 * if(adminLoginVO.isActive()){ ((BaseBO) adminUserBOList).setStatus("Active");
			 * } else{ ((BaseBO) adminUserBOList).setStatus("De-Active"); }
			 */

			adminUserBOList.add(adminUserBO); 
		} 
		return adminUserBOList; 
	}


	@Override public long employeesCount(AdminLoginBO adminLoginBO) { return
			adminDAO.employeesCount(adminLoginBO); }
	
	
	

	@Override
	public PrivilegesBO savePrivileges(PrivilegesBO privilegesbo) {
		PrivilegesBO privilegesBo = new PrivilegesBO();
		PrivilegesVO privilegesvo = new PrivilegesVO();
		privilegesvo.setPrivilegesName(privilegesbo.getPrivilegename());
		privilegesvo=adminDAO.savePrivileges(privilegesvo);
		privilegesBo.setPrivilegename(privilegesvo.getPrivilegesName());
		privilegesBo.setPrivilegeId(privilegesvo.getPrivilegeId());
		return privilegesBo;


	}

	@Override
	public List<PrivilegesBO> retrivePrivileges(List<PrivilegesBO> privilegesbolist) {
		return adminDAO.retrivePrivileges(privilegesbolist);
	}

	@Override
	public PrivilegesBO deletePrivilege(PrivilegesBO bo){
		int result=0;
		PrivilegesVO vo = new PrivilegesVO();
		vo.setPrivilegeId(bo.getPrivilegeId());
		vo.setDeleted(bo.getDeleted());
		result=adminDAO.deletePrivilege(vo);
		if(0!=result){
			bo.setResponse(SuccessMsg.DELETE_SUCCESS);
		}

		return bo;
	}

	@Override
	public PrivilegesBO editPrivileges(PrivilegesBO bo) {
		PrivilegesVO vo = new PrivilegesVO();
		PrivilegesBO bo1 = new PrivilegesBO();
		vo.setPrivilegeId(bo.getPrivilegeId());
		vo=adminDAO.editPrivileges(vo);
		bo1.setPrivilegeId(vo.getPrivilegeId());
		bo1.setPrivilegename(vo.getPrivilegesName());
		return bo1;
	}

	@Override
	public PrivilegesBO updatePrivilege(PrivilegesBO privilegebo) {
		PrivilegesVO vo = new PrivilegesVO();
		vo.setPrivilegeId(privilegebo.getPrivilegeId());
		vo.setPrivilegesName(privilegebo.getPrivilegename());
		vo=adminDAO.updatePrivileges(vo);
		return privilegebo;
	}

	@Override
	public List<PrivilegesBO> searchPrivilegename(PrivilegesBO bo) {
		List<PrivilegesBO> listbo = new ArrayList<PrivilegesBO>();
		List<PrivilegesVO> listvo = new ArrayList<PrivilegesVO>();
		PrivilegesVO vo = new PrivilegesVO();
		vo.setPrivilegesName(bo.getPrivilegename());
		listvo=adminDAO.searchPrivileges(vo);


		if(null!=listvo&&listvo.size()>0){
			int count=0;
			for(PrivilegesVO privilegevo : listvo){
				PrivilegesBO privilegeBO = new PrivilegesBO();
				int sno=++count;
				privilegeBO.setsNo(sno);
				privilegeBO.setPrivilegename(privilegevo.getPrivilegesName());
				privilegeBO.setPrivilegeId(privilegevo.getPrivilegeId());
				listbo.add(privilegeBO);
			}
		}
		return listbo;
	}

	/*@Override
			public PrivilegesBO searchPrivilegename(PrivilegesBO bo) {
						return null;
			}
	 */

	@Override
	public List<RoleBO> retrieveRoleprivilege(List<RoleBO> rolebolist) {
		return adminDAO.retriveRolePrivilege(rolebolist);
	}

	@Override
	public List<PrivilegesBO> getprivileges(List<PrivilegesBO> rolebolist) {
		PrivilegesVO vo = new PrivilegesVO();
		List<PrivilegesBO> bolist = new ArrayList<PrivilegesBO>();
		for(PrivilegesBO bo: rolebolist){
			PrivilegesVO privilegevo = new PrivilegesVO();
			vo.setPrivilegesName(bo.getPrivilegename());
			privilegevo=adminDAO.getprivilege(vo);
			PrivilegesBO privilegebo= new PrivilegesBO();
			privilegebo.setPrivilegeId(privilegevo.getPrivilegeId());
			privilegebo.setPrivilegename(privilegevo.getPrivilegesName());
			bolist.add(privilegebo);

		}

		return bolist;

	}

	@Override
	public List<RoleBO> roleprivileges(List<RoleBO> listrolebo) {
		RolePrivileges roleprivileges = new RolePrivileges();

		List<PrivilegesVO> rolevolist = new ArrayList<PrivilegesVO>();
		if(null!=listrolebo&&listrolebo.size()>0){
			for(RoleBO bo : listrolebo){
				RolePrivileges roleprivilege = new RolePrivileges();
				RolePrivilegesVO vo = new RolePrivilegesVO(roleprivileges);
				PrivilegesVO privilegevo = new PrivilegesVO();
				RolesVO rolevo = new RolesVO();
				rolevo.setRoleId(bo.getRoleId());

				privilegevo.setPrivilegeId(bo.getPrivilegeId());
				int roleid = (int) rolevo.getRoleId();
				int privilegeid=(int) privilegevo.getPrivilegeId();
				roleprivilege.setRoleId(roleid);
				roleprivilege.setPrivilegeId(privilegeid);
				vo.setId(roleprivilege);
				/*vo.setRoleTypeVO(rolevo);
						vo.setPrivilegesVO(privilegevo);*/
				/*						vo.setRoleTypeVO(rolevo);
				 */						
				/*						vo.setPrivilegesVO(privilegevo);
				 */						vo = adminDAO.assignRolePrivilege(vo);
			}
		}
		return listrolebo;
	}


	@Override
	public RoleBO getroleprivilege(RoleBO rolebo) {
		RolesVO rolevo = new RolesVO();
		PrivilegesVO privilegevo = new PrivilegesVO();
		int roleid = (int) rolebo.getRoleId();
		int privilegeid = (int) rolebo.getPrivilegeId();
		RolePrivileges roleprivilege= new RolePrivileges();
		roleprivilege.setRoleId(roleid);
		roleprivilege.setPrivilegeId(privilegeid);
		RolePrivilegesVO roleprivilegevo = new RolePrivilegesVO();
		roleprivilegevo.setId(roleprivilege);
		roleprivilegevo=adminDAO.getroleprivilege(roleprivilegevo);
		long rolesid = (long) roleprivilegevo.getId().getRoleId();
		long privilegesid =(long) roleprivilegevo.getId().getPrivilegeId();
		RoleBO rolesbo = new RoleBO();
		RoleBO borole = new RoleBO();
		borole.setRoleId(rolesid);
		borole=roleTypeService.getrolebyid(borole);
		rolesbo.setRoleId(borole.getRoleId());
		rolesbo.setRoleName(borole.getRoleName());
		rolesbo.setPrivilegeId(privilegesid);
		return borole;
	}

	@Override
	public RoleBO removeRole(RoleBO rolebo) {
		RolePrivilegesVO assignvo = new RolePrivilegesVO();
		RolesVO roletypevo = new RolesVO();
		int roleid=(int) rolebo.getRoleId();

		roletypevo.setRoleId(roleid);
		assignvo.getId().setRoleId((int)roletypevo.getRoleId());
		assignvo=adminDAO.removeRole(assignvo);
		return rolebo;
	}

	@Override
	public List<AdminUserBO> retrieveUser(List<AdminUserBO> listUserBo) {
		List<AdminUserBO> BOList = new ArrayList<AdminUserBO>();
		BOList = adminDAO.retrieveUser(BOList);
		return BOList;


	}

	@Override
	public AdminUserBO retriveUserByName(AdminUserBO bo) {
		User user = new User();
		user.setName(bo.getName());
		user=adminDAO.retriveUserByname(user);
		AdminUserBO userbo = new AdminUserBO();
		userbo.setId(user.getId());
		userbo.setName(user.getName());
		userbo.setMobileNo(user.getMobileNo());
		userbo.setPassword(user.getPassword());
		userbo.setEmailAddress(user.getEmailAddress());
		userbo.setConfirmPassword(user.getConfirmpassword());
		return userbo;
	}

	@Override
	public RoleBO getPrivilegesbyId(RoleBO rolebo) {
		RoleBO role = new RoleBO();
		PrivilegesVO privilegesvo = new PrivilegesVO();
		privilegesvo.setPrivilegeId(rolebo.getPrivilegeId());
		privilegesvo=adminDAO.getprivilegeById(privilegesvo);
		role.setPrivilegeId(privilegesvo.getPrivilegeId());
		role.setPrivilegename(privilegesvo.getPrivilegesName());
		return role;
	}

	@Override
	public RoleBO createRolePrivileges(RoleBO listrolebo) {
		/*		List<RolesVO> rolesvolist = new ArrayList<RolesVO>();*/
		RolesVO rolevo = new RolesVO();
		List<PrivilegesVO> privilegesvolist = new ArrayList<PrivilegesVO>();

		for(PrivilegesBO privilegebo:listrolebo.getPrivilegesbolist()){
			PrivilegesVO vo = new PrivilegesVO();
			vo.setPrivilegeId(privilegebo.getPrivilegeId());
			vo.setPrivilegesName(privilegebo.getPrivilegename());
			privilegesvolist.add(vo);
		}

		rolevo.setRoleId(listrolebo.getRoleId());
		rolevo.setRoleName(listrolebo.getRoleName());
		rolevo.setListPrivilegesvo(privilegesvolist);
		rolevo.setActive(true);
		rolevo=roleTypeDAO.createRolePrivileges(rolevo);
		return listrolebo;
	}

	@Override
	public RoleBO deleteRolePrivilege(RoleBO rolebo) {
		RolesVO rolevo = new RolesVO();
		rolevo.setRoleId(rolebo.getRoleId());
		rolevo=roleTypeDAO.getRolelist(rolevo);

		rolevo.setActive(false);
		/*user.setRoleVo(null);*/

		rolevo=roleTypeDAO.deleteRolePrivileges(rolevo);
		return rolebo;
	}

	@Override
	public List<PrivilegesBO> listOfPrivileges() {
		// TODO Auto-generated method stub

		PrivilegesVO privVO=new PrivilegesVO();
		List<PrivilegesBO> privilegeListBO=new ArrayList<>();
		List<PrivilegesVO> privilegeListVO=new ArrayList<>();

		privVO.setDeleted(false);
		if(false==privVO.getisDeleted()){
			privilegeListVO.add(privVO);
			privilegeListVO=adminDAO.listOfPrivileges(privilegeListVO);

			if(null!=privilegeListVO&&!privilegeListVO.isEmpty()&&0<privilegeListVO.size()){

				for (PrivilegesVO privilegesVO : privilegeListVO) {
					PrivilegesBO privBO=new PrivilegesBO();
					privBO.setPrivilegeId(privilegesVO.getPrivilegeId());
					privBO.setPrivilegename(privilegesVO.getPrivilegesName());
					privilegeListBO.add(privBO);

				}
			}
		}
		return privilegeListBO;
	}

	@Override
	public List<AccessBo> listOfAccess() {
		// TODO Auto-generated method stub

		AccessVo accessVO=new AccessVo();
		List<AccessBo> accessBOlist=new ArrayList<>();
		List<AccessVo> accessVOlist=new ArrayList<>();

		accessVOlist=adminDAO.listOfAccess();

		if(null!=accessVOlist &&!accessVOlist.isEmpty()&&0<accessVOlist.size()){

			for (AccessVo accessVo2 : accessVOlist) {

				AccessBo accessBO=new AccessBo();

				accessBO.setAccessId(accessVo2.getAccessId());
				accessBO.setAccessName(accessVo2.getAccessName());
				accessBOlist.add(accessBO);

			}

		}

		return accessBOlist;
	}

	@Override
	public PrivilegesBO privilegeAccess(PrivilegesBO privlegeBO) {
		// TODO Auto-generated method stub

		PrivilegesVO privilegeVo=new PrivilegesVO();
		List<AccessVo> accessVOlist=new ArrayList<>();
		if(null!=privlegeBO){
			for (AccessBo accessBO : privlegeBO.getAccessBOlist()) {
				AccessVo accessvo=new AccessVo();
				accessvo.setAccessId(accessBO.getAccessId());
				accessvo.setAccessName(accessBO.getAccessName());
				accessVOlist.add(accessvo);
				privilegeVo.setAccessList(accessVOlist);
			}
			if(null!=privlegeBO){
				for (PrivilegesBO privilegeBO : privlegeBO.getPrivilegeslis()) {
					privilegeVo.setPrivilegeId(privilegeBO.getPrivilegeId());
					privilegeVo.setPrivilegesName(privilegeBO.getPrivilegename());
				}
			}
		}

		if(null!=privilegeVo){
			privilegeVo=adminDAO.privilegeAccess(privilegeVo);
		}
		if(0<privilegeVo.getPrivilegeId()){
			/*String str=privilegeVo.getPrivilegesName();
			Long privilegeId=Long.parseLong(str);
			privlegeBO.setPrivilegeId(privilegeId);*/
			privlegeBO.setPrivilegeId(privilegeVo.getPrivilegeId());
		}
		return privlegeBO;
	}

	@Override
	public List<PrivilegesBO> listOfPrvielegeAccess() {
		// TODO Auto-generated method stub

		List<PrivilegesBO> privilegeBOList=new ArrayList<>();
		List<PrivilegesVO> privilegeVOList=new ArrayList<>();

		List<AccessBo> accessList=new ArrayList<>();

		privilegeVOList=adminDAO.listOfPrivilegeAccess();

		if(null!=privilegeVOList && !privilegeVOList.isEmpty() && 0<privilegeVOList.size()){

			int count=0;

			for (PrivilegesVO privilege : privilegeVOList) {
				PrivilegesBO privilegeBO=new PrivilegesBO();
				int data=++count;
				privilegeBO.setsNo(data);
				privilegeBO.setPrivilegeId(privilege.getPrivilegeId());
				privilegeBO.setPrivilegename(privilege.getPrivilegesName());
				privilegeBOList.add(privilegeBO);
				/*for (AccessVo accessVo : privilege.getAccessList()) {
					AccessBo accessBO=new AccessBo();
					PrivilegesBO privilegeBO1=new PrivilegesBO();
					accessBO.setAccessId(accessVo.getAccessId());
					accessBO.setAccessName(accessVo.getAccessName());
					accessList.add(accessBO);
					privilegeBO1.setAccessBOlist(accessList);
					if(null!=privilegeBO1.getPrivilegename()){
						privilegeBOList.add(privilegeBO1);
					}

				}	*/
			}

		}

		return privilegeBOList;
	}

	@Override
	public List<PrivilegesBO> editPriviegeAccess(PrivilegesBO privilegeBO) {
		// TODO Auto-generated method stub
		PrivilegesVO privilegeVO=new PrivilegesVO();
		List<PrivilegesBO> privilegeBOList=new ArrayList<>();
		List<PrivilegesVO> privilegeVOList=new ArrayList<>();
		List<AccessBo> accessBOList1=new ArrayList<>();
		if(0<privilegeBO.getPrivilegeId()){
			privilegeVO.setPrivilegeId(privilegeBO.getPrivilegeId());
		}
		privilegeVOList=adminDAO.editPrivilegeAccess(privilegeVO);
		List<Long> privilegeIdList=adminDAO.geAccessIdListIdList(privilegeVO);

		if(null!=privilegeVOList && !privilegeVOList.isEmpty() && 0<privilegeVOList.size()){
			for (PrivilegesVO privilegeVO1 : privilegeVOList) {
				privilegeBO.setPrivilegeId(privilegeVO1.getPrivilegeId());
				privilegeBO.setPrivilegename(privilegeVO1.getPrivilegesName());
				privilegeBOList.add(privilegeBO);
				for (AccessVo accessVO : privilegeVO1.getAccessList()) {
					AccessBo accessBO=new AccessBo();
					PrivilegesBO privilegeBO1=new PrivilegesBO();
					accessBO.setAccessId(accessVO.getAccessId());
					accessBO.setAccessName(accessVO.getAccessName());
					accessBOList1.add(accessBO);
					privilegeBO1.setAccessIds(privilegeIdList);
					privilegeBO1.setAccessBOlist(accessBOList1);
					privilegeBOList.add(privilegeBO1);
				}	
			}
		}
		return privilegeBOList;
	}

	@Override
	public PrivilegesBO updatePrivilegeAccess(PrivilegesBO privilegeBO) {
		// TODO Auto-generated method stub

		PrivilegesVO privilegeVO=new PrivilegesVO();
		List<AccessVo> accessVOlist=new ArrayList<>();

		if(0<privilegeBO.getPrivilegeId()){
			privilegeVO.setPrivilegeId(privilegeBO.getPrivilegeId());
			privilegeVO.setPrivilegesName(privilegeBO.getPrivilegename());
		}
		if(null!=privilegeBO){
			for (AccessBo accessbo2 : privilegeBO.getAccessBOlist()) {
				AccessVo accessVO=new AccessVo();
				accessVO.setAccessId(accessbo2.getAccessId());
				accessVOlist.add(accessVO);
				privilegeVO.setAccessList(accessVOlist);
			}
		}

		if(null!=privilegeVO){
			privilegeVO=adminDAO.updatePrivilegeAccess(privilegeVO);
		}
		if(0<privilegeVO.getPrivilegeId()){
			privilegeBO.setPrivilegeId(privilegeVO.getPrivilegeId());
			System.out.println("Sucessfully Updated");
		}
		return privilegeBO;
	}

	@Override
	public PrivilegesBO deletePrivilegeAccess(PrivilegesBO privilegeBO) {
		// TODO Auto-generated method stub
		PrivilegesVO privilegeVO=new PrivilegesVO();
		if(0<privilegeBO.getPrivilegeId()){
			privilegeVO.setPrivilegeId(privilegeBO.getPrivilegeId());
		}
		privilegeVO=adminDAO.deletePrivilegeAccess(privilegeVO);
		if(0<privilegeVO.getPrivilegeId()){
			privilegeBO.setPrivilegeId(privilegeVO.getPrivilegeId());
			System.out.println("sucessfully deleted");
		}
		return privilegeBO;
	}

		
}
