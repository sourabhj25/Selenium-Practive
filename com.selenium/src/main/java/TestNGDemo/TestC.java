package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TestC {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername() {
		WebElement username = driver.findElement(By.xpath("*//input[@name='userName']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		username.sendKeys("agsftTest");
	}

	public void enterPassword() {
		WebElement password = driver.findElement(By.xpath(
				".//input[@name='userName']/parent::td/parent::tr/following-sibling::tr//input[@name='password']"));
		
		// Optional
		// WebElement password = driver.findElement(By.name("password"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		password.sendKeys("password");
	}

}
