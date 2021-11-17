package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "opportunity_history")
public class OpportunityHistoryDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;
	private double amount;
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
	private int opportunityHistoryId;
	// private int opportunityHistoryId;
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
	private int opportunityId;

	/**
	 * @return the deletedDate
	 */
	@Column(name = "DELETED_DATETIME", unique = false)
	public String getDeletedDate() {
		return deletedDate;
	}

	/**
	 * @param deletedDate
	 *            the deletedDate to set
	 */
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}
	/**
	 * @return the opportunityId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OPPORTUNITY_HISTORY_ID", unique = true, nullable = false)
	public int getOpportunityHistoryId() {
		return opportunityHistoryId;
	}

	/**
	 * @param opportunityId
	 *            the opportunityId to set
	 */
	public void setOpportunityHistoryId(int opportunityHistoryId) {
		this.opportunityHistoryId = opportunityHistoryId;
	}

	/**
	 * @return the accountId
	 */
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
	 * @return the amount
	 */
	@Column(name = "AMOUNT")
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the campaignId
	 */
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
	@Column(name = "IS_DELETED", unique = false, nullable = false)
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
	 * @return the isWon
	 */
	@Column(name = "IS_WON")
	public Boolean getIsWon() {
		return isWon;
	}

	/**
	 * @param isWon
	 *            the isWon to set
	 */
	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

	/**
	 * @return the lastActivityDate
	 */
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
	@Column(name = "CREATED_DATE")
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastModifiedBy
	 */
	@Column(name = "LAST_MODIFIED_BY")
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	@Column(name = "LAST_MODIFIED_DATE")
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate
	 *            the lastModifiedDate to set
	 */
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/**
	 * @return the ownerId
	 */
	@Column(name = "OWNER_ID")
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId
	 *            the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the opportunityId
	 */
	@Column(name = "OPPORTUNITY_ID")
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
}
