package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the price_book_entry database table.
 * 
 */
@Entity
@Table(name = "price_book_entry")
public class PriceBookEntryDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int priceBookEntryId;
	private int createdById;
	private Date createdDate;
	private String currencyIsoCode;
	private Boolean isActive;
	private Boolean isDeleted;
	private int lastModifiedById;
	private Date lastModifiedDate;
	private String name;
	private String productCode;
	private Date systemModstamp;
	private Double unitPrice;
	private Boolean useStandardPrice;
	
	// bi-directional many-to-one association to PriceBookDO
	private PriceBookDO priceBook;

	// bi-directional many-to-one association to ProductDO
	private ProductDO ProductDO;

	// bi-directional one-to-many association to PriceBookEntryDO
	private List<OpportunityLineItemDO> opportunityLineItemDO;

	public PriceBookEntryDO() {
	}

	@Id
	@GeneratedValue
	@Column(name = "PRICE_BOOK_ENTRY_ID", unique = true, nullable = false)
	public int getPriceBookEntryId() {
		return this.priceBookEntryId;
	}

	public void setPriceBookEntryId(int priceBookEntryId) {
		this.priceBookEntryId = priceBookEntryId;
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

	@Column(name = "CURRENCY_ISO_CODE")
	public String getCurrencyIsoCode() {
		return this.currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
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

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PRODUCT_CODE")
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SYSTEM_MODSTAMP")
	public Date getSystemModstamp() {
		return this.systemModstamp;
	}

	public void setSystemModstamp(Date systemModstamp) {
		this.systemModstamp = systemModstamp;
	}

	@Column(name = "UNIT_PRICE")
	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "USE_STANDARD_PRICE")
	public Boolean getUseStandardPrice() {
		return this.useStandardPrice;
	}

	public void setUseStandardPrice(Boolean useStandardPrice) {
		this.useStandardPrice = useStandardPrice;
	}

	@ManyToOne
	@JoinColumn(name = "PRICE_BOOK_ID", nullable = false)
	public PriceBookDO getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(PriceBookDO priceBook) {
		this.priceBook = priceBook;
	}

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	public ProductDO getProductDO() {
		return this.ProductDO;
	}

	public void setProductDO(ProductDO ProductDO) {
		this.ProductDO = ProductDO;
	}

	/**
	 * @return the opportunityLineItemDO
	 */
	@OneToMany(mappedBy = "priceBookEntryDO")
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

}
