package TestNGDemo;
/*package com.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

*//**
 * Hello world!
 *
 *//*
public class App {
//	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/saurabh/Documents/softwares/chromedriver");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		Thread.sleep(2000);
		// WebElement firstname = driver.findElement(By.name("firstname"));
		// WebElement firstname =
		// driver.findElement(By.xpath("//input[@name='firstname']"));
		// WebElement firstname =
		// driver.findElement(By.id("et_pb_contact_name_1"));

		
		 * firstname.clear(); firstname.sendKeys("Sourabh");
		 
		Thread.sleep(2000);
		// WebElement twitter = driver.findElement(By.linkText("Video
		// Tutorials"));
		// twitter.click();
		Thread.sleep(2000);

		List<WebElement> rows = driver.findElements(By.xpath(".//table[@class='dataTable']/tbody/tr"));
		List<Money> moneys = new ArrayList<App.Money>();
		if (!rows.isEmpty()) {
			for (int rowCount = 0; rowCount < rows.size(); rowCount++) {
				List<WebElement> tds = driver
						.findElements(By.xpath(".//table[@class='dataTable']/tbody/tr[" + rowCount + "]/td"));
				if (!tds.isEmpty()) {
					App.Money money = new App.Money();
					for (int tdCount = 0; tdCount < tds.size(); tdCount++) {
						String text = tds.get(tdCount).getText();
						switch (tdCount) {
						case 0:
							money.setCompany(text);
							break;
						case 1:
							money.setGroup(text);
							break;
						case 2:
							money.setPrevious(text);
							break;
						case 3:
							money.setCurrent(text);
							break;
						case 4:
							money.setChange(text);
							break;
						}
					}
					moneys.add(money);
				}
			}
		}

		for (Money money : moneys) {
			System.out.println(money);
		}
		driver.quit();

	}

	private static class Money {
		private String company;
		private String group;
		private String previous;
		private String current;
		private String change;

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getGroup() {
			return group;
		}

		public void setGroup(String group) {
			this.group = group;
		}

		public String getPrevious() {
			return previous;
		}

		public void setPrevious(String previous) {
			this.previous = previous;
		}

		public String getCurrent() {
			return current;
		}

		public void setCurrent(String current) {
			this.current = current;
		}

		public String getChange() {
			return change;
		}

		public void setChange(String change) {
			this.change = change;
		}

		@Override
		public String toString() {
			return "Money [company=" + company + ", group=" + group + ", previous=" + previous + ", current=" + current
					+ ", change=" + change + "]";
		}

	}
}
*/