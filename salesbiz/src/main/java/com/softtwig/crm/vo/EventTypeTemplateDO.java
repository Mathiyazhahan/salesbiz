package com.softtwig.crm.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_type_template")
public class EventTypeTemplateDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int eventTypeId;
	private int ownerId;
	private String eventType;
	private String createdBy;
	private Date createdByDate;
	private String lastModifiedBy;
	private Date lastModifiedByDate;
	private Boolean isDeleted;
	/**
	 * @return the eventTypeId
	 */
	@Id
	@GeneratedValue
	@Column(name = "EVENT_TYPE_ID", unique = true, nullable = false)
	public int getEventTypeId() {
		return eventTypeId;
	}
	/**
	 * @param eventTypeId the eventTypeId to set
	 */
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	/**
	 * @return the ownerId
	 */
	@Column(name = "OWNER_ID")
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
	 * @return the eventType
	 */
	@Column(name = "EVENT_TYPE")
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return the createdBy
	 */
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
	 * @return the createdByDate
	 */
	@Column(name = "CREATED_BY_DATE")
	public Date getCreatedByDate() {
		return createdByDate;
	}
	/**
	 * @param createdByDate the createdByDate to set
	 */
	public void setCreatedByDate(Date createdByDate) {
		this.createdByDate = createdByDate;
	}
	/**
	 * @return the lastModifiedBy
	 */
	@Column(name = "LAST_MODIFIED_BY")
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
	 * @return the lastModifiedByDate
	 */
	@Column(name = "LAST_MODIFIED_BY_DATE")
	public Date getLastModifiedByDate() {
		return lastModifiedByDate;
	}
	/**
	 * @param lastModifiedByDate the lastModifiedByDate to set
	 */
	public void setLastModifiedByDate(Date lastModifiedByDate) {
		this.lastModifiedByDate = lastModifiedByDate;
	}
	/**
	 * @return the isDeleted
	 */
	@Column(name = "IS_DELETED")
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}	
}
