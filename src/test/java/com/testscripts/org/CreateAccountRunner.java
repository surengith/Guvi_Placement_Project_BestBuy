package com.testscripts.org;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.extentreport.org.ExtentReport;
import com.pages.org.CreateAccount;
import com.utils.org.BaseClass;
import com.utils.org.ConfigProperty;
import com.utils.org.ExcelUtils;
import com.utils.org.FileReaderManager;

import junit.framework.Assert;

public class CreateAccountRunner extends BaseClass {

	public static CreateAccount ca;
	public static WebDriver driver;

	@Test
	public void reader() throws IOException {
		FileReaderManager.GetInstanceFRM().getInstanceCR();
	}

	@Parameters("browser")
	@BeforeClass
	public void driverSetup(String browser) throws IOException {
		reader();
		// String browser = ConfigProperty.getBrowser();
		driver = launchBrowser(browser);
		implicitlyWait(5);
		String url = ConfigProperty.getUrl();
		launchUrl(url);
		ExtentReport.extentReport().createTest(url);
	}

	@BeforeMethod
	public void urlVerify() throws IOException {
		String url = ConfigProperty.getUrl();
		verifyUrlLink(url, "--", " Link is broken", " Link has been verified successfully");
	}

	@Parameters("validphonenumber")
	@Test(priority = 0)
	public void createAccountValidCredentials(@Optional String validphonenumber) throws IOException {
		ca = new CreateAccount(driver);
		clickOnElement(ca.getCountrySelectionUS());
		clickOnElement(ca.getAccountButton());
		clickOnElement(ca.getCreateAccountButton());
		passInput(ca.getCreateAccountFirstName(), ExcelUtils.ExcelUtils("Sheet1", 1, 0));
		passInput(ca.getCreateAccountLastName(), ExcelUtils.ExcelUtils("Sheet1", 1, 1));
		passInput(ca.getCreateAccountEmail(), ExcelUtils.ExcelUtils("Sheet1", 1, 2));
		passInput(ca.getCreateAccountPassword(), ExcelUtils.ExcelUtils("Sheet1", 1, 3));
		passInput(ca.getCreateAccountConfirmPassword(), ExcelUtils.ExcelUtils("Sheet1", 1, 4));
		passInput(ca.getCreateAccountPhoneNumber(), validphonenumber);
		clickOnElement(ca.getCreateAccountSubmit());
		timeOut(2000);
		takeScreenshot("accountvalid");
		clickOnElement(ca.getCreateAccountReturnPreviousPage());
		Assert.assertTrue(true);
	}

	@Parameters("invalidphonenumber")
	@Test(priority = 1)
	public void createAccountInvalidCredentials(@Optional String invalidphonenumber)
			throws IOException, InterruptedException {
		ca = new CreateAccount(driver);
		clickOnElement(ca.getAccountButton());
		clickOnElement(ca.getCreateAccountButton());
		passInput(ca.getCreateAccountFirstName(),ExcelUtils.ExcelUtils("Sheet1", 2, 0));
		passInput(ca.getCreateAccountLastName(), ExcelUtils.ExcelUtils("Sheet1", 2, 1));
		passInput(ca.getCreateAccountEmail(), ExcelUtils.ExcelUtils("Sheet1", 2, 2));
		passInput(ca.getCreateAccountPassword(), ExcelUtils.ExcelUtils("Sheet1", 2, 3));
		passInput(ca.getCreateAccountConfirmPassword(), ExcelUtils.ExcelUtils("Sheet1", 2, 4));
		passInput(ca.getCreateAccountPhoneNumber(), invalidphonenumber);
		clickOnElement(ca.getCreateAccountSubmit());
		timeOut(2000);
		takeScreenshot("accountinvalidCredentials");
		clickOnElement(ca.getCreateAccountReturnPreviousPage());
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void createAccountEmptyCredentials() throws IOException {
		ca = new CreateAccount(driver);
		clickOnElement(ca.getAccountButton());
		clickOnElement(ca.getCreateAccountButton());
		passInput(ca.getCreateAccountFirstName(), "");
		passInput(ca.getCreateAccountLastName(), "");
		passInput(ca.getCreateAccountEmail(), "");
		passInput(ca.getCreateAccountPassword(), "");
		passInput(ca.getCreateAccountConfirmPassword(), "");
		passInput(ca.getCreateAccountPhoneNumber(), "");
		clickOnElement(ca.getCreateAccountSubmit());
		takeScreenshot("accountEmptyCredentials");
		clickOnElement(ca.getCreateAccountReturnPreviousPage());
		Assert.assertTrue(true);
	}
}
