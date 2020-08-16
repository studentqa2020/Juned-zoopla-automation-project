package com.sanity.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.code.AgentInfo;
import com.generic.code.PropertySelection;
import com.generice.code.testng.BaseLoginTestng;

public class RunSanityTestNG {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws Throwable {
		driver = BaseLoginTestng.setupBrowser();
	}
	
	@Test
	public void getLogin() throws Throwable {
		BaseLoginTestng.getLogin(driver);
	}
	
	@Test(dependsOnMethods="getLogin")
	public void selectProperty() throws Throwable {
		PropertySelection.selectProperty(driver);
	}
	@Test(dependsOnMethods="selectProperty")
	public void getAgentInfo() throws Throwable {
		AgentInfo.getAgentInfo(driver);
	}
	@AfterTest
	public void tearoff() {
		driver.quit();
	}
}
