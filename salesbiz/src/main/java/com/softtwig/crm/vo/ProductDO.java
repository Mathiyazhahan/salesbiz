package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productId;
	private byte canUseQuantitySchedule;
	private byte canUseRevenueSchedule;
	private int connectionReceivedId;
	private int connectionSendId;
	private int createdById;
	private Date createdDate;
	private String currencyIsoCode;
	private String description;
	private String family;
	private Boolean isActive;
	private Boolean isdeleted;
	private int lastModifiedById;
	private Date lastModifiedDate;
	private int numberOfQuantityInstallments;
	private int numberOfRevenueInstallments;
	private String productCode;
	private String productName;
	private String quantityInstallmentPeriad;
	private String quantityScheduleType;
	private String revenueInstallmentPeriod;
	private String revenueScheduleType;
	private Date systemModstamp;

	// bi-directional Many-to-one association to PriceBookEntryDO
	private ProductCategoryDO  productCategoryDO;
	
	// bi-directional one-to-many association to PriceBookEntryDO
		private List<PriceBookEntryDO> priceBookEntries;

	public ProductDO() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "CAN_USE_QUANTITY_SCHEDULE")
	public byte getCanUseQuantitySchedule() {
		return this.canUseQuantitySchedule;
	}

	public void setCanUseQuantitySchedule(byte canUseQuantitySchedule) {
		this.canUseQuantitySchedule = canUseQuantitySchedule;
	}

	@Column(name = "CAN_USE_REVENUE_SCHEDULE")
	public byte getCanUseRevenueSchedule() {
		return this.canUseRevenueSchedule;
	}

	public void setCanUseRevenueSchedule(byte canUseRevenueSchedule) {
		this.canUseRevenueSchedule = canUseRevenueSchedule;
	}

	@Column(name = "CONNECTION_RECEIVED_ID")
	public int getConnectionReceivedId() {
		return this.connectionReceivedId;
	}

	public void setConnectionReceivedId(int connectionReceivedId) {
		this.connectionReceivedId = connectionReceivedId;
	}

	@Column(name = "CONNECTION_SEND_ID")
	public int getConnectionSendId() {
		return this.connectionSendId;
	}

	public void setConnectionSendId(int connectionSendId) {
		this.connectionSendId = connectionSendId;
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

	@Column(name = "CURRENCY_ISO_CODE", length = 3)
	public String getCurrencyIsoCode() {
		return this.currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "FAMILY", length = 40)
	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "IS_ACTIVE")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "ISDELETED")
	public Boolean getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
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

	@Column(name = "NUMBER_OF_QUANTITY_INSTALLMENTS")
	public int getNumberOfQuantityInstallments() {
		return this.numberOfQuantityInstallments;
	}

	public void setNumberOfQuantityInstallments(int numberOfQuantityInstallments) {
		this.numberOfQuantityInstallments = numberOfQuantityInstallments;
	}

	@Column(name = "NUMBER_OF_REVENUE_INSTALLMENTS")
	public int getNumberOfRevenueInstallments() {
		return this.numberOfRevenueInstallments;
	}

	public void setNumberOfRevenueInstallments(int numberOfRevenueInstallments) {
		this.numberOfRevenueInstallments = numberOfRevenueInstallments;
	}

	@Column(name = "PRODUCT_CODE", length = 255)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "PRODUCT_NAME", length = 255)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "QUANTITY_INSTALLMENT_PERIAD", length = 40)
	public String getQuantityInstallmentPeriad() {
		return this.quantityInstallmentPeriad;
	}

	public void setQuantityInstallmentPeriad(String quantityInstallmentPeriad) {
		this.quantityInstallmentPeriad = quantityInstallmentPeriad;
	}

	@Column(name = "QUANTITY_SCHEDULE_TYPE", length = 40)
	public String getQuantityScheduleType() {
		return this.quantityScheduleType;
	}

	public void setQuantityScheduleType(String quantityScheduleType) {
		this.quantityScheduleType = quantityScheduleType;
	}

	@Column(name = "REVENUE_INSTALLMENT_PERIOD", length = 40)
	public String getRevenueInstallmentPeriod() {
		return this.revenueInstallmentPeriod;
	}

	public void setRevenueInstallmentPeriod(String revenueInstallmentPeriod) {
		this.revenueInstallmentPeriod = revenueInstallmentPeriod;
	}

	@Column(name = "REVENUE_SCHEDULE_TYPE", length = 40)
	public String getRevenueScheduleType() {
		return this.revenueScheduleType;
	}

	public void setRevenueScheduleType(String revenueScheduleType) {
		this.revenueScheduleType = revenueScheduleType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SYSTEM_MODSTAMP")
	public Date getSystemModstamp() {
		return this.systemModstamp;
	}

	public void setSystemModstamp(Date systemModstamp) {
		this.systemModstamp = systemModstamp;
	}

	@OneToMany(mappedBy = "productDO")
	public List<PriceBookEntryDO> getPriceBookEntries() {
		return this.priceBookEntries;
	}
	/**
	 * @return the productCategoryDO
	 */
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public ProductCategoryDO getProductCategoryDO() {
		return productCategoryDO;
	}

	/**
	 * @param productCategoryDO the productCategoryDO to set
	 */
	public void setProductCategoryDO(ProductCategoryDO productCategoryDO) {
		this.productCategoryDO = productCategoryDO;
	}
	public void setPriceBookEntries(List<PriceBookEntryDO> priceBookEntries) {
		this.priceBookEntries = priceBookEntries;
	}

	public PriceBookEntryDO addPriceBookEntryDO(
			PriceBookEntryDO PriceBookEntryDO) {
		getPriceBookEntries().add(PriceBookEntryDO);
		PriceBookEntryDO.setProductDO(this);

		return PriceBookEntryDO;
	}

	public PriceBookEntryDO removePriceBookEntryDO(
			PriceBookEntryDO PriceBookEntryDO) {
		getPriceBookEntries().remove(PriceBookEntryDO);
		PriceBookEntryDO.setProductDO(null);

		return PriceBookEntryDO;
	}
}