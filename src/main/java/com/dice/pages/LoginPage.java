package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage> {

	private static final String URL = "https://www.dice.com/dashboard/login";

	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By signInBtn = By.xpath("//button[@type='submit']");
	private By loginErrorMsg = By.cssSelector(
			"[data-automation-id='login-failure-help-message']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void openLoginPage() {
		getPage(URL);
	}

	public void fillEmailAndPassword(String email, String pass) {
		type(email, emailField);
		type(pass, passwordField);
	}

	public ProfilePage clickSignInButton() {
		click(signInBtn);
		return new ProfilePage(driver);
	}

	public String getLoginErrorMsg() {
		waitForVisibilityOf(loginErrorMsg, 10);
		return getText(loginErrorMsg);
	}

}
