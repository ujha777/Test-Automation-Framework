package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constant.Env;
import com.utilities.JSONUtility;
import com.utilities.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
  //  private static final int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperties(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
    private static final int MAX_NUMBER_OF_ATTEMPTS=JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();	
    private static int currentAttempt=1;
	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
