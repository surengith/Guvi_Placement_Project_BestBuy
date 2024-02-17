package com.testscripts.org;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.org.CheckoutAndPaymentProcess;
import com.utils.org.BaseClass;
import com.utils.org.ExcelUtils;

import junit.framework.Assert;

public class CheckoutAndPaymentProcessRunner extends BaseClass {

	public static CheckoutAndPaymentProcess cpp;

	@Test
	public void checkoutLoginProcess() throws InterruptedException, IOException {
		cpp = new CheckoutAndPaymentProcess(driver);
		test = extent.createTest("CheckoutLoginProcess");
		clickOnElement(cpp.getCheckoutButton());
		passInput(cpp.getCheckoutEmail(), ExcelUtils.ExcelUtils("Sheet1", 13, 0));
		passInput(cpp.getCheckoutPassword(), ExcelUtils.ExcelUtils("Sheet1", 13, 1));
		explicitlyWait(20, cpp.getCheckoutSignin());
		clickOnElement(cpp.getCheckoutSignin());
		test.log(Status.PASS, "checkoutLoginProcess test has been passed successfully");
		Assert.assertTrue(true);
	}

	@Test
	public void paymentInformation() throws InterruptedException, IOException {
		cpp = new CheckoutAndPaymentProcess(driver);
		test = extent.createTest("CheckoutAndPaymentProcess");
		sleep(10000);
		//explicitlyWait(30, cpp.getContinueToGuest());
		clickOnElement(cpp.getContinueToGuest());
		//sleep(10000);
		explicitlyWait(30, cpp.getSwitchToPickUp());
		clickOnElement(cpp.getSwitchToPickUp());
		passInput(cpp.getPaymentFirstName(), ExcelUtils.ExcelUtils("Sheet1", 17, 0));
		passInput(cpp.getPaymentLastName(), ExcelUtils.ExcelUtils("Sheet1", 17, 1));
		passInput(cpp.getAddressLine(), ExcelUtils.ExcelUtils("Sheet1", 17, 2));
		passInput(cpp.getCity(), ExcelUtils.ExcelUtils("Sheet1", 17, 3));
		selectOperation(cpp.getState(), "RI");
		passInput(cpp.getPostalCode(), "02842");
		clickOnElement(cpp.getApply());
		takeScreenshot("CheckoutAndPaymentProcess");
		test.log(Status.PASS, "checkoutAndPaymentProcess test has been passed successfully");
		Assert.assertTrue(true);
		sleep(3000);
	}
	
	@AfterClass
	public void tearDown() {
		quit();
	}
	
	
}
