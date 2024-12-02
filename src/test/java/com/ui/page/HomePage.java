package com.ui.page;

import static com.constant.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;

import static com.utilities.JSONUtility.*;
//child classes always to use final keyword
public final class HomePage extends BrowserUtility {
	//Page Object Design Pattern->The way u create classes
	//Rule -final variable locators value should not be changed
	//if variable is final then also is going to be static
	//Class variable
	//It should be private
	//HomePage Constructor can be called when we create object of the child class
	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[@class='login']");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);//To call the parent class constructor from the child constructor
		//goToWebSite(readProperties(QA, "URL"));
		goToWebSite(readJSON(QA).getUrl());



	}
	public HomePage(WebDriver driver) {
		super(driver);//To call the parent class constructor from the child constructor
		//goToWebSite(readProperties(QA, "URL"));
		goToWebSite(readJSON(QA).getUrl());



	}


	public LoginPage goToLoginPage() {//-->Page Function-->do not use void return type in Page Object Design Pattern
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		//passing the one session object of One Page to another Page by using getDriver method
		LoginPage loginPage= new LoginPage(getDriver());
		return loginPage;
	}

}
