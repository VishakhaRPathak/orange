package com.selfw.orangehrm.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtils {
	
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("waitTime")));
	private static WebDriverWait createWait(WebDriver driver) {
		return new WebDriverWait(driver, DEFAULT_TIMEOUT);
	}
	
	private WaitUtils() {
        // Prevent instantiation
    }

	public static WebElement waitForElementClickable(WebDriver driver, By locator) {
		return createWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static WebElement waitForElementVisible(WebDriver driver, By locator) {
		return createWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static boolean waitForElementInvisible(WebDriver driver, By locator) {
		return createWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static boolean waitForText(WebDriver driver, By locator,  String text) {
		return createWait(driver).until(ExpectedConditions.textToBe(locator, text));
	}
}
