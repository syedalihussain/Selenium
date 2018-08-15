/**
 * 
 */
package com.mercury.testcases;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mercury.base.TestBase;
import com.mercury.pages.LoginPage;

/**
 * @author hussa
 *
 */
public class LoginPageTest extends TestBase {
	
	LoginPage login;
	
	@Before
	public void setUp() {
		initialization();
		login = new LoginPage();
	}
	
	@Test
	public void loginPageURLTest() throws InterruptedException {
		String url = login.verifyLoginPageURL();
		Assert.assertEquals("http://newtours.demoaut.com/mercurywelcome.php", url);
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = login.verifyLoginPageTitle();
		Assert.assertEquals("Welcome: Mercury Tours", title);
	}
	
	@Test
	public void loginPageLoginButtonTest() {
		Assert.assertTrue(login.validateLoginPageButton());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
