package practicetestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actions123{
	
	WebDriver driver;
	
	@BeforeMethod
	public void confiBeforeMethod() {
		
		
		String url="https://facebook.com";
				String browsername="chrome";
				
				if (browsername.equals("edge")) {
					
					driver= new EdgeDriver();
					
					
				}
				else if (browsername.equals("firefox")) {
					
					driver=new FirefoxDriver();
					
				}
				else {
					
					driver=new ChromeDriver();
					
				}
				driver.manage().window().maximize();
				driver.get(url);	
				}
	
	@AfterMethod
	public void cofiAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
		
	}
	@Test
	public void rightcontextclick() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actions = new Actions(driver);
		WebElement loginButton = driver.findElement(By.name("login"));
		//actions.contextClick(loginButton).pause(2000);
		actions.moveToElement(loginButton).pause(5).contextClick();
		Thread.sleep(1000);
		
		// default check of right click 
		//actions.contextClick();
	}
}