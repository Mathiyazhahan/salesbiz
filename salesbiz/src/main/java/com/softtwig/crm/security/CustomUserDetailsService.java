package com.softtwig.crm.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softtwig.crm.dao.AdminDAO;
import com.softtwig.crm.utils.EncryptAndDecrypt;
import com.softtwig.crm.vo.PrivilegesVO;
import com.softtwig.crm.vo.RolesVO;
import com.softtwig.crm.vo.User;


@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private AdminDAO dao;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	List<String> userType=new ArrayList<String>();

	String salt = "this is a simple clear salt";
	private final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user=null;
	
		if(null!=username){
			try {
						user=dao.authendicate(username);
						if(null!=user){
							return new MySalesUser(user.getEmailAddress(),getPwd(user.getPassword()), true, true, true, 
									true, getAuthorities(user.getListRoletypeVo()),user.getId(),user.getName(),userType);
						}						
					
					
				
			}catch(Exception he){
				if(LOGGER.isInfoEnabled()) {
					LOGGER.info("FROM INFO: Exception \t"+he);
				}
				if(LOGGER.isDebugEnabled()) {
					LOGGER.debug("FROM DEBUG : Exception \t"+he);
				}

			}
		}

		return new org.springframework.security.core.userdetails.User(null,null, null);
	}

	
	private String getPwd(String pwd) throws Exception {
		String decrypted=EncryptAndDecrypt.decrypt(pwd);
		System.out.println(decrypted);
		return passwordEncoder().encode(decrypted);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<RolesVO> userRole) {
		
		List<PrivilegesVO> privillegesList=new ArrayList<PrivilegesVO>();
		for(RolesVO rolesVO:userRole) {
			privillegesList.addAll(rolesVO.getListPrivilegesvo());
			userType.add(rolesVO.getRoleName());
		}
		return getGrantedAuthorities(getPrivileges(privillegesList));
	}

	private List<PrivilegesVO> getPrivileges(List<PrivilegesVO> privillegesList) {
		List<PrivilegesVO> privileges = new ArrayList<PrivilegesVO>();
		
		for(PrivilegesVO privillege:privillegesList) {
		privileges.add(privillege);
		}
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<PrivilegesVO> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (PrivilegesVO privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege.getPrivilegesName()));
		}
		return authorities;
	}

}
