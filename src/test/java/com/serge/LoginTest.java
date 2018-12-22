package com.serge;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.base.CsvDataProvider;
import com.dice.base.TestBase;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

public class LoginTest extends TestBase {

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void positiveLogInTest(Map<String, String> testData) {
		LoginPage loginPage = new LoginPage(driver);
		String expectedPageTitle = "Seeker Dashboard - Profile";
		String exectedProfileName = "Serge Kononenko";
		String testNumber = testData.get("no");
		String email = testData.get("email");
		String password = testData.get("password");
		String description = testData.get("description")
				.toUpperCase();

		System.out.println("Tes NO:" + testNumber + " for "
				+ description + " where\nEmail: " + email
				+ ", password: " + password);
		
		loginPage.openLoginPage();
		loginPage.fillEmailAndPassword(email, password);
		ProfilePage profilePage = loginPage.clickSignInButton();
		profilePage.waitForProfilePageToLoad();

		String actualTitle = profilePage.getTitle();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle),
				"Page Title is not as expected.");

		Assert.assertTrue(
				profilePage
						.isCorrectProfileLoaded(exectedProfileName),
				"Profile name is not as expected");

	}

	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void negativeLogInTest(Map<String, String> testData) {
		String expectedErrorMsg = "Email and/or password incorrect";
		String testNumber = testData.get("no");
		String email = testData.get("email");
		String password = testData.get("password");
		String description = testData.get("description")
				.toUpperCase();

		System.out.println("Tes NO:" + testNumber + " for "
				+ description + " where\nEmail: " + email
				+ ", password: " + password);

		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();
		loginPage.fillEmailAndPassword(email, password);
		loginPage.clickSignInButton();
		String errorMsg = loginPage.getLoginErrorMsg();

		Assert.assertTrue(errorMsg.contains(expectedErrorMsg),
				"Error msg is not as expected");
	}

}
