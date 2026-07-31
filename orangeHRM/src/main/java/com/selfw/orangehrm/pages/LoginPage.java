package com.selfw.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selfw.orangehrm.utility.WaitUtils;

public class LoginPage {
	WebDriver driver;
	
	By txtUsername = By.name("username");
	By txtPasswordField = By.name("password");
	By btnLogin = By.xpath("//button[normalize-space()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public DashboardPage login(String username, String password) {
		WaitUtils.waitForElementClickable(driver,txtUsername).sendKeys(username);
		driver.findElement(txtPasswordField).sendKeys(password);
		WaitUtils.waitForElementClickable(driver, btnLogin).click();
		return new DashboardPage(driver);
	}
	
}
