package com.testing.pageobjects;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.testing.framework.LocalDriverContext;
import com.testing.framework.BasePage;



public class LoginPage extends BasePage {

//	public LoginPage(RemoteWebDriver webDriver) {
//		super(webDriver);		
//	}
	private final String loginPageUrl = "https://www.tennis-warehouse.com/loginaccount.html";
	
	public String getLoginPageUrl() {
		return loginPageUrl;
	}
	@FindBy(xpath="//*[@id=\"login\"]/a")
	WebElement loginLink;
	
	@FindBy(name ="login")
	WebElement userName;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login_form\"]/div/div[6]/input")
	WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"login\"]/form/a")
	WebElement accountLink;
	
	
	
	public void ClickOnTheLoginLink() {
		LocalDriverContext.click(loginLink);
			
	}	
	public String getTheUrlAfterNavigationToTheLoginPage() {
		return LocalDriverContext.getCurrentUrl();
	}
	
	public void enterUserName(String userName) {
		this.userName.sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickOnTheLoginButton() {
		loginButton.click();
	}
	
	public String GetAccountLink(){
		String txt = null;
		try {
			txt = accountLink.getText();
		}catch(NotFoundException e) {
			txt= "";
		}
		
		return txt;
		
	}
	public String navigateToLoginPage() {
		ClickOnTheLoginLink();
		return getTheUrlAfterNavigationToTheLoginPage();
	}
	
}
