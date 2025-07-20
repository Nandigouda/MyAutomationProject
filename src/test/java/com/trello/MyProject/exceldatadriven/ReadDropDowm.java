package com.trello.MyProject.exceldatadriven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadDropDowm {

	public static void main(String[] args) {
		List<String> dayOptions=new ArrayList<String>();
		List<String> monthOptions=new ArrayList<String>();
		List<String> yearOptions=new ArrayList<String>();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https:/facebook.com/signup/");
		
		List<WebElement> dropdownOpt = driver.findElements(By.tagName("select"));
for (WebElement select : dropdownOpt) {
		if (select.isDisplayed()) {
			Select drop=new Select(select);
			if (select.getAttribute("title").equals("Day")) {
				List<WebElement> allday = drop.getOptions();
				for (WebElement AllDaydrop : allday) {
					dayOptions.add(AllDaydrop.getText());
				}
				
			}
		}
			
		}
           System.out.println(dayOptions);
	}
}
