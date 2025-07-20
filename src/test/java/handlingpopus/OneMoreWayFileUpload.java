package handlingpopus;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OneMoreWayFileUpload {

	
	@Test
	public void oneMoreWayFileUpload() throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.foundit.in/seeker/registration");
	String S="‪downloads";
	StringSelection sele=new StringSelection(S);
	Toolkit kit=Toolkit.getDefaultToolkit();
	Clipboard clipboard=kit.getSystemClipboard();
	clipboard.setContents(sele, null);
	
	driver.findElement(By.className("contentTitle")).click();
	Thread.sleep(5000);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(1000);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(100);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	String S1="‪resume.pdf";
	StringSelection sele1=new StringSelection(S1);
	Toolkit kit1=Toolkit.getDefaultToolkit();
	Clipboard clipboard1=kit1.getSystemClipboard();
	clipboard1.setContents(sele1, null);
	Thread.sleep(5000);
	Robot robot1= new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(1000);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(100);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);

		
		
	}
}
