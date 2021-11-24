package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name="campaigns")
public class CampaignsDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -218430471859463936L;
	
	private int campaignId;
	private String campaignOwner;
	private String campaignName;
	private long mobileNo;
	private String type;
	private String status;
	private Date startDate;
	private Date endDate;
	private double expectedRevenue;
	private double actualCost;
	private double budgetedCost;
	private double expectedResponse;
	private int numberSent;
	private String Description;
	private Boolean isDeleted;
	
	@Id
	@GeneratedValue
	@Column(name = "CAMPAIGN_ID")
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CAMPAIGN_OWNER")
	public String getCampaignOwner() {
		return campaignOwner;
	}

	public void setCampaignOwner(String campaignOwner) {
		this.campaignOwner = campaignOwner;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CAMPAIGN_NAME")
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "MOBILE_NO")
	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CAMPAIGN_TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getExpectedRevenue() {
		return expectedRevenue;
	}

	public void setExpectedRevenue(double expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}
	
	public double getActualCost() {
		return actualCost;
	}

	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "BUDGETED_COST")
	public double getBudgetedCost() {
		return budgetedCost;
	}

	public void setBudgetedCost(double budgetedCost) {
		this.budgetedCost = budgetedCost;
	}
	
	public double getExpectedResponse() {
		return expectedResponse;
	}

	public void setExpectedResponse(double expectedResponse) {
		this.expectedResponse = expectedResponse;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "NUMBER_SENT")
	public int getNumberSent() {
		return numberSent;
	}

	public void setNumberSent(int numberSent) {
		this.numberSent = numberSent;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_DELETED", unique = false, nullable = true)
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
