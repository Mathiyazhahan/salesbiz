package com.softtwig.crm.bo;

import org.hibernate.validator.constraints.NotBlank;

public class AccessBo extends BaseBO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4474212248100469141L;
	private long accessId;
	@NotBlank(message="Access name cannot be empty")
	private String accessName;

	public long getAccessId() {
		return accessId;
	}

	public void setAccessId(long accessId) {
		this.accessId = accessId;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}
	

}
