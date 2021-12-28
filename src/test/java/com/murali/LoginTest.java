package com.murali;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void openWebsite() {
		
		driver.get("https://flipkart.com");
		
		
	}
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
