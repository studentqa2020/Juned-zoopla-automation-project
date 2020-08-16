package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"featureFiles/zoopla.feature"},
		glue = {"com.step.def"},
		plugin = {"pretty", "html:target" , "json:target/cucumber.json" , 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		monochrome = true
		
		
		)
public class ZooplaRunner extends AbstractTestNGCucumberTests{
	
}
