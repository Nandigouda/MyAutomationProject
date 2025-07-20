package iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NestedFrame {
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browsername", "url"})
	public void beforeMethod(String browsername,String url ) {
		
		if (browsername.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if (browsername.equals("FireFox")) {
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.quit();
	}
	@Test
	@Parameters("text")
	public void nestedFrames( String text) throws InterruptedException {
		
		WebElement wait= new WebDriverWait(driver, Duration.ofSeconds(5))
		.until(ExpectedConditions.elementToBeClickable(By.linkText("Iframe with in an Iframe")));
		wait.click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Multiple']/iframe")));
		Thread.sleep(2000);
		driver.switchTo().frame(0).findElement(By.xpath("//input[@type='text']")).sendKeys(text);
		Thread.sleep(2000);
		
	
	}
}
