package com.thegreatcourses.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.library.Base;
import com.thegreatcourses.pages.AddToCartPage;
import com.thegreatcourses.pages.CheckOutProgressPage;
import com.thegreatcourses.pages.ChooseProductFormatPage;
import com.thegreatcourses.pages.HomePage;
import com.thegreatcourses.pages.ScienceCoursesPage;

public class BuyACourseTests extends Base{
	
	HomePage myHomePage = new HomePage();
	ScienceCoursesPage sciencePage = new ScienceCoursesPage();
	ChooseProductFormatPage cpfPage = new ChooseProductFormatPage();
	AddToCartPage atcPage = new AddToCartPage();
	CheckOutProgressPage copPage = new CheckOutProgressPage();
	
	@Test
	public void buy_Nightsky_course() {
		myHomePage.goto_thegreatCoursesWebsite();
		myHomePage.click_CategoryScience();
		sciencePage.waitUntilPageLoadcomplete();
		sciencePage.selectACourse("Our Night Sky");		
		cpfPage.waitUntilPageLoadcomplete();
		cpfPage.select_DVD();	
		cpfPage.click_AddToCartBtn();
		atcPage.waitUntilPageLoadComplete();
		atcPage.click_ProceedToCheckOutBtn();
		copPage.waitUntilPageLoadComplete();
		String tempEmail = "test"+myLibrary.getCurrentTime()+"@test.com";	
		System.out.println("Email: [" + tempEmail + "]");
		copPage.complete_CheckoutMethodSection(tempEmail);
		copPage.complete_BillingAddressSection();
		
	}
	

}
