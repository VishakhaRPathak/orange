package com.selfw.orangehrm.base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.selfw.orangehrm.driver.DriverManager;
import com.selfw.orangehrm.utility.ConfigReader;
import com.selfw.orangehrm.utility.ReportUtils;
import com.selfw.orangehrm.utility.ScreenshotUtils;

public class BaseTest {
	@BeforeSuite
	public void initiateExtentReport() {
		ReportUtils.initialize();
	}
	@BeforeSuite
	public void loadProperties() {
		ConfigReader.loadProperties();
	}
	@BeforeMethod
	public void createTest(Method method) {
		ReportUtils.createTest(method.getName());
	}
	@AfterMethod
	public void endTest(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			String path = ScreenshotUtils.getScreenshot(DriverManager.getDriver());
			ReportUtils.fail(result.getThrowable(), path);
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			ReportUtils.pass("Testcase passed");
		}else if(result.getStatus() == ITestResult.SKIP) {
			ReportUtils.skip("Testcase skipped");
		}
	}
	@AfterSuite
	public void stopExtentReport() {
		ReportUtils.close();
	}
}
