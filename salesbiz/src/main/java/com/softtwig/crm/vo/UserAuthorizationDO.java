package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_athorization")
public class UserAuthorizationDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4801461138567848510L;
	
	private int AuthorizedId;
	private String entityName;
	private String securityName;
	private Boolean isDeleted;
	// bi-directional Many-to-one association to PriceBookEntryDO
	private User user;
	/**
	 * @return the authorizedId
	 */
	@Id
	@GeneratedValue
	@Column(name = "AUTHORIZED_ID", unique = true, nullable = false)
	public int getAuthorizedId() {
		return AuthorizedId;
	}
	/**
	 * @param authorizedId the authorizedId to set
	 */
	public void setAuthorizedId(int authorizedId) {
		AuthorizedId = authorizedId;
	}
	/**
	 * @return the entityName
	 */
	@Column(name = "ENTIRY_NAME", nullable = false)
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
	/**
	 * @return the isDeleted
	 */
	@Column(name = "IS_DELETED", nullable = false)
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}	
	/**
	 * @return the userDO
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}
	/**
	 * @param userDO the userDO to set
	 */
	public void setUser(User user) {
		this.user = user;
	}	
}