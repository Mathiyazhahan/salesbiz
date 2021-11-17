package com.softtwig.crm.vo;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_line_item")
public class OpportunityLineItemDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int lineItemId;
	private Boolean isDeleted;
	private Date date;
	private Double listPrice;
	private Double totalPrice;
	private Double salesPrice;
	private String lineDescription;
	private int sortOrder;
	private Double subtotal;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	private String productName;
	private String productCode;
	private String currencyIsoCode;
	private Double dicount;
	private String division;
	private Boolean hasQuantitySchedule;
	private Boolean hasRevenueSchedule;
	private Boolean hasSchedule;
	private String receivedConnectionName;
	private String sentConnectionName;
	private Date modstamp;
	private int quantity;

	// bi-directional many-to-one association to PriceBookDO
	private PriceBookEntryDO priceBookEntryDO;

	// bi-directional many-to-one association to PriceBookDO
	private OpportunityDO opportunityDO;

	/**
	 * @return the lineItemId
	 */
	@Id
	@GeneratedValue
	@Column(name = "LINE_ITEM_ID", unique = true, nullable = false)
	public int getLineItemId() {
		return lineItemId;
	}

	/**
	 * @param lineItemId
	 *            the lineItemId to set
	 */
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	/**
	 * @return the isDeleted
	 */
	@Column(name = "IS_DELETED")
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
	 * @return the date
	 */
	@Column(name = "DATE")
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the listPrice
	 */
	@Column(name = "LIST_PRICE")
	public Double getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice
	 *            the listPrice to set
	 */
	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the totalPrice
	 */
	@Column(name = "TOTAL_PRICE")
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the salesPrice
	 */
	@Column(name = "SALES_PRICE")
	public Double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * @param salesPrice
	 *            the salesPrice to set
	 */
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * @return the lineDescription
	 */
	@Column(name = "LINE_DESCRIPTION")
	public String getLineDescription() {
		return lineDescription;
	}

	/**
	 * @param lineDescription
	 *            the lineDescription to set
	 */
	public void setLineDescription(String lineDescription) {
		this.lineDescription = lineDescription;
	}

	/**
	 * @return the sortOrder
	 */
	@Column(name = "SORT_ORDER")
	public int getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 *            the sortOrder to set
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the subtotal
	 */
	@Column(name = "SUBTOTAL")
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal
	 *            the subtotal to set
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
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
	 * @return the createdDate
	 */
	@Column(name = "CREATED_BY_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	@Column(name = "LAST_MODIFIED_BY")
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDate
	 */
	@Column(name = "LAST_MODIFIED_DATE")
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the productName
	 */
	@Column(name = "PRODUCT_NAME")
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCode
	 */
	@Column(name = "PRODUCT_CODE")
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	 * @return the dicount
	 */
	@Column(name = "DISCOUNT")
	public Double getDicount() {
		return dicount;
	}

	/**
	 * @param dicount
	 *            the dicount to set
	 */
	public void setDicount(Double dicount) {
		this.dicount = dicount;
	}

	/**
	 * @return the division
	 */
	@Column(name = "DIVISION")
	public String getDivision() {
		return division;
	}

	/**
	 * @param division
	 *            the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * @return the hasQuantitySchedule
	 */
	@Column(name = "HAS_QUANTITY_SCHEDULE")
	public Boolean getHasQuantitySchedule() {
		return hasQuantitySchedule;
	}

	/**
	 * @param hasQuantitySchedule
	 *            the hasQuantitySchedule to set
	 */
	public void setHasQuantitySchedule(Boolean hasQuantitySchedule) {
		this.hasQuantitySchedule = hasQuantitySchedule;
	}

	/**
	 * @return the hasRevenueSchedule
	 */
	@Column(name = "HAS_REVENUE_SCHEDULE")
	public Boolean getHasRevenueSchedule() {
		return hasRevenueSchedule;
	}

	/**
	 * @param hasRevenueSchedule
	 *            the hasRevenueSchedule to set
	 */
	public void setHasRevenueSchedule(Boolean hasRevenueSchedule) {
		this.hasRevenueSchedule = hasRevenueSchedule;
	}

	/**
	 * @return the hasSchedule
	 */
	@Column(name = "HAS_SCHEDULE")
	public Boolean getHasSchedule() {
		return hasSchedule;
	}

	/**
	 * @param hasSchedule
	 *            the hasSchedule to set
	 */
	public void setHasSchedule(Boolean hasSchedule) {
		this.hasSchedule = hasSchedule;
	}

	/**
	 * @return the receivedConnectionName
	 */
	@Column(name = "RECEIVED_CONNECTION_NAME")
	public String getReceivedConnectionName() {
		return receivedConnectionName;
	}

	/**
	 * @param receivedConnectionName
	 *            the receivedConnectionName to set
	 */
	public void setReceivedConnectionName(String receivedConnectionName) {
		this.receivedConnectionName = receivedConnectionName;
	}

	/**
	 * @return the sentConnectionName
	 */
	@Column(name = "SENT_CONNECTION_NAME")
	public String getSentConnectionName() {
		return sentConnectionName;
	}

	/**
	 * @param sentConnectionName
	 *            the sentConnectionName to set
	 */
	public void setSentConnectionName(String sentConnectionName) {
		this.sentConnectionName = sentConnectionName;
	}

	/**
	 * @return the modstamp
	 */
	@Column(name = "MODSTAMP")
	public Date getModstamp() {
		return modstamp;
	}

	/**
	 * @param modstamp
	 *            the modstamp to set
	 */
	public void setModstamp(Date modstamp) {
		this.modstamp = modstamp;
	}

	/**
	 * @return the priceBookEntryDO
	 */
	@ManyToOne
	@JoinColumn(name = "PRICE_BOOK_ENTRY", nullable = false)
	public PriceBookEntryDO getPriceBookEntryDO() {
		return priceBookEntryDO;
	}

	/**
	 * @param priceBookEntryDO
	 *            the priceBookEntryDO to set
	 */
	public void setPriceBookEntryDO(PriceBookEntryDO priceBookEntryDO) {
		this.priceBookEntryDO = priceBookEntryDO;
	}

	/**
	 * @return the opportunityDO
	 */
	@ManyToOne
	@JoinColumn(name = "OPPORTUNITY_ID", nullable = false)
	public OpportunityDO getOpportunityDO() {
		return opportunityDO;
	}

	/**
	 * @param opportunityDO
	 *            the opportunityDO to set
	 */
	public void setOpportunityDO(OpportunityDO opportunityDO) {
		this.opportunityDO = opportunityDO;
	}

	/**
	 * @return the quantity
	 */
	@Column(name ="PRODUCT_QUANTITY")
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
