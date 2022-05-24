package com.test.selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Write a code to read the properties from property file(Hint: Create config.properties file in your project 
//and mention all the properties reagrding credentials,browser name,URL etc.)
public class TestAssignment09 {

	WebDriver driver;

	@Test
	public void ReadPropertiesFromProperyFile() throws IOException {

		FileOutputStream writeFile = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties");

		// set the properties value
		Properties config = new Properties();
		config.setProperty("browser", "chrome");
		config.setProperty("user", "astha");
		config.setProperty("password", "123@astha");
		config.setProperty("url", "http://10.82.180.36/Common/Login.aspx");

		// save/store properties
		config.store(writeFile, null);

		System.out.println(config);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties");

		// load a properties file
		config.load(file);

		// get value by key
		System.out.println(config.getProperty("browser"));
		System.out.println(config.getProperty("user"));
		System.out.println(config.getProperty("password"));
		System.out.println(config.getProperty("url"));

		// get (keys) size
		System.out.println(config.keySet().size());
		file.close();
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
