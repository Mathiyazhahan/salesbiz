/**
 * 
 */
package com.softtwig.crm.service;

import java.util.List;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.bo.AccessLogBO;
import com.softtwig.crm.bo.AdminLoginBO;
import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.exception.MySalesException;
import com.softtwig.crm.vo.LoginStatusVO;


public interface AdminService {

	AdminLoginBO authendicate(AdminLoginBO adminLoginBO) throws MySalesException;

	boolean addLoginStatus(String username) throws MySalesException;

	public boolean createAccessLog(AccessLogBO logBO);

	boolean editLoginStatus(LoginStatusVO loginStatusVO);

	AdminUserBO createuser(AdminUserBO adminBO) throws MySalesException;

	boolean findByEmail(String emailAddress);

	boolean findByMobilenoEmployee(AdminUserBO adminBO);

	List<AdminUserBO> retrieveUser() throws MySalesException;

	List<AdminUserBO> searchEmployeeList(AdminUserBO adminBO);

	boolean userStatus(AdminUserBO userBO) throws MySalesException;

	AdminUserBO deleteProfile(AdminUserBO deleteProfile) throws MySalesException;

	AdminUserBO retrieveusers(long userId) throws MySalesException;

	AdminUserBO updateuser(AdminUserBO adminBO);

	long employeesCount(AdminLoginBO adminLoginBO);

	
	PrivilegesBO savePrivileges(PrivilegesBO privilegesbo);

	List<PrivilegesBO> retrivePrivileges(List<PrivilegesBO> privilegesbolist);

	PrivilegesBO deletePrivilege(PrivilegesBO bo);


	PrivilegesBO editPrivileges(PrivilegesBO bo);

	PrivilegesBO updatePrivilege(PrivilegesBO privilegebo);

	List<PrivilegesBO> searchPrivilegename(PrivilegesBO bo);
	
	List<RoleBO> retrieveRoleprivilege(List<RoleBO> rolebolist);
	
	List<PrivilegesBO> getprivileges(List<PrivilegesBO> rolebolist);
	
	List<RoleBO> roleprivileges(List<RoleBO> listrolebo);
	
	RoleBO getroleprivilege(RoleBO rolebo);
	
	RoleBO removeRole(RoleBO rolebo);

	List<AdminUserBO> retrieveUser(List<AdminUserBO> listUserBo);
	
	AdminUserBO retriveUserByName(AdminUserBO bo);

	RoleBO getPrivilegesbyId(RoleBO rolebo);

	RoleBO createRolePrivileges(RoleBO borole);

	RoleBO deleteRolePrivilege(RoleBO rolebo);

	List<PrivilegesBO> listOfPrivileges();

	List<AccessBo> listOfAccess();

	PrivilegesBO privilegeAccess(PrivilegesBO privlegeBO);

	List<PrivilegesBO> listOfPrvielegeAccess();

	List<PrivilegesBO> editPriviegeAccess(PrivilegesBO privilegeBO);

	PrivilegesBO updatePrivilegeAccess(PrivilegesBO privilegeBO);

	PrivilegesBO deletePrivilegeAccess(PrivilegesBO privilegeBO);
	
	




	
}
