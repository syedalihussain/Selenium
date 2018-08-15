/**
 * 
 */
package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.base.TestBase;

/**
 * @author hussa
 *
 */
public class SelectFlightPage extends TestBase {
	
	By continueButton = By.name("reserveFlights");
	By flightDetails = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/b/font");
	
	public SelectFlightPage() {
		super();
	}
	
	public PurchasePage confirmFlight() {
		driver.findElement(continueButton).click();
		return new PurchasePage();
	}
	
	public String verifySelectFlightPageURL() {
		return driver.getCurrentUrl();
	}
	
	public String verifySelectPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateContinueButton() {
		return driver.findElement(continueButton).isDisplayed();
	}
	
	public String getFlightDetails() {
		return driver.findElement(flightDetails).getText();
	}
	
	
}
