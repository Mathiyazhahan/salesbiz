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

@Entity
@Table(name="product_category")
public class ProductCategoryDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int categoryId;
	private int createdById;
	private Date createdDate;
	private String description;
	private Boolean isDeleted;
	private int lastModifiedById;
	private Date lastModifiedDate;
	private String categoryName;
	
	// bi-directional One-to-Many association to PriceBookEntryDO
	private List<ProductDO> productDO;
		
	/**
	 * @return the categoryId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORY_ID",unique=true,nullable=false)
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the createdById
	 */
	@Column(name="CREATED_BY_ID")
	public int getCreatedById() {
		return createdById;
	}
	/**
	 * @param createdById the createdById to set
	 */
	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}
	/**
	 * @return the createdDate
	 */
	@Column(name="CREATED_BY_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the description
	 */
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the isDeleted
	 */
	@Column(name="IS_DELETED")
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
	 * @return the lastModifiedById
	 */
	@Column(name="LASTMODIFIED_BY_ID")
	public int getLastModifiedById() {
		return lastModifiedById;
	}
	/**
	 * @param lastModifiedById the lastModifiedById to set
	 */
	public void setLastModifiedById(int lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	/**
	 * @return the lastModifiedDate
	 */
	@Column(name="LASTMODIFIED_BY_DATE")
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/**
	 * @return the categoryName
	 */
	@Column(name="CATEGORY_NAME",unique=true)
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the productDO
	 */
	@OneToMany(mappedBy = "productCategoryDO")
	public List<ProductDO> getProductDO() {
		return productDO;
	}
	/**
	 * @param productDO the productDO to set
	 */
	public void setProductDO(List<ProductDO> productDO) {
		this.productDO = productDO;
	}
}
