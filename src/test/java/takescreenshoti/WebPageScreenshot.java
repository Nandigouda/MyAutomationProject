package takescreenshoti;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebPageScreenshot {

    private static final String URL = "https://www.facebook.com/";
    private static final String SCREENSHOT_DIR = "./errorshots";

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(URL);

            Path folder = Path.of(SCREENSHOT_DIR);
            Files.createDirectories(folder);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File destination = folder.resolve("fb_screenshot_" + timestamp + ".png").toFile();

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, destination);

            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
