package com.ui.tests;


import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utilities.LoggerUtility;

@Listeners({com.ui.listeners.TestListeners.class})

public class LoginTest3 extends TestBase{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	@Test(description="Verified if the valid User is able to login to the application",groups= {"e2e","sanity"},
			dataProviderClass = com.ui.dataprovider.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {			
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Gangesh Jha");
	}
	
//	@Test(description="Verified if the valid User is able to login to the application",groups= {"e2e","sanity"},
//			dataProviderClass = com.ui.dataprovider.LoginDataProvider.class,dataProvider = "LoginTestCSVDataProvider")
//	public void loginCSVTest(User user) {			
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Gangesh Jha");
//	}
//	
//	@Test(description="Verified if the valid User is able to login to the application",groups= {"e2e","sanity"},
//			dataProviderClass = com.ui.dataprovider.LoginDataProvider.class,dataProvider = "LoginTestExcelDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {	
//	
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Gangesh Jha1");
//		
//	}

}
