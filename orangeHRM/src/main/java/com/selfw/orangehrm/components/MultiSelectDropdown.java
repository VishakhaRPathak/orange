package com.selfw.orangehrm.components;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiSelectDropdown extends CustomDropdown {
	private final String labelText;
	private final WebDriver driver; 
	
	private final By selectedItems = By.xpath("//span[contains(@class, 'oxd-multiselect-chips-selected')]");
	private final By clearSelected = By.xpath("//i[contains(@class,'--clear')]");

	public MultiSelectDropdown(WebDriver driver, String labelText) {
		super(driver, labelText);
		this.driver = driver;
		this.labelText = labelText;
	}
	public void select(String... options) {
		for(String option: options) {
			select(option);
		}
	}

	private void clearSelection() {
		while(driver.findElements(clearSelected).size()>0){
		    driver.findElements(clearSelected).get(0).click();
		}
	}

	public String[] getSelectedValues() {
		List<WebElement> elementSelected = driver.findElements(selectedItems);
		
		return elementSelected.stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
	}

	public boolean isOptionSelected(String option) {
		return Arrays.asList(getSelectedValues()).contains(option);
	}


}
