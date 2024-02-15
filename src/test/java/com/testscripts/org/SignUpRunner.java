package com.testscripts.org;

import java.io.IOException;
import org.testng.annotations.Test;
import com.pages.org.SignUp;
import com.utils.org.BaseClass;
import com.utils.org.ExcelUtils;

import junit.framework.Assert;

public class SignUpRunner extends BaseClass {

	public static SignUp sin;

	@Test(priority = 0)
	public void signUpValidCredentials() throws IOException {
		sin = new SignUp(driver);
		clickOnElement(sin.getAccountButton());
		clickOnElement(sin.getSignInButton());
		passInput(sin.getSignInEmail(), ExcelUtils.ExcelUtils("Sheet1", 6, 0));
		passInput(sin.getSignInPassword(), ExcelUtils.ExcelUtils("Sheet1", 6, 1));
		clickOnElement(sin.getSignInSubmit());
		timeOut(2000);
		takeScreenshot("signUpValidCredentials");
		clickOnElement(sin.getSignUpReturnPreviousPage());
		Assert.assertTrue(true);
	}

	@Test(priority = 1)
	public void signUpInValidCredentials() throws IOException {
		sin = new SignUp(driver);
		clickOnElement(sin.getAccountButton());
		clickOnElement(sin.getSignInButton());
		passInput(sin.getSignInEmail(), ExcelUtils.ExcelUtils("Sheet1", 7, 0));
		passInput(sin.getSignInPassword(), ExcelUtils.ExcelUtils("Sheet1", 7, 1));
		clickOnElement(sin.getSignInSubmit());
		timeOut(2000);
		takeScreenshot("signUpInValidCredentials");
		clickOnElement(sin.getSignUpReturnPreviousPage());
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void signUpEmptyCredentials() throws IOException {
		sin = new SignUp(driver);
		clickOnElement(sin.getAccountButton());
		clickOnElement(sin.getSignInButton());
		passInput(sin.getSignInEmail(), "");
		passInput(sin.getSignInPassword(), "");
		clickOnElement(sin.getSignInSubmit());
		timeOut(2000);
		takeScreenshot("signUpEmptyCredentials");
		clickOnElement(sin.getSignUpReturnPreviousPage());
		Assert.assertTrue(true);
	}
}
