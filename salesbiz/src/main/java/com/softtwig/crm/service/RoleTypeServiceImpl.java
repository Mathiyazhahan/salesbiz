package com.softtwig.crm.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtwig.crm.bo.PrivilegesBO;
import com.softtwig.crm.bo.RoleBO;
import com.softtwig.crm.dao.RoleTypeDao;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolesVO;



@Service
@Transactional
public class RoleTypeServiceImpl implements RoleTypeService{

	@Autowired
	private RoleTypeDao roletypeDao;


	@Override
	public RoleBO getroletype(RoleBO roleBOObj) {
		// TODO Auto-generated method stub

		RolesVO roleVOobj=new RolesVO();

		roleVOobj.setRoleName(roleBOObj.getRoleName());

		roleVOobj=roletypeDao.getroletype(roleVOobj);

		if(0<roleVOobj.getRoleId()) {

			roleBOObj.setRoleId(roleVOobj.getRoleId());
		}


		return roleBOObj;
	}


	@Override
	public List<RoleBO> viewrole() {

		List<RoleBO> viewroleobj=new ArrayList<>();

		viewroleobj=roletypeDao.viewrole();

		if(null!=viewroleobj && viewroleobj.size()>0 && !viewroleobj.isEmpty()) {

			System.out.println("hello");
		}

		return viewroleobj;
	}


	/*
	 * @Override public RoleBO geteditrole(String roleId) { // TODO Auto-generated
	 * method stub
	 * 
	 * long id=0; RoleBO roleBOobj=new RoleBO(); RoleTypeVO roleVOobj=new
	 * RoleTypeVO();
	 * 
	 * if(null!=roleId) {
	 * 
	 * id=Long.parseLong(roleId); }
	 * 
	 * roleVOobj=roletypeDao.geteditrole(id);
	 * 
	 * 
	 * return roleBOobj; }
	 */


	@Override
	public RoleBO posteditrole(RoleBO roleBOobj) {
		// TODO Auto-generated method stub

		RolesVO roleVOobj=new RolesVO();

		roleVOobj.setRoleId(roleBOobj.getRoleId());

		roleVOobj.setRoleName(roleBOobj.getRoleName());

		roleVOobj=roletypeDao.posteditrole(roleVOobj);

		if(null!=roleVOobj) {

			roleBOobj.setRoleId(roleVOobj.getRoleId());
		}

		return roleBOobj;
	}


	@Override
	public int deleteroletype(RoleBO rolebo) {
		// TODO Auto-generated method stub

		int count=0;

		RolesVO roleVOobj=new RolesVO();
		roleVOobj.setRoleId(rolebo.getRoleId());
		roleVOobj.setRoleName(rolebo.getRoleName());
		roleVOobj=roletypeDao.deletepost(roleVOobj);

		if(null!=roleVOobj) {

			rolebo.setRoleId(roleVOobj.getRoleId());

		}

		return count;
	}

	@Override
	public RoleBO getRoleid(RoleBO borole) {
		RolesVO roletypevo = new RolesVO();
		roletypevo.setRoleName(borole.getRoleName());
		roletypevo=roletypeDao.getroleid(roletypevo);
		RoleBO roleBO = new RoleBO();
		roleBO.setRoleName(roletypevo.getRoleName());
		roleBO.setRoleId(roletypevo.getRoleId());
		return roleBO;

	}

	@Override
	public List<RoleBO> getroleList(List<RoleBO> roleblist) {
		List<RoleBO> rolelist = new ArrayList<RoleBO>();
		for(RoleBO rolbe :roleblist ){
			RolesVO rolevo = new RolesVO();
			rolevo.setRoleId(rolbe.getRoleId());
			rolevo=roletypeDao.getRolelist(rolevo);
			RoleBO bo = new RoleBO();
			bo.setRoleId(rolevo.getRoleId());
			bo.setRoleName(rolevo.getRoleName());
			rolelist.add(bo);
		}
		return rolelist;
	}


	@Override
	public RoleBO getrolebyid(RoleBO rolebo) {
		RoleBO role = new RoleBO();

		RolesVO rolevo = new RolesVO();
		rolevo.setRoleId(rolebo.getRoleId());
		rolevo=roletypeDao.getRolelist(rolevo);
		List<Long> privilegeIdList=roletypeDao.getPrivelegeIdList(rolevo);
		role.setPrivilegeIds(privilegeIdList);
		role.setRoleId(rolevo.getRoleId());
		role.setRoleName(rolevo.getRoleName());

		return role;
	}


	@Override
	public RolesVO createRolePrivileges(RolesVO rolevo) {

		/*		session.save(rolevo);
		 */		return null;
	}



	@Override
	public List<RoleBO> getroleLists(List<RoleBO> rolebo) {
		List<RoleBO> viewroleobj=new ArrayList<>();
		List<RolesVO> rolesvo = new ArrayList<RolesVO>();
		rolesvo=roletypeDao.viewrole(rolesvo);
		if(null!=rolesvo&&rolesvo.size()>0){
			for(RolesVO rolevo : rolesvo){
				List<PrivilegesBO> listbo = new ArrayList<PrivilegesBO>() ;   
				for(PrivilegesVO vo :rolevo.getListPrivilegesvo()){
					PrivilegesBO privolegesbo = new PrivilegesBO();
					privolegesbo.setPrivilegeId(vo.getPrivilegeId());
					privolegesbo.setPrivilegename(vo.getPrivilegesName());
					listbo.add(privolegesbo);
				}
				RoleBO rolesbo = new RoleBO();
				rolesbo.setRoleId(rolevo.getRoleId());
				rolesbo.setRoleName(rolevo.getRoleName());
				rolesbo.setPrivilegesbolist(listbo);
				viewroleobj.add(rolesbo);
			}
		}
		return viewroleobj;
	}


	@Override
	public List<RoleBO> searchRoleName(RoleBO roleBO) {
		// TODO Auto-generated method stub

		List<RolesVO> roleVOList=new ArrayList<>();
		List<RoleBO> roleBOList=new ArrayList<>();
		
		RolesVO roleVO=new RolesVO();

		if(null!=roleBO.getRoleName()) {   

			roleVO.setRoleName(roleBO.getRoleName());
		}

		roleVOList=roletypeDao.searchRoleName(roleVO);
		
		if(null!=roleVOList&&!roleVOList.isEmpty()&&0<roleVOList.size()) {
			
			int count=0;
			
			for (RolesVO rolesVO : roleVOList) {
				
				RoleBO roleBOobj=new RoleBO();
				int sNo=++count;
				roleBOobj.setsNo(sNo);
				roleBOobj.setRoleName(rolesVO.getRoleName());
				roleBOList.add(roleBOobj);
			}
			
		}

		return roleBOList;
	}


	@Override
	public PrivilegesBO getPrivilegebyid(PrivilegesBO privilegesBO) {
		PrivilegesBO privilegesBo= new PrivilegesBO();

		PrivilegesVO privilegesVO = new PrivilegesVO();
		privilegesVO.setPrivilegeId(privilegesBO.getPrivilegeId());
		privilegesVO=roletypeDao.getPrivilegelist(privilegesVO);
		List<Long> privilegeIdList=roletypeDao.getPrivelegeIdList(privilegesVO);
		privilegesBo.setAccessIds(privilegeIdList);
		privilegesBo.setPrivilegeId(privilegesVO.getPrivilegeId());
		privilegesBo.setPrivilegename(privilegesVO.getPrivilegesName());

		return privilegesBo;
	}

}
