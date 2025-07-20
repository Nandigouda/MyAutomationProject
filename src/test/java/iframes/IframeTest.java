package iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IframeTest {
	WebDriver driver;

	@BeforeMethod
	@Parameters({ "browserName", "url" })
	public void beforeMethod(String browserName, String url) {
		if (browserName.equals("edge")) {

			driver = new EdgeDriver();
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
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
	public void iframeTest() {

		driver.switchTo().frame(driver.findElement(By.id("iframe1")));
		WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));
		button.click();
		driver.switchTo().alert().accept();

	}
}
