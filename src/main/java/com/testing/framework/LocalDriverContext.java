package com.testing.framework;

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
	    			WebDriverWait wait = new WebDriverWait(remoteWebDriverThreadLocal.get(), waitForElement);
	    			ExecuteJavaScriptToScrollToAnElement(element);	    			
	    			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	    		}catch (NotFoundException e) {
					e.printStackTrace();
				}			
			
	    }
	    

		
		
		public static String getCurrentUrl()
		{
			return remoteWebDriverThreadLocal.get().getCurrentUrl();
		}


		public static String getTxt(WebElement element) {
			try {
				ExecuteJavaScriptToScrollToAnElement(element);
    			WebDriverWait wait = new WebDriverWait(remoteWebDriverThreadLocal.get(), waitForElement);
    			wait.until(ExpectedConditions.visibilityOf(element));
    			return element.getText();
    		}catch (NotFoundException e) {
    			 e.printStackTrace();
			}
			return null;			
		
		}
		
		public static String getAttribute(WebElement element, String attribute) {
			try {
				ExecuteJavaScriptToScrollToAnElement(element);
				WebDriverWait wait = new WebDriverWait(remoteWebDriverThreadLocal.get(), waitForElement);
				wait.until(ExpectedConditions.visibilityOf(element));
				return element.getAttribute(attribute);
			}catch(NotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}

}
