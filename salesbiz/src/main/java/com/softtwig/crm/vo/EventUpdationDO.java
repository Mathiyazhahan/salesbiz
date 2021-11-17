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
@Table(name="event_updation")
public class EventUpdationDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int eventUpdationId;
	private String eventType;
	private String createdBy;
	private Date createdByDate;
	private String lastModifiedBy;
	private Date lastModifiedByDate;
	private String eventStatus;
	private Boolean isDeleted;
	private Date eventDate;
	private String eventTime;
	private String description;
	private Boolean isReminder;
	private Date reminderDate;
	private String reminderTime;
	
	// bi-directional many-to-one association to ProductDO
	private User user;
	// bi-directional many-to-one association to ProductDO
	private EventDO eventDO;
	/**
	 * @return the eventUpdationId
	 */
	@Id
	@GeneratedValue
	@Column(name = "EVENT_UPDATE_ID", unique = true, nullable = false)
	public int getEventUpdationId() {
		return eventUpdationId;
	}
	/**
	 * @param eventUpdationId the eventUpdationId to set
	 */
	public void setEventUpdationId(int eventUpdationId) {
		this.eventUpdationId = eventUpdationId;
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
	 * @return the eventStatus
	 */
	@Column(name = "EVENT_STATUS")
	public String getEventStatus() {
		return eventStatus;
	}
	/**
	 * @param eventStatus the eventStatus to set
	 */
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
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
	/**
	 * @return the eventDate
	 */
	@Column(name = "EVENT_DATE")
	public Date getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the eventTime
	 */
	@Column(name = "EVENT_TIME")
	public String getEventTime() {
		return eventTime;
	}
	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	/**
	 * @return the description
	 */
	@Column(name = "DESCRIPTION")
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
	 * @return the isReminder
	 */
	@Column(name = "IS_REMINDER")
	public Boolean getIsReminder() {
		return isReminder;
	}
	/**
	 * @param isReminder the isReminder to set
	 */
	public void setIsReminder(Boolean isReminder) {
		this.isReminder = isReminder;
	}
	/**
	 * @return the reminderDate
	 */
	@Column(name = "REMINDER_DATE")
	public Date getReminderDate() {
		return reminderDate;
	}
	/**
	 * @param reminderDate the reminderDate to set
	 */
	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}
	/**
	 * @return the reminderTime
	 */
	@Column(name = "REMINDER_TIME")
	public String getReminderTime() {
		return reminderTime;
	}
	/**
	 * @param reminderTime the reminderTime to set
	 */
	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}
	/**
	 * @return the userDO
	 */
	@ManyToOne
	@JoinColumn(name="OWNER_ID")
	public User getUser() {
		return user;
	}
	/**
	 * @param userDO the userDO to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the eventDO
	 */
	@ManyToOne
	@JoinColumn(name="EVENT_ID")
	public EventDO getEventDO() {
		return eventDO;
	}
	/**
	 * @param eventDO the eventDO to set
	 */
	public void setEventDO(EventDO eventDO) {
		this.eventDO = eventDO;
	}
}
