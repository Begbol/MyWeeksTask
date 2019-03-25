package com.library;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class Base {
	
	public static WebDriver driver;
	public static GlobalSelenium myLibrary;
	
	@BeforeClass
	public void beforeAllTestStart(){
		myLibrary = new GlobalSelenium(driver);
	}
	
	@AfterClass
	public void afterAllTestCompleted(){
		
	}
	
	@BeforeMethod
	public void beforeEachTestStart() {
		driver = myLibrary.startChromeBrowser();	
	}

	@AfterMethod
	public void afterEachTestEnd(ITestResult result) {
		try {
			if (ITestResult.FAILURE==result.getStatus()) {
				myLibrary.captureScreenShot(result.getName(), "target/screenshots/");
				
			}
			Thread.sleep(3 * 1000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
