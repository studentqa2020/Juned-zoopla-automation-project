package com.generic.code.cucumber;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.config.BaseConfig;
import com.page.object.model.PropertySelectionPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class SearchPropertyCucumber {
	
	static PropertySelectionPage propertypf;
	
	public static void searchProperty(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		propertypf = new PropertySelectionPage(driver);	
					
		Wait.getExplicitWaitClickable(driver, propertypf.getLocationName());
		propertypf.getLocationName().sendKeys(BaseConfig.getconfig("SearchLocationName"));
		new Highlighter().getcolor(driver, propertypf.getLocationName());
		new Highlighter().getcolor(driver, propertypf.getSearchSubmit(), "blue");
		TakeAppScreenShot.captureScreenShot(driver, "Search City");
		
		propertypf.getSearchSubmit().click();
	}
	public static void userPropertyPage(WebDriver driver) {
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Property for Sale in New York - Buy Properties in New York - Zoopla");
	}
	public static void displayPrice(WebDriver driver) {
		String [] price;
		List<Integer> intPrice = new ArrayList<>();
		for(int i=0; i<propertypf.getHomePrices().size();i++) {			
			price = propertypf.getHomePrices().get(i).getText().split(" ");
			intPrice.add(Integer.parseInt(price[0].replace("£","").replace(",","").trim()));
		}
		System.out.println("House Prices: "+intPrice);
		Collections.sort(intPrice);
		System.out.println("House Prices Sorted Asc: "+intPrice);
		Collections.reverse(intPrice);
		System.out.println("House Prices Sorted Desc: "+intPrice);
	}
	
	public static void userSelectProperty(WebDriver driver) {
		// select 5th property
		//new ExplicitWait().getExplicitWaitVisible(driver, propertypf.getHomePrices().get(4));
	//	new ExplicitWait().getExplicitWait(driver, propertypf.getHomePrices().get(4));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertypf.getHomePrices().get(4));
	//	propertypf.getHomePrices().get(4).click();		

	}
	

}
