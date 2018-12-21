package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {

	private By editProfileButton = By
			.xpath("//button[@id='editProfile']");
	private By advanceSearchLink = By
			.xpath("//a[@class='dice-btn-link']");
	private By profileNameText = By
			.cssSelector(".profile-contact-name");

	protected ProfilePage(WebDriver driver) {
		super(driver);

	}

	public void waitForProfilePageToLoad() {
		waitForVisibilityOf(editProfileButton);
		waitForVisibilityOf(advanceSearchLink, 10);
	}

	public boolean isCorrectProfileLoaded(String exectedProfileName) {
		if (getText(profileNameText).equals(exectedProfileName))
			return true;
		else
			return false;

	}
}
