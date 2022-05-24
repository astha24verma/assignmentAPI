package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write automation script to Scroll web page.
public class TestAssignment05 {

	WebDriver driver;

	@Test
	public void ScrollWebpage() throws InterruptedException {
		driver.navigate().to("http://openclinic.sourceforge.net/openclinic/home/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// Using Actions Class
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.PAGE_DOWN).build().perform();
//		Thread.sleep(1000);
//		act.sendKeys(Keys.PAGE_UP).build().perform();

		// Using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 240)");
		Thread.sleep(1000);
		js.executeScript("window.scroll(0, 0)");
		Thread.sleep(1000);

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
