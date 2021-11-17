package com.softtwig.crm.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLOBAL_SEARCH")
public class GlobalSearchDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7802686988615128658L;
	private int globalSearchId;
	private String name;
	private String entityGroup;
	private int entityGroupId;

	/**
	 * @return the globalSearchId
	 */
	@Id
	@GeneratedValue
	@Column(name = "GLOBAL_SEARCH_ID", unique = true, nullable = false)
	public int getGlobalSearchId() {
		return globalSearchId;
	}

	/**
	 * @param globalSearchId
	 *            the globalSearchId to set
	 */
	public void setGlobalSearchId(int globalSearchId) {
		this.globalSearchId = globalSearchId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", unique = false, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the entityGroup
	 */
	@Column(name = "ENTITY_GROUP", unique = false, nullable = false)
	public String getEntityGroup() {
		return entityGroup;
	}

	/**
	 * @param entityGroup
	 *            the entityGroup to set
	 */
	public void setEntityGroup(String entityGroup) {
		this.entityGroup = entityGroup;
	}

	/**
	 * @return the entityGroupId
	 */
	@Column(name = "ENTITY_GROUP_ID", unique = false, nullable = false)
	public int getEntityGroupId() {
		return entityGroupId;
	}

	/**
	 * @param entityGroupId
	 *            the entityGroupId to set
	 */
	public void setEntityGroupId(int entityGroupId) {
		this.entityGroupId = entityGroupId;
	}
}
