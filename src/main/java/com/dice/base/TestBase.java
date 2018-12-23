package com.dice.base;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

	@Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	public void setUpClass(String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();

		log = Logger.getLogger(testName);
		driver = BrowserFactory.getDriver(browser, log);
		
		this.testName = testName;
		this.testSuiteName = ctx.getSuite().getName();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, ITestContext ctx) {

		log.info("Method Set Up.");
		this.testMethodName = method.getName();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		log.info("Method Tear Down.");
		driver.quit();

	}

	protected WebDriver driver;
	protected Logger log;

	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

}
