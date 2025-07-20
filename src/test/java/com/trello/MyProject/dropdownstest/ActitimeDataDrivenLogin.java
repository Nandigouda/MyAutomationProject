package com.trello.MyProject.dropdownstest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeDataDrivenLogin {

	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resource/prop.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
      String browser = pobj.getProperty("browser");
      if (browser.equals("edge")) {
    	  
    	 driver= new EdgeDriver();
	} 
      else if (browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}else if (browser.equals("chrome")) {
		driver= new ChromeDriver();
		
	}
      driver.manage().window().maximize();
      
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      new WebDriverWait(driver, Duration.ofSeconds(10));
      driver.get(pobj.getProperty("url"));
      driver.findElement(By.id("username")).sendKeys(pobj.getProperty("username"));
      Thread.sleep(2000);
      driver.findElement(By.name("pwd")).sendKeys(pobj.getProperty("passaword"));
      driver.findElement(By.id("loginButton")).click();
	}
	
		
}
