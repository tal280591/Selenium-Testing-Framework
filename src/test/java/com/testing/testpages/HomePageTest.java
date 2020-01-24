package com.testing.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testing.dataproviders.ShoesDataProvider;
import com.testing.enums.BaseSortBy;
import com.testing.enums.Gender;
import com.testing.extentreports.ExtentTestManager;
import com.testing.framework.Base;
import com.testing.framework.LocalDriverContext;
import com.testing.helper.Helper;
import com.testing.pageobjects.HomePageObject;

import com.testing.pageobjects.ShoesBrandsPage;



public class HomePageTest extends BaseTest
{
	private String landingUrl;
	private HomePageObject homePage;

	public HomePageTest() {
		
		landingUrl = "https://www.tennis-warehouse.com/";
		
	}

	
//	@BeforeTest(alwaysRun = true)
//	public void init(ITestContext context) {
//		
//		homePage = new HomePageObject(getDriver());
//	}
	
	@BeforeMethod(alwaysRun = true)
	public void navigateToHomePage() {
//		homePage = new HomePageObject(getDriver());
		//CurrentPage = GetInstance(HomePageObject.class);
		homePage = GetInstance(HomePageObject.class);
		LocalDriverContext.navigate(landingUrl);
	}
	
	
	@Test(priority = 0)
	public void valdiateTitle() {
						
		String expectedTitle = "Tennis Warehouse";
		//CurrentPage = GetInstance(HomePageObject.class);		
		String homePageTitle = homePage.GetPageTitle();
		
		assertEquals(homePageTitle, expectedTitle);
	}
	
	@Test(priority = 0)
	public void validateSearchBox() {

		String expectedSearchResult = "Search Results for \"wilson pro staff\"";						
		homePage.SearchFor("wilson pro staff");
		homePage.ClickOnSearchButton();	
		String actualSearchResult = homePage.ValidateSearchPerformedAsExpected();
		
		assertEquals(actualSearchResult, expectedSearchResult);		
	}
	
	
	@Test(dataProvider = "Men-Shoes-Brand", dataProviderClass = ShoesDataProvider.class,
			priority = 0)
	public void clickOnShoesBrandLinkForMen(String shoeBrand, String expectedUrl) 
			throws MalformedURLException {
		
		String urlAfterBrandClicked = getUrlAfterClick(shoeBrand, Gender.MALE.getGender());
		
		assertTrue(Helper.CheckIfURLEquality(expectedUrl, urlAfterBrandClicked));
	}
	
	@Test(dataProvider = "Women-Shoes-Brand", dataProviderClass = ShoesDataProvider.class, priority = 1)
	public void clickOnShoesBrandLinkForWomen(String shoeBrand, String expectedUrl) 
			throws MalformedURLException {
			
		String urlAfterBrandClicked = getUrlAfterClick(shoeBrand, Gender.FEMALE.getGender());
		
		assertTrue(Helper.CheckIfURLEquality(expectedUrl, urlAfterBrandClicked));
	}
	
	
	@Test(dataProvider = "Men-Shoes-Brand", dataProviderClass = ShoesDataProvider.class,
			dependsOnMethods = "clickOnShoesBrandLinkForMen", 
			description = "At specific brand shoes page, filter acording to the provided sort method",
			priority = 1)
	public void filteredShoesBySortType(String shoeBrand, String s) {
		
		
		CurrentPage = homePage.clickOnShoeElementByBrand(shoeBrand, Gender.MALE.getGender());			
		CurrentPage.As(ShoesBrandsPage.class).ClickOnSortByOption(BaseSortBy.NEW.getAction());
		 
		boolean isFiltered = CurrentPage.As(ShoesBrandsPage.class).validatesFilteredCorrectly(BaseSortBy.NEW.getAction());
		String[][] data = {
				{"Brand", "Filtered By Method"},
				{shoeBrand, BaseSortBy.NEW.getAction()}				
		};		
		ExtentTestManager.getTest().info(MarkupHelper.createTable(data));
				
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Brand: " + shoeBrand, ExtentColor.BLUE));
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SortBy " + BaseSortBy.NEW.getAction(), ExtentColor.BLUE));
		
		assertTrue(isFiltered);		
		
	}
	
	@Test(dataProvider = "Men-Shoes-Brand", dataProviderClass = ShoesDataProvider.class,
		dependsOnMethods = "filteredShoesBySortType", priority = 1)
	public void addShoeToBasket(String shoeBrand, String s) {
		
		//ShoesBrandsPage shoesPage = new ShoesBrandsPage(getDriver());
		 CurrentPage = homePage.clickOnShoeElementByBrand(shoeBrand, Gender.MALE.getGender());
		 CurrentPage.As(ShoesBrandsPage.class).ClickOnRandomShoeElement(); 
		
		
	}
	
	public String getUrlAfterClick(String shoeBrand, String gender) {
		
		homePage.clickOnShoeElementByBrand(shoeBrand, gender);			
		return Helper.getUrl();
		
	}

}
