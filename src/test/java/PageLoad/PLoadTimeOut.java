package PageLoad;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PLoadTimeOut {
public static void main(String[] args) {
	
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	
	// Loading of page will get stopped after timeout
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
	driver.get("https://www.myntra.com");	
}
}
