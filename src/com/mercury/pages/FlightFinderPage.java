/**
 * 
 */
package com.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.mercury.base.TestBase;

/**
 * @author hussa
 *
 */
public class FlightFinderPage extends TestBase {
	
	By tripType = By.cssSelector("input[name='tripType'][type='radio'][value='oneway']");
	By fromPort = By.name("fromPort");
	By toPort	= By.name("toPort");
	By flightType = By.cssSelector("input[name='servClass'][type='radio'][value='First']");
	By continueButton = By.name("findFlights");
	
	//	Constructor
	public FlightFinderPage() {
		super();
	}
	
	//	Enter Flight Details
	public SelectFlightPage enterFlightDetails() {
		driver.findElement(tripType).click();
		
		Select fromPortDropdown = new Select(driver.findElement(fromPort));
		fromPortDropdown.selectByVisibleText(prop.getProperty("fromPort"));
		
		Select toPortDropdown = new Select(driver.findElement(toPort));
		toPortDropdown.selectByVisibleText(prop.getProperty("toPort"));
		
		driver.findElement(flightType).click();
		driver.findElement(continueButton).click();
		
		return new SelectFlightPage();
	}
	
	//	Verify Reservation Page Title
	public String verifyReservationPageTitle() {
		return driver.getTitle();
	}
	
	//	Validate Continue Button
	public boolean validateContinueButton() {
		return driver.findElement(continueButton).isDisplayed();
	}
}
