package com.testing.framework;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage extends Base {
//	  //Declare the WebDriver
//	protected RemoteWebDriver webDriver;
//        
//    //constructor of base class
//    public BasePage(RemoteWebDriver webDriver) {
//    	this.webDriver = webDriver;
////	    PageFactory.initElements(this.webDriver.get(), this);  
//    	PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,5), this); 
	
	public <TPage extends BasePage> TPage As(Class<TPage> pageInstance)
    {
        try
        {
            return (TPage)this;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }

        return null;
    }
}
