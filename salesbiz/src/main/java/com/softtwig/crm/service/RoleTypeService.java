package com.softtwig.crm.service;

import java.util.List;

import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.vo.RolesVO;

public interface RoleTypeService {

	RoleBO getroletype(RoleBO roleBOObj);

	List<RoleBO> viewrole();

	/* RoleBO geteditrole(String roleId); */

	RoleBO posteditrole(RoleBO roleBOobj);

	int deleteroletype(RoleBO rolebo);
	
	RoleBO getRoleid(RoleBO borole);
	
	List<RoleBO> getroleList(List<RoleBO> roleblist);

	RoleBO getrolebyid(RoleBO rolebo);

	RolesVO createRolePrivileges(RolesVO rolevo);

	List<RoleBO> getroleLists(List<RoleBO> rolebo);

	List<RoleBO> searchRoleName(RoleBO roleBO);

	PrivilegesBO getPrivilegebyid(PrivilegesBO privilegesBO);



}
