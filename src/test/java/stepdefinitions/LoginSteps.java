package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.framework.Base;
import com.testing.framework.BasePage;
import com.testing.framework.LocalDriverContext;
import com.testing.pageobjects.HomePageObject;
import com.testing.pageobjects.LoginPage;
import com.testing.testpages.BaseTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class LoginSteps extends BasePage {
	
		
		
	
			
	    @Given("^Initialized the browser$")
	    public void initialized_the_browser() throws Throwable {
	    	
	    }

	    @When("^The user enters (.+) and (.+)$")
	    public void the_user_enters_and(String userName, String password) throws Throwable {
	    	 CurrentPage = GetInstance(LoginPage.class);
	    	 
	    	 CurrentPage.As(LoginPage.class).enterUserName(userName);
	    	 CurrentPage.As(LoginPage.class).enterPassword(password);
	    	 CurrentPage.As(LoginPage.class).clickOnTheLoginButton();
	    }

	    @Then("^Verify that user is successfully logged in$")
	    public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    	boolean loggedin = false;
	    	 CurrentPage = GetInstance(LoginPage.class);
			String accountLink = CurrentPage.As(LoginPage.class).GetAccountLink();
			
			if(accountLink.equals("ACCOUNT")) {
				loggedin = true;
			}

			assertTrue(loggedin);
	    }

	    @And("^Navigate to \"([^\"]*)\"$")
	    public void navigate_to_something(String strArg1) throws Throwable {
	    	LocalDriverContext.navigate(strArg1);
	    }

	    @And("^In home page click on the login button$")
	    public void in_home_page_click_on_the_login_button() throws Throwable {
	    	CurrentPage = GetInstance(HomePageObject.class);
	    	CurrentPage.As(HomePageObject.class).ClickOnTheLoginLink();
	      
	    }

	    @And("^Close browsers$")
	    public void close_browsers() throws Throwable {
	      
	    }

}