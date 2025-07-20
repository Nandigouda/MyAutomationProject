package handlingpopus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleTable {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://irctc.com/contact.html");
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='card-header']"));
		for (WebElement option : allOptions) {
			if (option.getText().contains("IRCTC")) {
				option.click();
				new Actions(driver).scrollByAmount(0, 300).perform();
				WebElement parentElement = driver.findElement(By.tagName("table"));
				WebElement lastRow = parentElement.findElement(By.xpath("(//tr)[last()]"));
				List<WebElement> allCells = lastRow.findElements(By.tagName("td"));
				for (WebElement cell : allCells) {
					if (cell.getAttribute("data-title").equals("url")) {
						String attValue = cell.findElement(By.tagName("a")).getAttribute("href");
						System.out.println(cell.getAttribute("data-title") + " = " + attValue);
					}else {
						System.out.println(cell.getAttribute("data-title") + " = " + cell.getText());
					}
				}
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}