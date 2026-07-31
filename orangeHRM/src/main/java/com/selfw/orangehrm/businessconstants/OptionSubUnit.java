package com.selfw.orangehrm.businessconstants;

public enum OptionSubUnit { 
	REJECTED("Rejected"),
	CANCELLED("Cancelled"),
	PENDINGAPPROVAL("Pending Approval"),
	SCHEDULED("Scheduled"),
	TAKEN("Taken");
	
	private final String option;
	
	private OptionSubUnit(String option) {
		this.option = option;
	}
	public String option() {
		return option;
	}
}
