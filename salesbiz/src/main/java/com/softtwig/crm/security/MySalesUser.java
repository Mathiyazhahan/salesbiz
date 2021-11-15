package com.softtwig.crm.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MySalesUser extends User{
	
	private static final long serialVersionUID = 1412418605713742140L;
	
	private final String salt="STSEHO2020";
	private Long loginId; 
	private String name;	
	private List<String> role;

	public MySalesUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, long loginId,String name,List<String> role) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);		
		this.setName(name);	
		this.setLoginId(loginId);
		this.role=role;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	
	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getSalt() {
		return salt;
	}
	
	

}
