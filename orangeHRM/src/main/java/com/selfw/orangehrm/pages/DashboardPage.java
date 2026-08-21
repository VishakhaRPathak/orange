package com.selfw.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selfw.orangehrm.utility.WaitUtils;

public class DashboardPage {
	private By header = By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]");
	private WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getHeader() {
		return WaitUtils.waitForElementVisible(driver, header).getText();
	}

}
