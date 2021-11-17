package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "esales_entity")
public class EsalesEntityDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 200007641164138979L;

	private int entityId;
	private String entityName;
	

	/**
	 * @return the entityId
	 */
	@Id
	@GeneratedValue
	@Column(name = "ENTITY_ID", unique = true, nullable = false)
	public int getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId
	 *            the entityId to set
	 */
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the entityName
	 */
	@Column(name = "ENTITY_NAME",nullable = false)
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName
	 *            the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}
