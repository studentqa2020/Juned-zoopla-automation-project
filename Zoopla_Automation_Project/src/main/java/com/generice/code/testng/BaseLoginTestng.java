package com.generice.code.testng;

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

public class BaseLoginTestng {
	
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
	
	public static void getLogin(WebDriver driver) throws Throwable {
		LoginPage login =new LoginPage(driver);
		
		System.out.println(driver.getTitle());
		TakeAppScreenShot.captureScreenShot(driver, "Cookies page");
		
		login.getCookies().click();
		new Highlighter().getcolor(driver, login.getLogin(), "blue");
		TakeAppScreenShot.captureScreenShot(driver, "Sign In Link");
		login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		Wait.getExplicitWaitClickable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "green");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
	
		new Highlighter().getcolor(driver, login.getPassword(),"blue");
		login.getPassword().sendKeys(BaseConfig.getconfig("password"));
		
		Thread.sleep(3000);
		new Highlighter().getcolor(driver, login.getSubmit(), "red");
		TakeAppScreenShot.captureScreenShot(driver, "Before Login");
		login.getSubmit().click();
		TakeAppScreenShot.captureScreenShot(driver, "Login success");
		System.out.println(driver.getTitle());
	}

}
