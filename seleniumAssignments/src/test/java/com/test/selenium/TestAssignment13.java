package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write Automation script to switch on new tab by clinking on “Medical Records” for following website.
//After switching on new tab click on “Search Patient” and select dropdown as “First Name” and click on search button.
public class TestAssignment13 {

	WebDriver driver;

	@Test
	public void SearchPatient() throws InterruptedException {

		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Medical Records")).click();
		driver.findElement(By.linkText("Search Patient")).click();
		WebElement frm = driver.findElement(By.id("search_type"));
		Select sc = new Select(frm);
		sc.selectByVisibleText("First Name");
		driver.findElement(By.id("search_text")).sendKeys("Rishabh");
		driver.findElement(By.id("search_patient")).click();
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

	
