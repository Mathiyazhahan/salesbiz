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
@Table(name="email_attachment")
public class EmailAttachmentDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int attachmentId;
	private String fileName;
	private byte[] attachmentByte;
	private String createdBy;
	private Date createdByDate;
	private String lastModifiedBy;
	private Date lastModifiedByDate;
	private Boolean isDeleted;
	
	// bi-directional many-to-one association to ProductDO
	private EmailMessageDO emailMessageDO;
	/**
	 * @return the attachmentId
	 */
	@Id
	@GeneratedValue
	@Column(name = "ATTACHMENT_ID", unique = true, nullable = false)
	public int getAttachmentId() {
		return attachmentId;
	}
	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	/**
	 * @return the fileName
	 */
	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the attachmentByte
	 */
	@Column(name = "FILE_ATTACHMENT")
	public byte[] getAttachmentByte() {
		return attachmentByte;
	}
	/**
	 * @param attachmentByte the attachmentByte to set
	 */
	public void setAttachmentByte(byte[] attachmentByte) {
		this.attachmentByte = attachmentByte;
	}
	/**
	 * @return the createdBy
	 */
	@Column(name = "CREATE_BY")
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
	/**
	 * @return the emailMessageDO
	 */
	@ManyToOne
	@JoinColumn(name = "EMAIL_MESSAGE_ID", nullable = false)
	public EmailMessageDO getEmailMessageDO() {
		return emailMessageDO;
	}
	/**
	 * @param emailMessageDO the emailMessageDO to set
	 */
	public void setEmailMessageDO(EmailMessageDO emailMessageDO) {
		this.emailMessageDO = emailMessageDO;
	}
}
