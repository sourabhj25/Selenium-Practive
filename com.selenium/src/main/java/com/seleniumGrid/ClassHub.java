package com.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassHub {

	WebDriver driver;
	String url, nodeURL;
	
	 @BeforeTest
	 public void setup() throws MalformedURLException{
		 url = "http://newtours.demoaut.com/";
		 nodeURL = "http://IP:port/wd/hub";
		 
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 capabilities.setBrowserName("chrome");
		 capabilities.setPlatform(Platform.ANY);
		 driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
	 }
	
	 @AfterTest
	 public void quit(){
		 driver.quit();
	 }
	 
	 @Test
	 public void simpleTest(){
		 driver.get(url);
		 Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
	 }
	
}
