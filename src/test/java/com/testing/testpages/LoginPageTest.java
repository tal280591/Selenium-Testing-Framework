package com.testing.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testing.base.LocalDriverContext;
import com.testing.constants.Constants;
import com.testing.extentreports.ExtentTestManager;
import com.testing.pageobjects.LoginPage;


public class LoginPageTest extends BaseTest {
	
	
	private LoginPage login;
	private String landingUrl;
	
	public LoginPageTest() {
		landingUrl = "https://www.tennis-warehouse.com/";
	}
		
//	@BeforeTest(alwaysRun = true)
//	public void init(ITestContext context) {
//		login = new LoginPage(getDriver());
//	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void bm() {
		login = new LoginPage(getDriver());
		LocalDriverContext.navigate(landingUrl);
		System.out.println(getDriver().toString());
	}
	@Test(description = "login test", groups = "sanity-test", priority = 0)
	public void goToLoginPage() {
		
		assertEquals(login.navigateToLoginPage(), login.getLoginPageUrl());

	}
	
	@Test(dependsOnMethods = "goToLoginPage", groups = "sanity-test", priority = 1)
	public void login() {
		
		boolean loggedin = false;
		
		login.ClickOnTheLoginLink();		
		login.enterUserName(Constants.USERNAME);
		login.enterPassword(Constants.PASSWORD);
		login.clickOnTheLoginButton();
		String accountLink = login.GetAccountLink();
		
		if(accountLink.equals("ACCOUNT")) {
			loggedin = true;
		}
			
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Credentials: \n" 
				+ Constants.USERNAME + ", " +Constants.PASSWORD  ,ExtentColor.BLUE));
		
		assertTrue(loggedin);
		
	}

}

