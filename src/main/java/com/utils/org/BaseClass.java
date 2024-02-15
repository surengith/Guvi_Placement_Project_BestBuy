package com.utils.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	//public static String value;

	public static WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOp = new ChromeOptions();
			chromeOp.addArguments("--headless=new");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeOp = new EdgeOptions();
			edgeOp.addArguments("--headless");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			FirefoxOptions fireOp = new FirefoxOptions();
			fireOp.addArguments("--headless");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void implicitlyWait(int value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
	}

	public static void explicitlyWait(int value, WebElement visibilityOfElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.visibilityOf(visibilityOfElement));
	}

	public static void explicitlyWaitAll(int value, WebElement visibilityOfAllElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.elementToBeClickable(visibilityOfAllElement));
	}

	public static void scrollDownorUp(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}

	public static void verifyUrlLink(String url, String value, String valueOneOfOne, String valueTwoOfTwo)
			throws IOException {
		try {
			URL Url = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) Url.openConnection();
			urlConnection.connect();
			if (urlConnection.getResponseCode() >= 400) {
				System.out.println(url + value + urlConnection.getResponseMessage() + valueOneOfOne);
			} else {
				System.out.println(url + value + urlConnection.getResponseMessage() + valueTwoOfTwo);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void passInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void sendPhoneNumber(WebElement element, String phoneNumber) {
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			element.clear();
			element.sendKeys(phoneNumber);
		} else {
			System.out.println("Phone number cannot be null or empty.");
		}
	}

//	public static void topLinksVerification(By locator, String valueBefore, String assertValue) {
//		List<WebElement> topLinksVerification = driver.findElements(locator);
//		for (int i = 0; i < topLinksVerification.size(); i++) {
//			System.out.println(valueBefore + topLinksVerification.get(i).getText());
//			Assert.assertTrue(true, assertValue);
//		}
//	}
//
//	public static void bottomLinksVerification(By locator, String valueBefore, String assertValue) {
//		List<WebElement> bottomLinksVerification = driver.findElements(locator);
//		for (int i = 0; i < bottomLinksVerification.size(); i++) {
//			System.out.println(valueBefore + bottomLinksVerification.get(i).getText());
//			Assert.assertTrue(true, assertValue);
//		}
//	}

	public static void pageSource(String containsValue, String sysoMessageOne, String sysoMessageTwo) {

		if (driver.getPageSource().contains(containsValue)) {
			System.out.println(sysoMessageOne);
		} else {
			System.out.println(sysoMessageTwo);
		}
	}

//	public static void listOperation(By listOfProducts2, String productsName, String sysoMessage) {
//		String productName = productsName;
//		List<WebElement> listOfProducts = driver.findElements(listOfProducts2);
//		for (WebElement productList : listOfProducts) {
//			String productText = productList.getText();
//			if (productText.contains(productName)) {
//				productList.click();
//				System.out.println(sysoMessage + productText);
//				break;
//			}
//		}
//	}

	public static void selectOperation(WebElement element, String value) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement opt : options) {
			if (opt.getText().contains(value)) {
				opt.click();
				break;
			}
		}
	}

	public static void timeOut(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshot(String location) throws IOException {
		Date d = new Date();
		String FileName = d.toString().replace(":", "-").replace(" ", "-") + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("screenshots" + "\\" + location + FileName + ".png");
		FileUtils.copyFile(source, destination);
	}

//	public static String ExcelUtils(String sheetName, int rowIndex, int cellIndex) throws IOException {
//
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\Surendhar\\eclipse-workspace\\BestBuy-E-Commerce-Project\\Data.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheet(sheetName);
//		XSSFRow row = sheet.getRow(rowIndex);
//		XSSFCell cell = row.getCell(cellIndex);
//		CellType cellType = cell.getCellType();
//
//		if (cellType.equals(CellType.STRING)) {
//			value = cell.getStringCellValue();
//		} else if (cellType.equals(CellType.NUMERIC)) {
//			double numericCellValue = cell.getNumericCellValue();
//			int numeric = (int) numericCellValue;
//			cell.getStringCellValue();
//			value = String.valueOf(numeric);
//		}
//		workbook.close();
//		return value;
//	}

	public static void quit() {
		driver.quit();
	}
}
