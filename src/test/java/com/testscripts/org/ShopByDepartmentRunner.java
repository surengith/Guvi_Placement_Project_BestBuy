package com.testscripts.org;

import org.testng.annotations.Test;
import com.pages.org.ShopByDepartment;
import com.utils.org.BaseClass;

public class ShopByDepartmentRunner extends BaseClass {

	public static ShopByDepartment sbd;

	@Test
	public void shopByDepartment() throws InterruptedException {
		sbd = new ShopByDepartment(driver);
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

		Thread.sleep(10000);
		explicitlyWaitAll(15, sbd.getSelectProductAddToCart());
		clickOnElement(sbd.getSelectProductAddToCart());

		explicitlyWait(10, sbd.getProductGoToCart());
		clickOnElement(sbd.getProductGoToCart());

		pageSource("Epson - Pro EX11000 3LCD Full HD 1080p Wireless Laser Projector - Black",
				"Shop by department Product has been added successfully",
				"Shop by department Product not added to the cart");
	}

}