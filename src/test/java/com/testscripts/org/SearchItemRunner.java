package com.testscripts.org;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.pages.org.SearchItems;
import com.utils.org.BaseClass;

public class SearchItemRunner extends BaseClass {

	public static SearchItems si;

	@Test
	public void searchAddToshoppingCart() throws InterruptedException {
		si = new SearchItems(driver);
		passInput(si.getSearchBox(), "Apple laptop");
		si.getSearchBox().sendKeys(Keys.ENTER);
		scrollDownorUp("window.scrollBy(0,1700)");
		si.getListOfProducts("Laptop - Apple M2 chip - 8GB Memory - 256GB SSD - Midnight",
				"Clicked on the target product: ");
		scrollDownorUp("window.scrollBy(0,2100)");
		explicitlyWait(10, si.getAddToCart());
		clickOnElement(si.getAddToCart());
		Thread.sleep(6000);
		explicitlyWait(10, si.getGoToCart());
		clickOnElement(si.getGoToCart());
		pageSource("Laptop - Apple M2 chip - 8GB Memory - 256GB SSD - Midnight", "Search Item Product has been added successfully",
				"Search Item Product not added to the cart");
	}

}
