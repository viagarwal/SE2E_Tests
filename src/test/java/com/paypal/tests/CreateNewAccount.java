package com.paypal.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.paypal.pages.AccountInformationPage;
import com.paypal.pages.AccountSetUpPage;
import com.paypal.pages.HomePage;
import com.paypal.pages.SignUpPage;
import com.paypal.utils.Driver;
import com.paypal.utils.YamlDataProvider;
import com.paypal.utils.YamlDataReader;
import com.paypal.utils.YamlReader;

public class CreateNewAccount extends Driver {

	private String locale = null;
	private HomePage homePage = null;
	private SignUpPage signUpPage = null;
	private AccountInformationPage accountInformationPage = null;
	private AccountSetUpPage AccountSetUpPage = null;
	private YamlReader readyamlFile = null;
	
	
	@BeforeClass
	public void setUp1() {
		homePage = new HomePage();
		signUpPage = new SignUpPage();
		AccountSetUpPage = new AccountSetUpPage();
		accountInformationPage = new AccountInformationPage();
		readyamlFile = new  YamlReader();
		
	}
	@Factory(dataProviderClass=YamlDataProvider.class,dataProvider="geteDataProviderData")
	public CreateNewAccount(YamlDataReader eachCountryData) {
		this.locale	= eachCountryData.getLocale();
	}
	
	@Test
	public void createNewAccount() throws IOException{
		homePage.clickSignUpButton();
		AccountSetUpPage.clickOnBusinessRadioButton();
		AccountSetUpPage.clickOnContinueButton();
		accountInformationPage.fillAccountInfo(locale);
		
	}
}
