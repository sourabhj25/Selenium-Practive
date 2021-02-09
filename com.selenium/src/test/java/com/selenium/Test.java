package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.selenium.pages.LoginPage;

public class Test {

	private WebDriver driver;
	private LoginPage loginPage;

	@BeforeClass(alwaysRun = true)
	public void setDriverConfig() {
	}

	@BeforeTest(alwaysRun = true)
	public void init() {
		System.setProperty("webdriver.chrome.driver", "/home/saurabh/Documents/softwares/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	/*@org.testng.annotations.Test(alwaysRun = true)
	public void test1() throws InterruptedException {
		loginPage.login("agilesofttest", "agsfttest2017");
	}
	
	@org.testng.annotations.Test(alwaysRun = true)
	public void test2() throws InterruptedException{
		loginPage.checkAlerts();
	}*/
	
	@org.testng.annotations.Test(alwaysRun=true)
	public void homePageTest() throws InterruptedException {
		loginPage.homePage("agilesofttest", "agsfttest2017");
		

	}

	@AfterTest(alwaysRun = true)
	public void close() {
		driver.close();
	}
}
