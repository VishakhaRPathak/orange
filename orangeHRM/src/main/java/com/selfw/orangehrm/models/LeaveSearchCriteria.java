package com.selfw.orangehrm.models;

import java.time.LocalDate;
import java.util.Set;

public class LeaveSearchCriteria {
	private String leaveType;
	private String subUnit;
	private String employeeName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Set<String> leaveStatuses;
	private Boolean includePastEmployees;
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getSubUnit() {
		return subUnit;
	}
	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public Set<String> getLeaveStatuses() {
		return leaveStatuses;
	}
	public void setLeaveStatuses(Set<String> leaveStatuses) {
		this.leaveStatuses = leaveStatuses;
	}
	public Boolean getIncludePastEmployees() {
		return includePastEmployees;
	}
	public void setIncludePastEmployees(Boolean includePastEmployees) {
		this.includePastEmployees = includePastEmployees;
	}
	

}
