package com.testing.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.testing.enums.Gender;
import com.testing.helper.Helper;



public class HomePageObject extends PageObject{

	//	  private WebDriverFacade webDriver;
	//	  private WebElement element;

	public HomePageObject(RemoteWebDriver webDriver)
	{
		super(webDriver);
		
	}
	

	@FindBy(xpath = "//*[@id=\"searchtext\"]")
	WebElement searchField;

	@FindBy(id="search_icon")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"home_link\"]")
	WebElement pageTitle;

	@FindBy(xpath = "//*[@id=\"searchnavbar\"]/h1/span[1]")
	WebElement searchResultTxt;

	@FindBy(xpath = "//*[@class=\"lnav_columns cf\"]//div[1]//a")
	List<WebElement> mensShoes;
	
	@FindBy(xpath=	"//*[@class=\"lnav_columns cf\"]//div[2]//a")
	List<WebElement> womenShoes;
	

	public void SearchFor(String text)
	{
		searchField.sendKeys(text);
	}

	public String GetPageTitle() {
		return pageTitle.getText();
	}

	public void ClickOnSearchButton() {
		searchButton.click();
	}

	public void ClearSearch()
	{
		
		searchField.clear();
	}

	public String ValidateSearchPerformedAsExpected() {

		return searchResultTxt.getText();
	}


	public void clickOnShoeElementByBrand(String shoeBrand, String gender) {
				
		Helper.clickOnListElementEquals(getShoesListByGender(gender), shoeBrand);		
	}
	
	public List<WebElement> getShoesListByGender(String gender) {
		if(gender.equals(Gender.MALE.getGender())){
			return mensShoes;			
		}
		else
			return womenShoes;
	}
	
	

}
