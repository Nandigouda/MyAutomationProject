package handlingpopus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalenderPopUp {
	@Test
	public void calenderPopupClearTrip() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.cleartrip.com/");
		// handle the HDPP
		WebElement closeButton = driver.findElement(By.xpath("//div[@class='px-1   flex flex-middle nmx-1 pb-1']"));
		closeButton.click();
		WebElement homeCalenderButton = driver
				.findElement(By.xpath("//div[contains(@class,'homeCalender')]/button[not(.='Return')]"));
		homeCalenderButton.click();
		Thread.sleep(2000);

//			WebElement leftArrow = driver.findElement(By.xpath("//*[@data-testid='leftArrow']"));
//			homeCalenderButton.sendKeys("Fri, Apr 28");
		Actions actions = new Actions(driver);
		WebElement date;
		for (;;) {
			try {
				date = driver.findElement(By.xpath("//div[@aria-label='Fri Jul 28 2023']"));
				actions.pause(500).scrollByAmount(0, 300).click(date).pause(2000).scrollByAmount(0, -200).perform();
				break;
			} catch (NoSuchElementException e) {
				WebElement rightArrow = driver.findElement(By.xpath("//*[@data-testid='rightArrow']"));
//				rightArrow.click();
				actions.moveToElement(rightArrow).pause(1000).click(rightArrow).perform();
				Thread.sleep(1000);
			}
		}
//			date.click();
	}
}
