package com.softtwig.crm.vo;

import java.io.Serializable;

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
	
	@Id
	@GeneratedValue
	@Column(name = "CAMPAIGN_ID")
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

}
