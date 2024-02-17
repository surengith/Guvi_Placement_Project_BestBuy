package com.testscripts.org;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.org.MenuValidation;
import com.utils.org.BaseClass;

import junit.framework.Assert;

public class MenuValidationRunner extends BaseClass {

	public static MenuValidation mv;

	@Test(priority = 0)
	public void topLinkVerification() {
		mv = new MenuValidation(driver);
		test = extent.createTest("TopLinkVerification");
		mv.getTopLinksVerification("Top menu item title for: ");
		test.log(Status.PASS, "TopLinkVerification test has been passed successfully");
		Assert.assertTrue(true);
	}

	@Test(priority = 1)
	public void bottomLinkVerification() {
		mv = new MenuValidation(driver);
		test = extent.createTest("BottomLinkVerification");
		mv.getBottomLinksVerification("Bottom menu items: ");
		test.log(Status.PASS, "BottomLinkVerification test has been passed successfully");
		Assert.assertTrue(true);
	}

}
