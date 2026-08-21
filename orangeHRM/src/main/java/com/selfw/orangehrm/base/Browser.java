package com.selfw.orangehrm.base;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.selfw.orangehrm.driver.DriverManager;
import com.selfw.orangehrm.utility.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	protected WebDriver driver;
	public static ExtentReports reports;
	
	@BeforeMethod
	public void launchBrowser() {
		ConfigReader.loadProperties();
		String browser = ConfigReader.getProperty("browser");
		System.out.println(browser);
		
		switch(browser.toLowerCase()) {
			case "chrome":
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.password_manager_leak_detection", false);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
		        options.setExperimentalOption("prefs", prefs);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw new InvalidArgumentException("Invalid Browser " + browser);
		}
		DriverManager.setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ConfigReader.getProperty("url"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(driver -> {
	        String value = driver.findElement(By.name("_token")).getAttribute("value");
	        return value != null && !value.isEmpty();
	    });
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
