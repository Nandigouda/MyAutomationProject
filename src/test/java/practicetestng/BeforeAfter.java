package practicetestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfter {
	
	WebDriver driver;
	@BeforeMethod
public void beforeTestCase() {
	driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.actitime.com/login.do");
}
	@Test
	public void testCase() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait waite=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void AfterMethod() {
		
		driver.manage().window().minimize();
		driver.quit();
		
		
	}
	
	
}
