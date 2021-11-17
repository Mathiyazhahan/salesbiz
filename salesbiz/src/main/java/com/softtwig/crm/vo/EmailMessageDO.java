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

@Entity
@Table(name = "email_message")
public class EmailMessageDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int emailMessageID;
	private int activityId;
	private String bccAddress;
	private String ccAddress;
	private String fromName;
	private Date createdDate;
	private String fromAddress;
	private String lastModifiedBy;
	private Date lastModifiedDate;
	private Boolean isDeleted;
	private Date messageDate;
	private String status;
	private String subject;
	private String textBody;
	private String toAddress;
	private Boolean hasAttachment;
	private String headers;
	private Boolean incoming;
	private String division;
	private String htmlBody;
	private int replyToEmailMessageId;
	private Date systemModstamp;
	private String additionalTo;
	
	// bi-directional many-to-one association to ProductDO
	private User user;
	// bi-directional many-to-one association to ProductDO
	private EventDO eventDO;
	// bi-directional one-to-many association to PriceBookEntryDO
	private List<EmailAttachmentDO> emailAttachmentDO;
	
	/**
	 * @return the emailMessageID
	 */
	@Id
	@GeneratedValue
	@Column(name = "EMAIL_MESSAGE_ID", unique = true, nullable = false)
	public int getEmailMessageID() {
		return emailMessageID;
	}

	/**
	 * @param emailMessageID
	 *            the emailMessageID to set
	 */
	public void setEmailMessageID(int emailMessageID) {
		this.emailMessageID = emailMessageID;
	}

	/**
	 * @return the activityId
	 */
	@Column(name = "ACTIVITY_ID")
	public int getActivityId() {
		return activityId;
	}

	/**
	 * @param activityId
	 *            the activityId to set
	 */
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	/**
	 * @return the bccAddress
	 */
	@Column(name = "BCC_ADDRESS")
	public String getBccAddress() {
		return bccAddress;
	}

	/**
	 * @param bccAddress
	 *            the bccAddress to set
	 */
	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}

	/**
	 * @return the ccAddress
	 */
	@Column(name = "CC_ADDRESS")
	public String getCcAddress() {
		return ccAddress;
	}

	/**
	 * @param ccAddress
	 *            the ccAddress to set
	 */
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
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
	 * @return the lastModifiedBy
	 */
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
	@Column(name = "LAST_MODIFIED_BY_DATE")
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
	 * @return the messageDate
	 */
	@Column(name = "MESSAGE_DATE")
	public Date getMessageDate() {
		return messageDate;
	}

	/**
	 * @param messageDate
	 *            the messageDate to set
	 */
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	/**
	 * @return the fromAddress
	 */
	@Column(name = "FROM_ADDRESS")
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * @param fromAddress
	 *            the fromAddress to set
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	/**
	 * @return the fromName
	 */
	@Column(name = "FROM_NAME")
	public String getFromName() {
		return fromName;
	}

	/**
	 * @param fromName
	 *            the fromName to set
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * @return the status
	 */
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
	 * @return the textBody
	 */
	@Column(name = "TEXT_BODY")
	public String getTextBody() {
		return textBody;
	}

	/**
	 * @param textBody
	 *            the textBody to set
	 */
	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	/**
	 * @return the toAddress
	 */
	@Column(name = "TO_ADDRESS")
	public String getToAddress() {
		return toAddress;
	}

	/**
	 * @param toAddress
	 *            the toAddress to set
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	/**
	 * @return the hasAttachment
	 */
	@Column(name = "HAS_ATTACHMENT")
	public Boolean getHasAttachment() {
		return hasAttachment;
	}

	/**
	 * @param hasAttachment
	 *            the hasAttachment to set
	 */
	public void setHasAttachment(Boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	/**
	 * @return the headers
	 */
	@Column(name = "HEADERS")
	public String getHeaders() {
		return headers;
	}

	/**
	 * @param headers
	 *            the headers to set
	 */
	public void setHeaders(String headers) {
		this.headers = headers;
	}

	/**
	 * @return the incoming
	 */
	@Column(name = "IS_INCOMING")
	public Boolean getIncoming() {
		return incoming;
	}

	/**
	 * @param incoming
	 *            the incoming to set
	 */
	public void setIncoming(Boolean incoming) {
		this.incoming = incoming;
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
	 * @return the htmlBody
	 */
	@Column(name = "HTML_BODY")
	public String getHtmlBody() {
		return htmlBody;
	}

	/**
	 * @param htmlBody
	 *            the htmlBody to set
	 */
	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}

	/**
	 * @return the replyToEmailMessageId
	 */
	@Column(name = "REPLY_TO_EMAIL_MSG")
	public int getReplyToEmailMessageId() {
		return replyToEmailMessageId;
	}

	/**
	 * @param replyToEmailMessageId
	 *            the replyToEmailMessageId to set
	 */
	public void setReplyToEmailMessageId(int replyToEmailMessageId) {
		this.replyToEmailMessageId = replyToEmailMessageId;
	}

	/**
	 * @return the systemModstamp
	 */
	@Column(name = "SYSTEM_MODSTAMP")
	public Date getSystemModstamp() {
		return systemModstamp;
	}

	/**
	 * @param systemModstamp
	 *            the systemModstamp to set
	 */
	public void setSystemModstamp(Date systemModstamp) {
		this.systemModstamp = systemModstamp;
	}
	/**
	 * @return the additionalTo
	 */
	@Column(name = "ADDITIONAL_TO")
	public String getAdditionalTo() {
		return additionalTo;
	}

	/**
	 * @param additionalTo
	 *            the additionalTo to set
	 */
	public void setAdditionalTo(String additionalTo) {
		this.additionalTo = additionalTo;
	}

	/**
	 * @return the userDO
	 */
	@ManyToOne
	@JoinColumn(name = "PARENT_CASE_ID", nullable = false)
	public User getUser() {
		return user;
	}

	/**
	 * @param userDO
	 *            the userDO to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the eventBO
	 */
	@ManyToOne
	@JoinColumn(name = "EVENT_ID")
	public EventDO getEventDO() {
		return eventDO;
	}

	/**
	 * @param eventBO the eventBO to set
	 */
	public void setEventDO(EventDO eventDO) {
		this.eventDO = eventDO;
	}

	/**
	 * @return the emailAttachmentDO
	 */
	@OneToMany(mappedBy = "emailMessageDO")
	public List<EmailAttachmentDO> getEmailAttachmentDO() {
		return emailAttachmentDO;
	}

	/**
	 * @param emailAttachmentDO the emailAttachmentDO to set
	 */
	public void setEmailAttachmentDO(List<EmailAttachmentDO> emailAttachmentDO) {
		this.emailAttachmentDO = emailAttachmentDO;
	}
}
