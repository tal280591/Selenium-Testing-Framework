package cucumberoptions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.constants.Constants;
import com.testing.framework.LocalDriverContext;
import com.testing.testpages.Base;
import com.testing.testpages.BaseTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(
			features = "src/test/java/features",
			glue = "stepdefinitions")
			 
	public class TestRunner extends Base  {
	
		private TestNGCucumberRunner testNGCucumberRunner;
		
		@Override
		@Parameters("browser")
		@BeforeClass(alwaysRun = true)
		public void setup(ITestContext context,String browser) throws MalformedURLException {
			
			remoteWebDriver = new RemoteWebDriver(new URL(Constants.hubUrl), capabilityFactory.getCapabilities(browser));
			LocalDriverContext.setWebDriver(remoteWebDriver); 
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
			System.out.println(LocalDriverContext.getRemoteWebDriver().toString());
			
		}
		
	
		@Test(dataProvider = "features")
		public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {
			testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
		}
		
		@DataProvider
		public Object[][] features(){
			return testNGCucumberRunner.provideFeatures();
		}
		
		@AfterClass(alwaysRun = true)
		public void afterClass() {
			testNGCucumberRunner.finish();
		}
		
	}
