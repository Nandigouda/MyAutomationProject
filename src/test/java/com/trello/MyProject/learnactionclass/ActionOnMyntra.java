package com.trello.MyProject.learnactionclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionOnMyntra {
	WebDriver driver;

	@BeforeMethod
	public void configBeforeMethod() {
		
		//String url="https://demo.actitime.com";
		//String url="https://www.facebook.com/login/";
		String url ="https://www.myntra.com/";
		String browserName = "chrome";
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		Reporter.log("Browser Launched");
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("URL Triggered.");

	}

	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("Browser Session Terminated");
	}
	@Test
	public void moveMousePointerOnMenSection() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement menSectionOnNav = driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Men']"));
		//move the control of the mouse pointer on to the element.
		//moveToElement(WebElement target)
		//With calling the perform() at last action will not be performed on the app.
		actions.moveToElement(menSectionOnNav).perform();
		Thread.sleep(5000);
	}
	@Test
	public void moveOnSoManyEleAtATime() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		List<WebElement> allNavMenuOptions = driver.findElements(By.xpath("//div[@class='desktop-navContent']"));
		for (WebElement navOption : allNavMenuOptions) {
			//we have more than one action - composite action
			//we can pause the series actions class action with the interval 
			//pause(long pause) 
			actions.moveToElement(navOption).pause(2000).perform();
		}
	}
	@Test
	public void oneEleOffsetAndMoveToOther() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement menSectionOnNav = driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Men']"));
		actions.moveToElement(menSectionOnNav).pause(1000).moveToElement(menSectionOnNav, 74, 0).pause(1000)
		.moveToElement(menSectionOnNav, 148, 0).pause(1000).moveToElement(menSectionOnNav, 247, 0).pause(1000).moveToElement(menSectionOnNav, 354, 0).pause(1000).
		moveToElement(menSectionOnNav, 437, 0).build().perform();
	}
	@Test
	public void mouseHoverOnMensSection() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions action=new Actions(driver);
		WebElement mensSection = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		action.moveToElement(mensSection).pause(2000).perform();
		
		List<WebElement>allMensOptions=driver.findElements(By.xpath("//ul/li/a[text()='Topwear']/../following-sibling::li/a"));
		
for (WebElement alloptions : allMensOptions) {
String xyz = alloptions.getAttribute("class");
			if (xyz.equals("desktop-categoryLink")) {
				action.moveToElement(alloptions).pause(1000).perform();
			}
			else if (xyz.equals("desktop-categoryName")) {
				break;
			}
			
		}	
	}
	
	@Test
	public void PerformRightClickOnElement() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement loginButton = driver.findElement(By.name("login"));
		actions.contextClick(loginButton).perform();
		
		//actions.moveToElement(loginButton).click().perform();
		// default check of right click 
		actions.contextClick().build().perform();
		Thread.sleep(2000);
	}
	@Test
	public void UsageOfActionsClick() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement loginButton = driver.findElement(By.name("login"));
		//actions.click(loginButton).perform();
		actions.moveToElement(loginButton).click().perform();
		Thread.sleep(5000);
		
	}
	@Test
	public void withOutEleReferenceLoginToActitime() throws Throwable {
		Actions actions = new Actions(driver);
		Thread.sleep(1000);
		//driver.switchTo().activeElement().sendKeys("admin");
		//actions.sendKeys("admin").perform();
		actions.sendKeys("admin").pause(200).sendKeys(Keys.TAB).pause(200).sendKeys("manager").pause(200).sendKeys(Keys.TAB)
		.pause(200).sendKeys(Keys.TAB).pause(200).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
	}
	
	
}
	
	
	
	
	
	
	
	
	
