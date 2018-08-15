package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.base.TestBase;

public class FlightConfirmationPage extends TestBase {
	
	By backToFlights = By.cssSelector("img[src='/images/forms/backtoflights.gif']");
	By backToHome = By.cssSelector("img[src='/images/forms/home.gif']");
	By logOut = By.cssSelector("img[src='/images/forms/Logout.gif']");
	
	public FlightConfirmationPage() {
		super();
	}
	
	public boolean validateBackToFlightsImg() {
		return driver.findElement(backToFlights).isDisplayed();
	}
	
	public boolean validateBackToHomeImg() {
		return driver.findElement(backToHome).isDisplayed();
	}
	
	public boolean validateLogOutImg() {
		return driver.findElement(logOut).isDisplayed();
	}
	
	public String validateFlightConfirmationPageTitle() {
		return driver.getTitle();
	}

	public String verifyFlightConfirmationPageURL() {
		return driver.getCurrentUrl();
	}
	
}
