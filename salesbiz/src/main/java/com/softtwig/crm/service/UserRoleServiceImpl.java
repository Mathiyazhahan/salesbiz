package com.softtwig.crm.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.dao.AdminDAO;
import com.softtwig.crm.dao.UserRoleDAO;
import com.softtwig.crm.utils.EncryptAndDecrypt;
import com.softtwig.crm.vo.RolesVO;
import com.softtwig.crm.vo.User;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;
		/*@Override
	public List<UserRolesBO> retriveUserRoles(List<UserRolesBO> listbo) {

		return userRoleDAO.retrieveUserRoles(listbo);
	}
*/	@Override
	public AdminUserBO createUserRoles(AdminUserBO adminuserlist) throws Exception {
		List<RolesVO> listrolevo = new ArrayList<RolesVO>();
		User uservo = new User();
		for(RoleBO bo :adminuserlist.getListrlebo()){
			RolesVO vo = new RolesVO();
			vo.setRoleId(bo.getRoleId());
			vo.setRoleName(bo.getRoleName());
			listrolevo.add(vo);
		}
		uservo.setId(adminuserlist.getId());
		uservo.setConfirmpassword(EncryptAndDecrypt.encrypt(adminuserlist.getConfirmPassword()));
		uservo.setEmailAddress(adminuserlist.getEmailAddress());
		uservo.setName(adminuserlist.getName());
		uservo.setMobileNo(adminuserlist.getMobileNo());
		uservo.setPassword(EncryptAndDecrypt.encrypt(adminuserlist.getPassword()));
		uservo.setListRoletypeVo(listrolevo);
		boolean active=false;
		active=adminuserlist.isActive();
		if(active==false){
			uservo.setActive(true);
		}
		else{
			uservo.setActive(true);
		}
		uservo = userRoleDAO.createUserRole(uservo);
		AdminUserBO bo = new AdminUserBO();
		bo.setId(uservo.getId());
				return bo;
	}

@Override
public void deleteUserRole(AdminUserBO userbo) {

	User user = new User();
	user.setId(userbo.getId());
	user=adminDAO.retriveuserById(user);	
	user.setActive(false);	
	user=userRoleDAO.deleteUserRole(user);
}



}
