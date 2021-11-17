/**
 * 
 */
package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "event")
public class EventDeleteDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eventId;
	private Boolean isDeleted;
	/**
	 * @return the taskId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVENT_ID", unique = true, nullable = false)
	public int getEventId() {
		return eventId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setEventId(int EventId) {
		this.eventId = EventId;
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

}
