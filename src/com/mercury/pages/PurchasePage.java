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
public class PurchasePage extends TestBase{
	By firstName = By.name("passFirst0");
	By lastName = By.name("passLast0");
	
	By cc_creditNumber = By.name("creditnumber");
	By cc_firstName = By.name("cc_frst_name");
	By cc_lastName = By.name("cc_last_name");
	By cc_month = By.name("cc_exp_dt_mn");
	By cc_year = By.name("cc_exp_dt_yr");
	
	By ticketless = By.name("ticketLess");
	By purchase = By.name("buyFlights");
		
	
	public String selectDepartCost, selectReturnCost;
	public PurchasePage() {
		super();
	}
	
	public FlightConfirmationPage purchaseTicket() {
		driver.findElement(firstName).sendKeys(prop.getProperty("firstName"));
		driver.findElement(lastName).sendKeys(prop.getProperty("lastName"));
		
		driver.findElement(cc_creditNumber).sendKeys(prop.getProperty("ccNumber"));
		driver.findElement(cc_firstName).sendKeys(prop.getProperty("ccFirstName"));
		driver.findElement(cc_lastName).sendKeys(prop.getProperty("ccLastName"));
		Select monthDropdown = new Select(driver.findElement(cc_month));
		monthDropdown.selectByVisibleText(prop.getProperty("ccMonth"));
		Select yearDropdown = new Select(driver.findElement(cc_year));
		yearDropdown.selectByVisibleText(prop.getProperty("ccYear"));
		driver.findElement(ticketless).click();
		driver.findElement(purchase).click();
		
		return new FlightConfirmationPage();
	}
	
	public void enterPassengerDetails(String fn, String ln) {
		driver.findElement(firstName).sendKeys(fn);
		driver.findElement(lastName).sendKeys(ln);
	}
	
	public void enterCreditCardDetails(String ccn, String fn, String ln, String mn, String yr) {
		driver.findElement(cc_creditNumber).sendKeys(ccn);
		driver.findElement(cc_firstName).sendKeys(fn);
		driver.findElement(cc_lastName).sendKeys(ln);
		Select monthDropdown = new Select(driver.findElement(cc_month));
		monthDropdown.selectByVisibleText(mn);
		Select yearDropdown = new Select(driver.findElement(cc_year));
		yearDropdown.selectByVisibleText(yr);
	}
	
	public void checkTicketless() {
		driver.findElement(ticketless).click();
	}
	
	public void confirmPurchase() {
		driver.findElement(purchase).click();
	}
	
	public String validatePurchasePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePurchaseButton() {
		return driver.findElement(purchase).isDisplayed();
	}

	public String verifyPurchasePageURL() {
		return driver.getCurrentUrl();
	}
	
	
	
}
