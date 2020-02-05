package com.testing.testpages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.testing.constants.Constants;
import com.testing.emailreport.MailReport;

import com.testing.framework.CapabilityFactory;
import com.testing.framework.LocalDriverContext;


public class BaseTest extends Base {
	
	
//	public CapabilityFactory capabilityFactory = new CapabilityFactory();
//	public RemoteWebDriver remoteWebDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void Init() throws MalformedURLException {
		//hubUrl = new URL("http://localhost:4444/wd/hub");		
	}
	
//	@BeforeClass(alwaysRun = true)
//	@Parameters("browser")
	@Override
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setup(ITestContext context,String browser) throws MalformedURLException {
		
		remoteWebDriver = new RemoteWebDriver(new URL(Constants.hubUrl), capabilityFactory.getCapabilities(browser));
		LocalDriverContext.setWebDriver(remoteWebDriver);            		
		System.out.println(LocalDriverContext.getRemoteWebDriver().toString());
		
	}

//	public RemoteWebDriver getDriver() {
//        return LocalDriverContext.getRemoteWebDriver();
//    }
	
//	@AfterMethod(alwaysRun = true)
//	public void teardown() {
//		getDriver().quit();
//	}
 
//	@AfterTest(alwaysRun = true)
//	public void teardown() {
//		LocalDriverContext.stop();
//	}
//	@AfterSuite(alwaysRun = true)
//	public void afterSuite() {
//		getDriver().quit();
//		
//	}



	
	
	
//    @AfterMethod
//    public void tearDown() {
//        getDriver().quit();
//    }
 
    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
    	getDriver().quit();
    }
    

//	@AfterTest
//	public void Teardown() {
//		
//	}
	
		
	

	

}
