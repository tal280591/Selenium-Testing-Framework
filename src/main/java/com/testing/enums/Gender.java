package com.testing.enums;

public enum Gender {
	// This will call enum constructor with one 
    // String argument 
    MALE("Men's"), FEMALE("Women's"); 
  
    // declaring private variable for getting values 
    private String gender; 
  
   
	// getter method 
    public String getGender() 
    { 
        return this.gender; 
    } 
  
    // enum constructor - cannot be public or protected 
    private Gender(String gender) {
		this.gender = gender;
	}

}
