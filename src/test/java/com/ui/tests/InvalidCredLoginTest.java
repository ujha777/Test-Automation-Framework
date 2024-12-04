package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.utilities.LoggerUtility;

public class InvalidCredLoginTest extends TestBase {
	
Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "jatinvsharma@gmail.com";
	private static final String INVALID_PASSWORD = "Qwerty1234!";
	
	@Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials ", groups = {
		"e2e", "sanity", "smoke" })
	public void loginTest() {
		String actualResult=homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage();
		
		assertEquals(actualResult, "Authentication failed.");
	}
	
}
