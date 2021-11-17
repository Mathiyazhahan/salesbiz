package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "price_book")

public class PriceBookDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int priceBookId;
	private int createdById;
	private Date createdDate;
	private String description;
	private Boolean isActive;
	private Boolean isDeleted;
	private Boolean isStandard;
	private int lastModifiedById;
	private Date lastModifiedDate;
	private String priceBookName;
	private Date systemModstamp;

	// bi-directional one-to-many association to PriceBookEntryDO
	private List<PriceBookEntryDO> priceBookEntries;

	// bi-directional one-to-many association to PriceBookEntryDO
	private List<OpportunityDO> opportunityDO;

	public PriceBookDO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRICE_BOOK_ID", unique = true, nullable = false)
	public int getPriceBookId() {
		return this.priceBookId;
	}

	public void setPriceBookId(int priceBookId) {
		this.priceBookId = priceBookId;
	}

	@Column(name = "CREATED_BY_ID")
	public int getCreatedById() {
		return this.createdById;
	}

	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "DESCRIPTION", length = 255)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IS_ACTIVE")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "IS_DELETED")
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "IS_STANDARD")
	public Boolean getIsStandard() {
		return this.isStandard;
	}

	public void setIsStandard(Boolean isStandard) {
		this.isStandard = isStandard;
	}

	@Column(name = "LAST_MODIFIED_BY_ID")
	public int getLastModifiedById() {
		return this.lastModifiedById;
	}

	public void setLastModifiedById(int lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE")
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "PRICE_BOOK_NAME", length = 40)
	public String getPriceBookName() {
		return this.priceBookName;
	}

	public void setPriceBookName(String priceBookName) {
		this.priceBookName = priceBookName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SYSTEM_MODSTAMP")
	public Date getSystemModstamp() {
		return this.systemModstamp;
	}

	public void setSystemModstamp(Date systemModstamp) {
		this.systemModstamp = systemModstamp;
	}

	@OneToMany(mappedBy = "priceBook")
	public List<PriceBookEntryDO> getPriceBookEntries() {
		return this.priceBookEntries;
	}

	public void setPriceBookEntries(List<PriceBookEntryDO> priceBookEntries) {
		this.priceBookEntries = priceBookEntries;
	}
	/**
	 * @return the opportunityDO
	 */
	@OneToMany(mappedBy = "priceBook")
	public List<OpportunityDO> getOpportunityDO() {
		return opportunityDO;
	}

	/**
	 * @param opportunityDO the opportunityDO to set
	 */
	public void setOpportunityDO(List<OpportunityDO> opportunityDO) {
		this.opportunityDO = opportunityDO;
	}
	

	public PriceBookEntryDO addPriceBookEntryDO(
			PriceBookEntryDO PriceBookEntryDO) {
		getPriceBookEntries().add(PriceBookEntryDO);
		PriceBookEntryDO.setPriceBook(this);

		return PriceBookEntryDO;
	}

	public PriceBookEntryDO removePriceBookEntryDO(
			PriceBookEntryDO PriceBookEntryDO) {
		getPriceBookEntries().remove(PriceBookEntryDO);
		PriceBookEntryDO.setPriceBook(null);

		return PriceBookEntryDO;
	}
	
	public OpportunityDO addOpportunityDO(
			OpportunityDO OpportunityDO) {
		getOpportunityDO().add(OpportunityDO);
		OpportunityDO.setPriceBook(this);

		return OpportunityDO;
	}

	public OpportunityDO removeOpportunityDO(
			OpportunityDO OpportunityDO) {
		getOpportunityDO().remove(OpportunityDO);
		OpportunityDO.setPriceBook(null);

		return OpportunityDO;
	}
}