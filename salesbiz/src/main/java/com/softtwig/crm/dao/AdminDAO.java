package com.softtwig.crm.dao;

import java.util.List;

import com.softtwig.crm.bo.AdminLoginBO;
import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.exception.MySalesException;
import com.softtwig.crm.vo.AccessLogVO;
import com.softtwig.crm.vo.AccessVo;
import com.softtwig.crm.vo.EmailAccess;
import com.softtwig.crm.vo.LoginStatusVO;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolePrivilegesVO;
import com.softtwig.crm.vo.RolesVO;
import com.softtwig.crm.vo.User;

/**
 * @author Administrator
 * @param <T>
 * 
 */
public interface AdminDAO {

	User authendicate(String string, String emailAddress) throws MySalesException;

	User authendicate(String emailAddress) throws MySalesException;
	
	LoginStatusVO editLoginStatus(LoginStatusVO loginStatusVO);
	
	long addLoginStatus(LoginStatusVO loginStatus);
	
	 public boolean createAccessLog(AccessLogVO logVO);

	 long createuser(User adminVO) throws MySalesException;
	 
	 AdminUserBO retrieveusers(long userId);
	 
	 List<AdminUserBO> retrieveUser()throws MySalesException;
	 
	 User userStatus(User userVO)throws MySalesException;
	 
	 User deleteProfile(User vo)throws MySalesException;
	 
	 User getuserId(AdminUserBO adminBO) throws MySalesException;
	 
	 User updateuser(User loginVO) throws MySalesException;
	 
	 User findByEmail(String string, String emailAddress);
	 
	 EmailAccess saveEmailList(List<EmailAccess> accessVOList);	 
		 
	 long employeesCount(AdminLoginBO adminLoginBO);
	 
	 List<User> searchEmployeeList(AdminUserBO adminBO);
	 
	 boolean findByMobilenoEmployee(User userVO);  

	List<String> getImageName();

	boolean findEmployerEmail(String emailAddress);

	boolean mobileNoVerification(String mobileNo);

	PrivilegesVO savePrivileges(PrivilegesVO privilegesvo);

	List<PrivilegesBO> retrivePrivileges(List<PrivilegesBO> privilegesbolist);

	int deletePrivilege(PrivilegesVO vo);

	PrivilegesVO editPrivileges(PrivilegesVO vo);

	PrivilegesVO updatePrivileges(PrivilegesVO vo);

	List<PrivilegesVO> searchPrivileges(PrivilegesVO vo);
	
	List<RoleBO> retriveRolePrivilege(List<RoleBO> listrolebo);

	PrivilegesVO getprivilege(PrivilegesVO vo);
	
	RolePrivilegesVO assignRolePrivilege(RolePrivilegesVO vo);

	RolePrivilegesVO getroleprivilege(RolePrivilegesVO roleprivilegevo);
	
	RolePrivilegesVO removeRole(RolePrivilegesVO assignvo);

	List<AdminUserBO> retrieveUser(List<AdminUserBO> bOList);

	User retriveUserByname(User user);

	User retriveuserById(User user);

	PrivilegesVO getprivilegeById(PrivilegesVO privilegesvo);

	List<PrivilegesVO> listOfPrivileges(List<PrivilegesVO> privilegeListVO);

	List<AccessVo> listOfAccess();

	PrivilegesVO privilegeAccess(PrivilegesVO privilegeVo);

	List<PrivilegesVO> listOfPrivilegeAccess();

	List<PrivilegesVO> editPrivilegeAccess(PrivilegesVO privilegeVO);

	PrivilegesVO updatePrivilegeAccess(PrivilegesVO privilegeVO);

	PrivilegesVO deletePrivilegeAccess(PrivilegesVO privilegeVO);

	List<Long> geAccessIdListIdList(PrivilegesVO privilegeVO);

	List<RolesVO> getUserRoles(long userId);
	 
}
