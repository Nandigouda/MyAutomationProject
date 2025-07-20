package takescreenshoti;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		//driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div/*[@class='YBLJE4']/.."));
		
		for (WebElement listofimg : list) {
			String tSpamp = LocalDateTime.now().toString().replace(':', '-');
			File tempFile = listofimg.getScreenshotAs(OutputType.FILE);
			File destFile=new File("./errorshots/O"+tSpamp+"fblogin.png");
			FileUtils.copyFile(tempFile, destFile);
		}
		driver.manage().window().minimize();
		driver.quit();
       }
	}
