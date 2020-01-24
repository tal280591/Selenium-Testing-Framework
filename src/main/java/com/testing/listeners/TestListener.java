package com.testing.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.testing.extentreports.ExtentManager;
import com.testing.extentreports.ExtentTestManager;
import com.testing.framework.LocalDriverContext;
import com.testing.logger.Log;



public class TestListener implements ITestListener {
	
	
	
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
		//System.out.println(context.getName() + " " + WebDriverFacade.getRemoteWebDriver().toString());
		Log.startTestCase(context.getName());
		Log.debug(context.getName() + " suite has been started, " + "Thread id: " + Thread.currentThread().getId());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		Log.debug(context.getName() + " suite ended, " + "Thread id: " + Thread.currentThread().getId());
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		Log.startTestCase(result.getMethod().getMethodName());
		Log.debug(result.getMethod().getMethodName() + " test is running");
		Log.debug("Thread id: " + Thread.currentThread().getId());
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		Log.debug(result.getMethod().getMethodName() + " test was ended successfully, test PASSED!!! ");
		Log.debug("Thread id: " + Thread.currentThread().getId());
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		Log.endTestCase("");
		
	}

//	public void onTestFailure(ITestResult result) {
//		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//	}

	public void onTestFailure(ITestResult result) {
		//Object testClass = result.getInstance();
		
		//WebDriver webDriver = BaseTest.webDriver.get();
		//WebDriverFacade webDriver = (WebDriverFacade)result.getTestContext().getAttribute("webDriver");		
		//WebDriver webDriver = ((BaseTest)result.getInstance()).webDriver.get();
		
		
		
		String methodName = result.getMethod().getMethodName();
				
		System.out.println("*** Test execution " + methodName + " failed...");
		String description = result.getMethod().getDescription();
				
		if(description!=null) {
			ExtentTestManager.getTest().log(Status.FAIL, description +" Test Failed");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, methodName +" Test Failed");
		}
		
		Log.debug(result.getMethod().getMethodName() + " test FAILED!!! ");
		Log.debug("Priority of test: " + result.getMethod().getPriority());
		Log.debug(result.getMethod().getQualifiedName());
		Log.debug("Friend in groups: " +result.getMethod().getGroups());
		Log.debug("Thread id: " + Thread.currentThread().getId());
		
        String screenshotPath =null;;
		try {
			screenshotPath = ExtentTestManager.getScreenhot(LocalDriverContext.getRemoteWebDriver(), result.getName());
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.debug("screen shot was taken, path to screenshot: " + screenshotPath);
		Log.debug("Thread id: " + Thread.currentThread().getId());
		Log.endTestCase("");
		  
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		Log.debug(result.getMethod().getMethodName() + " test skipped ");
		Log.debug("Test depends upon " +result.getMethod().getMethodsDependedUpon());
		Log.debug("Thread id: " + Thread.currentThread().getId());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}



