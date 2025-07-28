package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinations{

	 WebDriver driver ;
	 
	//WebdriverUtility utility1;
	//BaseClass class1;
	
	
 	@Given("User is on login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
 		
 		driver =new ChromeDriver();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
 		driver.get("https://www.saucedemo.com/v1/");
 		
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		
	}

	@And("Clicks on login Button")
	public void clicks_on_login_button() {
		driver.findElement(By.id("login-button")).click();
		
	}

	@Then("User is naviagted to Home page")
	public void user_is_naviagted_to_home_page() throws InterruptedException {
		 String currentUrl = driver.getCurrentUrl();
	        if (!currentUrl.contains("inventory")) {
	            throw new AssertionError("User is not navigated to the home page.");
	        }


	}

	@And("Close the browser")
	public void close_the_browser() {
		 if (driver != null) {
	            driver.quit(); // ✅ safest way to close browser
	        }
	}

}