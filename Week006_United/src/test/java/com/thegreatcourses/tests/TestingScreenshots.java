package com.thegreatcourses.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.library.Base;

public class TestingScreenshots extends Base{

	@Test
	public void testing_screen_shot1() {
		try {
		driver.get("http://www.google.com/");
		myLibrary.captureScreenShot("google", "");
		
		}catch(Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	

@Test
public void testing_screen_shot2() {
	try {
	driver.get("http://www.costco.com/");
	assertEquals(driver.getTitle(), "Omar");
	myLibrary.captureScreenShot("costco", "");
	}catch(Exception e) {
		e.printStackTrace();
		assertTrue(false);
	}
}
}