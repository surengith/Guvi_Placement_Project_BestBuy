package com.testscripts.org;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.org.ShopByDepartment;
import com.utils.org.BaseClass;

import junit.framework.Assert;

public class ShopByDepartmentRunner extends BaseClass {

	public static ShopByDepartment sbd;

	@Test
	public void shopByDepartment() throws InterruptedException, IOException {
		sbd = new ShopByDepartment(driver);
		test = extent.createTest("ShopByDepartment");
		sbd.getMenuButton();
		clickOnElement(sbd.getMenuButton());
		sbd.getShopByDepartment("TV & Home Theater");
		sbd.getAppliancesItem("Projectors & Screens");
		sbd.getSelectProductBrand();
		clickOnElement(sbd.getSelectProductBrand());
		sbd.getSelectProductResolution();
		clickOnElement(sbd.getSelectProductResolution());
		sbd.getSelectProductLumens();
		clickOnElement(sbd.getSelectProductLumens());
		sbd.getProductMinimumRange();
		passInput(sbd.getProductMinimumRange(), "1000");
		sbd.getProductMaximumRange();
		passInput(sbd.getProductMaximumRange(), "1500");
		sbd.getSelectProductRangeButton();
		clickOnElement(sbd.getSelectProductRangeButton());
		sleep(10000);
		//explicitlyWaitAll(20, sbd.getSelectProductAddToCart());
		clickOnElement(sbd.getSelectProductAddToCart());
		explicitlyWait(20, sbd.getProductGoToCart());
		clickOnElement(sbd.getProductGoToCart());
		takeScreenshot("shopByDepartment");
		sleep(3000);
		pageSource("Epson - Pro EX11000 3LCD Full HD 1080p Wireless Laser Projector - Black",
				"Shop by department Product has been added successfully",
				"Shop by department Product not added to the cart");
		test.log(Status.PASS, "shopByDepartment test has been passed successfully");
		Assert.assertTrue(true);
	}

}
