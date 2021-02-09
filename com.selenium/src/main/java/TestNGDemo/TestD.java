package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestD {

	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSubmit(){
		System.out.println("inside ClickSumbit()");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
	}
	
	public void verifyNextPage(){
		String nextPage = driver.getTitle();
		System.out.println("Next page title : " + nextPage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(nextPage.equals("Welcome: Mercury Tours"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
