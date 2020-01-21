package com.testing.pageobjects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject {
	  //Declare the WebDriver
	protected RemoteWebDriver webDriver;
        
    //constructor of base class
    public PageObject(RemoteWebDriver webDriver) {
    	this.webDriver = webDriver;
//	    PageFactory.initElements(this.webDriver.get(), this);  
    	PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,5), this); 
    	
    }

}
