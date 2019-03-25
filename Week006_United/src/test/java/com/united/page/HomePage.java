package com.united.page;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.Base;

public class HomePage extends Base {
	
	

	public HomePage goto_United_Website() {
		driver.get("http://www.united.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Website title is:" + pageTitle);
		String expectedTitle = "United Airlines - Airline Tickets, Travel Deals and Flights";
		assertEquals(pageTitle, expectedTitle);
		return this;
	}
	
	public HomePage selectOneWay() {
		myLibrary.handleCheckBoxRadioBtn(By.id("oneway"), true);
		
		
		
		
		return this;
	}
	
	public HomePage selectRoundTrip() {
		myLibrary.handleCheckBoxRadioBtn(By.id("roundtrip"), true);
		
		
		return this;
	}

//	public HomePage enterFromAirport(String inputOriginAirportName, String dropDownAirportText ) {
//		try {
//		myLibrary.enterTextField(By.id("bookFlightOriginInput"), inputOriginAirportName);
//		Thread.sleep(1000);
//		List<WebElement>dropDownElement = driver.findElements(By.className("app-components-AutoComplete-autocomplete__autoCompleteInput--3Rus_"));
//		WebElement fromList = dropDownElement.get(0);
//		WebElement airportOptions = fromList.findElement(By.className("	app-components-AutoComplete-autocomplete__autoCompleteLabel--sp0Ll"));
//		for(WebElement airport : airportOptions) {
//			WebElement targetAirport = airport.findElement(By.tagName("label"));
//			if(dropDownAirportText.contains(targetAirport.getText()));
//			targetAirport.click();
//		}
//		
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return this;
//	}

}
