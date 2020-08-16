package com.generic.code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.page.object.model.AgentInfoPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class AgentInfo {
	public static void getAgentInfo(WebDriver driver) throws Throwable {
		
		AgentInfoPage agentpf  = new AgentInfoPage(driver);		
		
		//check logo and agent contact info
		Wait.getExplicitWaitClickable(driver, agentpf.getPropertyLogo());
		
		if(agentpf.getPropertyLogo().isDisplayed()) {
			System.out.println("Logagentinfopfo is present");
		} else {
			System.out.println("Logo is not present");
		}
		
		System.out.println("Agent Name is: "+agentpf.getAgentName().getText());
		System.out.println("Agent Phone#: "+agentpf.getAgentPhoneNum().getText());
		TakeAppScreenShot.captureScreenShot(driver, "Agent Info");
		
		Actions signOut = new Actions(driver);
		signOut.moveToElement(agentpf.getMyZooplaBtn()).build().perform();
		new Highlighter().getcolor(driver,agentpf.getMyZooplaBtn(),"red");
		signOut.moveToElement(agentpf.getSignOutBtn()).build().perform();
		new Highlighter().getcolor(driver, agentpf.getSignOutBtn(), "yellow");
		TakeAppScreenShot.captureScreenShot(driver, "Sign Out");
		agentpf.getSignOutBtn().click();	
		
//		driver.quit();

	}

}
