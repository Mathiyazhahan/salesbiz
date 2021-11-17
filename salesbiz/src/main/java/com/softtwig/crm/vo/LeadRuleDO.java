package com.softtwig.crm.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name ="lead_rule")
public class LeadRuleDO {
	private String taskCriteria;
	private String eventCriteria;
	private String valueCriteria;
	private int sno;
	private LeadDO leadDO;
	
	@Column(name = "TASK_CRITERIA", unique = false, nullable = false)
	public String getTaskCriteria() {
		return taskCriteria;
	}
	public void setTaskCriteria(String taskCriteria) {
		this.taskCriteria = taskCriteria;
	}
	
	@Column(name = "EVENT_CRITERIA", unique = false, nullable = false)
	public String getEventCriteria() {
		return eventCriteria;
	}
	public void setEventCriteria(String eventCriteria) {
		this.eventCriteria = eventCriteria;
	}
	
	@Column(name = "VALUE_CRITERIA", unique = false, nullable = false)
	public String getValueCriteria() {
		return valueCriteria;
	}
	public void setValueCriteria(String valueCriteria) {
		this.valueCriteria = valueCriteria;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "sno" , unique=true, nullable = false)
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name = "LEAD_ID")
	public LeadDO getLeadDO() {
		return leadDO;
	}
	
	
	public void setLeadDO(LeadDO leadDO) {
		this.leadDO = leadDO;
	}
	
	
	

}
