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
import org.testng.annotations.Test;

public class IndividualFrames {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		String url = "https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html";

		String browsername = "b";
		if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.quit();

	}

	@Test
	public void navigationThroughFrames() throws InterruptedException {

		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.name("classFrame")));
		Thread.sleep(2000);
		Reporter.log("first frame");
		
		driver.switchTo().frame("packageListFrame").findElement(By.xpath("//li/a[text()='org.openqa.selenium']"))
				.click();
		Reporter.log("Second frame");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("packageFrame").findElement(By.xpath("//a//span[text()='Alert']")).click();
		Reporter.log("third frame");
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		driver.switchTo().frame("classFrame").findElement(By.xpath("//caption//span/a[text()='Instance Methods']"))
				.click();
		Reporter.log("Againfirst frame");
		Thread.sleep(2000);

	}
}
