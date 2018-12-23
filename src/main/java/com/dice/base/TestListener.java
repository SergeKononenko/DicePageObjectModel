package com.dice.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestUtilities implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult tr) {
		
	}

	@Override
	public void onTestFailure(ITestResult tr) {
	}	

	@Override
	public void onStart(ITestContext testContext) {
		log.info("onStart of " + testContext.getName());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("onTestStart of " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(
			ITestResult result) {
		
		
	}

	
}
