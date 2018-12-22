package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {

		driver = BrowserFactory.getDriver(browser);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

	protected WebDriver driver;

}
