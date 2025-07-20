package javascriptexecuter;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebPageHeightAndWidth {
	
@Test
public  void DynamicWebPageHeightAndWidth1() throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.google.com/doodles");
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	long Height01 = (long)jse.executeScript("return document.body.scrollHeight");
	System.out.println("Height01 :"+Height01);
	driver.navigate().refresh();
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);
	long Hieght02 = (long)jse.executeScript("return document.body.scrollHeight");
	
	System.out.println("Hieght02 :"+Hieght02);
	
	driver.quit();
	
}
}
