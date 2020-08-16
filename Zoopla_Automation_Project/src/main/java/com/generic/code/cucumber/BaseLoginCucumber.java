package com.generic.code.cucumber;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;
import static org.testng.Assert.assertEquals;

public class BaseLoginCucumber {
	
	static LoginPage login;
	public static WebDriver setupBrowser() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(BaseConfig.getconfig("URL"));
		return driver;
	}
	
	public static void clickSignIn(WebDriver driver) {
		
		login =new LoginPage(driver);		
		System.out.println(driver.getTitle());
		TakeAppScreenShot.captureScreenShot(driver, "Cookies page");
		
		login.getCookies().click();
		new Highlighter().getcolor(driver, login.getLogin(), "blue");
		TakeAppScreenShot.captureScreenShot(driver, "Sign In Link");
		login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

	}
	
	public static void getLogin(WebDriver driver) throws Throwable {
		Wait.getExplicitWaitClickable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "green");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
	
		new Highlighter().getcolor(driver, login.getPassword(),"blue");
		login.getPassword().sendKeys(BaseConfig.getconfig("password"));
		
		Wait.getExplicitWaitClickable(driver, login.getSubmit());
		new Highlighter().getcolor(driver, login.getSubmit(), "red");
		TakeAppScreenShot.captureScreenShot(driver, "Before Login");
		login.getSubmit().click();
		TakeAppScreenShot.captureScreenShot(driver, "Login success");		

	}
	
	public static void userLogIn(WebDriver driver) {
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	}

}
