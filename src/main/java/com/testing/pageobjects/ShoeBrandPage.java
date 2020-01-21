package com.testing.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.testing.helper.Helper;



public class ShoeBrandPage extends PageObject {

	public ShoeBrandPage(RemoteWebDriver remoteWebDriver) {
		super(remoteWebDriver);
		
	}
	@FindBy(xpath = "//h1[starts-with(@id,'MS')][1]")
	WebElement pageTitle;
	
	@FindBy(xpath = "//ul[@class=\"cat_jumplinks-list\"]//li[starts-with(@class,\"cat_jumplinks-list\")]//a")
	List<WebElement> sortOptions;
	
	@FindBy(xpath=".//div[@class=\"product_wrapper cf shoe\"]//a[contains(@class,\"name \")]")
	List<WebElement> shoesElements;
	
	@FindBy(xpath = "//*[@class=\"product_wrapper cf shoe\"]//*[starts-with(@class, 'producttag') or @class = \"name notag_pad\"] ")
	List<WebElement> productTagList;
	
	
	
	public void ClickOnSortByOption(String sortBy) {
		Helper.clickOnListElementEquals(sortOptions, sortBy);
	}
	public boolean validatesFilteredCorrectly(String sortBy) {
		return Helper.checkFilteredPage(productTagList, sortBy);
	}
	public void ClickOnRandomShoeElement() {

		Helper.clickOnRandomElement(shoesElements);
	}
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
	
	
	

}