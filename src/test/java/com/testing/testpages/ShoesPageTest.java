package com.testing.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testing.dataproviders.GenderDataProvider;
import com.testing.dataproviders.ShoesDataProvider;
import com.testing.enums.Gender;
import com.testing.extentreports.ExtentTestManager;
import com.testing.framework.Base;
import com.testing.framework.LocalDriverContext;
import com.testing.helper.Helper;
import com.testing.pageobjects.HomePageObject;

import com.testing.pageobjects.ShoesBrandsPage;
import com.testing.pageobjects.ShoesPage;



public class ShoesPageTest extends BaseTest {
	
	private String landingUrl;
	private ShoesPage shoesPage;
	
	public ShoesPageTest() {
		landingUrl = "https://www.tennis-warehouse.com/";
	}


	
	@BeforeMethod
	public void navigate() {
		shoesPage = GetInstance(ShoesPage.class);
		LocalDriverContext.navigate(landingUrl);
		System.out.println(LocalDriverContext.getRemoteWebDriver().toString());
	}
	
	@Test(dataProvider = "Gender", dataProviderClass = GenderDataProvider.class)
	public void checkShoesGenderTitle(String gender ) {
		
		CurrentPage = GetInstance(HomePageObject.class);
		String elementName = CurrentPage.As(HomePageObject.class).getShoesListByGender(gender).get(0).getText();
		CurrentPage.As(HomePageObject.class).clickOnShoeElementByBrand(elementName, gender);
		
		ExtentTestManager.getTest().info(MarkupHelper.createLabel(gender, ExtentColor.BLUE));
		String actualTitle = shoesPage.getPageTitle();
		assertEquals(actualTitle, gender + " Tennis Shoes");
	}
	
	@Test(dataProvider = "Men-Shoes-Brand", dataProviderClass = ShoesDataProvider.class)
	public void clickOnSpecificBrand(String shoeBrand, String expectedUrl) 
			throws MalformedURLException
	{
		
		CurrentPage = GetInstance(HomePageObject.class);
		CurrentPage = CurrentPage.As(HomePageObject.class).clickOnShoeElementByBrand(Gender.MALE.getGender(), Gender.MALE.getGender());
		shoesPage.clickOnShoeBrand(shoeBrand, "alt");
		String actualBrandPage = CurrentPage.As(ShoesBrandsPage.class).getPageTitle();
		assertTrue(Helper.containsValue(shoeBrand, actualBrandPage));
	}
}



