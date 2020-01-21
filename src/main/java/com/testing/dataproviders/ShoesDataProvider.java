package com.testing.dataproviders;

import org.testng.annotations.DataProvider;


public class ShoesDataProvider {
	
	
	@DataProvider(name = "Men-Shoes-Brand")
	public static Object[][] menShoesBrandsDataProvider(){
			
			return new Object[][] {
				
				{"Nike", "/Nike_Tennis_Shoes/catpage-MSNIKE.html"}, 
				{"Adidas", "/adidas_Mens_Tennis_Shoes/catpage-MSADIDAS.html"},
				{"Asics", "/Asics_Tennis_Shoes/catpage-MSASICS.html"},
				{"Diadora", "/Diadora_Tennis_Shoes/catpage-MSDIADORA.html"},
				{"Babolat", "/Babolat_Mens_Tennis_Shoes/catpage-MSBAB.html"}
			
	
		};
	}
	
	@DataProvider(name = "Women-Shoes-Brand")
	public static Object[][] womenShoesBrandsDataProvider(){
			
			return new Object[][] {
				
				{"Nike", "/Nike_Womens_Tennis_Shoes/catpage-WSNIKE.html"}, 
				{"Adidas", "/adidas_Womens_Tennis_Shoes/catpage-WSADIDAS.html"},
				{"Asics", "/Asics_Womens_Tennis_Shoes/catpage-WSASICS.html"},
				{"Diadora", "/Diadora_Womens_Tennis_Shoes/catpage-WSDIADORA.html"},
				{"Babolat", "/Babolat_Womens_Tennis_Shoes/catpage-WSBAB.html"}
			
	
		};
	}
	
	@DataProvider(name = "URL")
	public static Object[][] temp(){
			
		
			return new Object[][] {
				
				{"Nike", "/Nike_Womens_Tennis_Shoes/catpage-WSNIKE.html"}, 
				{"Adidas", "/adidas_Womens_Tennis_Shoes/catpage-WSADIDAS.html"},
				{"Asics", "/Asics_Womens_Tennis_Shoes/catpage-WSASICS.html"},
				{"Diadora", "/Diadora_Womens_Tennis_Shoes/catpage-WSDIADORA.html"},
				{"Babolat", "/Babolat_Womens_Tennis_Shoes/catpage-WSBAB.html"}
			
	
		};
	}
}

	


