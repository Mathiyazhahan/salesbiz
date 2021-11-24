package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

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
	
	@Id
	@GeneratedValue
	@Column(name = "CAMPAIGN_ID")
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	@Column(name = "CAMPAIGN_OWNER")
	public String getCampaignOwner() {
		return campaignOwner;
	}

	public void setCampaignOwner(String campaignOwner) {
		this.campaignOwner = campaignOwner;
	}
	@Column(name = "CAMPAIGN_NAME")
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	@Column(name = "MOBILE_NO")
	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Column(name = "CAMPAIGN_TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
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
	@Column(name = "NUMBER_SENT")
	public int getNumberSent() {
		return numberSent;
	}

	public void setNumberSent(int numberSent) {
		this.numberSent = numberSent;
	}
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
    
}
