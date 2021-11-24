package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


@Entity
@Indexed
@Table(name="contacts")
public class ContactDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;
	private int connectionSentId;
	private int reportToId;
	private int connectionRecvId;
	private long mobilePhone;
	private long homePhone;
	private long fax;
	private String createdBy;
	private int contactId;
	private int masterRecordId;
	private String lastModifiedBy;
	private long asistantPhone;
	private Boolean isDeleted;
	private Boolean doNotCall;
	private Boolean hasOptedOutOfMail;
	private Boolean hasOptedOutOfFax;
	private Boolean canAllowPortalSelfReg; 
	private Boolean isPersonAccount;
	private String assistantName;
	private String birthDate;
	private String createdDate;
	private String jigSaw;
	private String department;
	private String description;
	private String emailId;
	private String emailBouncedDate;
	private String emailBouncedReason;
	private String lastActivityDate;
	private String lastModifyDate;
	private String lastCuReqDate; 
	private String leadSource;
	private String mailingSrt;
	private String mailingCity;
	private String mailingState;
	private String mailingPostlCode;
	private String mailingCountry;
	private String salution;
	private String firstName;
	private String lastName;
	private String otherStrt;
	private String otherCity;
	private String otherState;
	private String othrPostalCode;
	private String otherCountry; 
	private String otherPhone;
	private String title;
	private String lastCuUpdtDate;
	private String name;
	private String cleanStatus;
	private String otherCountryCode;
	private String otherStateCode;
	private String mailingCountryCode; 
	private String maillingStateCode;
	//private UserDO userDO;
	private int ownerId;
	private String role;
	private String groupBy;
	
	/**
	 * @return the accountId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="ACCOUNT_ID",unique=false,nullable=false)
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the connectionSentId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="CONNECTION_SEND_ID",unique=false,nullable=true)
	public int getConnectionSentId() {
		return connectionSentId;
	}
	/**
	 * @param connectionSentId the connectionSentId to set
	 */
	public void setConnectionSentId(int connectionSentId) {
		this.connectionSentId = connectionSentId;
	}
	/**
	 * @return the reportToId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="REPORT_TO_ID",unique=false,nullable=true)
	public int getReportToId() {
		return reportToId;
	}
	/**
	 * @param reportToId the reportToId to set
	 */
	public void setReportToId(int reportToId) {
		this.reportToId = reportToId;
	}
	/**
	 * @return the connectionRecvId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="CONNECTION_RECEIVED_ID",unique=false,nullable=true)
	public int getConnectionRecvId() {
		return connectionRecvId;
	}
	/**
	 * @param connectionRecvId the connectionRecvId to set
	 */
	public void setConnectionRecvId(int connectionRecvId) {
		this.connectionRecvId = connectionRecvId;
	}
	/**
	 * @return the mobilePhone
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MOBILE_PHONE",unique=false,nullable=true)
	public long getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return the homePhone
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="HOME_PHONE",unique=false,nullable=true)
	public long getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(long homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @return the fax
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="FAX",unique=false,nullable=true)
	public long getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(long fax) {
		this.fax = fax;
	}
	/**
	 * @return the createdById
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="CREATED_BY",unique=false,nullable=true)
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdById the createdById to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the ownerId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OWNER_ID",unique=false,nullable=true)
	public int getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * @return the contactId
	 */
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID", unique=true, nullable=false)
	public int getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the masterRecordId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MASTER_RECORD_ID",unique=false,nullable=true)
	public int getMasterRecordId() {
		return masterRecordId;
	}
	/**
	 * @param masterRecordId the masterRecordId to set
	 */
	public void setMasterRecordId(int masterRecordId) {
		this.masterRecordId = masterRecordId;
	}
	/**
	 * @return the lastModifiedByid
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_MODIFIED_BY",unique=false,nullable=true)
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	/**
	 * @param lastModifiedByid the lastModifiedByid to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	/**
	 * @return the asistantPhone
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="ASSISTANT_PHONE",unique=false,nullable=true)
	public long getAsistantPhone() {
		return asistantPhone;
	}
	/**
	 * @param asistantPhone the asistantPhone to set
	 */
	public void setAsistantPhone(long asistantPhone) {
		this.asistantPhone = asistantPhone;
	}
	/**
	 * @return the isDeleted
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="IS_DELETED",unique=false,nullable=true)
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
	 * @return the doNotCall
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="DO_NOT_CALL",unique=false,nullable=true)
	public Boolean getDoNotCall() {
		return doNotCall;
	}
	/**
	 * @param doNotCall the doNotCall to set
	 */
	public void setDoNotCall(Boolean doNotCall) {
		this.doNotCall = doNotCall;
	}
	/**
	 * @return the hasOptedOutOfMail
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="HAS_OPTED_OUT_OF_EMAIL",unique=false,nullable=true)
	public Boolean getHasOptedOutOfMail() {
		return hasOptedOutOfMail;
	}
	/**
	 * @param hasOptedOutOfMail the hasOptedOutOfMail to set
	 */
	public void setHasOptedOutOfMail(Boolean hasOptedOutOfMail) {
		this.hasOptedOutOfMail = hasOptedOutOfMail;
	}
	/**
	 * @return the hasOptedOutOfFax
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="HAS_OPTED_OUT_OF_FAX",unique=false,nullable=true)
	public Boolean getHasOptedOutOfFax() {
		return hasOptedOutOfFax;
	}
	/**
	 * @param hasOptedOutOfFax the hasOptedOutOfFax to set
	 */
	public void setHasOptedOutOfFax(Boolean hasOptedOutOfFax) {
		this.hasOptedOutOfFax = hasOptedOutOfFax;
	}
	/**
	 * @return the canAllowPortalSelfReg
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="CAN_ALLOW_PORTAL_SELF_REG",unique=false,nullable=true)
	public Boolean getCanAllowPortalSelfReg() {
		return canAllowPortalSelfReg;
	}
	/**
	 * @param canAllowPortalSelfReg the canAllowPortalSelfReg to set
	 */
	public void setCanAllowPortalSelfReg(Boolean canAllowPortalSelfReg) {
		this.canAllowPortalSelfReg = canAllowPortalSelfReg;
	}
	/**
	 * @return the isPersonAccount
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="IS_PERSON_ACCOUNT",unique=false,nullable=true)
	public Boolean getIsPersonAccount() {
		return isPersonAccount;
	}
	/**
	 * @param isPersonAccount the isPersonAccount to set
	 */
	public void setIsPersonAccount(Boolean isPersonAccount) {
		this.isPersonAccount = isPersonAccount;
	}
	/**
	 * @param isPersonAccount the isPersonAccount to set
	 */
	public void setPersonAccount(boolean isPersonAccount) {
		this.isPersonAccount = isPersonAccount;
	}
	/**
	 * @return the assistantName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="ASSISTANT_NAME",unique=false,nullable=true)
	public String getAssistantName() {
		return assistantName;
	}
	/**
	 * @param assistantName the assistantName to set
	 */
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	/**
	 * @return the birthDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="BIRTH_DATE",unique=false,nullable=true)
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the createdDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="CREATED_DATE",unique=false,nullable=true)
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the jigSaw
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="JIGSAW",unique=false,nullable=true)
	public String getJigSaw() {
		return jigSaw;
	}
	/**
	 * @param jigSaw the jigSaw to set
	 */
	public void setJigSaw(String jigSaw) {
		this.jigSaw = jigSaw;
	}
	/**
	 * @return the department
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="DEPARTMENT",unique=false,nullable=true)
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the description
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="DESCRIPTION",unique=false,nullable=true)
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the email
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(impl=WhitespaceAnalyzer.class)
	@Column(name="EMAIL",unique=true,nullable=true)
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the emailBouncedDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="EMAIL_BOUNCED_DATE",unique=false,nullable=true)
	public String getEmailBouncedDate() {
		return emailBouncedDate;
	}
	/**
	 * @param emailBouncedDate the emailBouncedDate to set
	 */
	public void setEmailBouncedDate(String emailBouncedDate) {
		this.emailBouncedDate = emailBouncedDate;
	}
	/**
	 * @return the emailBouncedReason
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="EMAIL_BOUNCED_REASON",unique=false,nullable=true)
	public String getEmailBouncedReason() {
		return emailBouncedReason;
	}
	/**
	 * @param emailBouncedReason the emailBouncedReason to set
	 */
	public void setEmailBouncedReason(String emailBouncedReason) {
		this.emailBouncedReason = emailBouncedReason;
	}
	/**
	 * @return the lastActivityDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_ACTIVITY_DATE",unique=false,nullable=true)
	public String getLastActivityDate() {
		return lastActivityDate;
	}
	/**
	 * @param lastActivityDate the lastActivityDate to set
	 */
	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}
	/**
	 * @return the lastModifyDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_MODIFIED_DATE",unique=false,nullable=true)
	public String getLastModifyDate() {
		return lastModifyDate;
	}
	/**
	 * @param lastModifyDate the lastModifyDate to set
	 */
	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	/**
	 * @return the lastCuReqDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_CU_REQUEST_DATE",unique=false,nullable=true)
	public String getLastCuReqDate() {
		return lastCuReqDate;
	}
	/**
	 * @param lastCuReqDate the lastCuReqDate to set
	 */
	public void setLastCuReqDate(String lastCuReqDate) {
		this.lastCuReqDate = lastCuReqDate;
	}
	/**
	 * @return the leadSource
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LEAD_SOURCE",unique=false,nullable=true)
	public String getLeadSource() {
		return leadSource;
	}
	/**
	 * @param leadSource the leadSource to set
	 */
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	/**
	 * @return the mailingSrt
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_STREET",unique=false,nullable=true)
	public String getMailingSrt() {
		return mailingSrt;
	}
	/**
	 * @param mailingSrt the mailingSrt to set
	 */
	public void setMailingSrt(String mailingSrt) {
		this.mailingSrt = mailingSrt;
	}
	/**
	 * @return the mailingCity
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_CITY",unique=false,nullable=true)
	public String getMailingCity() {
		return mailingCity;
	}
	/**
	 * @param mailingCity the mailingCity to set
	 */
	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}
	/**
	 * @return the mailingState
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_STATE",unique=false,nullable=true)
	public String getMailingState() {
		return mailingState;
	}
	/**
	 * @param mailingState the mailingState to set
	 */
	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}
	/**
	 * @return the mailingPostlCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_POSTAL_CODE",unique=false,nullable=true)
	public String getMailingPostlCode() {
		return mailingPostlCode;
	}
	/**
	 * @param mailingPostlCode the mailingPostlCode to set
	 */
	public void setMailingPostlCode(String mailingPostlCode) {
		this.mailingPostlCode = mailingPostlCode;
	}
	/**
	 * @return the mailingCountry
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_COUNTRY",unique=false,nullable=true)
	public String getMailingCountry() {
		return mailingCountry;
	}
	/**
	 * @param mailingCountry the mailingCountry to set
	 */
	public void setMailingCountry(String mailingCountry) {
		this.mailingCountry = mailingCountry;
	}
	/**
	 * @return the salution
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="SALUTATION",unique=false,nullable=true)
	public String getSalution() {
		return salution;
	}
	/**
	 * @param salution the salution to set
	 */
	public void setSalution(String salution) {
		this.salution = salution;
	}
	/**
	 * @return the firstName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="FIRST_NAME",unique=false,nullable=true)
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_NAME",unique=false,nullable=true)
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the otherStrt
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_STREET",unique=false,nullable=true)
	public String getOtherStrt() {
		return otherStrt;
	}
	/**
	 * @param otherStrt the otherStrt to set
	 */
	public void setOtherStrt(String otherStrt) {
		this.otherStrt = otherStrt;
	}
	/**
	 * @return the otherCity
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_CITY",unique=false,nullable=true)
	public String getOtherCity() {
		return otherCity;
	}
	/**
	 * @param otherCity the otherCity to set
	 */
	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}
	/**
	 * @return the otherState
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_STATE",unique=false,nullable=true)
	public String getOtherState() {
		return otherState;
	}
	/**
	 * @param otherState the otherState to set
	 */
	public void setOtherState(String otherState) {
		this.otherState = otherState;
	}
	/**
	 * @return the othrPostalCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_POSTAL_CODE",unique=false,nullable=true)
	public String getOthrPostalCode() {
		return othrPostalCode;
	}
	/**
	 * @param othrPostalCode the othrPostalCode to set
	 */
	public void setOthrPostalCode(String othrPostalCode) {
		this.othrPostalCode = othrPostalCode;
	}
	/**
	 * @return the otherCountry
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_COUNTRY",unique=false,nullable=true)
	public String getOtherCountry() {
		return otherCountry;
	}
	/**
	 * @param otherCountry the otherCountry to set
	 */
	public void setOtherCountry(String otherCountry) {
		this.otherCountry = otherCountry;
	}
	/**
	 * @return the otherPhone
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_PHONE",unique=false,nullable=true)
	public String getOtherPhone() {
		return otherPhone;
	}
	/**
	 * @param otherPhone the otherPhone to set
	 */
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}
	/**
	 * @return the title
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="TITLE",unique=false,nullable=true)
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the lastCuUpdtDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_CU_UPDATE_DATE",unique=false,nullable=true)
	public String getLastCuUpdtDate() {
		return lastCuUpdtDate;
	}
	/**
	 * @param lastCuUpdtDate the lastCuUpdtDate to set
	 */
	public void setLastCuUpdtDate(String lastCuUpdtDate) {
		this.lastCuUpdtDate = lastCuUpdtDate;
	}
	/**
	 * @return the name
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="NAME",unique=false,nullable=true)
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
	 * @return the cleanStatus
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="CLEAN_STATUS",unique=false,nullable=true)
	public String getCleanStatus() {
		return cleanStatus;
	}
	/**
	 * @param cleanStatus the cleanStatus to set
	 */
	public void setCleanStatus(String cleanStatus) {
		this.cleanStatus = cleanStatus;
	}
	/**
	 * @return the otherCountryCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_COUNTRY_CODE",unique=false,nullable=true)
	public String getOtherCountryCode() {
		return otherCountryCode;
	}
	/**
	 * @param otherCountryCode the otherCountryCode to set
	 */
	public void setOtherCountryCode(String otherCountryCode) {
		this.otherCountryCode = otherCountryCode;
	}
	/**
	 * @return the otherStateCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OTHER_STATE_CODE",unique=false,nullable=true)
	public String getOtherStateCode() {
		return otherStateCode;
	}
	/**
	 * @param otherStateCode the otherStateCode to set
	 */
	public void setOtherStateCode(String otherStateCode) {
		this.otherStateCode = otherStateCode;
	}
	/**
	 * @return the mailingCountryCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_COUNTRY_CODE",unique=false,nullable=true)
	public String getMailingCountryCode() {
		return mailingCountryCode;
	}
	/**
	 * @param mailingCountryCode the mailingCountryCode to set
	 */
	public void setMailingCountryCode(String mailingCountryCode) {
		this.mailingCountryCode = mailingCountryCode;
	}
	/**
	 * @return the maillingStateCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="MAILING_STATE_CODE",unique=false,nullable=true)
	public String getMaillingStateCode() {
		return maillingStateCode;
	}
	/**
	 * @param maillingStateCode the maillingStateCode to set
	 */
	public void setMaillingStateCode(String maillingStateCode) {
		this.maillingStateCode = maillingStateCode;
	}
	
	/**
	 * @return the role
	 */
	@Column(name="ROLE",unique=false,nullable=true)
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the groupBy
	 */
	@Column(name="GROUP_BY",unique=false,nullable=true)
	public String getGroupBy() {
		return groupBy;
	}
	/**
	 * @param groupBy the groupBy to set
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
}
