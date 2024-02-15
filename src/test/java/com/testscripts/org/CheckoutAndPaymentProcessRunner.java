package com.testscripts.org;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.pages.org.CheckoutAndPaymentProcess;
import com.utils.org.BaseClass;
import com.utils.org.ExcelUtils;

public class CheckoutAndPaymentProcessRunner extends BaseClass {

	public static CheckoutAndPaymentProcess cpp;

	@Test
	public void checkoutLoginProcess() throws InterruptedException, IOException {
		cpp = new CheckoutAndPaymentProcess(driver);
		clickOnElement(cpp.getCheckoutButton());
		passInput(cpp.getCheckoutEmail(), ExcelUtils.ExcelUtils("Sheet1", 13, 0));
		passInput(cpp.getCheckoutPassword(), ExcelUtils.ExcelUtils("Sheet1", 13, 1));
		explicitlyWait(10, cpp.getCheckoutSignin());
		clickOnElement(cpp.getCheckoutSignin());
	}

	@Test
	public void paymentInformation() throws InterruptedException, IOException {
		cpp = new CheckoutAndPaymentProcess(driver);
		sleep(10000);
		clickOnElement(cpp.getContinueToGuest());
		clickOnElement(cpp.getSwitchToPickUp());
		passInput(cpp.getPaymentFirstName(), ExcelUtils.ExcelUtils("Sheet1", 17, 0));
		passInput(cpp.getPaymentLastName(), ExcelUtils.ExcelUtils("Sheet1", 17, 1));
		passInput(cpp.getAddressLine(), ExcelUtils.ExcelUtils("Sheet1", 17, 2));
		passInput(cpp.getCity(), ExcelUtils.ExcelUtils("Sheet1", 17, 3));
		selectOperation(cpp.getState(), "RI");
		passInput(cpp.getPostalCode(), "02842");
		clickOnElement(cpp.getApply());
		takeScreenshot("CheckoutAndPaymentProcess");
		sleep(3000);
	}

	@AfterClass
	public void tearDown() {
		quit();
	}
}
