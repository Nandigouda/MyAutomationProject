package handlingpopus;



	import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class HandlingForms {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement parentElement = driver.findElement(By.tagName("form"));
		WebElement emailTextField = parentElement.findElement(By.id("email"));
		System.out.println("emailTextField placeholder is: " + emailTextField.getAttribute("placeholder"));
		WebElement passwordTextField = parentElement.findElement(By.id("pass"));
		System.out.println("passwordTextField placeholder is: " + passwordTextField.getAttribute("placeholder"));
		WebElement loginButton = parentElement.findElement(By.tagName("button"));
		System.out.println("BUtton tagText is : " + loginButton.getText());
		List<WebElement> allAnchorsInForm = parentElement.findElements(By.tagName("a"));
		for (WebElement anchorTag : allAnchorsInForm) {
			if (anchorTag.isDisplayed()) {
				System.out.println("<a> >Tagtext< is : " + anchorTag.getText());
			}
		}
		driver.manage().window().minimize();
		driver.quit();
		
	}
	}

