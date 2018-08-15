package com.mercury.testcases;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mercury.base.TestBase;
import com.mercury.pages.FlightFinderPage;
import com.mercury.pages.LoginPage;
import com.mercury.pages.SelectFlightPage;


public class SelectFlightPageTest extends TestBase {

	LoginPage login;
	FlightFinderPage reserve;
	SelectFlightPage select;
	
	@Before
	public void setUp() {
		initialization();
		login = new LoginPage();
		reserve = login.loginToMercury("mercury", "mercury");
		select = reserve.enterFlightDetails();
	}
	
	@Test
	public void selectFlightPageTitleTest() {
		String title = select.verifySelectPageTitle();
		Assert.assertEquals("Select a Flight: Mercury Tours", title);
	}
	
	@Test
	public void selectFlightPageURLTest() {
		String url = select.verifySelectFlightPageURL();
		Assert.assertEquals("http://newtours.demoaut.com/mercuryreservation2.php", url);
	}
	
	@Test
	public void selectFlightPageContinueButtonTest() {
		Assert.assertTrue(select.validateContinueButton());
	}
	
	@Test
	public void selectFlightPageFromPortTest() {
		String str = select.getFlightDetails();
		String from = prop.getProperty("fromPort");
		Assert.assertEquals(from, str.substring(0, from.length()));
	}
	
	@Test
	public void selectFlightPageToPortTest() {
		String str = select.getFlightDetails();
		String to = prop.getProperty("toPort");
		Assert.assertEquals(to, str.substring(str.length()-to.length()));
	}
	
	@After
	public void tearDown() throws InterruptedException {
//		Thread.sleep(5000);
		driver.quit();
	}
}
