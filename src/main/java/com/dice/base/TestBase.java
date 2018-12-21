package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
	
	protected WebDriver driver;

}
