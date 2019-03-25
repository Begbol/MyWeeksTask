package com.thegreatcourses.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.library.Base;

public class CheckOutProgressPage extends Base{
	public CheckOutProgressPage waitUntilPageLoadComplete(){
		WebElement continueBtnElem = myLibrary.fluentWait(By.id("checkout-sigin"));
		Assert.assertNotNull(continueBtnElem, "Waiting for Checkout Progress page loading - Failed");
		return this;
	}
	
	public CheckOutProgressPage complete_CheckoutMethodSection(String emailAddress){
		myLibrary.enterTextField(By.id("login-email"), emailAddress);
		//myLibrary.handleCheckBoxRadioBtn(By.id("no_have_pass"), true);
		myLibrary.clickHiddenElement(By.id("no_have_pass"));
		myLibrary.clickButton(By.id("checkout-sigin"));		
		return this;
	}
	
	public CheckOutProgressPage complete_BillingAddressSection()
	{
		WebElement emailElem = myLibrary.waitForElementVisibility(By.id("billing:firstname"));
		myLibrary.enterTextField((By) emailElem, "Frank");
		
		myLibrary.enterTextField(By.id("billing:lastname"), "FrankLast");
		myLibrary.enterTextField(By.id("billing:street1"), "10 apple street");
		myLibrary.enterTextField(By.id("billing:city"), "Moon");
		myLibrary.selectDropDown(By.id("billing:region_id"), "Virginia");
		myLibrary.enterTextField(By.id("billing:postcode"), "12345");
		myLibrary.enterTextField(By.id("billing:customer_password"), "123456");
		myLibrary.enterTextField(By.id("billing:confirm_password"), "123456");
		
		WebElement btn = driver.findElement(By.id("billing-buttons-container"));
		WebElement continueBtn = btn.findElement(By.tagName("button"));
		continueBtn.click();
		
		return this;
	}
	

}
