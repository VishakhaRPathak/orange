package com.selfw.orangehrm.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

public final class ScreenshotUtils {

	private ScreenshotUtils() {
		
	}
	public static String getScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		return MediaEntityBuilder.createScreenCaptureFromBase64String( ts.getScreenshotAs(OutputType.BASE64)).build().getPath();
		
	}
}
