package com.mercury.testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mercury.base.TestBase;
import com.mercury.pages.FlightFinderPage;
import com.mercury.pages.LoginPage;

public class FlightFinderPageTest extends TestBase{

	LoginPage login;
	FlightFinderPage reserve;
	
	
	@Before
	public void setUp() {
		initialization();
		login = new LoginPage();
		reserve = login.loginToMercury(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void flightFinderPageTitleTest() {
		String title = reserve.verifyReservationPageTitle();
		Assert.assertEquals("Find a Flight: Mercury Tours:", title);
	}
	
	@Test
	public void flightFinderPageContinueButtonTest() {
		Assert.assertTrue(reserve.validateContinueButton());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
