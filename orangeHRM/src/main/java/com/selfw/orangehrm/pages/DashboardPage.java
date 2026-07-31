package com.selfw.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selfw.orangehrm.utility.WaitUtils;

public class DashboardPage {
	private By header = By.xpath("//div[contains(@class, 'oxd-topbar-header-title')]");
	private WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getHeader() {
		return WaitUtils.waitForElementVisible(driver, header).getText();
	}

}
