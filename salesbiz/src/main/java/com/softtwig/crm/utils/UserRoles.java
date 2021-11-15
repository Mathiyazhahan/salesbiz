package com.softtwig.crm.utils;

public enum UserRoles {   
  
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_CAMPAIGN_MANAGER("ROLE_CAMPAIGN_MANAGER"), 
    ROLE_CAMPAIGN_TEAM("ROLE_CAMPAIGN_TEAM"),
    ROLE_SALES_MANAGER("ROLE_SALES_MANAGER"),
    ROLE_SALES_TEAM("ROLE_SALES_TEAM");
	
    private String role;
    
    UserRoles(String role) {
    
        this.role = role;
    }
    
    
    public String getRole() {
    
        return role;
    }
}
