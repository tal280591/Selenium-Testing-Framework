package com.testing.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.testing.base.LocalDriverContext;
import com.testing.dataproviders.GenderDataProvider;
import com.testing.dataproviders.ShoesDataProvider;
import com.testing.enums.Gender;
import com.testing.extentreports.ExtentTestManager;
import com.testing.helper.Helper;
import com.testing.pageobjects.HomePageObject;
import com.testing.pageobjects.ShoeBrandPage;
import com.testing.pageobjects.ShoesPage;



public class ShoesPageTest extends BaseTest {
	
	private String landingUrl;
	private ShoesPage shoesPage;
	private HomePageObject homePage;
	private ShoeBrandPage shoeBrandPage;

	public ShoesPageTest() {
		landingUrl = "https://www.tennis-warehouse.com/";
	}

		
	@BeforeClass
	public void init() {
		this.homePage = new HomePageObject(getDriver());
		this.shoesPage = new ShoesPage(getDriver());
		this.shoeBrandPage = new ShoeBrandPage(getDriver());
		
		
	}
	
	@BeforeMethod
	public void navigate() {
		LocalDriverContext.navigate(landingUrl);
		System.out.println(LocalDriverContext.getRemoteWebDriver().toString());
	}
	
	@Test(dataProvider = "Gender", dataProviderClass = GenderDataProvider.class)
	public void checkShoesGenderTitle(String gender ) {
		
		//HomePageObject homePage = new HomePageObject(webDriver);
		String elementName = homePage.getShoesListByGender(gender).get(0).getText();
		homePage.clickOnShoeElementByBrand(elementName, gender);
		
		ExtentTestManager.getTest().info(MarkupHelper.createLabel(gender, ExtentColor.BLUE));
		String actualTitle = shoesPage.getPageTitle();
		assertEquals(actualTitle, gender + " Tennis Shoes");
	}
	
	@Test(dataProvider = "Men-Shoes-Brand", dataProviderClass = ShoesDataProvider.class)
	public void clickOnSpecificBrand(String shoeBrand, String expectedUrl) 
			throws MalformedURLException
	{
		
		//HomePageObject homePage = new HomePageObject(webDriver);
		homePage.clickOnShoeElementByBrand(Gender.MALE.getGender(), Gender.MALE.getGender());
		shoesPage.clickOnShoeBrand(shoeBrand, "alt");
		//String urlAfterBrandClicked = Helper.getUrl(webDriver);
		String actualBrandPage = shoeBrandPage.getPageTitle();
		assertTrue(Helper.containsValue(shoeBrand, actualBrandPage));
	}
}



