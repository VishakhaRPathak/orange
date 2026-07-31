package com.selfw.orangehrm.utility;

import java.time.Instant;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
	private static ExtentReports reports;
	private static ExtentTest test;

	public static void initialize() {
		if (reports == null) {
			String time = Instant.now().toString();
			ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")
					+ "/Reports/ExtentReport_" + time.replace(".", "_").replace(":", "_") + "1.html");
			reports = new ExtentReports();
			reports.attachReporter(reporter);
		}
	}
	
	public static void close() {
		if (reports != null) {
			reports.flush();
		}
	}

	public static void createTest(String description) {
		test =  reports.createTest(description);
	}

	public static void fail(Throwable throwable, String path) {
		test.addScreenCaptureFromPath(path);
		test.fail(throwable);
		
		
	}
	public static void pass(String message) {
		test.pass(message);
	}
	public static void skip(String message) {
		test.skip(message);
	}
	
}
