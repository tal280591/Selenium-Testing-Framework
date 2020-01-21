package com.testing.dataproviders;

import org.testng.annotations.DataProvider;

public class GenderDataProvider {
	
	@DataProvider(name = "Gender")
	public static Object[] genderDataProvider(){
			
			return new Object[] {			
					"Men's",
					"Women's"
		};
	}
}
