package com.test.selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write automation script to Take screenshot of web page-
public class TestAssignment14 {

	WebDriver driver;

	@Test
	public void Screenshot() throws IOException, InterruptedException {

		driver.get("https://api.jquery.com/dblclick/\n");
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss,
				new File(System.getProperty("user.dir") + "/src/test/resources/Utilites/Screenshots/screenshot1.png"));

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
