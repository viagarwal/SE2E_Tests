package com.paypal.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.paypal.pages.AccountInformationPage;
import com.paypal.pages.AccountSetUpPage;
import com.paypal.pages.HomePage;
import com.paypal.utils.Driver;
import com.paypal.utils.YamlDataProvider;
import com.paypal.utils.YamlDataReader;

public class CreateNewAccount extends Driver {

	private String locale = null;
	private HomePage homePage = null;
	private AccountInformationPage accountInformationPage = null;
	private AccountSetUpPage AccountSetUpPage = null;
	String methodName = null;
	
	
	@BeforeClass
	public void setUp1() {
		homePage = new HomePage();
		AccountSetUpPage = new AccountSetUpPage();
		accountInformationPage = new AccountInformationPage();
		
	}
	@Factory(dataProviderClass=YamlDataProvider.class,dataProvider="geteDataProviderData")
	public CreateNewAccount(YamlDataReader eachCountryData) {
		this.locale	= eachCountryData.getLocale();
	}
	
	@Test(description  ="Create new PayPal Account")
	public void getNewAccount() throws IOException  {
	
		methodName =  new Object(){}.getClass().getEnclosingMethod().getName();
		homePage.clickSignUpButton();
		AccountSetUpPage.clickOnBusinessRadioButton();
		AccountSetUpPage.clickOnContinueButton();
		accountInformationPage.fillAccountInfo(locale);
	}

}
