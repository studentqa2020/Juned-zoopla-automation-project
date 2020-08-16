package com.generic.code.cucumber;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.page.object.model.AgentInfoPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class AgentInfoCucumber {
	
	AgentInfoPage agentpf;
	
	public void verifyLogo(WebDriver driver) {
		agentpf  = new AgentInfoPage(driver);		
		
		//check logo and agent contact info
		Wait.getExplicitWaitClickable(driver, agentpf.getPropertyLogo());
		
		if(agentpf.getPropertyLogo().isDisplayed()) {
			System.out.println("Logo is present");
		} else {
			System.out.println("Logo is not present");
		}
	}
	public void showAgentInfo(WebDriver driver) {
		System.out.println("Agent Name is: "+agentpf.getAgentName().getText());
		System.out.println("Agent Phone#: "+agentpf.getAgentPhoneNum().getText());
		TakeAppScreenShot.captureScreenShot(driver, "Agent Info");
	}
	
	public void userClickSignOut(WebDriver driver) {
		Actions signOut = new Actions(driver);
		signOut.moveToElement(agentpf.getMyZooplaBtn()).build().perform();
		new Highlighter().getcolor(driver,agentpf.getMyZooplaBtn(),"red");
	
		signOut.moveToElement(agentpf.getSignOutBtn()).build().perform();
		new Highlighter().getcolor(driver, agentpf.getSignOutBtn(), "yellow");
		TakeAppScreenShot.captureScreenShot(driver, "Sign Out");
		agentpf.getSignOutBtn().click();	

	}
	public void userSignOut(WebDriver driver) {
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(),"Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	}

}
