package com.selfw.orangehrm.components;

import java.time.LocalDate;
import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selfw.orangehrm.utility.WaitUtils;

public class DatePicker {
	private final WebDriver driver;
	private String labelText = "";

	private final By btnPreviousMonth = By.xpath("//i[contains(@class,'bi-chevron-left')]"
			+ "//parent::button[contains(@class,'oxd-icon-button') and not(@role='none')]");

	private final By btnNextMonth = By.xpath("//i[contains(@class,'bi-chevron-right')]" 
					+ "//parent::button[contains(@class,'oxd-icon-button')]");
	private final By pMonthSelected = By.xpath("//li[contains(@class, 'oxd-calendar-selector-month')]"
					+ "//p[contains(@class,'oxd-text--p')]");
	private final By pYearSelected = By
			.xpath("//li[contains(@class, 'oxd-calendar-selector-year')]"
					+ "//p[contains(@class,'oxd-text--p')]");
	private final By liOpenMonthDropdown = By.xpath("//li[contains(@class, 'oxd-calendar-selector-month')]");
	private final By liOpenYearDropdown = By.xpath("//li[contains(@class, 'oxd-calendar-selector-year')]");
	private final By dateSelected = By
			.xpath("//div[contains(@class, 'oxd-calendar-date') and contains(@class, '--selected')]");
	private final By drpdSelected = By
			.xpath("//li[contains(@class, 'oxd-calendar-dropdown--option') and contains(@class, '--selected')]");

	private final By btnToday = By
			.xpath("//div[contains(@class, 'oxd-date-input-link') and contains(@class, '--today')]");
	private final By btnClear = By
			.xpath("//div[contains(@class, 'oxd-date-input-link') and contains(@class, '--clear')]");
	private final By btnClose = By
			.xpath("//div[contains(@class, 'oxd-date-input-link') and contains(@class, '--close')]");

	private final String divDateValue = "//div[contains(@class,'oxd-calendar-date') and normalize-space()='%s']";
	

	public DatePicker(WebDriver driver, String labelText) {
		this.driver = driver;
		this.labelText = labelText;
	}

	public void selectDate(LocalDate date) {
		
		enterDate(date);
	}

	public void enterDate(LocalDate date) {
		driver.findElement(txtDateField()).clear();
		WaitUtils.waitForElementClickable(driver, txtDateField()).sendKeys(date.toString());

	}

	
	public void pickDate(LocalDate date) {
		WaitUtils.waitForElementClickable(driver, iconCalendar()).click();
		WaitUtils.waitForElementClickable(driver, liOpenYearDropdown).click();
		WaitUtils.waitForElementClickable(driver,optionByText(String.valueOf(date.getYear()))).click();
		driver.findElement(liOpenMonthDropdown).click();
		WaitUtils.waitForElementClickable(driver,optionByText(String.valueOf(date.getMonth()))).click();;
		WaitUtils.waitForElementClickable(driver,By.xpath(String.format(divDateValue, date.getDayOfMonth()))).click();
	}

	private void nextMonth() {
		WaitUtils.waitForElementClickable(driver,btnNextMonth).click();
	}

	private void previousMonth() {
		WaitUtils.waitForElementClickable(driver,btnPreviousMonth).click();
	}

	private By optionByText(String text) {
		return By
				.xpath("//li[contains(@class, 'oxd-calendar-dropdown--option')"
						+ " and (normalize-space()='" + text + "')]");
	}

	private By txtDateField() {
	    return By.xpath("//label[normalize-space()='" + labelText + "']"
	    				+"//ancestor::div[contains(@class,'oxd-input-group')]"
	    				+"//input[contains(@class, 'oxd-input')]");
	        
	}
	private By iconCalendar() {
		return By.xpath("//label[normalize-space()='"+labelText+"']"
			+ "//ancestor::div[contains(@class,'oxd-input-group')]"
			+ "//i[contains(@class, 'oxd-icon')]");
	}
	
	public LocalDate getSelectedDate() {
		String selDate = driver.findElement(dateSelected).getText();
		Month selMonth = Month.valueOf(driver.findElement(pMonthSelected).getText().toUpperCase());

		String selYear = driver.findElement(pYearSelected).getText();

		return LocalDate.of(Integer.parseInt(selYear), selMonth.getValue(), Integer.parseInt(selDate));
	}

	public void selectToday() {
		WaitUtils.waitForElementClickable(driver, btnToday).click();
	}

	public void clearDate() {
		WaitUtils.waitForElementClickable(driver, btnClear).click();
	}
	
//	private final By drpdOption = By.xpath("//li[contains(@class, 'oxd-calendar-dropdown--option') and (normalize-space()='%s']");
//	private final By btnYearDropdown = By.xpath("//li[contains(@class, 'oxd-calendar-selector-year')]//i[contains(@class,'oxd-icon')]");
//	private final By divOpenYearDropdown = By.xpath("//div[contains(@class, 'oxd-calendar-selector-month-selected')]");

}
