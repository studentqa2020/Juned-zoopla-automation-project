package com.generic.code;

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

public class PropertySelection {
	
	public static void selectProperty(WebDriver driver) throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertySelectionPage propertypf = new PropertySelectionPage(driver);	
					
		Wait.getExplicitWaitClickable(driver, propertypf.getLocationName());
		propertypf.getLocationName().sendKeys(BaseConfig.getconfig("SearchLocationName"));
		new Highlighter().getcolor(driver, propertypf.getLocationName());
		new Highlighter().getcolor(driver, propertypf.getSearchSubmit(), "blue");
		TakeAppScreenShot.captureScreenShot(driver, "Search City");
		
		propertypf.getSearchSubmit().click();
		
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
		
		// select 5th property
		//new ExplicitWait().getExplicitWaitVisible(driver, propertypf.getHomePrices().get(4));
	//	new ExplicitWait().getExplicitWait(driver, propertypf.getHomePrices().get(4));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertypf.getHomePrices().get(4));
	//	propertypf.getHomePrices().get(4).click();		
		
	}


}
