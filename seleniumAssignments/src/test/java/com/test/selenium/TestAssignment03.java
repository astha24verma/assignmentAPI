package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write automation script to handle the window popup for following website.
public class TestAssignment03 {
	WebDriver driver;

	@Test
	public void PopupHandling() throws InterruptedException {
		driver.get("http://popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@class='social-card mt-4']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div/div[3]/input")).click();
		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.findElement(By.id("popup_modal_dismiss_button")).click();

		System.out.println(driver.getTitle());

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
