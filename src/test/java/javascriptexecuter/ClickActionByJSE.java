package javascriptexecuter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickActionByJSE {
@Test
	public void loginButton() throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	//driver.get("https://demo.actitime.com/login.do");
	
	driver.get("https://google.com/");
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(3000);
	
	//jse.executeScript("document.getElementById(\"loginButton\").click()");
	
	//jse.executeScript("document.getElementById(\"inputWrapper\").sendkeys(\"facebook\")");
	

	jse.executeScript("document.getElementsByName('q')[0].form.submit();");
	 // Set text in Google search box
    jse.executeScript("document.getElementsByName('q')[0].value='facebook';");
}}
