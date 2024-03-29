package com.testscripts.org;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.org.ShopByBrands;
import com.utils.org.BaseClass;

import junit.framework.Assert;

public class ShopByBrandRunner extends BaseClass {

	public static ShopByBrands sb;

	@Test
	public void shopByBrands() throws IOException, InterruptedException {
		sb = new ShopByBrands(driver);
		test = extent.createTest("ShopByBrands");
		sb.getMenuButtonBrands();
		clickOnElement(sb.getMenuButtonBrands());
		sb.getShopByBrands("Brands");
		sb.getShopByBrandName("Sony");
		explicitlyWait(10, sb.getCameraButton());
		clickOnElement(sb.getCameraButton());
		sb.getCameraAccessories();
		clickOnElement(sb.getCameraAccessories());
		sb.getSelectCameraResolution();
		clickOnElement(sb.getSelectCameraResolution());
		sb.getCameraMinimumRange();
		passInput(sb.getCameraMinimumRange(), "1500");
		sb.getCameramaximumRange();
		passInput(sb.getCameramaximumRange(), "3000");
		sb.getSelectCameraRangeButton();
		clickOnElement(sb.getSelectCameraRangeButton());
		sb.getSelectCameraColor();
		clickOnElement(sb.getSelectCameraColor());
		sb.getSelectCameraFocus();
		clickOnElement(sb.getSelectCameraFocus());
		sb.getSelectCameraCondition();
		clickOnElement(sb.getSelectCameraCondition());
		sb.getSelectCameraCurrentDeals();
		clickOnElement(sb.getSelectCameraCurrentDeals());
		sb.getSelectCameraModelFamily();
		clickOnElement(sb.getSelectCameraModelFamily());
		sb.getSelectCustomerRatings();
		clickOnElement(sb.getSelectCustomerRatings());
		sb.getSelectCamera();
		clickOnElement(sb.getSelectCamera());
		scrollDownorUp("window.scrollBy(0,600)");
		explicitlyWait(10, sb.getSelectCameraAddToCart());
		clickOnElement(sb.getSelectCameraAddToCart());
		explicitlyWait(10, sb.getCameraGoToCart());
		clickOnElement(sb.getCameraGoToCart());
		sleep(3000);
		pageSource("Sony - Alpha a7 III Mirrorless [Video]", "Shop by brand Product has been added successfully",
				"Shop by brand Product not added to the cart");
		takeScreenshot("shopByBrands");
		test.log(Status.PASS, "shopByBrands test has been passed successfully");
		Assert.assertTrue(true);
	}

}
