package com.trello.MyProject.A;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class isDisplayed {
WebDriver driver;
SoftAssert assert1=new SoftAssert();
	@BeforeMethod
	public void beforeMethod() {
		
		//String browserName="edge";
		//String url="https:/flipkart.com";
		
		String url="https:/flipkart.com";
		String browser="Chrome";
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		assert1.assertEquals(driver.getCurrentUrl(), "url");
		Reporter.log("current URL is correct");
	}
	@AfterMethod
	public void afterMethod() {
		
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@Test
	public void display() {
		WebElement nnnn = driver.findElement(By.xpath("//button[text()='✕']"));
		if (nnnn.isDisplayed()) {
			Reporter.log("is displayed"); 
		}
		nnnn.click();
		Reporter.log("element is displayed and clicked");
		try {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(nnnn));
		}
		catch (StaleElementReferenceException e) {
		Reporter.log("not displayed");
		
	}
	
	
	}
}
