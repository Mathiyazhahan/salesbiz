package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security_entity_operation")
public class SecurityEntityOperationDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3056901251411370961L;
	
	private int securityId;
	private String securityName;
	/**
	 * @return the securityId
	 */
	@Id
	@GeneratedValue
	@Column(name = "SECURITY_E_ID", unique = true, nullable = false)
	public int getSecurityId() {
		return securityId;
	}
	/**
	 * @param securityId the securityId to set
	 */
	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}
	/**
	 * @return the securityName
	 */
	@Column(name = "SECURITY_ENTITY_NAME", nullable = false)
	public String getSecurityName() {
		return securityName;
	}
	/**
	 * @param securityName the securityName to set
	 */
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
}
