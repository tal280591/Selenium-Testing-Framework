package com.testing.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalDriverContext {
	
	 public static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<RemoteWebDriver>();
	 private static long waitForElement = 5;
	 	
	 public static RemoteWebDriver getRemoteWebDriver() {
	 		return remoteWebDriverThreadLocal.get();
	 	}
	  
	 
	    public static void setWebDriver(RemoteWebDriver driverThreadLocal) {
	        remoteWebDriverThreadLocal.set(driverThreadLocal);
	    }
	    
	    public static void navigate(String navigateTo) {
	    	remoteWebDriverThreadLocal.get().get(navigateTo);
	    	remoteWebDriverThreadLocal.get().navigate();
	    }

	    public static void Stop()
	    {
	    	//webDriver.close();
	    	remoteWebDriverThreadLocal.get().close();
	    	
	       
	    }

	    public static Object ExecuteJavaScript(String script)
	    {
	        return ((JavascriptExecutor)remoteWebDriverThreadLocal.get()).executeScript("return " + script);
	            
	    }
	    
	    public static  void ExecuteJavaScriptToScrollToAnElement(WebElement element) {
	    	
	    	((JavascriptExecutor)remoteWebDriverThreadLocal.get()).
	    		executeScript("arguments[0].scrollIntoView()", element); 	
	    }
	    

	    public static WebElement FindElement(By by)
	    {
	        try
	        {
	            WebDriverWait wait = new WebDriverWait(remoteWebDriverThreadLocal.get(), waitForElement);
	            return wait.until(ExpectedConditions.elementToBeClickable(by));
	        }catch(Exception ex)
	        {
	            return NullWebElement.getInstance();
	        }
	    }
	    
	    public static void click(WebElement element) {
	    	
	    		try {
	    			element.click();
	    		}catch (NotFoundException e) {
					// TODO: handle exception
				}			
			
	    }
	    

		
		
		public static String getCurrentUrl()
		{
			return remoteWebDriverThreadLocal.get().getCurrentUrl();
		}

}
