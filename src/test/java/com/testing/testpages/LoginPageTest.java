package com.testing.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testing.constants.Constants;
import com.testing.extentreports.ExtentTestManager;
import com.testing.framework.Base;
import com.testing.framework.LocalDriverContext;
import com.testing.pageobjects.HomePageObject;
import com.testing.pageobjects.LoginPage;


public class LoginPageTest extends BaseTest {
	
	
	private LoginPage login;
	private String landingUrl;
	
	public LoginPageTest() {
		landingUrl = "https://www.tennis-warehouse.com/";
	}
		
	
	@BeforeMethod(alwaysRun = true)
	public void bm() {
		//login = new LoginPage(getDriver());
		login= GetInstance(LoginPage.class);
		//login = CurrentPage.As(LoginPage.class);
		LocalDriverContext.navigate(landingUrl);
		System.out.println(getDriver().toString());
	}
	@Parameters("go-to-login-param")
	@Test(priority = 0)
	public void goToLoginPage(String expectedResult) {
		
		CurrentPage = GetInstance(HomePageObject.class);
		String loginPageText = CurrentPage.As(HomePageObject.class).ClickOnTheLoginLink();
		assertEquals(loginPageText, expectedResult);

	}
	
	@Test(priority = 1)
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

