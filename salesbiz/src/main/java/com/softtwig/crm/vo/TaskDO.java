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
@Table(name = "task")
public class TaskDO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int taskId;
	private Date activityDate;
	private String callDisposition;
	private int callDuration;
	private String callObject;
	private String callType;
	private int connectionSentId;
	private int connectionReceivedId;
	private String createdBy;
	private Date createdDate;
	private String description;
	private boolean isClosed;
	private boolean isDeleted;
	private Boolean isRecurrence;
	private Boolean isReminderSet;
	private Boolean notifyMail;
	private String lastModifiedBy;
	private Date lastModifiedDate;
	private String priority;
	private int recurrenceActivityId;
	private Date reminderDateTime;
	private String status;
	private String subject;
	private String type;
	private int whatCount;
	private int whocount;
	private String whatName;
	private String whoName;
	private String reminderTime;
	private String recurrenceEveryWeekDays;
	private String recurrenceEveryDays;
	private String recurrenceOnWeeks;
	private String recurrenceOnDays;
	private String recurrenceDayOfEveryMonth;
	private String recurrenceOnMonth;
	private String recurrenceOnDate;
	private String recurrenceTime;
	private Date recurrenceStartingDate;
	private Date recurrenceEndingDate;
	private String timeZoneSidKey;
	private String recurrenceFrequency;
	private String role;
	private String groupBy;
	private String taskDetails;
	private Date fromDate;
	private Date toDate;

	// bi-directional Many-to-one association to PriceBookEntryDO
	private User user;
	// bi-directional Many-to-one association to PriceBookEntryDO
	private LeadDO leadDO;
	private OpportunityDO opportunityDO;
	// bi-directional one-to-many association to PriceBookEntryDO
	private List<EventDO> eventDO;

	/**
	 * @return the taskId
	 */
	@Id
	@GeneratedValue
	@Column(name = "TASK_ID", unique = true, nullable = false)
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the activityDate
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "ACTIVITY_DATE")
	public Date getActivityDate() {
		return activityDate;
	}

	/**
	 * @param activityDate
	 *            the activityDate to set
	 */
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	/**
	 * @return the callDisposition
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "CALL_DISPOSITION")
	public String getCallDisposition() {
		return callDisposition;
	}

	/**
	 * @param callDisposition
	 *            the callDisposition to set
	 */
	public void setCallDisposition(String callDisposition) {
		this.callDisposition = callDisposition;
	}

	/**
	 * @return the callDuration
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "CALL_DURATION_IN_SECONDS")
	public int getCallDuration() {
		return callDuration;
	}

	/**
	 * @param callDuration
	 *            the callDuration to set
	 */
	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	/**
	 * @return the callObject
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "CALL_OBJECT")
	public String getCallObject() {
		return callObject;
	}

	/**
	 * @param callObject
	 *            the callObject to set
	 */
	public void setCallObject(String callObject) {
		this.callObject = callObject;
	}

	/**
	 * @return the callType
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "CALL_TYPE")
	public String getCallType() {
		return callType;
	}

	/**
	 * @param callType
	 *            the callType to set
	 */
	public void setCallType(String callType) {
		this.callType = callType;
	}

	/**
	 * @return the connectionSentId
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "CONNECTION_SEND_ID")
	public int getConnectionSentId() {
		return connectionSentId;
	}

	/**
	 * @param connectionSentId
	 *            the connectionSentId to set
	 */
	public void setConnectionSentId(int connectionSentId) {
		this.connectionSentId = connectionSentId;
	}

	/**
	 * @return the connectionReceivedId
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "CONNECTION_RECEIVED_ID")
	public int getConnectionReceivedId() {
		return connectionReceivedId;
	}

	/**
	 * @param connectionReceivedId
	 *            the connectionReceivedId to set
	 */
	public void setConnectionReceivedId(int connectionReceivedId) {
		this.connectionReceivedId = connectionReceivedId;
	}

	/**
	 * @return the createdBy
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the description
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the isClosed
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "IS_CLOSED")
	public Boolean getIsClosed() {
		return isClosed;
	}

	/**
	 * @param isClosed
	 *            the isClosed to set
	 */
	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	/**
	 * @return the isDeleted
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the isRecurrence
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "LAST_MODIFIED_BY")
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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the priority
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "PRIORITY")
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the recurrenceActivityId
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the reminderDateTime
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the status
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the subject
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	 * @return the type
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the whatCount
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "WHAT_COUNT")
	public int getWhatCount() {
		return whatCount;
	}

	/**
	 * @param whatCount
	 *            the whatCount to set
	 */
	public void setWhatCount(int whatCount) {
		this.whatCount = whatCount;
	}

	/**
	 * @return the whocount
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "WHO_COUNT")
	public int getWhocount() {
		return whocount;
	}

	/**
	 * @param whocount
	 *            the whocount to set
	 */
	public void setWhocount(int whocount) {
		this.whocount = whocount;
	}

	/**
	 * @return the contactName
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "WHAT_NAME")
	public String getWhatName() {
		return whatName;
	}

	/**
	 * @param contactName
	 *            the contactName to set
	 */
	public void setWhatName(String whatName) {
		this.whatName = whatName;
	}

	/**
	 * @return the opportunityName
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "WHO_NAME")
	public String getWhoName() {
		return whoName;
	}

	/**
	 * @param opportunityName
	 *            the opportunityName to set
	 */
	public void setWhoName(String whoName) {
		this.whoName = whoName;
	}

	/**
	 * @return the notifyMail
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "IS_NOTIFY_EMAIL")
	public Boolean getNotifyMail() {
		return notifyMail;
	}

	/**
	 * @param notifyMail
	 *            the notifyMail to set
	 */
	public void setNotifyMail(Boolean notifyMail) {
		this.notifyMail = notifyMail;
	}

	/**
	 * @return the reminderTime
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "REMINDER_TIME")
	public String getReminderTime() {
		return reminderTime;
	}

	/**
	 * @param reminderTime
	 *            the reminderTime to set
	 */
	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}

	/**
	 * @return the recurrenceEveryWeekDays
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_EVERY_WEEKDAYS")
	public String getRecurrenceEveryWeekDays() {
		return recurrenceEveryWeekDays;
	}

	/**
	 * @param recurrenceEveryWeekDays
	 *            the recurrenceEveryWeekDays to set
	 */
	public void setRecurrenceEveryWeekDays(String recurrenceEveryWeekDays) {
		this.recurrenceEveryWeekDays = recurrenceEveryWeekDays;
	}

	/**
	 * @return the recurrenceEveryDays
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_EVERYDAYS")
	public String getRecurrenceEveryDays() {
		return recurrenceEveryDays;
	}

	/**
	 * @param recurrenceEveryDays
	 *            the recurrenceEveryDays to set
	 */
	public void setRecurrenceEveryDays(String recurrenceEveryDays) {
		this.recurrenceEveryDays = recurrenceEveryDays;
	}

	/**
	 * @return the recurrenceOnWeeks
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_ON_WEEKS")
	public String getRecurrenceOnWeeks() {
		return recurrenceOnWeeks;
	}

	/**
	 * @param recurrenceOnWeeks
	 *            the recurrenceOnWeeks to set
	 */
	public void setRecurrenceOnWeeks(String recurrenceOnWeeks) {
		this.recurrenceOnWeeks = recurrenceOnWeeks;
	}

	/**
	 * @return the recurrenceOnDays
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_ON_DAYS")
	public String getRecurrenceOnDays() {
		return recurrenceOnDays;
	}

	/**
	 * @param recurrenceOnDays
	 *            the recurrenceOnDays to set
	 */
	public void setRecurrenceOnDays(String recurrenceOnDays) {
		this.recurrenceOnDays = recurrenceOnDays;
	}

	/**
	 * @return the recurrenceDayOfEveryMonth
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_ON_DAYOF_EVERYMONTH")
	public String getRecurrenceDayOfEveryMonth() {
		return recurrenceDayOfEveryMonth;
	}

	/**
	 * @param recurrenceDayOfEveryMonth
	 *            the recurrenceDayOfEveryMonth to set
	 */
	public void setRecurrenceDayOfEveryMonth(String recurrenceDayOfEveryMonth) {
		this.recurrenceDayOfEveryMonth = recurrenceDayOfEveryMonth;
	}

	/**
	 * @return the recurrenceOnMonth
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_ON_MONTH")
	public String getRecurrenceOnMonth() {
		return recurrenceOnMonth;
	}

	/**
	 * @param recurrenceOnMonth
	 *            the recurrenceOnMonth to set
	 */
	public void setRecurrenceOnMonth(String recurrenceOnMonth) {
		this.recurrenceOnMonth = recurrenceOnMonth;
	}

	/**
	 * @return the recurrenceOnDate
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_ON_DATE")
	public String getRecurrenceOnDate() {
		return recurrenceOnDate;
	}

	/**
	 * @param recurrenceOnDate
	 *            the recurrenceOnDate to set
	 */
	public void setRecurrenceOnDate(String recurrenceOnDate) {
		this.recurrenceOnDate = recurrenceOnDate;
	}

	/**
	 * @return the recurrenceStartingDate
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_STARTING_DATETIME")
	public Date getRecurrenceStartingDate() {
		return recurrenceStartingDate;
	}

	/**
	 * @param recurrenceStartingDate
	 *            the recurrenceStartingDate to set
	 */
	public void setRecurrenceStartingDate(Date recurrenceStartingDate) {
		this.recurrenceStartingDate = recurrenceStartingDate;
	}

	/**
	 * @return the recurrenceEndingDate
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_ENDINGDATE_TIME")
	public Date getRecurrenceEndingDate() {
		return recurrenceEndingDate;
	}

	/**
	 * @param recurrenceEndingDate
	 *            the recurrenceEndingDate to set
	 */
	public void setRecurrenceEndingDate(Date recurrenceEndingDate) {
		this.recurrenceEndingDate = recurrenceEndingDate;
	}

	/**
	 * @return the timeZoneSidKey
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "REMINDER_TIMEZONE")
	public String getTimeZoneSidKey() {
		return timeZoneSidKey;
	}

	/**
	 * @param timeZoneSidKey
	 *            the timeZoneSidKey to set
	 */
	public void setTimeZoneSidKey(String timeZoneSidKey) {
		this.timeZoneSidKey = timeZoneSidKey;
	}

	/**
	 * @return the recurrenceFrequency
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_FREQUENCY")
	public String getRecurrenceFrequency() {
		return recurrenceFrequency;
	}

	/**
	 * @param recurrenceFrequency
	 *            the recurrenceFrequency to set
	 */
	public void setRecurrenceFrequency(String recurrenceFrequency) {
		this.recurrenceFrequency = recurrenceFrequency;
	}

	/**
	 * @return the recurrenceTime
	 */
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "RECURRENCE_TIME")
	public String getRecurrenceTime() {
		return recurrenceTime;
	}

	/**
	 * @param recurrenceTime
	 *            the recurrenceTime to set
	 */
	public void setRecurrenceTime(String recurrenceTime) {
		this.recurrenceTime = recurrenceTime;
	}

	/**
	 * @return the userDO
	 */
	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	public final User getUser() {
		return user;
	}

	/**
	 * @param userDO
	 *            the userDO to set
	 */
	public final void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the leadDO
	 */
	@ManyToOne
	@JoinColumn(name = "LEAD_ID")
	public LeadDO getLeadDO() {
		return leadDO;
	}

	/**
	 * @param leadDO
	 *            the leadDO to set
	 */
	public void setLeadDO(LeadDO leadDO) {
		this.leadDO = leadDO;
	}

	/**
	 * @return the eventDO
	 */
	@OneToMany(mappedBy = "taskDO")
	public List<EventDO> getEventDO() {
		return eventDO;
	}

	/**
	 * @param eventDO
	 *            the eventDO to set
	 */
	public void setEventDO(List<EventDO> eventDO) {
		this.eventDO = eventDO;
	}

	/**
	 * @return the opportunityDO
	 */
	@ManyToOne
	@JoinColumn(name = "OPPORTUNITY_ID")
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
	 * @return the role
	 */
	@Column(name = "ROLE", unique = false, nullable = true)
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the groupBy
	 */
	@Column(name = "GROUP_BY", unique = false, nullable = true)
	public String getGroupBy() {
		return groupBy;
	}

	/**
	 * @param groupBy
	 *            the groupBy to set
	 */
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	
	/**
	 * @return the taskDetails
	 */
	@Column(name ="TASK_DETAILS", unique=false, nullable=true)
	public String getTaskDetails() {
		return taskDetails;
	}

	/**
	 * @param taskDetails the taskDetails to set
	 */
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

	/**
	 * @return the fromDate
	 */
	@Column(name ="FROM_DATE", unique=false, nullable=true)
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
	@Column(name ="TO_DATE", unique=false, nullable=true)
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
