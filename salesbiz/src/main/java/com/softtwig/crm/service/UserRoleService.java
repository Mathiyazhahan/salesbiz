package com.softtwig.crm.service;

import com.softtwig.crm.bo.AdminUserBO;

public interface UserRoleService {

	AdminUserBO createUserRoles(AdminUserBO userRolesBo) throws Exception;

	void deleteUserRole(AdminUserBO userbo);

	/*List<UserRolesBO> retriveUserRoles(List<UserRolesBO> listbo);

	UserRolesBO createUserRoles(UserRolesBO userRolesBo);
*/
}
