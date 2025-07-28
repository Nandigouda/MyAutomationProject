package com.trello.MyProject.properties;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
WebDriver driver;
	@BeforeMethod
	public void beforeMethod() throws IOException {
		datadrivenTesting data=new datadrivenTesting();
		String browsername = data.readDataFromFiles("browser");
		if (browsername.equals("chrome")) {
			driver =new EdgeDriver();
		}
		else if (browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
				
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(data.readDataFromFiles("url"));
	}	

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.quit();
		
	}
	@Test
	public void readData() {
		
		
		
	}
	
	
	
	
}
