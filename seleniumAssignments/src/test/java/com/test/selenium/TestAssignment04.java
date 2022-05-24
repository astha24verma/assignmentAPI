package com.test.selenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write Automation script for Google search web page
//Create the customised Xpath then get the list of size. Iterate the list then the moment you find the suggestion perform click ().
public class TestAssignment04 {

	WebDriver driver;

	@Test
	public void GoogleSearch() throws InterruptedException {

		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("automation tools"); // search keywords related to "automation tools"
		Thread.sleep(3000);
		List<WebElement> webElement = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		Thread.sleep(3000);
		for (int i = 0; i < webElement.size(); i++) {
			String value = webElement.get(i).getText();
			System.out.println(webElement.size());
			if (value.contains("automation tools for testing")) // chooses "automation tools for testing"
			{
				Thread.sleep(2000);
				webElement.get(i).click();
				break;
			}
		}

//
//		driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("amazon forest ");
//
//		String search = "images";
//		Thread.sleep(3000);
//
//		Actions act = new Actions(driver);
//
//		for (int i = 1; i < 10; i++) {
//			try {
//				String currString = driver.findElement(By.xpath("//li[" + i + "]/div/div[2]/div[1]/span/b")).getText();
////				System.out.println(currString);
//				if (currString.endsWith(search)) {
//					act.sendKeys(Keys.ARROW_DOWN).build().perform();
//					act.sendKeys(Keys.ENTER).build().perform();
//					break;
//				} else {
//					act.sendKeys(Keys.ARROW_DOWN).build().perform();
//				}
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				act.sendKeys(Keys.ARROW_DOWN).build().perform();
//				continue;
//			}
//		}
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
}
