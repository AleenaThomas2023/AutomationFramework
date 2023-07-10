package com.demo.nopcommerce.AutomationFramework.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


import com.demo.nopcommerce.AutomationFramework.Utils.Utils;
import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class CustomListener2 extends TestBase implements ITestListener {
	

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test execution started for"+result.getMethod().getMethodName() +" *******************");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test"+result.getMethod().getMethodName() + "passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		logger.info("Test"+result.getMethod().getMethodName() + "failed"+" !!!!!!!!!!!!!!!!!!!");
		Utils.takeScreenShot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test"+result.getMethod().getMethodName() + "skipped"+" ###################");
	}

}
