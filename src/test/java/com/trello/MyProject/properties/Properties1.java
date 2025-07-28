package com.trello.MyProject.properties;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Properties1 {

	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
	
		FileInputStream fis=new FileInputStream("./src/test/resource/property.properties");
		
	Properties pos=new Properties();
	pos.load(fis);
	System.out.println(pos.getProperty("browser"));
	if (pos.getProperty("browser").equals("edge")) {
		
		driver=new EdgeDriver();	
	}
	driver.manage().window().maximize();
	
	driver.get(pos.getProperty("url"));
	driver.findElement(By.id("username")).sendKeys(pos.getProperty("username"));
	Thread.sleep(2000);
	driver.findElement(By.name("pwd")).sendKeys(pos.getProperty("passaword"));
	driver.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
	Thread.sleep(2000);
	driver.manage().window().minimize();
	driver.quit();
	
	
	
	
	
	
		
	}
	
}
