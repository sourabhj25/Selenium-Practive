package TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestB {

	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void openPage(){
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	
	public void checkWebSite(){
		String existingTitle = driver.getTitle();
		Assert.assertTrue(existingTitle.equals("Welcome: Mercury Tours"));
		
	}
	
	
}
