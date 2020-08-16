package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {
	
	public void getcolor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", element);

	}

	public void getcolor(WebDriver driver, WebElement element, String color) {// OOPs ==> Polymorphism ==> Compile time
																				// poly
		JavascriptExecutor js = (JavascriptExecutor) driver; // type casting polymorphism
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid " + color + ";');",
				element);

	}

	
}