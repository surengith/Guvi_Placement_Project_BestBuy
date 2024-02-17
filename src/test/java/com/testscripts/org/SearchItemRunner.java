package com.testscripts.org;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.org.SearchItems;
import com.utils.org.BaseClass;

import junit.framework.Assert;

public class SearchItemRunner extends BaseClass {

	public static SearchItems si;

	@Test
	public void searchAddToshoppingCart() throws InterruptedException, IOException {
		si = new SearchItems(driver);
		test = extent.createTest("SearchAddToshoppingCart");
		passInput(si.getSearchBox(), "Apple laptop");
		si.getSearchBox().sendKeys(Keys.ENTER);
		scrollDownorUp("window.scrollBy(0,2000)");
		si.getListOfProducts("MacBook Air 13.6\" Laptop - Apple M2 chip - 8GB Memory - 512GB SSD - Midnight - Midnight",
				"Clicked on the target product: ");
		scrollDownorUp("window.scrollBy(0,2000)");
		clickOnElement(si.getAddToCart());
		sleep(10000);
		clickOnElement(si.getGoToCart());
		takeScreenshot("SearchAddToshoppingCart");
		sleep(3000);
		pageSource("MacBook Air 13.6\" Laptop - Apple M2 chip - 8GB Memory - 512GB SSD - Midnight - Midnight",
				"Search Item Product has been added successfully", "Search Item Product not added to the cart");
		test.log(Status.PASS, "searchAddToshoppingCart test has been passed successfully");
		Assert.assertTrue(true);

	}

}
