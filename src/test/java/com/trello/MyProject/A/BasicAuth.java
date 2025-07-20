package com.trello.MyProject.A;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v123.indexeddb.model.Key;

public class BasicAuth {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Cast to Credentials (optional - marker interface)
//		Credentials creds = new UsernameAndPassword("admin", "admin");
//Thread.sleep(2000);
//		// Use in basic auth scenarios (custom implementation or DevTools)
//		String authUrl = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
//		driver.get(authUrl);
//
//		System.out.println(driver.getTitle());
//		
//		Thread.sleep(3000);
//		String auhurl1="https://httpbin.org/basic-auth/user/passwd";
//		driver.get(auhurl1);
//		Thread.sleep(4000);
//		driver.switchTo().alert().sendKeys("user");
//		driver.switchTo().activeElement().sendKeys("user");   //authenticate popup can be automated by below 
//		Thread.sleep(4000);
//		driver.switchTo().activeElement().sendKeys(Keys.TAB);
//		Thread.sleep(4000);
//		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
//		
//		Credentials creds1=new UsernameAndPassword("user", "passwd");
		UsernameAndPassword credentials = new UsernameAndPassword("user", "passwd");
		driver.get("https://" + credentials.username() + ":" + credentials.password() + "@httpbin.org/basic-auth/user/passwd");

		Thread.sleep(3000);
		
		
		System.out.print(driver.getTitle());
		
		driver.quit();
	}
}
