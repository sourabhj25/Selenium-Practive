package com.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

	private WebDriver driver;

	@FindBy(how = How.NAME, using = "Username")
	private WebElement usernameElement;

	@FindBy(how = How.NAME, using = "Password")
	private WebElement passwordElement;

	@FindBy(how = How.XPATH, using = "*//input[@name='Password']/ancestor::div[2]/following::div[1]//input[@type='submit']")
	private WebElement submit;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) throws InterruptedException {
		driver.get("https://apps.alsoenergypreview.com/Account/Login?ReturnUrl=%2f");
		Thread.sleep(2000);
		usernameElement.clear();
		usernameElement.sendKeys(username);
		Thread.sleep(2000);
		passwordElement.clear();
		passwordElement.sendKeys(password);
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);

		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals("https://apps.alsoenergypreview.com/PowerTrack", currentURL);

		List<WebElement> thirdRow = driver.findElements(By.xpath(
				"*//div[@class='fixedDataTableCellLayout_main public_fixedDataTableCell_main'][3]//img[@src='/Content/images/ui/bldg.png']/following::div[1]"));

		List<String> names = new ArrayList<String>();
		for (WebElement webElement : thirdRow) {
			String name = webElement.getText();
			names.add(name);
		}

		WebElement lastElement = driver.findElement(By.xpath(
				"*//div[@class='fixedDataTableCellLayout_main public_fixedDataTableCell_main'][3]/div/child::div/span"));
		String totalCount = lastElement.getText();
		int finalBlockelement = Integer.parseInt(totalCount.trim());
		Assert.assertEquals(finalBlockelement, names.size());

	}

	public void checkAlerts() throws InterruptedException {
		/*List<WebElement> status = driver.findElements(By.xpath(
				"*///div[@title='Awaiting AE Approval']//ancestor::div[7]//following-sibling::div//img[@src='/Content/images/ui/bldg.png']"));*/
		
		WebElement status = driver.findElement(By.xpath("*//div[contains(text(),'Top-Level Alerts')]"));
		
		Thread.sleep(2000);
		status.click();
		Thread.sleep(2000);
		
		List<WebElement> alerts = driver.findElements(By.xpath("*//img[@src='/Content/images/ui/bldg.png']//ancestor::div[8]//preceding-sibling::div[8]"));
		for (WebElement webElement : alerts) {
			webElement.click();
			Thread.sleep(1000);
			List<WebElement> checkboxs = driver.findElements(By.xpath("*//div/input[@class='checkbox']"));
			
			List<WebElement> statusFields = driver.findElements(By.xpath("*//div/input[@class='checkbox']/ancestor::div[3]"));
			List<String> fieldNames = new ArrayList<String>();
			for (WebElement webElement2 : statusFields) {
				String fieldName = webElement2.getText();
				fieldNames.add(fieldName);
			}
			int count = 0;
			for (WebElement webElement2 : checkboxs) {
				if (webElement2.isSelected()) {
					System.out.println("Fields CHECKED ARE : "+ fieldNames.get(count));
					count++;
				}
			}
		}
	}

	
	public void homePage(String username, String password) throws InterruptedException {
		driver.get("https://apps.alsoenergypreview.com/Account/Login?ReturnUrl=%2f");
		Thread.sleep(2000);
		usernameElement.clear();
		usernameElement.sendKeys(username);
		Thread.sleep(2000);
		passwordElement.clear();
		passwordElement.sendKeys(password);
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
		
		List<WebElement> sites = driver.findElements(By.xpath(
				"*//div[@class='fixedDataTableCellLayout_main public_fixedDataTableCell_main'][3]//img[@src='/Content/images/ui/bldg.png']/following::div[1]"));
//		int count = 0;
		for (WebElement newRow : sites) {
//		for(int rows = 0; rows<thirdRows.size(); rows++){	
			System.out.println("Hello ::::::"+sites);
			sites = driver.findElements(By.xpath(
					"/div[@class='fixedDataTableCellLayout_main public_fixedDataTableCell_main'][3]//img[@src='/Content/images/ui/bldg.png']/following::div[1]"));
		//Thread.sleep(2000);
			newRow.click();
			
//			sites.get(count).click();
			System.out.println("Row   ::::::"+newRow);
			Thread.sleep(4000);
			driver.navigate().back();
//			driver.findElement(By.xpath(".//div[contains(text(),'Top-Level Portfolio')]")).click(); 
			Thread.sleep(2000);
//			count++;
		}
	}

}
