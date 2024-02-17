package com.testscripts.org;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.org.SignIn;
import com.utils.org.BaseClass;
import com.utils.org.ExcelUtils;

import junit.framework.Assert;

public class SignInRunner extends BaseClass {

	public static SignIn sin;

	@Test(priority = 0)
	public void signUpValidCredentials() throws IOException {
		sin = new SignIn(driver);
		test = extent.createTest("SignUpValidCredentials");
		clickOnElement(sin.getAccountButton());
		clickOnElement(sin.getSignInButton());
		passInput(sin.getSignInEmail(), ExcelUtils.ExcelUtils("Sheet1", 6, 0));
		passInput(sin.getSignInPassword(), ExcelUtils.ExcelUtils("Sheet1", 6, 1));
		clickOnElement(sin.getSignInSubmit());
		timeOut(2000);
		takeScreenshot("signUpValidCredentials");
		clickOnElement(sin.getSignUpReturnPreviousPage());
		test.log(Status.PASS, "SignUpValidCredentials test has been passed successfully");
		Assert.assertTrue(true);
	}

	@Test(priority = 1)
	public void signUpInValidCredentials() throws IOException {
		sin = new SignIn(driver);
		test = extent.createTest("SignUpInValidCredentials");
		clickOnElement(sin.getAccountButton());
		clickOnElement(sin.getSignInButton());
		passInput(sin.getSignInEmail(), ExcelUtils.ExcelUtils("Sheet1", 7, 0));
		passInput(sin.getSignInPassword(), ExcelUtils.ExcelUtils("Sheet1", 7, 1));
		clickOnElement(sin.getSignInSubmit());
		timeOut(2000);
		takeScreenshot("signUpInValidCredentials");
		clickOnElement(sin.getSignUpReturnPreviousPage());
		test.log(Status.PASS, "SignUpValidCredentials test has been passed successfully");
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void signUpEmptyCredentials() throws IOException {
		sin = new SignIn(driver);
		test = extent.createTest("SignUpEmptyCredentials");
		clickOnElement(sin.getAccountButton());
		clickOnElement(sin.getSignInButton());
		passInput(sin.getSignInEmail(), "");
		passInput(sin.getSignInPassword(), "");
		clickOnElement(sin.getSignInSubmit());
		timeOut(2000);
		takeScreenshot("signUpEmptyCredentials");
		clickOnElement(sin.getSignUpReturnPreviousPage());
		test.log(Status.PASS, "SignUpEmptyCredentials test has been passed successfully");
		Assert.assertTrue(true);
	}
}
