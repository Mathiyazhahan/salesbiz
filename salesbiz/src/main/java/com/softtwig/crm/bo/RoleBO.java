package com.softtwig.crm.bo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class RoleBO extends BaseBO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long roleId;
	@NotBlank(message="Rolename should not be empty")
	private String roleName;
	private List<Long> privilegeIds;

	private String privilegename;
	private long privilegeId;
	private int sNo;
	
	private List<PrivilegesBO> privilegesbolist;
	public List<PrivilegesBO> getPrivilegesbolist() {
		return privilegesbolist;
	}

	public void setPrivilegesbolist(List<PrivilegesBO> privilegesbolist) {
		this.privilegesbolist = privilegesbolist;
	}

	
	

public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

public String getPrivilegename() {
		return privilegename;
	}

	public void setPrivilegename(String privilegename) {
		this.privilegename = privilegename;
	}

	public long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(long privilegeId) {
		this.privilegeId = privilegeId;
	}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}

public long getRoleId() {
	return roleId;
}

public void setRoleId(long roleId) {
	this.roleId = roleId;
}

public List<Long> getPrivilegeIds() {
	return privilegeIds;
}

public void setPrivilegeIds(List<Long> privilegeIds) {
	this.privilegeIds = privilegeIds;
}


}
