package com.testing.testpages;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.testing.emailreport.MailReport;
import com.testing.framework.CapabilityFactory;
import com.testing.framework.LocalDriverContext;

public abstract class Base extends com.testing.framework.Base {
	
	protected RemoteWebDriver remoteWebDriver;
	protected CapabilityFactory capabilityFactory = new CapabilityFactory();
		
	
	public abstract void setup(ITestContext context,String browser) throws MalformedURLException; 
	
	public RemoteWebDriver getDriver() {
        return LocalDriverContext.getRemoteWebDriver();
    }
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		MailReport.createMail();
		
	}
}
