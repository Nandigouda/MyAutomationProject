package takescreenshoti;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotofWebelement {

    private WebDriver driver;
    private static final String SCREENSHOT_DIR = "./errorshots";

    @BeforeMethod
    public void beforeMethod() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        Reporter.log("URL Triggered.");
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void takeScreenshotOfLoginButton() {
        try {
            Path folder = Path.of(SCREENSHOT_DIR);
            Files.createDirectories(folder);

            WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.name("login")));

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File destination = folder.resolve("fb_login_" + timestamp + ".png").toFile();

            File screenshot = loginButton.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, destination);

            Reporter.log("Screenshot saved at: " + destination.getAbsolutePath());

        } catch (IOException e) {
            Reporter.log("Screenshot failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
