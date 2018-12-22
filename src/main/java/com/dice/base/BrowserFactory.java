package com.dice.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver getDriver(String browser, Logger log) {

		WebDriver driver;
		log.info("Sterting " + browser.toUpperCase() + " browser.");

		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System
					.getProperty("user.dir")
					+ "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", System
					.getProperty("user.dir")
					+ "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.gecko.driver", System
					.getProperty("user.dir")
					+ "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().window().maximize();
		return driver;
	}

}
