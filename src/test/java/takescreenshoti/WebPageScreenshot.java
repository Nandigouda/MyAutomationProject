package takescreenshoti;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebPageScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver =new EdgeDriver();
		String stamp = LocalDateTime.now().toString().replace(':', '-');
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.facebook.com/");
		
		File tempScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile=new  File("./errorshots/"+stamp+"fbscreenshot.png");
		FileUtils.copyFile(tempScreenshotFile, destFile);
		driver.manage().window().minimize();
		driver.quit();
	}
}
