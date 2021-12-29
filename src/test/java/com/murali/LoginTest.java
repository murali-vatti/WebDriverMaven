package com.murali;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10) );
		
	}
	
	@Test
	public void openWebsite() {
		
		driver.get("https://flipkart.com");
		driver.close();
		driver = new ChromeDriver();		
		driver.get("https://amazon.in");
		driver.manage().window().maximize();

		
		
	}
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
