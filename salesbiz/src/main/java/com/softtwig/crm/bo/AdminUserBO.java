/**
 * 
 */
package com.softtwig.crm.bo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * @author User
 *
 */
public class AdminUserBO extends BaseBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long adminId;
	@NotBlank(message="Name should not be empty")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = " Name Should be a Character")
	private String name;
	@NotBlank(message="Email should not be empty")
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid Email Format")
	private String emailAddress;
	@NotBlank(message="Password should not be empty")
	@Size(min = 4,max=8, message = "Password minimum 4 value")
	private String password;
	@NotBlank(message="Confirm password should not be empty")
	@Size(min = 4,max=8, message = "Password minimum 4 value")
	private String confirmPassword;
	@NotNull
	@Range(min = 1111111111,message = "Phone Number must be a 10 Digits")
	private String mobileNo;
	
	/*
	 * @Pattern(regexp = "^[a-zA-Z\\s]*$", message =
	 * "User Type Should be a Character")
	 */
	private String userType;
	private boolean isActive;
	private boolean isDelete;
	private int sNo;
	private String status;
	private long userId;
	private long roleId;
	private String roleName;
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	private RoleBO rolebo;
	public RoleBO getRolebo() {
		return rolebo;
	}
	public void setRolebo(RoleBO rolebo) {
		this.rolebo = rolebo;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the isDelete
	 */
	public boolean isDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the sNo
	 */
	/**
	 * @return the sNo
	 */
	public int getsNo() {
		return sNo;
	}
	/**
	 * @param sNo the sNo to set
	 */
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the adminId
	 */
	public Long getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	/**
	 * @param adminLoginBO
	 */
	public void setAdminLoginBO(AdminLoginBO adminLoginBO) {
		
		
	}
	
	private List<RoleBO> listrlebo ;
	public List<RoleBO> getListrlebo() {
		return listrlebo;
	}
	public void setListrlebo(List<RoleBO> listrlebo) {
		this.listrlebo = listrlebo;
	}
	
	

}
