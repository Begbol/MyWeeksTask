package com.library;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class GlobalSelenium {
	private WebDriver driver;

	/***
	 * This is the Constructor
	 * 
	 * @param _driver
	 */
	public GlobalSelenium(WebDriver _driver) {
		driver = _driver;
	}

	/**
	 * This is the method enters text string to a edit WebElement in web-site
	 * 
	 * @param emailElem
	 * @param value
	 */
	public void enterTextField(By by, String value) {
		try {
			WebElement textWebElement = driver.findElement(by);
			highlightElement(textWebElement);
			textWebElement.clear();
			textWebElement.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	public void enterTextField(WebElement element, String value) {
		try {
			highlightElement(element);
			element.clear();
			element.sendKeys(value);
		}catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		
	}


	private void highlightElement(WebElement element) {
		
		
	}

	/***
	 * This method starts Chrome browser and maximize it
	 * 
	 * @return WebDriver
	 */
	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_driver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		return driver;
	}

	/***
	 * This is a fluent wait, waits dynamically for a WebElement and polls the
	 * source html
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			@SuppressWarnings("deprecation")
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		return targetElem;
	}

	public void selectDropDown(By by, String visibleTextValue) {
		try {
			WebElement dropdownElement = driver.findElement(by);
			Select dropDown = new Select(dropdownElement);
			dropDown.selectByVisibleText(visibleTextValue);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void selectDropDown(By by, int index) {
		try {
			WebElement dropdownElement = driver.findElement(by);
			Select dropDown = new Select(dropdownElement);
			dropDown.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void selectDropDown(String attributeValue, By by) {
		try {
			WebElement dropdownElement = driver.findElement(by);
			Select dropDown = new Select(dropdownElement);
			dropDown.selectByValue(attributeValue);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void clickButton(By by) {
		try {
			WebElement button = driver.findElement(by);
			button.click();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	/***
	 * This method clicks and un-click the any check-box 	and radio button
	 * @param by
	 * @param isUserWantsTocheckTheBox
	 */
	
	
	public void  handleCheckBoxRadioBtn(By by, boolean isUserWantsTocheckTheBox) {
		
	WebElement elem = driver.findElement(by);
		
		boolean checkBoxState = elem.isSelected();
		if(checkBoxState == true) {
			if(isUserWantsTocheckTheBox==true) {
			}else {
				elem.click();
			}
		}
		else {
			if(isUserWantsTocheckTheBox  = true) {
				elem.click();
			}
			else {
		}
	}
		
	}

	public void handleCheckBoxRadioBtn(WebElement webElement, boolean isUserWantsTocheckTheBox) {
		
		boolean checkBoxState = webElement.isSelected();
		if(checkBoxState == true) {
			if(isUserWantsTocheckTheBox==true) {
			}else {
				webElement.click();
			}
		}
		else {
			if(isUserWantsTocheckTheBox  = true) {
				webElement.click();
			}
			else {
		}
	}
		
		
	}
	
	public void clickHiddenElement(By by) {
		try {
			WebElement hiddenElem = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", hiddenElem);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void scrollToWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public String getCurrentTime() {
		String finalTimeStamp = null;
		Date date = new Date(0, 0, 0);
		String tempTime = new Timestamp(date.getTime()).toString();
		// System.out.println("original time stamp is: [" +tempTime+ "]");
		finalTimeStamp = tempTime.replace(":", "_").replace(" ", "_").replace(".", "_").replace("-", "_");
		// System.out.println("updated time stamp is: [" +finalTimeStamp+ "]");
		// tempTime.replace(':', '_').replace(' ', '_').replace('.', '_');
		return finalTimeStamp;
	}

	public WebElement waitForElementVisibility(By by) {
		WebElement element = null;
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	public String captureScreenShot(String screenshotFileName, String filePath) {
		String finalScreenshotPath = null;
		String timestamp = getCurrentTime();
		
		try {
			if(!filePath.isEmpty()) {
				filePath = checkDirectory(filePath);
				finalScreenshotPath = filePath + screenshotFileName + "_" + timestamp + ".png";
			}else {
				filePath = checkDirectory("target/screenshots");
				finalScreenshotPath = filePath + screenshotFileName + "_" + timestamp + ".png";
			}
			
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File(finalScreenshotPath));
		
		
		}catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
		System.out.println("screenshot location: " + finalScreenshotPath);
		return finalScreenshotPath;
	}
	
	private String checkDirectory(String inputPath) {
		File file = new File(inputPath);
		String abPath = file.getAbsolutePath();
		File file2 = new File(abPath);
		if(!file2.exists()) {
			if(file2.mkdirs()) {
				System.out.println("folders created...");
			}else {
				System.out.println("folders NOT created...");
			}
		}
		return abPath;
		
	}
	
	
	
	
	
	
	

	/*
	 * public static void main(String[] args) { GlobalSeleniumLibrary lib = new
	 * GlobalSeleniumLibrary(null); lib.getCurrentTime(); }
	 */
	
	
	
	
	
	

}
