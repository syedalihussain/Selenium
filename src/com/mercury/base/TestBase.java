package com.mercury.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mercury.util.TestUtil;

/**
 * @author hussa
 *	This is the TestBase class helping to initialize browser everytime
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {

		try {
			prop = new Properties();
			//	Change the path of the config.properties filename accordingly
			FileInputStream ip = new FileInputStream("C:\\ANU\\Vision 2018\\AutomationAssessment\\src\\com\\mercury\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initialization() {
		String browserName = prop.getProperty("browser");
		
		//	If browser property file path name does not need to be specified for a 
		//	particular browser, comment that line
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
