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
@Table(name="user_group")
public class UserGroupDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4703163242502568761L;
	private int userGroupId;
	private String userName;
	private String reportingName;
	private String email;	
	private User user;
	
	/**
	 * @return the userGroupId
	 */
	@Id
	@GeneratedValue
	@Column(name = "USER_GROUP_ID", unique = true, nullable = false)
	public int getUserGroupId() {
		return userGroupId;
	}
	/**
	 * @param userGroupId the userGroupId to set
	 */
	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}
	/**
	 * @return the userName
	 */
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the reportingName
	 */
	@Column(name="REPORTING_NAME")
	public String getReportingName() {
		return reportingName;
	}
	/**
	 * @param reportingName the reportingName to set
	 */
	public void setReportingName(String reportingName) {
		this.reportingName = reportingName;
	}
	/**
	 * @return the email
	 */
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the userDO
	 */
	@ManyToOne
	@JoinColumn(name = "REPORTING_ID", nullable = false)
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
