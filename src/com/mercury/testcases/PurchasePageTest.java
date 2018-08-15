package com.mercury.testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mercury.base.TestBase;
import com.mercury.pages.FlightFinderPage;
import com.mercury.pages.LoginPage;
import com.mercury.pages.PurchasePage;
import com.mercury.pages.SelectFlightPage;


public class PurchasePageTest extends TestBase{
	
	LoginPage login;
	FlightFinderPage reserve;
	SelectFlightPage reserve2;
	PurchasePage purchase;
	
	@Before
	public void setUp() {
		initialization();
		login = new LoginPage();
		reserve = login.loginToMercury(prop.getProperty("username"), prop.getProperty("password"));
		reserve2 = reserve.enterFlightDetails();
		purchase = reserve2.confirmFlight();
		
	}
	
	@Test
	public void purchasePageTitleTest() {
		String title = purchase.validatePurchasePageTitle();
		Assert.assertEquals("Book a Flight: Mercury Tours", title);
	}
	
	@Test
	public void purchasePageURLTest() {
		String url = purchase.verifyPurchasePageURL();
		Assert.assertEquals("http://newtours.demoaut.com/mercurypurchase.php", url);
	}
	
	@Test
	public void purchasePagePurchaseButtonTest() {
		Assert.assertTrue(purchase.validatePurchaseButton());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
