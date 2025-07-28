package handlingpopus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingActiveElement {

	WebDriver driver;
	
	public void handlingActive2() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Selenium");
	}
	public void handlingActiveElements1() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://trello.com/login");
		// identify the email text field
		// it is an active element.
		driver.switchTo().activeElement().sendKeys("peoplefortiptur@gmail.com");
	}
	/*ipl
	ipl score
	ipl match
	ipl match today
	ipl 2023
	ipl live score
	ipl schedule 2023
	ipl table
	ipl points table
	ipl today*/
	
	@Test
	public void handligMyntraAutoSuggestions() throws Throwable{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		WebElement searchTextField = driver.findElement(By.className("desktop-searchBar"));
		searchTextField.sendKeys("Jac");
		List<WebElement> allAutoSuggestions = driver.findElements(By.xpath("//ul[@class='desktop-group']/li"));
		System.out.println(allAutoSuggestions.size());
		for (WebElement suggestion : allAutoSuggestions) {
			String option = suggestion.getText();
			if (option.equals("Jacket Kids")) {
				suggestion.click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.quit();
	
	}
	//assignment
	
	@Test
	public void handlingGoogleAutoSuggestion() throws InterruptedException {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com");
		driver.switchTo().activeElement().sendKeys("ipl");
		List<WebElement> searchTextField = driver.findElements(By.xpath("//ul//li//div[@class='lnnVSe']"));
		System.out.println(searchTextField.size());
		for (WebElement suggestion : searchTextField) {
			String option = suggestion.getDomAttribute("aria-label");
			System.out.println(option);
			if (option.equals("ipl 2023")) {
				suggestion.click();
				break;
		}}
		Thread.sleep(1000);
		driver.quit();
	}
}
