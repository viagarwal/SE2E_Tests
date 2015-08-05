package com.paypal.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.pages.AccountInformationPage;
import com.paypal.pages.AccountSetUpPage;
import com.paypal.pages.HomePage;
import com.paypal.pages.SignUpPage;
import com.paypal.utils.Driver;
import com.paypal.utils.ReadYamlFile;

public class CreateNewAccount extends Driver {

	private WebDriver driver;
	private HomePage homePage = null;
	private SignUpPage signUpPage = null;
	private AccountInformationPage accountInformationPage = null;
	private AccountSetUpPage AccountSetUpPage = null;
	private ReadYamlFile readyamlFile = null;
	
	
	@BeforeClass
	public void setUp1() {
		driver= getDriver();
		homePage = new HomePage(driver);
		signUpPage = new SignUpPage(driver);
		AccountSetUpPage = new AccountSetUpPage(driver);
		accountInformationPage = new AccountInformationPage(driver);
		readyamlFile = new  ReadYamlFile();
		
	}
	
	@Test
	public void createNewAccount() throws IOException{

		homePage.clickSignUpButton();
		signUpPage.selectAccount("United States");
		AccountSetUpPage.clickOnBusinessRadioButton();
		AccountSetUpPage.clickOnContinueButton();
		readyamlFile.getKeyValue("in", "id");
		
	}
}
