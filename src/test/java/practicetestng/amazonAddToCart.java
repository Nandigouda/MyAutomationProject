package practicetestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class amazonAddToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		Actions action=new Actions(driver);
		
		WebElement aaa = driver.findElement(By.xpath("//div[@class='a-section feed-carousel-viewport']//img[@alt='Samsung Galaxy M14 5G']"));
		
		action.moveToElement(aaa).pause(2000).click().build().perform();
		
		/*
		 * WebElement img = driver.findElement(By.
		 * xpath("//img[@alt=\"Bluetooth Calling Smartwatch starts at ₹1,999\"]"));
		 * img.click(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(5)); wait.until(ExpectedConditions.titleIs("Amazon.in"));
		 * // Thread.sleep(2000); WebElement watch = driver.findElement(By.xpath(
		 * "//span[@aria-label=\"Amazon's Choice\"]//a[contains(@href,\"/Fire-Boltt-Bluetooth-Calling-Assistance-Resolution\")]"
		 * )); watch.click(); WebElement aa1 =
		 * wait.until(ExpectedConditions.elementToBeClickable(driver
		 * .findElement(By.cssSelector("input#add-to-cart-button")))); aa1.click();
		 */

	//	WebElement aa = wait.until(ExpectedConditions.elementToBeClickable(driver
		//		.findElement(By.xpath("//following-sibling::div//span[@id='attach-sidesheet-checkout-button']"))));
		//aa.click();
	}

}
