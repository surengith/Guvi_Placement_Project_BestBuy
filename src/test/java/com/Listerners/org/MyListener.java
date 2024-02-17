package com.Listerners.org;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Method started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Method passed: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Method failed: " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped: " + result.getName());
	}

	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");
	}

	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}
}
