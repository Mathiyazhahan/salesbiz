package com.softtwig.crm.controller;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.bo.AdminLoginBO;
import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.exception.MySalesException;
import com.softtwig.crm.exception.MySalesLogger;
import com.softtwig.crm.security.ControllerUtils;
import com.softtwig.crm.service.AdminService;
import com.softtwig.crm.service.RoleTypeService;
import com.softtwig.crm.utils.UserRoles;
import com.softtwig.crm.vo.LoginStatusVO;

@Controller
@Scope("session")
@SessionAttributes("/admin")
public class AdminController extends ControllerUtils implements Serializable {

	private static final long serialVersionUID = -5857977996611066292L;

	private static final MySalesLogger LOGGER = MySalesLogger.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	ServletContext servletContext;

	@Autowired
	private RoleTypeService roletypeservice;

	
	List<AdminUserBO> adminEmployeeList;
	
	List<PrivilegesBO> listbo = new ArrayList<PrivilegesBO>();
	List<AccessBo> accessBOList=new ArrayList<>();
	List<PrivilegesBO> privilegeList=new ArrayList<>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws FileNotFoundException {
		return "redirect:admin-sign-in";
	}

	@RequestMapping(value = "/admin-sign-in" , method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) throws FileNotFoundException {
		model.addAttribute("adminLogin", new AdminLoginBO());
		return "admin-sign-in";
	}

	
	@RequestMapping(value = "/send-mail", method = RequestMethod.GET)
	public String sendMail(Model model, HttpServletRequest request) {
		LOGGER.entry();
		long userLoginId = 0;
		boolean mailStatus = false;
		userLoginId = getUserSecurity().getLoginId();

		if (null != request.getParameter("email")) {
			String jobseekerName = request.getParameter("name");
			String emailAddress = request.getParameter("email");
			String sendId = request.getParameter("id");
			
			if (mailStatus) {
				model.addAttribute("successmessage", "Mail has been sent Successfully");
			}
		}
		return "redirect:/profile-view";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/create-employees", method = RequestMethod.GET)
	public String usercreate(Model model, HttpServletRequest request) throws MySalesException, MalformedURLException,
	NumberFormatException, FileNotFoundException, SerialException, SQLException {

		long loginId = getUserSecurity().getLoginId();
		if (0 == loginId) {
			return "redirect:/admin-sign-in";
		}
		AdminLoginBO adminLoginBO = new AdminLoginBO();
		//String userType = getUserSecurity().getRole();
		//adminLoginBO.setUserType(userType);
		adminLoginBO.setFirstName(getUserSecurity().getName());
		model.addAttribute("userType", adminLoginBO);
		AdminUserBO bo = new AdminUserBO();
		int page = 1;
		final String paging = request.getParameter("page");
		if (null != paging) {
			page = Integer.parseInt(paging);
		}
		/*
		 * userBOList = adminService.retrieveUser(); if (null != userBOList && 0 !=
		 * userBOList.size()) { model.addAttribute("userBOList", userBOList); }
		 */
		if (null != request.getParameter("successMessage")) {
			model.addAttribute("successMessage", request.getParameter("successMessage"));
		}
		if (null != request.getParameter("infoMessage")) {
			model.addAttribute("infoMessage", request.getParameter("infoMessage"));
		}
		if (null != request.getParameter("errorMessage")) {
			model.addAttribute("errorMessage", request.getParameter("errorMessage"));
		}
		if (null != request.getParameter("functionType") && !request.getParameter("functionType").isEmpty()) {
			model.addAttribute("functionType", request.getParameter("functionType"));
		} else {
			model.addAttribute("functionType", "add");
		}

		model.addAttribute("user", bo);
		return "create-employees";

	}


	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/create-employees", method = RequestMethod.POST)
	public String usercreate(@Valid @ModelAttribute("user") AdminUserBO adminBO, BindingResult result,
			HttpServletRequest request, Model model) throws MySalesException {
		long userId = 0;
		try {
			long loginId = getUserSecurity().getLoginId();
			// String userType=getUserSecurity().getRole();
			if (0 == loginId) {
				return "redirect:/admin-sign-in";
			}

			model.addAttribute("functionType", "add");
			if (result.hasErrors()) {
				return "create-employees";
			}

			if (!adminBO.getPassword().equals(adminBO.getConfirmPassword())) {
				result.rejectValue("confirmPassword", "Validate.Password");

				if (0 != userId) {
					model.addAttribute("infoMessage", "password-confirmpassword Verify");
				}

				return "create-employees";
			}
			if (adminService.findByEmail(adminBO.getEmailAddress())) {
				model.addAttribute("user", adminBO);
				model.addAttribute("errorMessage", "This account already exist");
			}
			if (adminService.findByMobilenoEmployee(adminBO)) {
				result.rejectValue("errorMessage", "Validate.AvailableMobileNo");
				model.addAttribute("errorMobileMessage", "This mobileNo is already exist");
				return "create-employees";

			}
			else {
				adminBO = adminService.createuser(adminBO);
				if (0 != adminBO.getId()) {
					model.addAttribute("successMessage", messageSource.getMessage("Create-Employee", null, null));
				} else {
					model.addAttribute("errorMessage", adminBO.getErrorMessage());
					adminBO.setErrorMessage(null);
				}
			}

		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add user has failed:" + ex.getMessage());
			}
			LOGGER.info("Add user has failed:" + ex.getMessage());
		}
		model.addAttribute("user", adminBO);
		model.addAttribute("functionType", "add");
		return "redirect:/view-employees";
	}

	@RequestMapping(value = "view-employees", method = RequestMethod.GET)
	public String viewEmployees(Model model, HttpServletRequest request, HttpSession session)
			throws FileNotFoundException, MySalesException {
		long loginId = getUserSecurity().getLoginId();
		//String userType=getUserSecurity().getRole();
		if (0 == loginId) {
			return "redirect:/admin-sign-in";
		}
		final String paging = request.getParameter("page");
		AdminLoginBO adminLoginBO = new AdminLoginBO();
		//adminLoginBO.setUserType(userType);
		adminLoginBO.setFirstName(getUserSecurity().getName());
		model.addAttribute("userType", adminLoginBO);
		if (null != paging) {
		}
		List<AdminUserBO> userBOList = new ArrayList<AdminUserBO>();
		userBOList = adminService.retrieveUser();
		if (null != userBOList && 0 < userBOList.size()) {
			model.addAttribute("userBOList", userBOList);
			/*
			 * model.addAttribute("successMessage",
			 * MyjobkartResourceBundle.getValue("Create-Employee"));
			 */
			model.addAttribute("successMessage", messageSource.getMessage("Create-Employee", null, null));
		}
		AdminUserBO adminUserBO = new AdminUserBO();
		model.addAttribute("user", adminUserBO);
		model.addAttribute("searchEmployees", new AdminUserBO());
		return "view-employees";
	}

	@RequestMapping(value = "/search-employees", method = RequestMethod.POST)
	public String searchEmployees(@Valid @ModelAttribute("searchEmployees") AdminUserBO adminBO, BindingResult result,
			HttpServletRequest request, Model model, HttpSession session)
					throws MySalesException, SerialException, SQLException {

		long loginId =getUserSecurity().getLoginId();
		if (0 == loginId) {
			return "redirect:/admin-sign-in";
		}
		AdminUserBO adminBo=new AdminUserBO();
		adminBo.setName(adminBO.getName());
		adminBo.setEmailAddress(adminBO.getEmailAddress());
		adminBo.setUserType(adminBO.getUserType());
		adminBO.setUserId(loginId);
		AdminLoginBO adminLoginBO = new AdminLoginBO();
		//String userType = getUserSecurity().getRole();
		//adminLoginBO.setUserType(userType);
		adminLoginBO.setFirstName(getUserSecurity().getName());
		model.addAttribute("userType", adminLoginBO);
		adminEmployeeList = adminService.searchEmployeeList(adminBO);
		if (null != adminEmployeeList && 0 < adminEmployeeList.size()) {
			model.addAttribute("userBOList", adminEmployeeList);
			model.addAttribute("searchEmployees", adminBo);
			return "view-employees";
		} else {
			model.addAttribute("errorMessage", "No Records Found");
			return "view-employees";
		}

	}

	@RequestMapping(value = "/active-deactive-user", method = RequestMethod.GET)
	public String activedeactiveuser(Model model, HttpServletRequest request)
			throws MySalesException, FileNotFoundException {
		try {
			long loginId = getUserSecurity().getLoginId();
			// String userType=getUserSecurity().getRole();
			if (0 == loginId) {
				return "redirect:/admin-sign-in";
			}
			AdminLoginBO adminLoginBO = new AdminLoginBO();
			//String userType = getUserSecurity().getRole();
			//adminLoginBO.setUserType(userType);
			adminLoginBO.setFirstName(getUserSecurity().getName());
			model.addAttribute("userType", adminLoginBO);
			String status = request.getParameter("status");
			String statusvalue[] = status.split(",");
			String userstatus = statusvalue[0];
			long userId = Long.valueOf(statusvalue[1]);

			AdminUserBO userBO = new AdminUserBO();
			userBO.setId(userId);
			if (userstatus.equals("Active")) {
				userBO.setActive(false);
			} else {
				userBO.setActive(true);
			}
			boolean useractivestatus = adminService.userStatus(userBO);
			if (useractivestatus) {
				model.addAttribute("successmessage", "Admin user activated Successfully");
			} else {
				model.addAttribute("successmessage", "Admin user de-activated Successfully");
			}
		} catch (final NullPointerException ne) {
			ne.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("user status has failed:" + ne.getMessage() + ne);
			}
			LOGGER.info("user status has failed:" + ne.getMessage() + ne);
		}
		return "redirect:/view-employees";
	}

	@RequestMapping(value = "/delete-employees", method = RequestMethod.GET)
	public String deleteUser(Model model, HttpServletRequest request) throws MySalesException, FileNotFoundException {

		AdminController.LOGGER.entry();
		long loginId = getUserSecurity().getLoginId();
		// String userType=getUserSecurity().getRole();
		if (0 == loginId) {
			return "redirect:/admin-sign-in";
		}
		String id = null;
		long deletedId = 0;
		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
			deletedId = Long.parseLong(id);
		}
		AdminUserBO deleteProfile = new AdminUserBO();
		deleteProfile.setId(deletedId);
		deleteProfile.setDelete(true);
		deleteProfile = adminService.deleteProfile(deleteProfile);
		if (null != deleteProfile.getResponse()) {
			model.addAttribute("successmessages", "deleted succesfully");
		} else {
			model.addAttribute("infoMessagemessage", "deleted failed");
		}
		AdminController.LOGGER.exit();
		model.addAttribute("functionType", "add");
		return "redirect:/view-employees";
	}

	@RequestMapping(value = "/edit-employees", method = RequestMethod.GET)
	public String edituser(Model model, HttpServletRequest request, HttpSession session) throws MySalesException {
		try {
			long loginId = getUserSecurity().getLoginId();
			if (0 == loginId) {
				return "redirect:/admin-sign-in";
			}
			AdminLoginBO adminLoginBO = new AdminLoginBO();
			//String userType = getUserSecurity().getRole();
			//adminLoginBO.setUserType(userType);
			adminLoginBO.setFirstName(getUserSecurity().getName());
			model.addAttribute("userType", adminLoginBO);
			final String id = request.getParameter("id");
			final long userId = Long.parseLong(id);
			//session.setAttribute("userId", userId);
			AdminUserBO userBO = new AdminUserBO();
			if (0 < loginId) {
				userBO = adminService.retrieveusers(userId);
			}
			List<AdminUserBO> userBOList = new ArrayList<AdminUserBO>();
			userBOList = adminService.retrieveUser();
			if (null != userBOList && 0 != userBOList.size()) {
				model.addAttribute("userBOList", userBOList);
			}

			if (userBO.getId() == userId) {
				//session.setAttribute("updateUser", reteriveprofile);
				model.addAttribute("functionType", "edit");
				model.addAttribute("editUser", userBO);
				return "edit-employees";
			}
		} catch (final NullPointerException ne) {

		}

		return "edit-employees";
	}

	@RequestMapping(value = "/edit-employees", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("updateuser") AdminUserBO adminBO, BindingResult result,
			HttpServletRequest request, Model model) throws MySalesException {
		//HttpSession session = request.getSession();
		long loginId = getUserSecurity().getLoginId();
		// String userType=getUserSecurity().getRole();
		if (0 == loginId) {
			return "redirect:/admin-sign-in";
		}

		if(result.hasErrors())
			return "edit-employees";
		try {
			long userId = 0;

			if (0 != getUserSecurity().getLoginId()) {
				userId = (Long) getUserSecurity().getLoginId();
				adminBO.setUserId(userId);
			}

			model.addAttribute("functionType", "edit");
			if (result.hasErrors()) {
				return "edit-employees";
			}

			adminBO = adminService.updateuser(adminBO);
			if (0 != adminBO.getId()) {
				model.addAttribute("Successmessage", "Admin user updated Successfully");

			} else {
				model.addAttribute("errorMessages", adminBO.getErrorMessage());
				adminBO.setErrorMessage(null);
			}
		} catch (Exception ex) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Edit adminuser has failed:" + ex.getMessage());
			}
			LOGGER.info("Edit adminuser has failed:" + ex.getMessage());
		}
		model.addAttribute("functionType", "add");
		return "redirect:/view-employees";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) throws MySalesException, MalformedURLException {
		final HttpSession session = request.getSession();
		String emailId = (String) session.getAttribute("lstatusemailId");
		LoginStatusVO loginStatusVO = new LoginStatusVO();
		loginStatusVO.setUserName(emailId);
		adminService.editLoginStatus(loginStatusVO);
		session.invalidate();
		return "redirect:/admin-sign-in";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) throws MySalesException, MalformedURLException {

		return "redirect:/admin-sign-in";
	}

	@RequestMapping(value = "admin-home", method = RequestMethod.GET)
	public String adminHome(Model model, HttpServletRequest request, HttpSession session) throws FileNotFoundException {
		long loginId=0;
		List<String> userTypes=null; 
		if(null!=getUserSecurity()) {
			loginId = getUserSecurity().getLoginId();
			userTypes = getUserSecurity().getRole();
		}
		if (0 == loginId && null==userTypes) {
			return "redirect:/admin-sign-in";
		}
		AdminLoginBO adminLoginBO = new AdminLoginBO();
		long userId =getUserSecurity().getLoginId();
		List<String> userType = getUserSecurity().getRole();
		//adminLoginBO.setUserType(userType);
		adminLoginBO.setId(userId);
		adminLoginBO.setFirstName(getUserSecurity().getName());
		model.addAttribute("userType", adminLoginBO);

		if (null != userType && userType.contains(UserRoles.ROLE_ADMIN.getRole())) {
			adminLoginBO.setEmployeeCount(adminService.employeesCount(adminLoginBO));			
		}

		

		/*
		 * if (null != userType &&
		 * userType.equalsIgnoreCase(UserRoles.ROLE_SALES.getRole())) {
		 * adminLoginBO.setCampaignCount(adminService.campaignCount(adminLoginBO));
		 * adminLoginBO.setCustomerCount(adminService.customerCount(adminLoginBO));
		 * adminLoginBO.setLeadsCount(adminService.leadsCount(adminLoginBO));
		 * //adminLoginBO.setCurrentActionCustomers(adminService.
		 * getCurrentActionCustomers(adminLoginBO)); }
		 */

		// }
		if (null != adminLoginBO) {
			model.addAttribute("adminDashboardCount", adminLoginBO);
		}
		return "admin-home";
	}


	@RequestMapping(value="/create-privileges",method=RequestMethod.GET)
	public String createprivileges(Model model,HttpServletRequest request,HttpServletResponse response){
		long loginid = getUserSecurity().getLoginId();
		if(0==loginid){
			return "redirect:/admin-sign-in";
		}

		if(!getUserSecurity().getRole().contains(UserRoles.ROLE_ADMIN.toString())){
			return "redirect:/admin-sign-in";
		}

		PrivilegesBO privilegesbo= new PrivilegesBO();
		model.addAttribute("privileges", privilegesbo);
		return "create-privileges";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/create-privileges",method= RequestMethod.POST)
	public String createprivileges(Model model,@Valid @ModelAttribute("privileges") PrivilegesBO privilegesbo,BindingResult result){

		long loginid = getUserSecurity().getLoginId();
		if(0==loginid){
			return "redirect:/admin-sign-in";
		}

		if(result.hasErrors()){
			return "create-privileges";
		}

		privilegesbo=adminService.savePrivileges(privilegesbo);
		if(0!=privilegesbo.getPrivilegeId()){
			model.addAttribute("successmessages", messageSource.getMessage("Create-Privileges", null, null));
			return "redirect:/view-privileges";
		}
		else{
			model.addAttribute("errorMessage", "Privileges no created");
		}
		return "redirect:/view-privileges";
	}



	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/view-privileges",method=RequestMethod.GET)
	public String getPrivileges(Model model,HttpServletRequest request){

		long loginid = getUserSecurity().getLoginId();
		if(0==loginid){
			return "redirect:/admin-sign-in";
		}
		final String paging=request.getParameter("page");
		if(null !=paging){
			int page=Integer.parseInt(paging);

		}


		List<PrivilegesBO> privilegesbolist = new ArrayList<PrivilegesBO>();
		privilegesbolist=adminService.retrivePrivileges(privilegesbolist);



		if(null!=request.getParameter("successmessages")){
			model.addAttribute("successMessage", request.getParameter("successmessages"));
		}


		model.addAttribute("privilegeslist", privilegesbolist);
		model.addAttribute("searchprivileges", new PrivilegesBO());
		return "view-privileges";
	}


	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/search-privileges",method=RequestMethod.POST)
	public String searchPrivileges(@Valid @ModelAttribute("searchprivileges") PrivilegesBO bo,BindingResult results,Model model){

		PrivilegesBO privbo = new PrivilegesBO();
		privbo.setPrivilegename(bo.getPrivilegename());
		long loginid=getUserSecurity().getLoginId();
		if(0==loginid){
			return "view-privileges";
		}
		List<PrivilegesBO> bolist = new ArrayList<PrivilegesBO>();
		listbo = adminService.searchPrivilegename(privbo);
		if(null!=listbo&&listbo.size()>0){
			model.addAttribute("privilegeslist", listbo);
			model.addAttribute("searchprivileges",privbo);
			return "view-privileges";

		}

		return "view-employees";



	}


	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/edit-privileges",method=RequestMethod.GET)
	public String editPrivileges(Model model,HttpServletRequest request){

		long loginid = getUserSecurity().getLoginId();
		if(0==loginid){
			return "redirect:/admin-sign-in";
		}

		if(null!=request.getParameter("id")){
			PrivilegesBO bo = new PrivilegesBO();

			String id = request.getParameter("id");
			long privilegeid = Long.parseLong(id);
			bo.setPrivilegeId(privilegeid);

			bo=adminService.editPrivileges(bo);

			if(null!=bo){
				model.addAttribute("privilegebo", bo);
			}

		}
		return "edit-privileges";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/edit-privileges",method=RequestMethod.POST)
	public String updatePrivileges(@ModelAttribute ("privilegebo") PrivilegesBO bo,Model model,BindingResult result,HttpServletRequest request ,BindingResult results ){

		if(results.hasErrors()){
			return "edit-privileges";
		}
		long loginid = getUserSecurity().getLoginId();
		if(0==loginid){
			return "redirect:/admin-sign-in";
		}

		if(null!=bo){
			bo=adminService.updatePrivilege(bo);

		}

		if(0!=bo.getPrivilegeId()){
			model.addAttribute("successmessages", messageSource.getMessage("Update-Privileges", null, null));
			return "redirect:/view-privileges";
		}
		return "redirect:view-privileges";
	}

	@RequestMapping(value = "/delete-privileges",method=RequestMethod.GET)
	public String deletePrivileges(Model model,HttpServletRequest request){
		if(null!=request.getParameter("id")){
			String id = request.getParameter("id");
			long privilegeid = Long.parseLong(id);

			PrivilegesBO bo = new PrivilegesBO();
			bo.setPrivilegeId(privilegeid);
			bo.setDeleted(true);
			bo=adminService.deletePrivilege(bo);
			if(null!=bo.getResponse()){
				model.addAttribute("successmessages", messageSource.getMessage("Delete-Privileges", null, null));
				return "redirect:/view-privileges";
			}

			else{
				model.addAttribute("infoMessagemessage", "deleted failed");

			}
		}
		return "redirect:/view-privileges";
	}


	@RequestMapping(value="/role-privileges",method=RequestMethod.GET)
	public String asignRolePrivilege(Model model,HttpServletRequest request){
		RoleBO rolebo = new RoleBO();
		List<PrivilegesBO> privilegesbolist = new ArrayList<PrivilegesBO>();
		List<RoleBO> rolebolist = new ArrayList<RoleBO>();
		long loginid=getUserSecurity().getLoginId();
		if(0==loginid){

			return "redirect:/admin-sign-in";

		}

		final String paging = request.getParameter("page");
		if(null!=paging){
			int page = Integer.parseInt(paging);
		}
		rolebolist=roletypeservice.viewrole();
		if(null!=rolebolist&&rolebolist.size()>0){
			model.addAttribute("rolebolists", rolebolist);
		}
		getPrivilege(model,request);
		model.addAttribute("roletype",rolebo);
		getrolePrivileges(model,request);
		/*		getRolePrivilege(model, request);
		 */
		return "role-privileges";
	}

	private void getrolePrivileges(Model model, HttpServletRequest request) {
		List<RoleBO> rolebo = new ArrayList<RoleBO>();
		rolebo=roletypeservice.getroleLists(rolebo);
		model.addAttribute("rolebo", rolebo);
	}

	@RequestMapping(value="/role-privileges",method=RequestMethod.POST)
	public String assignprivilegeRole(@ModelAttribute ("roletype") RoleBO rolebo,HttpServletRequest request){
		RoleBO borole = new RoleBO();
		borole.setPrivilegename(rolebo.getPrivilegename());
		borole.setRoleName(rolebo.getRoleName());
		List<PrivilegesBO> privilegebolist = new ArrayList<PrivilegesBO>();
		List<String> privilegenamelist = new ArrayList<String>(Arrays.asList(borole.getPrivilegename().split(",")));
		if(null!=privilegenamelist){
			for(String str : privilegenamelist){
				PrivilegesBO bo = new PrivilegesBO();
				bo.setPrivilegename(str);
				privilegebolist.add(bo);
			}

		}


		borole=roletypeservice.getRoleid(borole);
		privilegebolist=adminService.getprivileges(privilegebolist);
		borole.setPrivilegesbolist(privilegebolist);

		/*List<RoleBO> listrolebo = new ArrayList<RoleBO>();
		if(null!=privilegebolist&&privilegebolist.size()>0){
			for(PrivilegesBO bo : privilegebolist){
				RoleBO role = new RoleBO();
				role.setPrivilegeId(bo.getPrivilegeId());
				role.setPrivilegename(bo.getPrivilegename());
				role.setRoleName(borole.getRoleName());
				role.setRoleId(borole.getRoleId());
				listrolebo.add(role);
			}
		}
		 */
		final String paging = request.getParameter("page");
		if(null!=paging){
			int page = Integer.parseInt(paging);
		}
		borole=adminService.createRolePrivileges(borole);
		//listrolebo = adminService.roleprivileges(listrolebo);
		return "redirect:/role-privileges";
	}


	@RequestMapping(value="/edit-role-privileges",method=RequestMethod.GET)
	public String editRolePrivilege(Model model,HttpServletRequest request){

		/*		String id2=request.getParameter("privilegeid");
		 */		RoleBO rolesbo = new RoleBO();
		 String id=request.getParameter("roleId");
		 /*if(null!=request.getParameter("roleId")&&null!=request.getParameter("privilegeid")){
			long roleid = Long.parseLong(id);
			long privilegeid = Long.parseLong(id2);
			rolebo.setRoleId(roleid);
			rolebo.setPrivilegeId(privilegeid);
			rolebo = adminService.getroleprivilege(rolebo);

		}
		  */		List<RoleBO> rolebolist = new ArrayList<RoleBO>();
		  rolebolist=roletypeservice.viewrole();
		  if(null!=rolebolist&&rolebolist.size()>0){
			  model.addAttribute("rolebolists", rolebolist);
		  }
		  getPrivilege(model,request);
		  if(null!=request.getParameter("roleId")){
			  long roleid = Long.parseLong(id);
			  rolesbo.setRoleId(roleid);
			  rolesbo=roletypeservice.getrolebyid(rolesbo);
		  }
		  /*		getRolePrivilege(model, request);
		   */		model.addAttribute("rolesbo", rolesbo);


		   return "edit-role-privileges";
	}

	@RequestMapping(value="/edit-role-privileges",method=RequestMethod.POST)
	public String editRolePrivileges(@ModelAttribute ("rolebo") RoleBO rolebo){

		long loginId = getUserSecurity().getLoginId();
		if(0==loginId){
			return "redirect:/admin-sign-in";

		}

		/*rolebo=adminService.removeRole(rolebo)*/;

		List<PrivilegesBO> privilegebolist = new ArrayList<PrivilegesBO>();
		//List<String> privilegenamelist = new ArrayList<String>(Arrays.asList(rolebo.getPrivilegename().split(",")));
		if(null!=rolebo&&null!=rolebo.getPrivilegeIds()&&rolebo.getPrivilegeIds().size()>0){
			for(Long id : rolebo.getPrivilegeIds()){
				PrivilegesBO bo = new PrivilegesBO();
				bo.setPrivilegeId(id);
				privilegebolist.add(bo);
			}

		}

		//privilegebolist=adminService.getprivileges(privilegebolist);
		rolebo.setPrivilegesbolist(privilegebolist);
		/*List<RoleBO> listrolebo = new ArrayList<RoleBO>();
		if(null!=privilegebolist&&privilegebolist.size()>0){
			for(PrivilegesBO bo : privilegebolist){
				RoleBO role = new RoleBO();
				role.setPrivilegeId(bo.getPrivilegeId());
				role.setPrivilegename(bo.getPrivilegename());
				role.setRoleName(rolebo.getRoleName());
				role.setRoleId(rolebo.getRoleId());
				listrolebo.add(role);
			}
		}*/
		rolebo=adminService.createRolePrivileges(rolebo);
		/*listrolebo = adminService.roleprivileges(listrolebo);
		 */

		return "redirect:/role-privileges";

	}


	@RequestMapping(value="/delete-role-privileges" , method = RequestMethod.GET)
	public String deleterolePrivilege(Model model,HttpServletRequest request){
		RoleBO rolebo = new RoleBO();
		if(null!=request.getParameter("roleId")){
			String id = request.getParameter("roleId");
			/*String id2 = request.getParameter("privilegeid");*/
			long roleid = Long.parseLong(id);
			/*long privilegeid = Long.parseLong(id2);*/
			rolebo.setRoleId(roleid);
			/*rolebo.setPrivilegeId(privilegeid);*/
		}
		rolebo=adminService.deleteRolePrivilege(rolebo);

		return "redirect:/role-privileges";

	}
	public void getPrivilege(Model model,HttpServletRequest request){
		List<PrivilegesBO> listprivilgebo= new ArrayList<PrivilegesBO>();
		listprivilgebo=adminService.retrivePrivileges(listprivilgebo);
		if(null!=listprivilgebo){
			model.addAttribute("listprivilege", listprivilgebo);
		}
	}

	public void getRolePrivilege(Model model,HttpServletRequest request){
		List<RoleBO> listrolesbo = new ArrayList<RoleBO>();
		List<RoleBO> rolebolist = new ArrayList<RoleBO>();
		int count = 1;
		rolebolist=roletypeservice.viewrole();
		if(null!=rolebolist&&rolebolist.size()>0){
			rolebolist=adminService.retrieveRoleprivilege(rolebolist);
			if(null!=rolebolist){
				for(RoleBO rolebo:rolebolist){
					int data = count++;
					RoleBO bo = new RoleBO();
					bo.setRoleId(rolebo.getRoleId());
					RoleBO rolesbo = new RoleBO();
					rolesbo.setPrivilegeId(rolebo.getPrivilegeId());

					bo=roletypeservice.getrolebyid(bo);
					RoleBO role = new RoleBO();
					role.setRoleId(bo.getRoleId());
					role.setRoleName(bo.getRoleName());

					rolesbo=adminService.getPrivilegesbyId(rolesbo);
					role.setPrivilegeId(rolesbo.getPrivilegeId());
					role.setPrivilegename(rolesbo.getPrivilegename());
					role.setsNo(data);
					listrolesbo.add(role);
				}
			}
			model.addAttribute("rolebolist", listrolesbo);
			model.addAttribute("searchroleprivilege",rolebolist );
		} 

	}

	@RequestMapping(value="create-privilege-access",method=RequestMethod.GET)
	public String createPrivilegeAccess(Model model,HttpServletRequest req,HttpServletResponse res){
		PrivilegesBO privBO=new PrivilegesBO();
		/*getPrivileges(model,req);*/
		getListOfPrivilegs(model,req,res);
		getListOfAccess(model,req,res);
		model.addAttribute("privilegeBO", privBO);

		return "create-privilege-access";

	}

	public void getListOfPrivilegs(Model model,HttpServletRequest req,HttpServletResponse res){


		privilegeList=adminService.listOfPrivileges();
		if(null!=privilegeList&&!privilegeList.isEmpty()&&0<privilegeList.size()){
			model.addAttribute("privilegeList", privilegeList);
		}
	}

	public void getListOfAccess(Model model,HttpServletRequest req,HttpServletResponse res){


		accessBOList=adminService.listOfAccess();
		if(null!=accessBOList&&!accessBOList.isEmpty()&&0<accessBOList.size()){

			model.addAttribute("accessBO", accessBOList);

		}
	}

	@RequestMapping(value="create-privilege-access",method=RequestMethod.POST)
	public String privilegeAccess(@Valid Model model,@ModelAttribute("privilegeBO")PrivilegesBO privlegeBO,BindingResult result,HttpServletRequest req,HttpServletResponse res){

		if(result.hasErrors()){

			return "create-privilege-access";
		}
		List<AccessBo>accessBO1List=new ArrayList<>();
		List<String> accessListObj=new ArrayList<>(Arrays.asList(privlegeBO.getAccessName().split(",")));

		List<PrivilegesBO> privilegeList1=new ArrayList<>();
		if(null!=privlegeBO){

			if(null!=accessListObj){

				for (String accessBo : accessListObj) {
					AccessBo accessBOobj=new AccessBo();
					long accessId=Long.parseLong(accessBo);
					accessBOobj.setAccessId(accessId);
					for (AccessBo accessBO : accessBOList) {
						if(accessBO.getAccessId()==accessBOobj.getAccessId()){
							accessBO1List.add(accessBO);
							privlegeBO.setAccessBOlist(accessBO1List);
						}

					}	

				}

			}
			if(null!=privlegeBO){
				PrivilegesBO privilegeBOobj=new PrivilegesBO();
				Long privilegeId=Long.parseLong(privlegeBO.getPrivilegename());
				privilegeBOobj.setPrivilegeId(privilegeId);

				for (PrivilegesBO privilegesBO : privilegeList) {
					if(privilegesBO.getPrivilegeId()==privilegeBOobj.getPrivilegeId()){
						privilegeList1.add(privilegesBO);
						privlegeBO.setPrivilegeslis(privilegeList1);

					}

				}	

			}
		}

		if(null!=privlegeBO){
			privlegeBO=adminService.privilegeAccess(privlegeBO);
		}

		if(0<privlegeBO.getPrivilegeId()){
			System.out.println("Successfully Created");
		}
		model.addAttribute("privilegeBO", privlegeBO);
		model.addAttribute("privilegeList", privilegeList);
		model.addAttribute("accessBO", accessBOList);

		return "redirect:/view-privilege-access";
	}


	@RequestMapping(value="view-privilege-access",method=RequestMethod.GET)
	public String viewPrivilegeAccess(Model model,HttpServletRequest request,HttpServletResponse response){

		List<PrivilegesBO> privilegeList=new ArrayList<>();
		privilegeList=adminService.listOfPrvielegeAccess();
		if(null!=privilegeList &&!privilegeList.isEmpty()&&0<privilegeList.size()){
			model.addAttribute("privilegeBOlist", privilegeList);
		}
		return "view-privilege-access";
	}

	@RequestMapping(value="edit-privilege-access",method=RequestMethod.GET)
	public String editPRivilegeAccess(Model model,@RequestParam("privilegeId")long privilegeId,HttpServletRequest request,HttpServletResponse response){
		PrivilegesBO privilegesBO=new PrivilegesBO();
		/*
		 * List<PrivilegesBO> privilegeListEdit=new ArrayList<>(); List<AccessBo>
		 * accessBOListEdit=new ArrayList<>(); PrivilegesBO privilegeBO=new
		 * PrivilegesBO();
		 */
		/*
		 * if(0<privilegeId){ privilegeBO.setPrivilegeId(privilegeId); }
		 * privilegeListEdit=adminService.editPriviegeAccess(privilegeBO);
		 */		/*
		 * if(null!=privilegeListEdit){ for (PrivilegesBO privilegeBO1 :
		 * privilegeListEdit) { if(null!=privilegeBO1.getPrivilegename()){
		 * model.addAttribute("privilegeBOEdit", privilegeListEdit); } }
		 * 
		 * } getListOfPrivilegs(model,request, response); getListOfAccess(model,request,
		 * response); for (PrivilegesBO privilegeBO1 : privilegeListEdit) { for
		 * (AccessBo accessBo : privilegeBO1.getAccessBOlist()) {
		 * if(null!=accessBo.getAccessName()){ model.addAttribute("accessBOEditlist",
		 * privilegeBO1.getAccessBOlist()); } } }
		 * 
		 * model.addAttribute("editPrivilegeAccessObj", privilegeBO);
		 */
		/*		String id2=request.getParameter("privilegeid");
		 */
		 getPrivilege(model,request);
		 getListOfAccess(model,request, response);
		 if(null!=privilegesBO) {
			 privilegesBO.setPrivilegeId(privilegeId);
			 privilegesBO=roletypeservice.getPrivilegebyid(privilegesBO); 
			 model.addAttribute("editPrivilegeAccessObj", privilegesBO);
			 return "edit-privilege-access";

		 }
		 return "edit-privilege-access";
	}
		 

	@RequestMapping(value="edit-privilege-access",method=RequestMethod.POST)
	public String updatePrivilegeAccess(@Valid Model model,@ModelAttribute("editPrivilegeAccessObj")PrivilegesBO privilegeBO,BindingResult result,HttpServletRequest request,HttpServletResponse response){

		if(result.hasErrors()){

			return "edit-privilege-access";
		}
		//List<String> strList=new ArrayList<>(Arrays.asList(privilegeBO.getAccessName().split(",")));
		List<AccessBo> accessBOList2=new ArrayList<>();
		if(null!=privilegeBO&&null!=privilegeBO.getAccessIds()&&privilegeBO.getAccessIds().size()>0){

		if(null!=privilegeBO){
			for (Long id : privilegeBO.getAccessIds()) {
				AccessBo accessBO=new AccessBo();
				//long accessId=Long.parseLong(string);
				accessBO.setAccessId(id);
				accessBOList2.add(accessBO);
			}
		}
		if(null!=accessBOList2 &&!accessBOList2.isEmpty()&&0<accessBOList2.size()){
			privilegeBO.setAccessBOlist(accessBOList2);
		}

		privilegeBO=adminService.updatePrivilegeAccess(privilegeBO);

		return "redirect:/view-privilege-access";
	}
		return "redirect:/view-privilege-access";
	}
	@RequestMapping(value="delete-privilege-access",method=RequestMethod.GET)
	public String deletePrivilegeAccess(Model model,@RequestParam("privilegeId")long privilegeId,HttpServletRequest req,HttpServletResponse res){

		PrivilegesBO privilegeBO=new PrivilegesBO(); 

		if(0<privilegeId){
			privilegeBO.setPrivilegeId(privilegeId);
		}

		privilegeBO=adminService.deletePrivilegeAccess(privilegeBO);


		return "redirect:/view-privilege-access";
	}


	/*public void getuserrole(Model model){
	List<UserRolesBO> listbo = new ArrayList<UserRolesBO>();
	listbo=userroleService.retriveUserRoles(listbo);
	model.addAttribute("listbo", listbo);
	}
	 */
}

