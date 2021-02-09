package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestA {

	WebDriver driver;
	TestB testB = new TestB();
	TestC testC =  new TestC();
	TestD testD = new TestD();

	@BeforeSuite(alwaysRun = true)
	public void setDriverConfig() {
		System.setProperty("webdriver.chrome.driver", "/home/saurabh/Documents/softwares/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterSuite(alwaysRun = true)
	public void closeWindow() {
		driver.close();
	}

	@BeforeTest(groups = "TestB")
	public void openPage() {
		testB.setDriver(driver);
		testB.openPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(groups = "TestB")
	public void startTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testB.setDriver(driver);
		testB.checkWebSite();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("WebSite title Verified");
	}

	@Test(groups = "TestC", dependsOnGroups = "TestB")
	public void userName() {
		testC.setDriver(driver);
		testC.enterUsername();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(groups = "TestC", dependsOnMethods = "userName")
	public void password() throws InterruptedException {
		testC.setDriver(driver);
		testC.enterPassword();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@AfterTest(groups = "TestD", dependsOnGroups = "TestC")
	public void submit() {
		testD.setDriver(driver);
		testD.clickSubmit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testD.verifyNextPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("All test cases exicuted successfully");
		
	}

}
