package com.trello.MyProject.learnactionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass {
	WebDriver driver;
	@BeforeMethod
	public void configBeforemethod() {
		String URL="https://www.myntra.com/";
		String browser="edge";
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		Reporter.log("Browser Launched");
		driver.manage().window().maximize();
		driver.get(URL);
		Reporter.log("URL Triggered.");
		
	}
	@AfterMethod
	public void configAftermethod() {
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("Browser Session Terminated");
		
	}
	@Test
	public void MoveMousePointerOnWomen() throws Throwable  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement womensectiononNav = driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Women']"));
		actions.moveToElement(womensectiononNav).perform();
		Thread.sleep(2000);
		
			
		
	}
	

}