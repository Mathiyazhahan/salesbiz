package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;



@Entity
@Indexed
@Table(name = "opportunity")
public class OpportunityDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;
	private int campaignId;
	private String closeDate;
	private int connectionReceivedId;
	private int connectionSentId;
	private String currencyIsoCode;
	private String description;
	private float expectedRevenue;
	private int fisCal;
	private int fiscalYear;
	private int fiscalQuarter;
	private String forecastCategory;
	private String forecastCategoryName;
	private int hasOpportunityLineItem;
	private Boolean isClosed;
	private Boolean isDeleted;
	private Boolean isWon;
	private String lastActivityDate;
	private String leadSource;
	private String name;
	private String nextStep;
	private int opportunityId;
	private int probability;
	private int recordTypeId;
	private String stageName;
	private int syncedQuoteID;
	private int totalOpportunityQuantity;
	private String type;
	private String createdDate;
	private String createdBy;
	private String lastModifiedBy;
	private String lastModifiedDate;	
	private String deletedDate;
	private int ownerId;
	private double amount;
	private String role;
	private String groupBy;

	/**
	 * @return the deletedDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DELETED_DATETIME", unique = false)
	public String getDeletedDate() {
		return deletedDate;
	}

	/**
	 * @param deletedDate the deletedDate to set
	 */
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}

	// bi-directional one-to-many association to PriceBookEntryDO
	private List<OpportunityLineItemDO> opportunityLineItemDO;
	// bi-directional many-to-one association to PriceBookDO
	private PriceBookDO priceBook;
	// bi-directional one-to-many association to PriceBookEntryDO
	private List<TaskDO> taskDO;

	/**
	 * @return the opportunityId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OPPORTUNITY_ID", unique = true, nullable = false)
	public int getOpportunityId() {
		return opportunityId;
	}

	/**
	 * @param opportunityId
	 *            the opportunityId to set
	 */
	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}
	/**
	 * @return the accountId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "ACCOUNT_ID", nullable = false)
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the campaignId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CAMPAIGN_ID")
	public int getCampaignId() {
		return campaignId;
	}

	/**
	 * @param campaignId
	 *            the campaignId to set
	 */
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * @return the closeDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CLOSE_DATE")
	public String getCloseDate() {
		return closeDate;
	}

	/**
	 * @param closeDate
	 *            the closeDate to set
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @return the connectionReceivedId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CONNECTION_RECIEVED_ID")
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
	@Column(name = "CONNECTION_SENT_ID")
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
	 * @return the currencyIsoCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CURRENCY_ISO_CODE")
	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	/**
	 * @param currencyIsoCode
	 *            the currencyIsoCode to set
	 */
	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	/**
	 * @return the description
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DESCRIPTION")
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
	 * @return the expectedRevenue
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "EXPECTED_REVENUE")
	public float getExpectedRevenue() {
		return expectedRevenue;
	}

	/**
	 * @param expectedRevenue
	 *            the expectedRevenue to set
	 */
	public void setExpectedRevenue(float expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}

	/**
	 * @return the fisCal
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "FISCAL")
	public int getFisCal() {
		return fisCal;
	}

	/**
	 * @param fisCal
	 *            the fisCal to set
	 */
	public void setFisCal(int fisCal) {
		this.fisCal = fisCal;
	}

	/**
	 * @return the fiscalYear
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "FISCAL_YEAR")
	public int getFiscalYear() {
		return fiscalYear;
	}

	/**
	 * @param fiscalYear
	 *            the fiscalYear to set
	 */
	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	/**
	 * @return the fiscalQuarter
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "FISCAL_QUARTER")
	public int getFiscalQuarter() {
		return fiscalQuarter;
	}

	/**
	 * @param fiscalQuarter
	 *            the fiscalQuarter to set
	 */
	public void setFiscalQuarter(int fiscalQuarter) {
		this.fiscalQuarter = fiscalQuarter;
	}

	/**
	 * @return the forecastCategory
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "FORECAST_CATEGOTY")
	public String getForecastCategory() {
		return forecastCategory;
	}

	/**
	 * @param forecastCategory
	 *            the forecastCategory to set
	 */
	public void setForecastCategory(String forecastCategory) {
		this.forecastCategory = forecastCategory;
	}

	/**
	 * @return the forecastCategoryName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "FORECAST_CATEGOTY_NAME")
	public String getForecastCategoryName() {
		return forecastCategoryName;
	}

	/**
	 * @param forecastCategoryName
	 *            the forecastCategoryName to set
	 */
	public void setForecastCategoryName(String forecastCategoryName) {
		this.forecastCategoryName = forecastCategoryName;
	}

	/**
	 * @return the hasOpportunityLineItem
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "HAS_OPPORTUNITY_LINE_ITEM")
	public int getHasOpportunityLineItem() {
		return hasOpportunityLineItem;
	}

	/**
	 * @param hasOpportunityLineItem
	 *            the hasOpportunityLineItem to set
	 */
	public void setHasOpportunityLineItem(int hasOpportunityLineItem) {
		this.hasOpportunityLineItem = hasOpportunityLineItem;
	}

	/**
	 * @return the isClosed
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_CLOSED")
	public Boolean getIsClosed() {
		return isClosed;
	}

	/**
	 * @param isClosed
	 *            the isClosed to set
	 */
	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}


	
	/**
	 * @return the isDeleted
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_DELETED", unique = false, nullable = false)
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
	 * @return the isWon
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_WON")
	public Boolean getIsWon() {
		return isWon;
	}

	/**
	 * @param isWon  the isWon to set
	 */
	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

	/**
	 * @return the lastActivityDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LAST_ACTIVITY_DATE")
	public String getLastActivityDate() {
		return lastActivityDate;
	}

	/**
	 * @param lastActivityDate
	 *            the lastActivityDate to set
	 */
	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	/**
	 * @return the leadSource
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LEAD_SOURCE")
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
	 * @return the name
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "OPPORTUNITY_NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nextStep
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "NEXT_STEP")
	public String getNextStep() {
		return nextStep;
	}

	/**
	 * @param nextStep
	 *            the nextStep to set
	 */
	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	/**
	 * @return the probability
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "PROBABILITY")
	public int getProbability() {
		return probability;
	}

	/**
	 * @param probability
	 *            the probability to set
	 */
	public void setProbability(int probability) {
		this.probability = probability;
	}

	/**
	 * @return the recordTypeId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECORDTYPE_ID")
	public int getRecordTypeId() {
		return recordTypeId;
	}

	/**
	 * @param recordTypeId
	 *            the recordTypeId to set
	 */
	public void setRecordTypeId(int recordTypeId) {
		this.recordTypeId = recordTypeId;
	}

	/**
	 * @return the stageName
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "STAGE_NAME", nullable = false)
	public String getStageName() {
		return stageName;
	}

	/**
	 * @param stageName
	 *            the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	/**
	 * @return the syncedQuoteID
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "SYNCED_QUOTE_ID")
	public int getSyncedQuoteID() {
		return syncedQuoteID;
	}

	/**
	 * @param syncedQuoteID
	 *            the syncedQuoteID to set
	 */
	public void setSyncedQuoteID(int syncedQuoteID) {
		this.syncedQuoteID = syncedQuoteID;
	}

	/**
	 * @return the totalOpportunityQuantity
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "TOTAL_OPPORTUNITY_QUANTITY")
	public int getTotalOpportunityQuantity() {
		return totalOpportunityQuantity;
	}

	/**
	 * @param totalOpportunityQuantity
	 *            the totalOpportunityQuantity to set
	 */
	public void setTotalOpportunityQuantity(int totalOpportunityQuantity) {
		this.totalOpportunityQuantity = totalOpportunityQuantity;
	}

	/**
	 * @return the type
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the createdDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CREATED_DATE")
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
	 * @return the createdBy
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CREATED_BY")
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
	 * @return the lastModifiedBy
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_MODIFIED_BY")
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="LAST_MODIFIED_DATE")
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}	

	/**
	 * @return the opportunityLineItemDO
	 */
	@OneToMany(mappedBy = "opportunityDO")
	public List<OpportunityLineItemDO> getOpportunityLineItemDO() {
		return opportunityLineItemDO;
	}

	/**
	 * @param opportunityLineItemDO
	 *            the opportunityLineItemDO to set
	 */
	public void setOpportunityLineItemDO(
			List<OpportunityLineItemDO> opportunityLineItemDO) {
		this.opportunityLineItemDO = opportunityLineItemDO;
	}

	@ManyToOne
	@JoinColumn(name = "PRICE_BOOK_ID")
	public PriceBookDO getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(PriceBookDO priceBook) {
		this.priceBook = priceBook;
	}

	/**
	 * @return the taskDO
	 */
	@OneToMany(mappedBy="opportunityDO")
	public List<TaskDO> getTaskDO() {
		return taskDO;
	}

	/**
	 * @param taskDO the taskDO to set
	 */
	public void setTaskDO(List<TaskDO> taskDO) {
		this.taskDO = taskDO;
	}

	/**
	 * @return the ownerId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="OWNER_ID")
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
	 * @return the amount
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name="AMOUNT")
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
