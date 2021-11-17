/**
 * 
 */
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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


@Entity
@Indexed
@Table(name = "event")
public class EventDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eventId;
	private String activityDate;
	//private Date activityDateTime;
	private int currencyIsoCode;
	private String createdBy;
	private Date createdDate;
	private String division;
	private String description;
	private int durationInMinutes;
	private Date endDateTime;
	private String groupEventType;
	private Boolean isAllDayEvent;
	private Boolean isChild;
	private Boolean isDeleted;
	private Boolean isGroupEvent;
	private Boolean isPrivate;
	private Boolean isRecurrence;
	private Boolean isReminderSet;
	private String lastModifiedBy;
	private Date lastModifiedDate;
	private String location;
	private int recurrenceActivityId;
	private Date reminderDateTime;
	private String showAs;
	private Date startDateTime;
	private String subject;
	private String reminderTime;
	private String recurrenceEveryWeekDays;
	private String recurrenceEveryDays;
	private String recurrenceOnWeeks;
	private String recurrenceOnDays;
	private String recurrenceDayOfEveryMonth;
	private String recurrenceOnMonth;
	private String recurrenceOnDate;
	private String recurrenceTime;
	private String eventStartTime;
	private String eventEndTime;
	private String recurrenceFrequency;
	private String eventStatus;
	private int ownerId;
	private String role;
	private String groupBy;
	private String eventDetails;
	private Date fromDate;
	private Date toDate;	
	
	
	// bi-directional One-to-Many association to PriceBookEntryDO
	private TaskDO taskDO;
	// bi-directional One-to-Many association to PriceBookEntryDO
	private List<EventUpdationDO> updationDO;

	/**
	 * @return the eventId
	 */
	@Id
	@GeneratedValue
	@Column(name = "EVENT_ID", unique = true, nullable = false)
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the activityDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "ACTIVITY_DATE")
	public String getActivityDate() {
		return activityDate;
	}

	/**
	 * @param activityDate
	 *            the activityDate to set
	 */
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}

	/**
	 * @return the activityDateTime
	 */
	/*@Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	@DateBridge(resolution=Resolution.DAY)
	@Column(name = "ACTIVITY_DATE_TIME")
	public Date getActivityDateTime() {
		return activityDateTime;
	}

	*//**
	 * @param activityDateTime
	 *            the activityDateTime to set
	 *//*
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	public void setActivityDateTime(Date activityDateTime) {
		this.activityDateTime = activityDateTime;
	}*/

	/**
	 * @return the currencyIsoCode
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CURRENCY_ISO_CODE")
	public int getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	/**
	 * @param currencyIsoCode
	 *            the currencyIsoCode to set
	 */
	public void setCurrencyIsoCode(int currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	/**
	 * @return the createdBy
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "CREATED_BY_ID")
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
	
	@Column(name = "CREATED_DATE")
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
	 * @return the division
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
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
	 * @return the description
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DESRIPTION")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the durationInMinutes
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "DURATION_IN_MINUTES")
	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	/**
	 * @param durationInMinutes
	 *            the durationInMinutes to set
	 */
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	/**
	 * @return the endDateTime
	 */
	
	@Column(name = "END_DATE_TIME")
	public Date getEndDateTime() {
		return endDateTime;
	}

	/**
	 * @param endDateTime
	 *            the endDateTime to set
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * @return the groupEventType
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "GROUP_EVENT_TYPE")
	public String getGroupEventType() {
		return groupEventType;
	}

	/**
	 * @param groupEventType
	 *            the groupEventType to set
	 */
	public void setGroupEventType(String groupEventType) {
		this.groupEventType = groupEventType;
	}

	/**
	 * @return the isAllDayEvent
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_ALL_DAY_EVENT")
	public Boolean getIsAllDayEvent() {
		return isAllDayEvent;
	}

	/**
	 * @param isAllDayEvent
	 *            the isAllDayEvent to set
	 */
	public void setIsAllDayEvent(Boolean isAllDayEvent) {
		this.isAllDayEvent = isAllDayEvent;
	}

	/**
	 * @return the isChild
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_CHILD")
	public Boolean getIsChild() {
		return isChild;
	}

	/**
	 * @param isChild
	 *            the isChild to set
	 */
	public void setIsChild(Boolean isChild) {
		this.isChild = isChild;
	}

	/**
	 * @return the isDeleted
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
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
	 * @return the isGroupEvent
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_GROUP_EVENT")
	public Boolean getIsGroupEvent() {
		return isGroupEvent;
	}

	/**
	 * @param isGroupEvent
	 *            the isGroupEvent to set
	 */
	public void setIsGroupEvent(Boolean isGroupEvent) {
		this.isGroupEvent = isGroupEvent;
	}

	/**
	 * @return the isPrivate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_PRIVATE")
	public Boolean getIsPrivate() {
		return isPrivate;
	}

	/**
	 * @param isPrivate
	 *            the isPrivate to set
	 */
	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	/**
	 * @return the isRecurrence
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_RECURRENCE")
	public Boolean getIsRecurrence() {
		return isRecurrence;
	}

	/**
	 * @param isRecurrence
	 *            the isRecurrence to set
	 */
	public void setIsRecurrence(Boolean isRecurrence) {
		this.isRecurrence = isRecurrence;
	}

	/**
	 * @return the isReminderSet
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "IS_REMINDER_SET")
	public Boolean getIsReminderSet() {
		return isReminderSet;
	}

	/**
	 * @param isReminderSet
	 *            the isReminderSet to set
	 */
	public void setIsReminderSet(Boolean isReminderSet) {
		this.isReminderSet = isReminderSet;
	}

	/**
	 * @return the lastModifiedBy
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LAST_MODIFIED_BY_ID")
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	
	@Column(name = "LAST_MODIFIED_DATE")
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate
	 *            the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the location
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the recurrenceActivityId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_ACTIVITY_ID")
	public int getRecurrenceActivityId() {
		return recurrenceActivityId;
	}

	/**
	 * @param recurrenceActivityId
	 *            the recurrenceActivityId to set
	 */
	public void setRecurrenceActivityId(int recurrenceActivityId) {
		this.recurrenceActivityId = recurrenceActivityId;
	}
	/**
	 * @return the reminderTime
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
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
	 * @return the recurrenceEveryWeekDays
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_EVERY_WEEKDAYS")
	public String getRecurrenceEveryWeekDays() {
		return recurrenceEveryWeekDays;
	}

	/**
	 * @param recurrenceEveryWeekDays the recurrenceEveryWeekDays to set
	 */
	public void setRecurrenceEveryWeekDays(String recurrenceEveryWeekDays) {
		this.recurrenceEveryWeekDays = recurrenceEveryWeekDays;
	}

	/**
	 * @return the recurrenceEveryDays
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_EVERYDAYS")
	public String getRecurrenceEveryDays() {
		return recurrenceEveryDays;
	}

	/**
	 * @param recurrenceEveryDays the recurrenceEveryDays to set
	 */
	public void setRecurrenceEveryDays(String recurrenceEveryDays) {
		this.recurrenceEveryDays = recurrenceEveryDays;
	}

	/**
	 * @return the recurrenceOnWeeks
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_ON_WEEKS")
	public String getRecurrenceOnWeeks() {
		return recurrenceOnWeeks;
	}

	/**
	 * @param recurrenceOnWeeks the recurrenceOnWeeks to set
	 */
	public void setRecurrenceOnWeeks(String recurrenceOnWeeks) {
		this.recurrenceOnWeeks = recurrenceOnWeeks;
	}

	/**
	 * @return the recurrenceOnDays
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_ON_DAYS")
	public String getRecurrenceOnDays() {
		return recurrenceOnDays;
	}

	/**
	 * @param recurrenceOnDays the recurrenceOnDays to set
	 */
	public void setRecurrenceOnDays(String recurrenceOnDays) {
		this.recurrenceOnDays = recurrenceOnDays;
	}

	/**
	 * @return the recurrenceDayOfEveryMonth
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_ON_DAYOF_EVERYMONTH")
	public String getRecurrenceDayOfEveryMonth() {
		return recurrenceDayOfEveryMonth;
	}

	/**
	 * @param recurrenceDayOfEveryMonth the recurrenceDayOfEveryMonth to set
	 */
	public void setRecurrenceDayOfEveryMonth(String recurrenceDayOfEveryMonth) {
		this.recurrenceDayOfEveryMonth = recurrenceDayOfEveryMonth;
	}

	/**
	 * @return the recurrenceOnMonth
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_ON_MONTH")
	public String getRecurrenceOnMonth() {
		return recurrenceOnMonth;
	}

	/**
	 * @param recurrenceOnMonth the recurrenceOnMonth to set
	 */
	public void setRecurrenceOnMonth(String recurrenceOnMonth) {
		this.recurrenceOnMonth = recurrenceOnMonth;
	}

	/**
	 * @return the recurrenceOnDate
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_ON_DATE")
	public String getRecurrenceOnDate() {
		return recurrenceOnDate;
	}

	/**
	 * @param recurrenceOnDate the recurrenceOnDate to set
	 */
	public void setRecurrenceOnDate(String recurrenceOnDate) {
		this.recurrenceOnDate = recurrenceOnDate;
	}

	/**
	 * @return the reminderDateTime
	 */
	
	@Column(name = "REMINDER_DATE_TIME")
	public Date getReminderDateTime() {
		return reminderDateTime;
	}

	/**
	 * @param reminderDateTime
	 *            the reminderDateTime to set
	 */
	public void setReminderDateTime(Date reminderDateTime) {
		this.reminderDateTime = reminderDateTime;
	}

	/**
	 * @return the showAs
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "SHOW_AS")
	public String getShowAs() {
		return showAs;
	}

	/**
	 * @param showAs
	 *            the showAs to set
	 */
	public void setShowAs(String showAs) {
		this.showAs = showAs;
	}

	/**
	 * @return the startDateTime
	 */
	
	@Column(name = "START_DATE_TIME")
	public Date getStartDateTime() {
		return startDateTime;
	}

	/**
	 * @param startDateTime
	 *            the startDateTime to set
	 */
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * @return the subject
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "SUBJECT")
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the eventStartTime
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "EVENT_START_TIME")
	public String getEventStartTime() {
		return eventStartTime;
	}

	/**
	 * @param eventStartTime the eventStartTime to set
	 */
	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	/**
	 * @return the eventEndTime
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "EVENT_END_TIME")
	public String getEventEndTime() {
		return eventEndTime;
	}

	/**
	 * @param eventEndTime the eventEndTime to set
	 */
	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}
	/**
	 * @return the recurrenceFrequency
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_FREQUENCY")
	public String getRecurrenceFrequency() {
		return recurrenceFrequency;
	}

	/**
	 * @param recurrenceFrequency the recurrenceFrequency to set
	 */
	public void setRecurrenceFrequency(String recurrenceFrequency) {
		this.recurrenceFrequency = recurrenceFrequency;
	}
	/**
	 * @return the recurrenceTime
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "RECURRENCE_TIME")
	public String getRecurrenceTime() {
		return recurrenceTime;
	}

	/**
	 * @param recurrenceTime the recurrenceTime to set
	 */
	public void setRecurrenceTime(String recurrenceTime) {
		this.recurrenceTime = recurrenceTime;
	}
	/**
	 * @return the eventStatus
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
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
	 * @return the userDO
	 */
	
	/**
	 * @return the ownerId
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "OWNER_ID", nullable = false)
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
/*@ManyToOne
 // @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@JoinColumn(name = "OWNER_ID", nullable = false)
	public UserDO getUserDO() {
		return userDO;
	}

	*//**
	 * @param userDO the userDO to set
	 *//*
	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}*/

	/**
	 * @return the taskDO
	 */
	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	public TaskDO getTaskDO() {
		return taskDO;
	}

	/**
	 * @param taskDO the taskDO to set
	 */
	public void setTaskDO(TaskDO taskDO) {
		this.taskDO = taskDO;
	}


	/**
	 * @return the updationDO
	 */
	@OneToMany(mappedBy = "eventDO")
	public List<EventUpdationDO> getUpdationDO() {
		return updationDO;
	}

	/**
	 * @param updationDO the updationDO to set
	 */
	public void setUpdationDO(List<EventUpdationDO> updationDO) {
		this.updationDO = updationDO;
	}
	/**
	 * @return the role
	 */
	@Column (name="ROLE",unique=false,nullable=true)
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the groupBy
	 */
	@Column (name ="GROUP_BY",unique=false,nullable=true)
	public String getGroupBy() {
		return groupBy;
	}

	/**
	 * @param groupBy the groupBy to set
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	/**
	 * @return the eventEntity
	 */
	
	/**
	 * @return the eventDetails
	 */
	@Column (name="EVENT_DETAILS",unique=false,nullable=true)
	public String getEventDetails() {
		return eventDetails;
	}

	/**
	 * @param eventDetails the eventDetails to set
	 */
	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}

	/**
	 * @return the fromDate
	 */
	@Column(name="FROM_DATE",unique=false,nullable=true)
	public Date getFromDate() {
		return fromDate;
	}
	
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	@Column(name="TO_DATE",unique=false,nullable=true)
	
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	
	
}
