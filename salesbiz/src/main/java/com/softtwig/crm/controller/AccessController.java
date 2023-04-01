package com.softtwig.crm.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softtwig.crm.bo.AccessBo;
import com.softtwig.crm.security.ControllerUtils;
import com.softtwig.crm.service.AccessService;


@Controller
public class AccessController extends ControllerUtils implements Serializable {
	
	@Autowired
	
	private AccessService accessService;
	
	
	
	
	@Autowired
	
	MessageSource messageSorce;
	
	List<AccessBo> getaccessbo=new ArrayList<AccessBo>();

	
	@RequestMapping(value="/create-access" ,method =RequestMethod.GET )
	
	public String accessValue(Model model,HttpServletRequest request,HttpServletResponse response) {
		AccessBo accessBo=new AccessBo();		
		model.addAttribute("accessBo", accessBo);		
		return "create-access";		
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/create-access",method =RequestMethod.POST )
	public String createAccessValue(@Valid @ModelAttribute("accessBo") AccessBo accessBo,BindingResult result,HttpServletRequest request,HttpServletResponse response,Model model) {
		if(result.hasErrors()) {
			return "create-access";
			
		}
		long loginId = getUserSecurity().getLoginId();
		//String userType = getUserSecurity().getRole();
		if (0 == loginId) {
			return "redirect:/admin-sign-in";
		}
		accessBo =accessService.createSaveAccess(accessBo);
		if(0 <accessBo.getAccessId()) {
			model.addAttribute("infomessage",messageSorce.getMessage("Access-creation", null, null) );
			
		}	
		
		return "create-access";
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/view-access",method = RequestMethod.GET)	
	public String viewAccess(Model model,HttpServletRequest request,HttpSession session) {
		
		AccessBo accessbo=new AccessBo();
		
		getaccessbo=accessService.viewAccess();
		if (null != getaccessbo) {
			model.addAttribute("accessbolist", getaccessbo);
			model.addAttribute("viewAccess",new AccessBo());
		}
		if(null!=request.getParameter("successMessage")) {
			model.addAttribute("successMessage", request.getParameter("successMessage"));
		}
		if(null!=request.getParameter("errorMessage")) {
			model.addAttribute("errorMessage", request.getParameter("errorMessage"));
		}	
		
		return "view-access";
		
		
		
	
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/edit-access",method =RequestMethod.GET )
	public String editAccess(@RequestParam("accessId")long accessId,Model model) {
		
	for (AccessBo accessBo : getaccessbo) {
		if(accessId==accessBo.getAccessId()) {
			model.addAttribute("editAccessBo", accessBo);
		}
		
	}
		return "edit-access";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/edit-access",method =RequestMethod.POST )
	public String editUpdateValue(@Valid @ModelAttribute("editAccessBo")AccessBo accessBo,BindingResult result,HttpServletRequest request,HttpServletResponse response,Model model) {
	
		if(result.hasErrors()) {
			return "edit-access";
		}
		
		accessBo=accessService.updateAccessValue(accessBo);
		if(0 <accessBo.getAccessId() ) {
			model.addAttribute("infomessage", messageSorce.getMessage("Access-Update", null, null));
	
			return "redirect:/view-access";
		}
		
		return "redirect:/view-access";		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/delete-access",method = RequestMethod.GET)
	public String deleteAccessValue(Model model,@RequestParam("accessId")long accessId,HttpServletRequest request) {
		for (AccessBo accessBo : getaccessbo) {
			if (accessId==accessBo.getAccessId()) {
				long id=accessService.deleteAccess(accessBo);
				model.addAttribute("infomessage", messageSorce.getMessage("Access-Delete", null, null));
				return "redirect:/view-access";			
			}			
		}			
		return "redirect:/view-access";
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/search-access" ,method = RequestMethod.POST)
	public String searchAccess(@ModelAttribute("viewAccess")AccessBo accessBo,Model model,HttpServletRequest request) {
		
		AccessBo accessbo=new AccessBo();
		accessbo.setAccessName(accessBo.getAccessName());
		
		List<AccessBo> getaccessbo=new ArrayList<AccessBo>();
		getaccessbo=accessService.getAccessList(accessbo);
		if(null !=getaccessbo && 0< getaccessbo.size()) {
			
			model.addAttribute("accessbolist", getaccessbo);
			model.addAttribute("viewAccess", accessBo);
			return "view-access";
			
		}
		else {
			model.addAttribute("error message", "no record found");
			return "view-access";
		}
		
	}

}
