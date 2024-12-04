package com.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;
//child classes always to use final keyword
public final class LoginPage extends BrowserUtility {
	//IF ANY VARIABLE IS FINAL THEN STATIC SHOULD BE THERE BUT STATIC VARIABLE CAN BE COME WITH FINAL OR WITHOUT FINAL
	private static final By EMAIL_TEXT_BOX_LOCATOR=By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT_BOX_LOCATOR=By.xpath("//input[@type='password']");
	private static final By SUBMIT_LOGIN_BUTTON_LOCATOR=By.xpath("//button[@id='SubmitLogin']");
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");
	
	public LoginPage(WebDriver driver) {
		super(driver);

	}
	//Page Object needs to return something
	public MyAccountPage doLoginWith(String emailAddress,String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage=new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_LOGIN_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public String getErrorMessage() {
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}
}
