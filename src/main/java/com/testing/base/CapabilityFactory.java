package com.testing.base;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
	 	public Capabilities capabilities;
	 
	    public Capabilities getCapabilities (String browser) {
	        if (browser.equals("firefox"))
	            capabilities = OptionsManager.getFirefoxOptions();
	        else if(browser.equals("chrome"))
	            capabilities = OptionsManager.getChromeOptions();
	        else
	        	capabilities = OptionsManager.getEdgeOptions();
	        
	        return capabilities;
	    }
}
