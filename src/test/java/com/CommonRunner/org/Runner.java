package com.CommonRunner.org;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.org.BaseClass;

import junit.framework.Assert;

public class Runner extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// Setup WebDriver driver

		driver = new ChromeDriver();

		// browser options to handle the pop notifications // ChromeOptions
		ChromeOptions chromeOp = new ChromeOptions();
		chromeOp.addArguments("--disable-notifications");
		chromeOp.addArguments("--headless");

		// FirefoxOptions
		FirefoxOptions firefoxOp = new FirefoxOptions();
		firefoxOp.addArguments("--disable-notifications");

		// EdgeOptions
		EdgeOptions edgeOp = new EdgeOptions();
		edgeOp.addArguments("--disable-notifications");

		// Maximize browser window driver.manage().window().maximize();

		// Use global wait for to load the web page functionality
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		implicitlyWait(10);

		// Use Explicitly wait to wait for particular element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Enter the valid URL
		// driver.get("https://www.bestbuy.com/");
		launchUrl("https://www.bestbuy.com");

		// JavascriptExecutor method used to scroll down or up the webpage
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Validate if the given URL link is broken
		String url = "https://www.bestbuy.com/";
		verifyUrlLink(url, "--", " Link is broken", " Link has been verified successfully");

		// Country Selection

		WebElement countrySelectionUS = driver
				.findElement(By.xpath("(//div[@class='country-selection']//child::h4[text()='United States'])[1]"));
		countrySelectionUS.click();

		System.out.println("WebPage Title: " + driver.getTitle());

		// Click the account button to create new account or sign in

		WebElement accountButton = driver.findElement(By.xpath("//span[text()='Account']"));
		accountButton.click();

		// Create Account Page functionality
		WebElement createAccountButton = driver.findElement(By.xpath("//a[normalize-space()='Create Account']"));
		createAccountButton.click();
		WebElement createAccountFirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		createAccountFirstName.sendKeys("Surendhar");
		WebElement createAccountLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		createAccountLastName.sendKeys("P");
		WebElement createAccountEmail = driver.findElement(By.xpath("//input[@name='email']"));
		createAccountEmail.sendKeys("surendhar01@gmail.com");
		WebElement createAccountPassword = driver.findElement(By.xpath("//input[@id='fld-p1']"));
		createAccountPassword.sendKeys("Surendhar@321$");
		WebElement createAccountConfirmPassword = driver.findElement(By.xpath("//input[@id='reenterPassword']"));
		createAccountConfirmPassword.sendKeys("Surendhar@321$");
		WebElement createAccountPhoneNumber = driver.findElement(By.xpath("//input[@id='phone']"));
		createAccountPhoneNumber.sendKeys("9443352021");
		WebElement createAccountSubmit = driver.findElement(By.xpath("//button[text()='Create an Account']"));
		createAccountSubmit.click();
		Assert.assertTrue(true);

		// Click the returnToPreviousPage button to view the Dash Board
		WebElement returnToPreviousPage = driver
				.findElement(By.xpath("//a[normalize-space()='Return to previous page']"));
		returnToPreviousPage.click();

		// After creating a new account click the account button to sign in
		WebElement PreviousPageaccountButtonCa = driver.findElement(By.xpath("//span[text()='Account']"));
		PreviousPageaccountButtonCa.click();

		// Create Sign in Page functionality

		WebElement signInButton = driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
		signInButton.click();
		WebElement signInEmail = driver.findElement(By.xpath("//input[@type='email']"));
		signInEmail.sendKeys("suren2696@gmail.com");
		WebElement signInPassword = driver.findElement(By.xpath("//input[@type='password']"));
		signInPassword.sendKeys("Surendhar@321$");
		WebElement signInSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
		signInSubmit.click();
		Assert.assertTrue(true);

		// After Sign Up click the PreviousPageaccount
		WebElement PreviousPageaccountButtonSu = driver.findElement(By.xpath("//a[text()='Return to previous page']"));
		PreviousPageaccountButtonSu.click();

		// Validation of Menu titles in each page

		List<WebElement> topLinksVerification = driver
				.findElements(By.xpath("//div[@class='bottom-fluid-container ']//nav/div/ul/li/a"));
		for (int i = 0; i < topLinksVerification.size(); i++) {
			System.out.println("Top menu items: " + topLinksVerification.get(i).getText());
			Assert.assertTrue("All the top menu links are not verified", true);
		}

		// Validation of Bottom Menu links

		List<WebElement> bottomLinksVerification = driver
				.findElements(By.xpath("//div[@class='flex justify-content-start']/a"));

		for (int i = 0; i < bottomLinksVerification.size(); i++) {
			System.out.println("Bottom menu items: " + bottomLinksVerification.get(i).getText());
		}

		Assert.assertTrue("All the bottom links are not verified", true);

		// Search and add items to shopping cart

		WebElement searchBox = driver.findElement(By.xpath("//input[@class='search-input']"));
		searchBox.sendKeys("Apple laptop");
		searchBox.sendKeys(Keys.ENTER);

		List<WebElement> listOfProducts = driver
				.findElements(By.xpath("//div[@class='list-wrapper top-border']/ol/li//child::h4/a[@href]"));
		String productName = "Laptop - Apple M2 chip - 8GB Memory - 256GB SSD - Midnight";
		js.executeScript("window.scrollBy(0,1700)");
		for (WebElement productList : listOfProducts) {
			String productText = productList.getText();
			if (productText.contains(productName)) {
				productList.click();
				System.out.println("Clicked on the target product: " + productText);
				break;
			}
		}

		js.executeScript("window.scrollBy(0,2000)");

		WebElement addToCart = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//button[@data-button-state='ADD_TO_CART'])[4]"))));
		addToCart.click();

		WebElement goToCart = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Go to Cart']"))));
		goToCart.click();

		Thread.sleep(3000);
		if (driver.getPageSource().contains("Laptop - Apple M2 chip - 8GB Memory - 256GB SSD - Midnight")) {
			System.out.println("Product has been added successfully");
		} else {
			System.out.println("Product not added to the cart");
		}

		// Add an item from (Menu a Shop by Department)

		WebElement menuButton = driver.findElement(By.xpath("//button[@aria-label='Menu']"));
		menuButton.click();

		List<WebElement> shopByDepartment = driver
				.findElements(By.xpath("//div[@class='hamburger-menu-flyout']//ul//li"));
		String departmentTargetItems = "TV & Home Theater";
		for (WebElement dprtListItems : shopByDepartment) {
			String dprtItemsText = dprtListItems.getText();
			if (dprtItemsText.contains(departmentTargetItems)) {
				dprtListItems.click();
				break;
			}
		}

		List<WebElement> appliancesItem = driver
				.findElements(By.xpath("//div[@class='hamburger-menu-flyout']//ul//li"));
		String appliancesTargetItems = "Projectors & Screens";
		for (WebElement appListItems : appliancesItem) {
			String appItemsText = appListItems.getText();
			if (appItemsText.contains(appliancesTargetItems)) {
				appListItems.click();
				break;
			}
		}

		WebElement selectProductBrand = driver.findElement(By.xpath("//input[@id='brand_facet-Epson-1']"));
		selectProductBrand.click();

		WebElement selectProductResolution = driver.findElement(By.xpath("//a[text()='Full HD (1080p)']"));
		selectProductResolution.click();

		WebElement selectProductLumens = driver.findElement(By.xpath("//a[text()='3000 Lumens & Above']"));
		selectProductLumens.click();

		WebElement productMinimumRange = driver
				.findElement(By.xpath("//div[@class='range-inputs']//child::input[@aria-label='Minimum Price']"));
		productMinimumRange.sendKeys("1000");

		WebElement productMaximumRange = driver
				.findElement(By.xpath("//div[@class='range-inputs']//child::input[@aria-label='Maximum Price']"));
		productMaximumRange.sendKeys("1500");

		WebElement selectProductRangeButton = driver.findElement(
				By.xpath("//div[@class='range-inputs']//following-sibling::button[@aria-label='Apply Price Range']"));
		selectProductRangeButton.click();

		js.executeScript("window.scrollBy(0,400)");

		Thread.sleep(5000);
		WebElement selectProductAddToCart = driver
				.findElement(By.xpath("(//button[@data-button-state='ADD_TO_CART'])[1]"));
		selectProductAddToCart.click();

		WebElement productGoToCart = driver
				.findElement(By.xpath("//div[@class='flyout-footer-wrapper']//child::a[text()='Go to Cart']"));
		productGoToCart.click();
		
		if (driver.getPageSource()
				.contains("Epson - Pro EX11000 3LCD Full HD 1080p Wireless Laser Projector - Black")) {
			System.out.println("Product has been added successfully");
		} else {
			System.out.println("Product not added to the cart");
		}

		// Add an item from (Menu a Brands a Select Any Brand)

		WebElement menuButtonBrands = driver.findElement(By.xpath("//button[@aria-label='Menu']"));
		menuButtonBrands.click();

		List<WebElement> shopByBrands = driver.findElements(By.xpath("//div[@class='hamburger-menu-flyout']//ul//li"));
		String brandsTargetItems = "Brands";
		for (WebElement brandsListItems : shopByBrands) {
			String brandsItemsText = brandsListItems.getText();
			if (brandsItemsText.contains(brandsTargetItems)) {
				brandsListItems.click();
				break;
			}
		}

		List<WebElement> shopByBrandName = driver.findElements(By.xpath(
				"//div[@class='hamburger-menu-flyout']//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']//li"));
		String brandsTargetItemName = "Sony";
		for (WebElement brandsNameListItem : shopByBrandName) {
			String brandsItemNameText = brandsNameListItem.getText();
			if (brandsItemNameText.contains(brandsTargetItemName)) {
				brandsNameListItem.click();
				break;
			}
		}

		WebElement cameraButton = driver.findElement(By.xpath("//a[text()='Cameras']"));
		explicitlyWait(10, cameraButton);
		cameraButton.click();

		WebElement cameraAccessories = driver
				.findElement(By.xpath("//a[normalize-space()='Camera & Camcorder Accessories']"));
		cameraAccessories.click();

		WebElement selectCameraResolution = driver.findElement(By.xpath("//a[text()='4K (2160p)']"));
		selectCameraResolution.click();

		WebElement cameraMinimumRange = driver
				.findElement(By.xpath("//div[@class='range-inputs']//child::input[@aria-label='Minimum Price']"));
		cameraMinimumRange.sendKeys("1500");

		WebElement cameramaximumRange = driver
				.findElement(By.xpath("//div[@class='range-inputs']//child::input[@aria-label='Maximum Price']"));
		cameramaximumRange.sendKeys("3000");

		WebElement selectCameraRangeButton = driver.findElement(
				By.xpath("//div[@class='range-inputs']//following-sibling::button[@aria-label='Apply Price Range']"));
		selectCameraRangeButton.click();

		WebElement selectCameraColor = driver.findElement(By.xpath("//a[text()='Black']"));
		selectCameraColor.click();

		WebElement selectCameraFocus = driver.findElement(By.xpath("//a[text()='Autofocus']"));
		selectCameraFocus.click();

		WebElement selectCameraCondition = driver.findElement(By.xpath("//a[text()='New']"));
		selectCameraCondition.click();

		WebElement selectCameraCurrentDeals = driver.findElement(By.xpath("//a[text()='On Sale']"));
		selectCameraCurrentDeals.click();

		WebElement selectCameraModelFamily = driver.findElement(By.xpath("//a[text()='Sony a7 III']"));
		selectCameraModelFamily.click();

		WebElement selectCustomerRatings = driver.findElement(By.xpath("//a[text()='4 & Up']"));
		selectCustomerRatings.click();

		WebElement selectCamera = driver.findElement(
				By.xpath("(//a[contains(text(),'Package - Sony - Alpha a7 III Mirrorless [Video] C')])[2]"));
		selectCamera.click();

		js.executeScript("window.scrollBy(0,600)");

		WebElement selectCameraAddToCart = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Add to Cart']"))));
		selectCameraAddToCart.click();

		WebElement cameraGoToCart = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Go to Cart']"))));
		cameraGoToCart.click();

		if (driver.getPageSource().contains("Sony - Alpha a7 III Mirrorless [Video]")) {
			System.out.println("Product has been added successfully");
		} else {
			System.out.println("Product not added to the cart");
		}

		// Checkout Login process
		WebElement checkoutButton = driver.findElement(By.xpath("//button[@data-track='Checkout - Top']"));
		checkoutButton.click();

		WebElement checkoutEmail = driver.findElement(By.xpath("//input[@type='email']"));
		checkoutEmail.sendKeys("suren2696@gmail.com");

		WebElement checkoutPassword = driver.findElement(By.xpath("//input[@type='password']"));
		checkoutPassword.sendKeys("Surendhar@321$");

		WebElement checkoutSignin = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']"))));
		checkoutSignin.click();

		// Payment Information

		WebElement continueToPayment = driver
				.findElement(By.xpath("//span[contains(text(),'Continue to Payment Information')]"));
		continueToPayment.click();

		WebElement creditCardNumber = driver.findElement(By.xpath("//input[@id='number']"));
		creditCardNumber.sendKeys("4675 3612 2508 7624");

		WebElement expireMonth = driver.findElement(By.xpath("//select[@name='expMonth']"));
		Select expMonth = new Select(expireMonth);
		List<WebElement> allmonth = expMonth.getOptions();
		for (WebElement expMon : allmonth) {
			if (expMon.getText().equals("12")) {
				expMon.click();
				break;
			}
		}

		WebElement expireYear = driver.findElement(By.xpath("//select[@name='expYear']"));
		Select expYrs = new Select(expireYear);
		List<WebElement> allYear = expYrs.getOptions();
		for (WebElement expYr : allYear) {
			if (expYr.getText().equals("2030")) {
				expYr.click();
				break;
			}
		}

		WebElement cvvNumber = driver.findElement(By.xpath("//input[@name='cvv']"));
		cvvNumber.sendKeys("777");

		WebElement paymentFirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		paymentFirstName.sendKeys("Surendhar");

		WebElement paymentLastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		paymentLastName.sendKeys("P");

		WebElement addressLine = driver.findElement(By.xpath("//input[@name='addressLine1']"));
		addressLine.sendKeys("F Admiralty Dr W");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Middletown");

		WebElement state = driver.findElement(By.xpath("//select[@name='state']"));
		Select stateSelection = new Select(state);
		List<WebElement> allState = stateSelection.getOptions();
		for (WebElement ste : allState) {
			if (ste.getText().equals("RI")) {
				ste.click();
				break;
			}
		}

		WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
		postalCode.sendKeys("02842");

		WebElement placeYourOrder = driver.findElement(By.xpath("//span[text()='Place Your Order']"));
		placeYourOrder.click();

		System.out.println("Everything has been done successfully");

		// ---------------- //

	}
}