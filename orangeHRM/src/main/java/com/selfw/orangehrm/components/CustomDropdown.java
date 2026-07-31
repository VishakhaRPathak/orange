package com.selfw.orangehrm.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selfw.orangehrm.utility.WaitUtils;

public class CustomDropdown {
	private final String labelText;
	private final WebDriver driver; 
	
	private final By selectedItems = By.xpath("//span[contains(@class, 'oxd-multiselect-chips-selected')]");
	private final By clearSelected = By.xpath("//i[contains(@class,'--clear')]");
	private final By listBox = By.xpath("//div[@role='listbox']");
	
	public CustomDropdown(WebDriver driver, String labelText) {
		this.driver = driver;
		this.labelText = labelText;
	}
	private By toggleOpenCloseByLabel() {
	
		return By.xpath("//label[normalize-space()='"+labelText+"']"
			+ "/ancestor::div[contains(@class, 'oxd-input-group')]"
			+ "/descendant::div[contains(@class, 'oxd-select-text--focus')]");
	}

	private By optionByText(String option) {
		return By.xpath(
				"//div[contains(@class,'oxd-select-option')]//span[normalize-space()='"+option+"']"
				);
	}
	private void open() {
		List<WebElement> elements = driver.findElements(listBox);
		if(elements.size()==0) {
			WaitUtils.waitForElementClickable(driver, toggleOpenCloseByLabel()).click();
		}
	}
	private void close() {
		List<WebElement> elements = driver.findElements(listBox);
		if(elements.size()>0) {
			WaitUtils.waitForElementClickable(driver, toggleOpenCloseByLabel()).click();
		}
	}
	public void select(String option){
		open();
				
		WaitUtils.waitForElementVisible(driver, listBox);
		WaitUtils.waitForElementClickable(driver, optionByText(option)).click();
	}

	}
