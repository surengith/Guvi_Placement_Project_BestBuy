package com.testscripts.org;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.pages.org.CheckoutAndPaymentProcess;
import com.utils.org.BaseClass;

public class CheckoutAndPaymentProcessRunner extends BaseClass {

	public static CheckoutAndPaymentProcess cpp;

	@Test
	public void checkoutLoginProcess() throws InterruptedException {
		cpp = new CheckoutAndPaymentProcess(driver);
		clickOnElement(cpp.getCheckoutButton());
		passInput(cpp.getCheckoutEmail(), "suren2696@gmail.com");
		passInput(cpp.getCheckoutPassword(), "Surendhar@321$");
		explicitlyWait(10, cpp.getCheckoutSignin());
		clickOnElement(cpp.getCheckoutSignin());
	}

	@Test
	public void paymentInformation() throws InterruptedException {
		cpp = new CheckoutAndPaymentProcess(driver);
		Thread.sleep(10000);
		clickOnElement(cpp.getContinueToGuest());
		clickOnElement(cpp.getSwitchToPickUp());
		passInput(cpp.getPaymentFirstName(), "Surendhar");
		passInput(cpp.getPaymentLastName(), "Palanisamy");
		passInput(cpp.getAddressLine(), "F Admiralty Dr W");
		passInput(cpp.getCity(), "Middletown");
		selectOperation(cpp.getState(), "RI");
		passInput(cpp.getPostalCode(), "02842");
		clickOnElement(cpp.getApply());

	}

	@AfterClass
	public void tearDown() {
		quit();
	}
}
