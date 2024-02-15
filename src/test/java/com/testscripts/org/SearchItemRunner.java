package com.testscripts.org;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.pages.org.SearchItems;
import com.utils.org.BaseClass;

public class SearchItemRunner extends BaseClass {

	public static SearchItems si;

	@Test
	public void searchAddToshoppingCart() throws InterruptedException, IOException {
		si = new SearchItems(driver);
		passInput(si.getSearchBox(), "Apple laptop");
		si.getSearchBox().sendKeys(Keys.ENTER);
		scrollDownorUp("window.scrollBy(0,1800)");
		si.getListOfProducts("MacBook Air 13.6\" Laptop - Apple M2 chip - 8GB Memory - 512GB SSD - Midnight - Midnight",
				"Clicked on the target product: ");
		scrollDownorUp("window.scrollBy(0,2000)");
		explicitlyWait(15, si.getAddToCart());
		clickOnElement(si.getAddToCart());
		explicitlyWait(15, si.getGoToCart());
		clickOnElement(si.getGoToCart());
		takeScreenshot("searchAddToshoppingCart");
		sleep(3000);
		pageSource("MacBook Air 13.6\" Laptop - Apple M2 chip - 8GB Memory - 512GB SSD - Midnight - Midnight", "Search Item Product has been added successfully",
				"Search Item Product not added to the cart");
	}

}
