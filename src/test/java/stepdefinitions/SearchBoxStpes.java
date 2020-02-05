package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.testing.framework.BasePage;
import com.testing.framework.LocalDriverContext;
import com.testing.pageobjects.HomePageObject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchBoxStpes extends BasePage {
	
	
	
//	@BeforeMethod(alwaysRun = true)
//	public void intin() {
//		homePage = GetInstance(HomePageObject.class);
//	}
//	
	
 	@Given("^Navigated to \"([^\"]*)\"$")
    public void navigated_to_something(String strArg1) throws Throwable {
 		LocalDriverContext.navigate(strArg1);
    }

    @When("^The user clicks on the serach button$")
    public void the_user_clicks_on_the_serach_button() throws Throwable {
    	CurrentPage = GetInstance(HomePageObject.class);
    	CurrentPage.As(HomePageObject.class).ClickOnSearchButton();
        
    }

    
    @Then("^Verify that the user moved to the (.+) page$")
    public void verify_that_the_user_moved_to_the_page(String item) throws Throwable {
      	CurrentPage = GetInstance(HomePageObject.class);
      	boolean res = CurrentPage.As(HomePageObject.class).ValidateSearchPerformedAsExpected(item);

    	assertTrue(res);
    }

    @And("^Insert (.+) into the search box field$")
    public void insert_into_the_search_box_field(String item) throws Throwable {
    	CurrentPage = GetInstance(HomePageObject.class);
    	CurrentPage.As(HomePageObject.class).SearchFor(item);
    }

	  
}
