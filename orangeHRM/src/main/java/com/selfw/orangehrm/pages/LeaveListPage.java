package com.selfw.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.selfw.orangehrm.businessconstants.LeaveListFieldNames;
import com.selfw.orangehrm.components.AutoComplete;
import com.selfw.orangehrm.components.CheckBox;
import com.selfw.orangehrm.components.CustomDropdown;
import com.selfw.orangehrm.components.DatePicker;
import com.selfw.orangehrm.components.MultiSelectDropdown;
import com.selfw.orangehrm.components.ResultsTable;
import com.selfw.orangehrm.models.LeaveSearchCriteria;

public class LeaveListPage {
	
		private WebDriver driver;

	    private final MultiSelectDropdown msdLeaveStatus;
	    private final CustomDropdown cdSubUnit;
	    private final CustomDropdown cdLeaveType;
	    private final DatePicker dpFromDate;
	    private final DatePicker dpToDate;

	    private final AutoComplete acEmployee;
	    
	    
	    private final By btnSearchLocator = By.xpath("//button[@type='submit']");
		private CheckBox includePastEmployees;
		private ResultsTable resultsTable;
	    
	    public LeaveListPage(WebDriver driver) {
	    	msdLeaveStatus = new MultiSelectDropdown(driver, LeaveListFieldNames.SHOWLEAVEWITHSTATUS.fieldName());
	    	cdSubUnit = new CustomDropdown(driver, LeaveListFieldNames.SUBUNIT.fieldName());
	    	cdLeaveType = new CustomDropdown(driver, LeaveListFieldNames.LEAVETYPE.fieldName());
	    	dpFromDate = new DatePicker(driver, LeaveListFieldNames.FROMDATE.fieldName());
	    	dpToDate = new DatePicker(driver, LeaveListFieldNames.TODATE.fieldName());
	    	acEmployee = new AutoComplete(driver, LeaveListFieldNames.EMPLOYEENAME.fieldName());
	    	includePastEmployees = new CheckBox(driver, (LeaveListFieldNames.INCLUDEPASTEMPLOYEES).fieldName());
	    			
	    }
	    
	    public ResultsTable search(LeaveSearchCriteria criteria) {

	        if (criteria.getEmployeeName() != null) {
	        	acEmployee.selectValue(criteria.getEmployeeName());
	        }

	        if (criteria.getFromDate() != null) {
	        	dpFromDate.selectDate(criteria.getFromDate());
	        }

	        if (criteria.getToDate() != null) {
	        	dpToDate.selectDate(criteria.getToDate());
	        }

	        if (criteria.getLeaveStatuses() != null) {
	        	msdLeaveStatus.select(criteria.getLeaveStatuses().toArray(new String[0]));
	        }

	        if (criteria.getLeaveType() != null) {
	        	cdLeaveType.select(criteria.getLeaveType());
	        }

	        if (criteria.getSubUnit() != null) {
	        	cdSubUnit.select(criteria.getSubUnit());
	        }

	        if (criteria.getIncludePastEmployees() != null) {
	            includePastEmployees.set(criteria.getIncludePastEmployees());
	        }

	        driver.findElement(btnSearchLocator).click();

	        return resultsTable;
	    }
	
}
	
