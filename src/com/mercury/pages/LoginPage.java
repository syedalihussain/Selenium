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
public class LoginPage extends TestBase {
	
	By username = By.name("userName");
	By pw = By.name("password");
	By loginButton = By.name("login");
	
	public LoginPage() {
		super();
	}
	
	//	Constructor
	public FlightFinderPage loginToMercury(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(pw).sendKeys(pass);
		driver.findElement(loginButton).click();
		return new FlightFinderPage();
	}
	
	//	Verify Login Page URL
	public String verifyLoginPageURL() {
		return driver.getCurrentUrl();
	}

	//	Verify Login Page Title
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	//	Validate Login Page Button
	public boolean validateLoginPageButton() {
		return driver.findElement(loginButton).isDisplayed();
	}
}
