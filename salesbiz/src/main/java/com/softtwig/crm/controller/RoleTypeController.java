package com.softtwig.crm.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.security.ControllerUtils;
import com.softtwig.crm.service.RoleTypeService;




@Controller
@Scope("session")
@SessionAttributes("/admin")
public class RoleTypeController extends ControllerUtils implements Serializable  {

	@Autowired

	private RoleTypeService roletypeService;

	@Autowired

	private MessageSource messageSource;

	List<RoleBO> rolelist=new ArrayList<>();

	@RequestMapping(value="/create-role",method = RequestMethod.GET)
	public String getRoleType(Model model) {


		RoleBO roleBOobj=new RoleBO();

		model.addAttribute("roleobj",roleBOobj);

		return "create-role";

	}

	@RequestMapping(value="/create-role",method =RequestMethod.POST )
	public String postRoleType(@Valid @ModelAttribute("roleobj") RoleBO roleBOobj,BindingResult result,HttpServletRequest request,Model model) {

		RoleBO roleBOObj=new RoleBO();
		String rolename=request.getParameter("roleName");
		roleBOObj.setRoleName(rolename);
		roleBOobj=roletypeService.getroletype(roleBOObj);

		if(result.hasErrors()) {

			return "create-role";
		}
		if(roleBOobj.getRoleName().isEmpty()) {

			model.addAttribute("createerrormessage",messageSource.getMessage("Role-Creation-Error", null, null));

		}


		if(null!=roleBOobj) {

			model.addAttribute("sucessmessage",messageSource.getMessage("Role-Creation", null, null));

		}


		return "redirect:/view-role";

	}

	@RequestMapping(value="/view-role",method = RequestMethod.GET)
	public String getViewRole(Model model,HttpServletRequest request,HttpServletResponse response) {


		rolelist=roletypeService.viewrole();

		if(null!=rolelist && rolelist.size()>0 && !rolelist.isEmpty()) {
			model.addAttribute("listroleobj", rolelist);
			model.addAttribute("searchObj", new RoleBO());

			if(null!=request.getParameter("sucessmessage")){
				model.addAttribute("sucessmessage", request.getParameter("sucessmessage"));
			}

			model.addAttribute("viewinfomessage", messageSource.getMessage("Role-View", null, null));

		}
		return "view-role";

	}

	@RequestMapping(value="/edit-role-type",method = RequestMethod.GET)
	public String geteditRole( @RequestParam("roleId")long id, Model model,HttpServletRequest request) {




		for(RoleBO rolebo:rolelist) {

			if(id==rolebo.getRoleId()) {
				model.addAttribute("editroleobj", rolebo);
			}
		}




		return "edit-role";

	}

	@RequestMapping(value="/edit-role-type",method = RequestMethod.POST)
	public String posteditrole(@Valid@ModelAttribute("editroleobj") RoleBO roleBOobj,BindingResult result,HttpServletRequest request,HttpServletResponse response,Model model) {

		if(result.hasErrors()) {

			return "redirect:/view-role";
		}

		roleBOobj=roletypeService.posteditrole(roleBOobj);

		if(null!=roleBOobj) {

			model.addAttribute("updateinfomessage", messageSource.getMessage("Role-Update", null, null) );
			System.out.println("message");	

		}


		return "redirect:/view-role";

	}

	@RequestMapping(value="/delete-role-type",method =RequestMethod.GET )
	public String deleteroletype(Model model,@RequestParam("roleId")long id,HttpServletRequest request) {

		for(RoleBO rolebo:rolelist) {

			if(id==rolebo.getRoleId()) {

				int count=roletypeService.deleteroletype(rolebo);
				model.addAttribute("deleteinfomessage", messageSource.getMessage("Role-Delete", null, null));
			}

		}


		return "redirect:/view-role";

	}

	@RequestMapping(value="search-role",method=RequestMethod.POST)
	public String searchRoleName(@Valid Model model,@ModelAttribute("searchObj")RoleBO roleBO,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
		
		List<RoleBO> roleBOList=new ArrayList<>();
		
		if(null!=roleBO.getRoleName()) {
			roleBOList=roletypeService.searchRoleName(roleBO);	
		}
		
		if(null!=roleBOList&&!roleBOList.isEmpty()&&0<roleBOList.size()) {
			
			model.addAttribute("listroleobj", roleBOList);
			model.addAttribute("searchObj",roleBO );
		}
		

		return "view-role";
	}

}
