package com.murali;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException {
		
				
		Properties OR = new Properties();
		FileInputStream fis;
		String browser;
		fis = new FileInputStream("E:\\GitWebDriverMaven\\webdriverMavenGit\\src\\test\\java\\com\\murali\\config.properties");
				
		OR.load(fis);		

		OR.getProperty("browser");
		
		if (System.getenv("browser") !=null && !System.getenv("browser").isEmpty()) {
			
			browser =  System.getenv("browser");
		}
		else {
			browser = OR.getProperty("browser");
		}		
		
		OR.setProperty("browser", browser);
		
		
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();				
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10) );
		
	}
	
	@Test
	public void openWebsite() {		
		
		//test.log(LogStatus.INFO, "Login bank manager");	
		
		
	
	
		driver.get("https://amazon.in");
	

		
		
	}
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
}
