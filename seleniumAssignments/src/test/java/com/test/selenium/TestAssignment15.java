package com.test.selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write automation script to read excel file using Apache POI (Download & configure Apache jars in your project).
public class TestAssignment15 {

	WebDriver driver;
	String path = System.getProperty("user.dir") + "/src/test/resources/ExcelFiles/DataFile.xlsx";

	@Test
	public void FileHandling() throws IOException, InterruptedException {
		driver.get("http://10.82.180.36/Common/Login.aspx");

		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Login");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			driver.findElement(By.id("body_txtUserID")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.id("body_txtPassword")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//input[@type='submit']")).click();

			Thread.sleep(2000);

			if (driver.getCurrentUrl().equals("http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx")) {

				String msg = driver.findElement(By.id("divWelcome")).getText();
				sheet.getRow(i).getCell(2).setCellValue(msg);

				driver.findElement(By.id("lbLoginOut")).click();

			} else {
				String msg = driver.findElement(By.id("body_lblStatus")).getText();
				sheet.getRow(i).getCell(2).setCellValue(msg);
			}
		}
		FileOutputStream fileOut = new FileOutputStream(path);
		book.write(fileOut);
		book.close();

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
