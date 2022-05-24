package com.test.selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Writing script to handle the bootstrap dropdown and add implicit wait 5sec.
public class TestAssignment01 {

	WebDriver driver;

	@Test
	public void Dropdown() throws InterruptedException {
		driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();

		WebElement frm = driver.findElement(By.id("option-droup-demo"));
		Select sc = new Select(frm);

		List<WebElement> allItems = sc.getOptions();

		List<String> check = new ArrayList<String>();
		check.add("Java");
		check.add("Python");
		check.add("Bootstrap");
		check.add("Oracle");

		for (WebElement item : allItems) {

			Thread.sleep(1000);

			if (item.isSelected()) {
				driver.findElement(By.xpath("//input[@type='checkbox'][@value='" + item.getText() + "']")).click();
			}

			for (String checkItem : check) {
				if (item.getText().equals(checkItem)) {
					driver.findElement(By.xpath("//input[@type='checkbox'][@value='" + item.getText() + "']")).click();
					System.out.println("Chceked " + item.getText());
				}
			}

		}

		List<WebElement> allSelectedItems = sc.getAllSelectedOptions();
		System.out.println("Selected Items :");
		for (WebElement selectedItem : allSelectedItems) {

			System.out.println(selectedItem.getText());
		}
		Thread.sleep(3000);

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
