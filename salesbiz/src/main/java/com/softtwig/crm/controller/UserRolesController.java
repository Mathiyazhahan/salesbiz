package com.softtwig.crm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtwig.crm.bo.AdminUserBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.exception.MySalesException;
import com.softtwig.crm.service.AdminService;
import com.softtwig.crm.service.RoleTypeService;
import com.softtwig.crm.service.UserRoleService;

@Controller
public class UserRolesController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRoleService userroleService;
	@Autowired
	private RoleTypeService roleTypeService;
	
	
	@RequestMapping(value="/create-user-roles",method=RequestMethod.GET)
	public String createUserRoles(Model model ,HttpServletRequest request) throws MySalesException{
		AdminUserBO userrolebo = new AdminUserBO();
		getUser(model, request);
		getuserroles(model,request);
		List<AdminUserBO> listUserBo = new ArrayList<AdminUserBO>();
		listUserBo=adminService.retrieveUser(listUserBo);
		model.addAttribute("listUserBo", listUserBo);		
		model.addAttribute("userRoles", userrolebo);	
		return "create-user-roles";
	}
	


	@RequestMapping(value="/create-user-roles",method=RequestMethod.POST)
	public String createUserRoles(@ModelAttribute ("userRoles") AdminUserBO adminUserBO) throws Exception{
		AdminUserBO userRolesBo = new AdminUserBO();
		String username=adminUserBO.getName();
		long userid=Long.parseLong(username);
		userRolesBo.setUserId(userid);
		List<RoleBO> roleblist = new ArrayList<RoleBO>();
		List<String> rolenamelist = new ArrayList<String>(Arrays.asList(adminUserBO.getRoleName().split(",")));
		if(null!=adminUserBO){
			for(String str : rolenamelist){
				RoleBO bo = new RoleBO();
				int roleid = Integer.parseInt(str);
				bo.setRoleId(roleid);
				roleblist.add(bo);
			}
		}
		roleblist=roleTypeService.getroleList(roleblist);
		userRolesBo=adminService.retrieveusers(userRolesBo.getUserId());

		userRolesBo.setListrlebo(roleblist);

		userRolesBo=userroleService.createUserRoles(userRolesBo);
		
		return "redirect:/create-user-roles";
	}
	
	@RequestMapping(value="/edit-user-role",method=RequestMethod.GET)
	public String updateUserRole(Model model,HttpServletRequest request) throws MySalesException{
		
		getUser(model, request);
		getuserroles(model,request);
		
		String userid=request.getParameter("userId");
		if(null!=userid&&!userid.isEmpty()){
			long id = Long.parseLong(userid);
			AdminUserBO bo = new AdminUserBO();
			bo.setId(id);
			bo=adminService.retrieveusers(id);
			model.addAttribute("useredit", bo);
			return "edit-user-role";
		}
		return "edit-user-role";
	}
	
	@RequestMapping(value="/edit-user-role",method=RequestMethod.POST)
	public String updateUserRole(@ModelAttribute ("useredit") AdminUserBO adminuserBO,Model model) throws Exception{
		
		AdminUserBO bo = new AdminUserBO();
		bo.setName(adminuserBO.getName());
		bo=adminService.retriveUserByName(bo);
		
		List<RoleBO> roleblist = new ArrayList<RoleBO>();
		List<String> rolenamelist = new ArrayList<String>(Arrays.asList(adminuserBO.getRoleName().split(",")));
		if(null!=adminuserBO){
			for(String str : rolenamelist){
				RoleBO rolebo = new RoleBO();
				int roleid = Integer.parseInt(str);
				rolebo.setRoleId(roleid);
				roleblist.add(rolebo);
			}
		}
		roleblist=roleTypeService.getroleList(roleblist);

		bo.setListrlebo(roleblist);

		bo=userroleService.createUserRoles(bo);

		return "redirect:/create-user-roles";
		
	}
	
	
	@RequestMapping(value="/delete-user-role",method=RequestMethod.GET)
	public String deleteUserRole(Model model,HttpServletRequest request){
		String userId = request.getParameter("userid");
		if(null!=userId){
			long id = Long.parseLong(userId);
			AdminUserBO userbo = new AdminUserBO();
			userbo.setId(id);
			userroleService.deleteUserRole(userbo);
		}
		return "redirect:/create-user-roles";
		
	}
	public void getuserroles(Model model,HttpServletRequest request){
		List<RoleBO> listbo = new ArrayList<RoleBO>();

		listbo=roleTypeService.viewrole();
		model.addAttribute("listbo", listbo);


	}		
	
	public void getUser(Model model,HttpServletRequest request){
		List<AdminUserBO> listuser = new ArrayList<AdminUserBO>();
		try {
			listuser=adminService.retrieveUser();
			if(null!=listuser&&listuser.size()>0){
				model.addAttribute("listuser", listuser);
			}
		} catch (MySalesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}