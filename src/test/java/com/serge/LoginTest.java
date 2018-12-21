package com.serge;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.base.TestBase;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

public class LoginTest extends TestBase {

	@Test
	public void positiveLogInTest() {
		LoginPage loginPage = new LoginPage(driver);
		String expectedPageTitle = "Seeker Dashboard - Profile";
		String exectedProfileName = "Serge Kononenko";

		loginPage.openLoginPage();
		loginPage.fillEmailAndPassword("", "");
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

	@Test
	public void negativeLogInTest() {
		String expectedErrorMsg = "Email and/or password incorrect";
		LoginPage loginPage = new LoginPage(driver);

		loginPage.openLoginPage();
		loginPage.fillEmailAndPassword("test@tect.com", "12345fserferf6789");
		loginPage.clickSignInButton();
		String errorMsg = loginPage.getLoginErrorMsg();

		Assert.assertTrue(errorMsg.contains(expectedErrorMsg),
				"Error msg is not as expected");
	}

}
