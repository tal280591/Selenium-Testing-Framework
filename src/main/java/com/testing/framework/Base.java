package com.testing.framework;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Base {
	
	 public BasePage CurrentPage;

	    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page)
	    {
	        Object obj = PageFactory.initElements(LocalDriverContext.getRemoteWebDriver(), page);
	        return page.cast(obj);
	    }
	   
}
