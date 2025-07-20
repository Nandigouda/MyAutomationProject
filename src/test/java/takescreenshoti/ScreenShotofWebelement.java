package takescreenshoti;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
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
import org.testng.annotations.Test;

public class ScreenShotofWebelement {

	WebDriver driver;
	@BeforeMethod
	public void beforemethod() {
		
		String browserName="edge";
		String url="https://www.facebook.com";
		if (browserName.equals("edge")) {
			driver=new EdgeDriver();
			
		}
		else if (browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("URL Triggered.");
	}
	
	@AfterMethod
	public void afterMethod() {
		 driver.manage().window().minimize();
		 driver.quit();	
	}
	
	@Test
	public void takeSshot() throws IOException {
		String tSpamp = LocalDateTime.now().toString().replace(':', '-');
		WebElement wait=new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.name("login")));
		
		File tempFile = wait.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./errorshots/O"+tSpamp+"fblogin.png");
		FileUtils.copyFile(tempFile, destFile);
		
			}	
		//WebElement wait=new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(nnnn))
	}
	
	

