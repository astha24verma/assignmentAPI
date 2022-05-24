package com.test.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write Automation script to perform Drag and Drop operation for following website.
public class TestAssignment02 {
	WebDriver driver;

	@Test
	public void DragAndDrop() throws InterruptedException {
		driver.navigate().to("http://10.82.181.42/Automation/DemoApps/Drag%27N%27Drop.aspx");

		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
		act.dragAndDrop(fromElement, toElement).perform();

		Thread.sleep(2000);

		Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText());
		Thread.sleep(2000);
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
