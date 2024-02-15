package com.testscripts.org;

import org.testng.annotations.Test;
import com.pages.org.MenuValidation;
import com.utils.org.BaseClass;

import junit.framework.Assert;

public class MenuValidationRunner extends BaseClass {

	public static MenuValidation mv;

	@Test(priority = 0)
	public void topLinkVerification() {
		mv = new MenuValidation(driver);
		mv.getTopLinksVerification("Top menu items: ", "All the top menu links are not verified");
		Assert.assertTrue("All the top menu links are not verified", true);
	}
	
	@Test(priority = 1)
	public void bottomLinkVerification() {
		mv = new MenuValidation(driver);
		mv.getBottomLinksVerification("Bottom menu items: ", "All the top menu links are not verified");
		Assert.assertTrue("All the bottom links are not verified", true);
	}
	
}
