package com.testing.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.LocalDriverContext;



public class Helper {
	
	public static void clickOnListElementEquals(List<WebElement> list, String elementName) {
		
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(elementName)) {
				
				LocalDriverContext.ExecuteJavaScriptToScrollToAnElement(list.get(i));
					list.get(i).click();
				
				break;
			}				
		}
	}
	
	public static void clickOnListElementContains(List<WebElement> list, 
			String elementName, String attribute) {
		for(int i=0; i<list.size();i++) {
			String element = list.get(i).getAttribute(attribute);
			if(element.contains(elementName) || element.contains(elementName.toLowerCase())) {
				
				LocalDriverContext.ExecuteJavaScriptToScrollToAnElement(list.get(i));
					list.get(i).click();
								
				break;
			}		
		}
	}
	
//	public static void clickOnListElement(WebDriverFacade webDriver, List<WebElement> list, 
//			String elementName , String attribute) {
//		for(WebElement element : list) {
//			element.click();
//		}
//	}
	
	public static void clickOnListElementActionContains(List<WebElement> list, 
			String elementName, String attribute) {
		for(int i=0; i<list.size();i++) {
			String element = list.get(i).getAttribute(attribute);
			if(element.contains(elementName) || element.contains(elementName.toLowerCase())) {
					LocalDriverContext.ExecuteJavaScriptToScrollToAnElement(list.get(i));
					Actions action = new Actions(LocalDriverContext.getRemoteWebDriver());
					action.moveToElement(list.get(i)).click().perform();
							
				break;
			}		
		}
	}

	public static boolean checkFilteredPage(List<WebElement> table, String sortBy) {
		
		for(WebElement element : table) {
			if(element.getText().equals(sortBy))
				continue;
			else 
				return false;						
		}
		return true;	
	}
	
	
	public static boolean CheckIfURLEquality(String expectedUrl, String urlAdderss) 
			throws MalformedURLException {
		URL url = new URL(urlAdderss);
		String fileName = url.getFile();
				
		if(fileName.equals(expectedUrl)){
			return true;
		}
		return false;
		
	}
	
	public  static String getUrl() {
		
		return LocalDriverContext.getCurrentUrl();
	}
	
	public  static void clickOnRandomElement(List<WebElement> list) {
		
		Random rand = new Random();
		int randomSelect = rand.nextInt(list.size());
		clickOnListElementEquals(list, list.get(randomSelect).getText());
	}
	
	public  static boolean containsValue(String containedString, String containsString) {
		if(containsString.contains(containedString) || 
				containsString.contains(containedString.toLowerCase()))
			return true;
		return false;
		
	}
	
	public  static void performClick(WebElement element) {
		
			element.click();
		
	}
	
	public static  void test() {
		System.out.println("hello");
	}
	
//	public static void extentReprotDataSupplier(String s) {
//		
//	}
//	public static void extentReprotDataSupplier(String s1,String s2) {
//		
//	}
//	public static void extentReprotDataSupplier(String s1, String s2, String s3) {
//		
//	}
//	public static void extentReprotDataSupplier(String s) {
//		
//	}

}
