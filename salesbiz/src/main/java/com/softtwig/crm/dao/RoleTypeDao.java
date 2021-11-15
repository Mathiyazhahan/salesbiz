package com.softtwig.crm.dao;

import java.util.List;

import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolesVO;

public interface RoleTypeDao {

	RolesVO getroletype(RolesVO roleVOobj);

	List<RoleBO> viewrole();

	/* RoleTypeVO geteditrole(long id); */

	RolesVO posteditrole(RolesVO roleVOobj);

	RolesVO deletepost(RolesVO roleVOobj);
	
	RolesVO getroleid(RolesVO roletypevo);

	RolesVO getRolelist(RolesVO rolevo);

	RolesVO createRolePrivileges(RolesVO rolevo);

	List<RolesVO> viewrole(List<RolesVO> rolesvo);

	RolesVO deleteRolePrivileges(RolesVO rolevo);

	List<RolesVO> searchRoleName(RolesVO roleVO);

	List<Long> getPrivelegeIdList(RolesVO rolevo);

	PrivilegesVO getPrivilegelist(PrivilegesVO privilegesVO);

	List<Long> getPrivelegeIdList(PrivilegesVO privilegesVO);

}
