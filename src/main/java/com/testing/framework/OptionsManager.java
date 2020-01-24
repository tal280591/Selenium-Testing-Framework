package com.testing.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsManager {

	  public static ChromeOptions getChromeOptions() {

	        DesiredCapabilities cap = new DesiredCapabilities();

			cap.setPlatform(Platform.ANY);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.merge(cap);

	        return options;
	    }

	    //Get Firefox Options
	    public static FirefoxOptions getFirefoxOptions () {

	        DesiredCapabilities cap = new DesiredCapabilities();
        	//System.setProperty("webdriver.gecko.driver", "C:/WebDrivers/FireFoxDriver/geckodriver.exe");
			//cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);  
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			options.merge(cap);

	        return options;
	    }

	    public static EdgeOptions getEdgeOptions(){
	    	DesiredCapabilities cap = new DesiredCapabilities();
	    	cap.setPlatform(Platform.WIN10); 
	    	EdgeOptions options = new EdgeOptions();
	    	options.merge(cap);

	    	return options;
	    }

}