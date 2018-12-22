package com.dice.base;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

	@BeforeClass
	protected void setUpClass(ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = Logger.getLogger(testName);
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {

		log.info("Method Set Up.");
		driver = BrowserFactory.getDriver(browser, log);
	}

	@AfterMethod
	public void tearDown() {

		log.info("Method Tear Down.");
		driver.quit();

	}

	protected WebDriver driver;
	protected Logger log;
}
