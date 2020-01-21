package com.testing.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testing.base.LocalDriverContext;
import com.testing.dataproviders.ShoesDataProvider;
import com.testing.enums.BaseSortBy;
import com.testing.enums.Gender;
import com.testing.extentreports.ExtentTestManager;
import com.testing.helper.Helper;
import com.testing.pageobjects.HomePageObject;
import com.testing.pageobjects.ShoeBrandPage;



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
		homePage = new HomePageObject(getDriver());
		LocalDriverContext.navigate(landingUrl);
	}
	
	
	@Test(groups = "sanity-test", priority = 0)
	public void valdiateTitle() {
						
		String expectedTitle = "Tennis Warehouse";
		String homePageTitle = homePage.GetPageTitle();
		
		assertEquals(homePageTitle, expectedTitle);
	}
	
	@Test(groups = "sanity-test", priority = 0)
	public void validateSearchBox() {

		String expectedSearchResult = "Search Results for \"wilson pro staff\"";						
		homePage.SearchFor("wilson pro staff");
		homePage.ClickOnSearchButton();	
		String actualSearchResult = homePage.ValidateSearchPerformedAsExpected();
		
		assertEquals(actualSearchResult, expectedSearchResult);		
	}
	
	
	@Test(groups = "functionallity",dataProvider = "Men-Shoes-Brand", dataProviderClass = ShoesDataProvider.class,
			dependsOnGroups = "sanity-test", successPercentage = 20, priority = 0)
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
		
		homePage.clickOnShoeElementByBrand(shoeBrand, Gender.MALE.getGender());				
		ShoeBrandPage shoesPage = new ShoeBrandPage(getDriver());
		shoesPage.ClickOnSortByOption(BaseSortBy.NEW.getAction());
		boolean isFiltered = shoesPage.validatesFilteredCorrectly(BaseSortBy.NEW.getAction());
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
		
		ShoeBrandPage shoesPage = new ShoeBrandPage(getDriver());
		homePage.clickOnShoeElementByBrand(shoeBrand, Gender.MALE.getGender());
		shoesPage.ClickOnRandomShoeElement(); 
		
		
	}
	
	public String getUrlAfterClick(String shoeBrand, String gender) {
		
		homePage.clickOnShoeElementByBrand(shoeBrand, gender);			
		return Helper.getUrl();
		
	}

}
