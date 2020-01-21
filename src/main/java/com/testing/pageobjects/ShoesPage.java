package com.testing.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.testing.helper.Helper;



public class ShoesPage extends PageObject {
	
	public ShoesPage(RemoteWebDriver webDriver) {
		super(webDriver);		
	}

	
	@FindBy(xpath = "//div[@id='content_wrap']//h1")
	WebElement pageTitle;
	
	@FindBy(xpath = "//div[@class=\"logo\"]//img")
	List<WebElement> shoesBrandTable;
	
	public String getPageTitle(){
		return pageTitle.getText();
	}
	public void clickOnShoeBrand(String shoeElement, String attribute) {
		Helper.clickOnListElementActionContains(shoesBrandTable, shoeElement, attribute);
	}
	public List<WebElement> getBrandsTable() {
		return shoesBrandTable;
	}

}
