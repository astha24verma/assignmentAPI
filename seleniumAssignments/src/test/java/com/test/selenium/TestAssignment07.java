package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write automation script to enter a text without using sendkeys for any website
public class TestAssignment07 {

	WebDriver driver;

	@Test
	public void WithoutSendKeys() throws InterruptedException {
		driver.navigate().to("http://www.zlti.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement searchbox = driver.findElement(By.xpath("//input[@class='search-form-input'][@id='searchform-1']"));

		// Using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Java';", searchbox);
		Thread.sleep(2000);

		WebElement btn = driver.findElement(By.xpath("//input[@class='search-form-submit'][@type='submit']"));

		js.executeScript("arguments[0].click();", btn);
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.xpath("//div/main/section/div/a[1]/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//div/main/section/div/a[1]/p")).getText());

		js.executeScript("alert('This is an ALERT using js');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		driver.close();
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
