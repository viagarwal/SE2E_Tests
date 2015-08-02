package com.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paypal.utils.Library;

public class SignUpPage {

	private WebDriver driver;
	private Library lib = null;
	WebDriverWait wait = null;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		lib = new Library();
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "country")
	private WebElement selectCountry;

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyPageTitle() {
		String pageTitle = "Sign Up for a PayPal Account – PayPal";
		return getPageTitle().contains(pageTitle);
	}

	public AccountSetUpPage selectAccount(String country) {
		wait.until(ExpectedConditions.visibilityOf(selectCountry));
		lib.selectVisibleText(selectCountry, country);
		return new AccountSetUpPage(driver);
	}
}
