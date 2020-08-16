package com.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeAppScreenShot {

	public static String captureScreenShot(WebDriver driver, String ScreenShotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd___HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date.getTime());
		 File dir=new File("./Screen Shot");
	       if(!dir.exists()){
	           
	           dir.mkdir();
	       }
		String destination = currentDir + "//Screen Shot//" + dateTime + "___" + ScreenShotName + ".png";
		try {
			
			com.google.common.io.Files.copy(source, new File(destination));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return destination;

	}

	}
