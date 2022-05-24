package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write automation script to set the size of browser window.
public class TestAssignment06 {

	WebDriver driver;

	@Test
	public void BrowserWindowSize() throws InterruptedException {

		driver.navigate().to("https://www.google.com");
		// Using manage() method
		driver.manage().window().setSize(new Dimension(1800, 600));
		Thread.sleep(2000);

		// !!DEPRECATED!!
		// --------------
		// Using JavascriptExecutor
//		String parent = driver.getWindowHandle();
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.open('http://www.zlti.com')");
//
//		Set<String> windows = driver.getWindowHandles();
//
//		for (String child : windows) {
//			if (!child.equals(parent)) {
//				driver.switchTo().window(child);
//				js.executeScript("window.resizeTo(3000, 5000)");
//
//			} else {
//				driver.close();
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
