package com.selfw.orangehrm.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
	WebDriver driver;
	By locator;
	public CheckBox(WebDriver driver, String labelText) {
		this.driver = driver;
		this.locator = checkByText(labelText);
	}
	private By checkByText(String labelText) {
    	return By.xpath("//p[normalize-space()='"+labelText+"']"
    			+ "/parent::div[contains(@class, 'oxd-grid-item')]"
    			+ "/descendant::input[@type='checkbox']");
    }
	public void set(boolean value) {
		WebElement element = driver.findElement(locator);
	    if (element.isSelected() != value) {
	        element.click();
	    }

	}

}
