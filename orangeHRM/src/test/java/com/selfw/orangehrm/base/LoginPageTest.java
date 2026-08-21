package com.selfw.orangehrm.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.selfw.orangehrm.businessconstants.LoginCredentialsInvalid;
import com.selfw.orangehrm.pages.DashboardPage;
import com.selfw.orangehrm.pages.LoginPage;
import com.selfw.orangehrm.utility.ConfigReader;

public class LoginPageTest extends Browser {
	

	@Test(description = "Verify user enters valid credentials")
	public void verifySuccessfulLogin() {
			String title = driver.getTitle();
			Assert.assertEquals(title, "OrangeHRM");
			
			LoginPage loginPage = new LoginPage(driver);
			System.out.println(ConfigReader.getProperty("username"));
			System.out.println(ConfigReader.getProperty("password"));
			DashboardPage dashboardPage = loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
			
			Assert.assertEquals(dashboardPage.getHeader(), "Dashboard");

	}
	@Test(description = "Verify unsuccessful login", dataProvider = "InvalidData", dataProviderClass = LoginCredentialsInvalid.class)
	
	public void verifyUnsuccessfulLogin(String username, String password) {
		
		
		LoginPage loginPage = new LoginPage(driver);


		LoginPage loginPageWithAlert = loginPage.loginInvalid(username, password);
		Assert.assertEquals(loginPageWithAlert.getAlertText(), "Invalid credentials");
	}
}
