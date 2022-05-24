package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write script to perform to create your Google account for following  given website using getAttribute().
public class TestAssignment12 {

	WebDriver driver;

	@Test
	public void SignupGoogle() throws InterruptedException {

		driver.get("https://accounts.google.com/signup");
		Thread.sleep(2000);

		driver.findElement(By.id("firstName")).sendKeys("Astha");
		driver.findElement(By.id("lastName")).sendKeys("Verma");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//input[@name='Passwd']")).getAttribute("type"));
		driver.findElement(By.id("username")).sendKeys("asthaverma8989");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("zxcvb@123#");
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("zxcvb@123#");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();

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
