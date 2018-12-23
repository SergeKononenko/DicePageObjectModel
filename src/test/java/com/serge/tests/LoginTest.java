package com.serge.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.base.CsvDataProvider;
import com.dice.base.TestUtilities;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

public class LoginTest extends TestUtilities {

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 1, groups = {
			"positive" })
	public void positiveLogInTest(Map<String, String> testData) {

		LoginPage loginPage = new LoginPage(driver, log);
		String expectedPageTitle = "Seeker Dashboard - Profile";
		String exectedProfileName = "Serge Kononenko";
		String testNumber = testData.get("no");
		String email = testData.get("email");
		String password = testData.get("password");
		String description = testData.get("description")
				.toUpperCase();

		log.info("Tes NO:" + testNumber + " for " + description
				+ " where\nEmail: " + email + ", password: "
				+ password);

		loginPage.openLoginPage();
		takeScreenshot("LogIn Page Opened");
		loginPage.fillEmailAndPassword(email, password);
		ProfilePage profilePage = loginPage.clickSignInButton();
		profilePage.waitForProfilePageToLoad();
		takeScreenshot("User Loged in");

		String actualTitle = profilePage.getTitle();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle),
				"Page Title is not as expected.");

		Assert.assertTrue(
				profilePage
						.isCorrectProfileLoaded(exectedProfileName),
				"Profile name is not as expected");

	}

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, 
			priority = 2, groups = { "negative", "broken" })
	public void negativeLogInTest(Map<String, String> testData) {

		String expectedErrorMsg = "Email and/or password incorrect";
		String testNumber = testData.get("no");
		String email = testData.get("email");
		String password = testData.get("password");
		String description = testData.get("description")
				.toUpperCase();

		log.info("Tes NO:" + testNumber + " for " + description
				+ " where\nEmail: " + email + ", password: "
				+ password);

		LoginPage loginPage = new LoginPage(driver, log);

		loginPage.openLoginPage();
		loginPage.fillEmailAndPassword(email, password);
		loginPage.clickSignInButton();
		String errorMsg = loginPage.getLoginErrorMsg();

		Assert.assertTrue(errorMsg.contains(expectedErrorMsg),
				"Error msg is not as expected");
	}

}
