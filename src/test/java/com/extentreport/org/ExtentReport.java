package com.extentreport.org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports extentReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				"C:\\Users\\Surendhar\\eclipse-workspace\\BestBuy-E-Commerce-Project\\extentreport\\TestReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest test = extent.createTest("TestCase001");
		test.pass("Test is passed");
		test.fail("Test is failed");
		extent.flush();
		return extent;
	}
}
