package FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class lambdaE {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofSeconds(200));
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

		
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.id("logoutLink"));
				if (element != null) {
					System.out.println("Target element found");
				}
				return element;
			}
		};
		wait.until(function);

	}
}
