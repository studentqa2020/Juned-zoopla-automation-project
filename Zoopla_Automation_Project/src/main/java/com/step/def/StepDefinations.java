package com.step.def;

import org.openqa.selenium.WebDriver;

import com.generic.code.cucumber.AgentInfoCucumber;
import com.generic.code.cucumber.BaseLoginCucumber;
import com.generic.code.cucumber.SearchPropertyCucumber;
import com.generice.code.testng.BaseLoginTestng;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	
	WebDriver driver;
	@Given("User is on Zoopla Webpage")
	public void user_is_on_Zoopla_Webpage() throws Throwable {
		driver = BaseLoginCucumber.setupBrowser();
	}

	@When("User click on Signin Buton")
	public void user_click_on_Signin_Buton() {
		BaseLoginCucumber.clickSignIn(driver);
	}

	@When("User Enters Credentials and Submit Login")
	public void user_Enters_Credentials_and_Submit_Login() throws Throwable {
		BaseLoginCucumber.getLogin(driver);
	}

	@Then("User logged in")
	public void user_logged_in() {
		System.out.println();
	}

	@Given("User is on Search Property page")
	public void user_is_on_Search_Property_page() {
		BaseLoginCucumber.userLogIn(driver);
	}

	@When("User Enters City Name and Search Properties")
	public void user_Enters_City_Name_and_Search_Properties() throws Throwable {
	   SearchPropertyCucumber.searchProperty(driver);
	}

	@Then("User gets the Properties page")
	public void user_gets_the_Properties_page() {
	   SearchPropertyCucumber.userPropertyPage(driver);
	}

	@When("User Display all Properties prices in desc order")
	public void user_Display_all_Properties_prices_in_desc_order() {
		SearchPropertyCucumber.displayPrice(driver);
	}

	@When("User Selects Fifth Property")
	public void user_Selects_Fifth_Property() {
		SearchPropertyCucumber.userSelectProperty(driver);
	}
	
	AgentInfoCucumber agentInfo;
	
	@When("User Verify Logo")
	public void user_Verify_Logo() {
	   agentInfo = new AgentInfoCucumber();
	   agentInfo.verifyLogo(driver);
	}

	@When("User Display Agent name and Phone Num")
	public void user_Display_Agent_name_and_Phone_Num() {
		agentInfo.showAgentInfo(driver);		
	}

	@When("User clicks on Sign out button")
	public void user_clicks_on_Sign_out_button() {
		agentInfo.userClickSignOut(driver);
	}

	@Then("User Signs Out")
	public void user_Signs_Out() {
		agentInfo.userSignOut(driver);
	}

}
