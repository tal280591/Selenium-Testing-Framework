package com.testing.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class NullWebElement implements WebElement 
{

	private static NullWebElement instance;
	//public static WebElement NULL;
	
	public static NullWebElement getInstance() 
	{ 
	    if (instance == null) 
            instance = new NullWebElement(); 
  
        return instance; 
	} 
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void click() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
//		System.out.println("Element cannot be found" + arg0.toString());
		return null;
	}
	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getCssValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void sendKeys(CharSequence... arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}

}
