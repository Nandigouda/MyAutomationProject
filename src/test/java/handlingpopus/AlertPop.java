package handlingpopus;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AlertPop {
@Test
	public void alertPopUp(){
		
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
		WebDriver driver =new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ajio.com");
		
		
	}
}
