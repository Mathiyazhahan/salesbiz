/**
 * 
 */
package com.softtwig.crm.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author User
 *
 */

@Entity
@Table(name = "login")
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email_Id")
	private String emailAddress;
	
	@Column(name="isActive")
	private boolean isActive;
	
	
	@Column(name="isDelete")
	private boolean isDelete;
	
	@Column(name="password")
	private String password;
	
	@Column(name="confirmpassword")
	private String confirmpassword;
	

	@Column(name="mobileno")
	private String mobileNo;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="users_roles",joinColumns={@JoinColumn(name="id")},inverseJoinColumns={@JoinColumn(name="roleId")})
	private List<RolesVO> listRoletypeVo;
	
	public List<RolesVO> getListRoletypeVo() {
		return listRoletypeVo;
	}

	public void setListRoletypeVo(List<RolesVO> listRoletypeVo) {
		this.listRoletypeVo = listRoletypeVo;
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
	 * @return the confirmpassword
	 */
	public String getConfirmpassword() {
		return confirmpassword;
	}

	/**
	 * @param confirmpassword the confirmpassword to set
	 */
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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
	
		
	

}
