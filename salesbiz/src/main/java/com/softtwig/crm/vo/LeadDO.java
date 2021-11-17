package com.softtwig.crm.vo;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "LEADS")
public class LeadDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8747184592385472218L;
	private int leadId;
	private String name;
	private String firstName;
	private String lastName;
	private String emailId;
	private long phoneNo;
	// private int leadOwner;
	private String leadStatus;
	private String street;
	private String city;
	private String state;
	private String country;
	private int noofemployees;
	private String leadSource;
	private double annualRevenue;
	private String industry;
	private int postalCode;
	private String company;
	private Boolean isConverted;
	private int convertedAccountId;
	private int convertedContactId;
	private int convertedOpportunityId;
	private String convertedDate;
	private String createdDate;
	private String jigSaw;
	private Boolean isDeleted;
	private String description;
	private String emailBouncedDate;
	private String emailBouncedReason;
	private Boolean hasOptedOutofEmail;
	private String jigsawContactId;
	private Date lastActivityDate;
	private String cleanStatus;
	private String companyDunsNumber;
	private int masterRecordId;
	private int currencyISOCode;
	private int division;
	private int mobile;
	private int salutation;
	private String rating;
	private int connectionReceivedId;
	private int connectionSentId;
	private String countryCode;
	private String stateCode;
	private String title;
	private Boolean isUnreadByOwner;
	private String website;
	private String recordTypeId;
	private String partnerAccountId;
	private String createdBy;
	//private UserDO userDO;
	private String productName;
	private Date timeLine;
	private String branch;
	private String ownerName;
	private int leadOwner;
	private String role;
	private String team;
	
	

	/**
	 * @return the productName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "PRODUCT_NAME", unique = false, nullable = true)
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the timeLine
	 */
	@Field(index=Index.YES,analyze=Analyze.NO,store=Store.YES)
	@DateBridge(resolution=Resolution.DAY)
	@Column(name = "TIME_LINE",unique = false, nullable = true)
	public Date getTimeLine() {
		return timeLine;
	}

	/**
	 * @param timeLine the timeLine to set
	 */
	public void setTimeLine(Date timeLine) {
		this.timeLine = timeLine;
	}

	// bi-directional one-to-many association to PriceBookEntryDO
	private List<TaskDO> taskDO;
	
	/**
	 * @return the leadId
	 */
	@Id
	@GeneratedValue
	@Column(name = "LEAD_ID", unique = true, nullable = false)
	public int getLeadId() {
		return leadId;
	}

	/**
	 * @param leadId
	 *            the leadId to set
	 */
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "NAME", unique = false, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @return the firstName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "FIRST_NAME", unique = false, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LAST_NAME", unique = false, nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(impl=WhitespaceAnalyzer.class)
	@Column(name = "EMAIL", unique = true, nullable = false)
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the phoneNo
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "PHONE", unique = false, nullable = false)
	public long getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo
	 *            the phoneNo to set
	 */
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the leadOwner
	 */
	/*
	 * @Column(name="LEAD_OWNER", unique = false, nullable = false) public int
	 * getLeadOwner() { return leadOwner; }
	 *//**
	 * @param leadOwner
	 *            the leadOwner to set
	 */
	/*
	 * public void setLeadOwner(int leadOwner) { this.leadOwner = leadOwner; }
	 */
	/**
	 * @return the leadStatus
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LEAD_STATUS", unique = false, nullable = false)
	public String getLeadStatus() {
		return leadStatus;
	}

	/**
	 * @param leadStatus
	 *            the leadStatus to set
	 */
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}

	/**
	 * @return the street
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "STREET", unique = false, nullable = true)
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CITY", unique = false, nullable = true)
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "STATE", unique = false, nullable = true)
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "COUNTRY", unique = false, nullable = true)
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the noofemployees
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "NO_OF_EMPLOYEES", unique = false, nullable = true)
	public int getNoofemployees() {
		return noofemployees;
	}

	/**
	 * @param noofemployees
	 *            the noofemployees to set
	 */
	public void setNoofemployees(int noofemployees) {
		this.noofemployees = noofemployees;
	}

	/**
	 * @return the leadSource
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LEAD_SOURCE", unique = false, nullable = true)
	public String getLeadSource() {
		return leadSource;
	}

	/**
	 * @param leadSource
	 *            the leadSource to set
	 */
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}

	/**
	 * @return the annualRevenue
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "ANNUAL_REVENUE", unique = false, nullable = true)
	public double getAnnualRevenue() {
		return annualRevenue;
	}

	/**
	 * @param annualRevenue
	 *            the annualRevenue to set
	 */
	public void setAnnualRevenue(double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	/**
	 * @return the industry
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "INDUSTRY", unique = false, nullable = true)
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry
	 *            the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return the postalCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "POSTAL_CODE", unique = false, nullable = true)
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the company
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Column(name = "COMPANY", unique = false, nullable = true)
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the convertedAccountId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CONVERTED_ACCOUNT_ID", unique = false, nullable = true)
	public int getConvertedAccountId() {
		return convertedAccountId;
	}

	/**
	 * @return the isConverted
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_CONVERTED", unique = false, nullable = true)
	public Boolean getIsConverted() {
		return isConverted;
	}

	/**
	 * @param isConverted the isConverted to set
	 */
	public void setIsConverted(Boolean isConverted) {
		this.isConverted = isConverted;
	}

	/**
	 * @param convertedAccountId
	 *            the convertedAccountId to set
	 */
	public void setConvertedAccountId(int convertedAccountId) {
		this.convertedAccountId = convertedAccountId;
	}

	/**
	 * @return the convertedContactId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CONVERTED_CONTACT_ID", unique = false, nullable = true)
	public int getConvertedContactId() {
		return convertedContactId;
	}

	/**
	 * @param convertedContactId
	 *            the convertedContactId to set
	 */
	public void setConvertedContactId(int convertedContactId) {
		this.convertedContactId = convertedContactId;
	}

	/**
	 * @return the convertedOpportunityId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CONVERTED_OPPORTUNITY_ID", unique = false, nullable = true)
	public int getConvertedOpportunityId() {
		return convertedOpportunityId;
	}

	/**
	 * @param convertedOpportunityId
	 *            the convertedOpportunityId to set
	 */
	public void setConvertedOpportunityId(int convertedOpportunityId) {
		this.convertedOpportunityId = convertedOpportunityId;
	}

	/**
	 * @return the convertedDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(impl=WhitespaceAnalyzer.class)
	@Column(name = "CONVERTED_DATE", unique = false, nullable = true)
	public String getConvertedDate() {
		return convertedDate;
	}

	/**
	 * @param convertedDate
	 *            the convertedDate to set
	 */
	public void setConvertedDate(String convertedDate) {
		this.convertedDate = convertedDate;
	}

	/**
	 * @return the createdById
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Analyzer(impl=WhitespaceAnalyzer.class)
	@Column(name = "CREATED_DATE", unique = false, nullable = true)
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdById
	 *            the createdById to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the jigSaw
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "JIGSAW", unique = false, nullable = true)
	public String getJigSaw() {
		return jigSaw;
	}

	/**
	 * @param jigSaw
	 *            the jigSaw to set
	 */
	public void setJigSaw(String jigSaw) {
		this.jigSaw = jigSaw;
	}

	/**
	 * @return the isDeleted
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_DELETED", unique = false, nullable = true)
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the description
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DESCRIPTION", unique = false, nullable = true)
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the emailBouncedDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "EMAIL_BOUNCED_DATE", unique = false, nullable = true)
	public String getEmailBouncedDate() {
		return emailBouncedDate;
	}

	/**
	 * @param emailBouncedDate
	 *            the emailBouncedDate to set
	 */
	public void setEmailBouncedDate(String emailBouncedDate) {
		this.emailBouncedDate = emailBouncedDate;
	}

	/**
	 * @return the emailBouncedReason
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "EMAIL_BOUNCED_REASON", unique = false, nullable = true)
	public String getEmailBouncedReason() {
		return emailBouncedReason;
	}

	/**
	 * @param emailBouncedReason
	 *            the emailBouncedReason to set
	 */
	public void setEmailBouncedReason(String emailBouncedReason) {
		this.emailBouncedReason = emailBouncedReason;
	}

	/**
	 * @return the hasOptedOutofEmail
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "HAS_OPTED_OUT_OF_EMAIL", unique = false, nullable = true)
	public Boolean getHasOptedOutofEmail() {
		return hasOptedOutofEmail;
	}

	/**
	 * @param hasOptedOutofEmail
	 *            the hasOptedOutofEmail to set
	 */
	public void setHasOptedOutofEmail(Boolean hasOptedOutofEmail) {
		this.hasOptedOutofEmail = hasOptedOutofEmail;
	}

	/**
	 * @return the jigsawContactId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "JIGSAW_CONTACT_ID", unique = false, nullable = true)
	public String getJigsawContactId() {
		return jigsawContactId;
	}

	/**
	 * @param jigsawContactId
	 *            the jigsawContactId to set
	 */
	public void setJigsawContactId(String jigsawContactId) {
		this.jigsawContactId = jigsawContactId;
	}

	/**
	 * @return the lastActivityDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@DateBridge(resolution=Resolution.DAY)
	@Column(name = "LAST_ACTIVITY_DATE", unique = false, nullable = true)
	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	/**
	 * @param lastActivityDate
	 *            the lastActivityDate to set
	 */
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	/**
	 * @param cleanStatus
	 *            the cleanStatus to set
	 */
	public void setCleanStatus(String cleanStatus) {
		this.cleanStatus = cleanStatus;
	}

	/**
	 * @return the cleanStatus
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CLEAN_STATUS", unique = false, nullable = true)
	public String getCleanStatus() {
		return cleanStatus;
	}

	/**
	 * @param companyDunsNumber
	 *            the companyDunsNumber to set
	 */
	public void setCompanyDunsNumber(String companyDunsNumber) {
		this.companyDunsNumber = companyDunsNumber;
	}

	/**
	 * @return the companyDunsNumber
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "COMPANY_DUNS_NUMBER", unique = false, nullable = true)
	public String getCompanyDunsNumber() {
		return companyDunsNumber;
	}

	/**
	 * @return the masterRecordId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "MASTER_RECORD_ID", unique = false, nullable = true)
	public int getMasterRecordId() {
		return masterRecordId;
	}

	/**
	 * @param masterRecordId
	 *            the masterRecordId to set
	 */
	public void setMasterRecordId(int masterRecordId) {
		this.masterRecordId = masterRecordId;
	}

	/**
	 * @return the currencyISOCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CURRENCY_ISO_CODE", unique = false, nullable = true)
	public int getCurrencyISOCode() {
		return currencyISOCode;
	}

	/**
	 * @param currencyISOCode
	 *            the currencyISOCode to set
	 */
	public void setCurrencyISOCode(int currencyISOCode) {
		this.currencyISOCode = currencyISOCode;
	}

	/**
	 * @return the division
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DIVISION", unique = false, nullable = true)
	public int getDivision() {
		return division;
	}

	/**
	 * @param division
	 *            the division to set
	 */
	public void setDivision(int division) {
		this.division = division;
	}

	/**
	 * @return the mobile
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "MOBILE", unique = false, nullable = true)
	public int getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the salutation
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "SALUTATION", unique = false, nullable = true)
	public int getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to set
	 */
	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the rating
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RATING", unique = false, nullable = true)
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the connectionReceivedId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CONNECTION_RECEIVED_ID", unique = false, nullable = true)
	public int getConnectionReceivedId() {
		return connectionReceivedId;
	}

	/**
	 * @param connectionReceivedId
	 *            the connectionReceivedId to set
	 */
	public void setConnectionReceivedId(int connectionReceivedId) {
		this.connectionReceivedId = connectionReceivedId;
	}

	/**
	 * @return the connectionSentId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CONNECTION_SENT_ID", unique = false, nullable = true)
	public int getConnectionSentId() {
		return connectionSentId;
	}

	/**
	 * @param connectionSentId
	 *            the connectionSentId to set
	 */
	public void setConnectionSentId(int connectionSentId) {
		this.connectionSentId = connectionSentId;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "COUNTRY_CODE", unique = false, nullable = true)
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param stateCode
	 *            the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the stateCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "STATE_CODE", unique = false, nullable = true)
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @return the title
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "TITLE", unique = false, nullable = true)
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the isUnreadByOwner
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_UNREAD_BY_OWNER", unique = false, nullable = true)
	public Boolean getIsUnreadByOwner() {
		return isUnreadByOwner;
	}

	/**
	 * @param isUnreadByOwner
	 *            the isUnreadByOwner to set
	 */
	public void setIsUnreadByOwner(Boolean isUnreadByOwner) {
		this.isUnreadByOwner = isUnreadByOwner;
	}

	/**
	 * @return the website
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "WEBSITE", unique = false, nullable = true)
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @param recordTypeId
	 *            the recordTypeId to set
	 */
	public void setRecordTypeId(String recordTypeId) {
		this.recordTypeId = recordTypeId;
	}
	/**
	 * @return the createdBy
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CREATED_BY", unique = false, nullable = true)
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the recordTypeId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECORD_TYPE_ID", unique = false, nullable = true)
	public String getRecordTypeId() {
		return recordTypeId;
	}

	/**
	 * @param partnerAccountId
	 *            the partnerAccountId to set
	 */
	public void setPartnerAccountId(String partnerAccountId) {
		this.partnerAccountId = partnerAccountId;
	}

	/**
	 * @return the partnerAccountId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "PARTNER_ACCOUNT_ID", unique = false, nullable = true)
	public String getPartnerAccountId() {
		return partnerAccountId;
	}

	/**
	 * @return the userDO
	 *//*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LEAD_OWNER")
	public final UserDO getUserDO() {
		return userDO;
	}

	*//**
	 * @param userDO
	 *            the userDO to set
	 *//*
	public final void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}
*/
	/**
	 * @return the taskDO
	 */
	@OneToMany(mappedBy = "leadDO")
	public List<TaskDO> getTaskDO() {
		return taskDO;
	}

	/**
	 * @param taskDO the taskDO to set
	 */
	public void setTaskDO(List<TaskDO> taskDO) {
		this.taskDO = taskDO;
	}

	@Column(name = "OWNERNAME", unique = false, nullable = true)
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
	
	@Column(name = "BRANCH", unique = false, nullable = true)
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the ownerId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LEAD_OWNER", unique = false, nullable = true)
	public int getLeadOwner() {
		return leadOwner;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setLeadOwner(int leadOwner) {
		this.leadOwner = leadOwner;
	}

	/**
	 * @return the role
	 */
	@Column(name = "ROLE", unique = false, nullable = true)
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
	 * @return the team
	 */
	@Column(name = "TEAM", unique = false, nullable = true)
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
}
