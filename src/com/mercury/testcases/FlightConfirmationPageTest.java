package com.mercury.testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mercury.base.TestBase;
import com.mercury.pages.FlightConfirmationPage;
import com.mercury.pages.FlightFinderPage;
import com.mercury.pages.LoginPage;
import com.mercury.pages.PurchasePage;
import com.mercury.pages.SelectFlightPage;

public class FlightConfirmationPageTest extends TestBase{
	
	LoginPage login;
	FlightFinderPage reserve;
	SelectFlightPage reserve2;
	PurchasePage purchase;
	FlightConfirmationPage confirm;
	
	@Before
	public void setUp() {
		initialization();
		login = new LoginPage();
		reserve = login.loginToMercury("mercury", "mercury");
		reserve2 = reserve.enterFlightDetails();
		purchase = reserve2.confirmFlight();
		confirm = purchase.purchaseTicket();
	}
	
	@Test
	public void backToFlightsImgTest() {
		Assert.assertTrue(confirm.validateBackToFlightsImg());
	}
	
	@Test
	public void backToHomeImgTest() {
		Assert.assertTrue(confirm.validateBackToHomeImg());
	}
	
	@Test
	public void logOutImgTest() {
		Assert.assertTrue(confirm.validateLogOutImg());
	}
	@Test
	public void flightConfirmationPageTitleTest() {
		Assert.assertEquals("Flight Confirmation: Mercury Tours", confirm.validateFlightConfirmationPageTitle());
	}
	
	@Test
	public void flightConfirmationPageURLTest() {
		String url = confirm.verifyFlightConfirmationPageURL();
		Assert.assertEquals("http://newtours.demoaut.com/mercurypurchase2.php", url);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
