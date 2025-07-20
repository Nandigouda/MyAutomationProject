package com.trello.MyProject.A;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A {
public static void main(String[] args) throws InterruptedException {
	
	//WebDriver driver=new EdgeDriver();
	
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com/ncr");
	driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
	
	// Initialize and wait till element(link) became clickable - timeout in 10 seconds
	WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(15))
	        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h2")));
	//ExpectedConditions.elementToBeClickable--->expectation for checking an element is visible and enabled such that you can click it.
	// Print the first result
	System.out.println(firstResult.getText());
	driver.manage().window().minimize();
	driver.quit();
	
	
	  
} 

}
