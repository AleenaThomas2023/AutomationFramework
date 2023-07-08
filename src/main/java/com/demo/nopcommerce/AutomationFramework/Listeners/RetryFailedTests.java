package com.demo.nopcommerce.AutomationFramework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {

	int maxCounter=2;  //for failed test cases
	int count=1;
	
	
	//how many times we need to run failed test cases
	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test!!!!!!!!!!"+ result.getMethod().getMethodName()+ "for "+count+ "times");
		if (count<maxCounter)  {
			count++;
			return true;
		}
		
		return false;
	}
	
	

}
