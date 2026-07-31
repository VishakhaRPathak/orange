package com.selfw.orangehrm.businessconstants;

public enum LeaveListFieldNames {
    SHOWLEAVEWITHSTATUS("Show Leave with Status"),
    LEAVETYPE("Leave Type"),
    SUBUNIT("Sub Unit"),
    EMPLOYEENAME("Employee Name"),
	FROMDATE("From Date"),
	INCLUDEPASTEMPLOYEES("Include Past Employees"),
	TODATE("To Date");

    private final String fieldName;

    LeaveListFieldNames(String fieldName) {
        this.fieldName = fieldName;
    }

    public String fieldName() {
        return fieldName;
    }
}