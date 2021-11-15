package com.softtwig.crm.dao;

import com.softtwig.crm.vo.User;

public interface UserRoleDAO {

	User createUserRole(User uservo);

	User deleteUserRole(User user);

	/*List<UserRolesBO> retrieveUserRoles(List<UserRolesBO> listbo);
*/

}
