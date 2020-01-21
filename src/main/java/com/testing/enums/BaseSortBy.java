package com.testing.enums;

public enum BaseSortBy {
	
	// This will call enum constructor with one 
    // String argument 
    ALL("All"), NEW("New"), BESTSELLER("Best Seller"); 
  
    // declaring private variable for getting values 
    private String action; 
  
    // getter method 
    public String getAction() 
    { 
        return this.action; 
    } 
  
    // enum constructor - cannot be public or protected 
    private BaseSortBy(String action) 
    { 
        this.action = action; 
    } 
	

}
