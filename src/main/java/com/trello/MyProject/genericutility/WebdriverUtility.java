package com.trello.MyProject.genericutility;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class WebdriverUtility helps us to perform functions related to WebDriver
 * Methods
 * 
 * @author Nikhil Nandigouda
 *
 */

public class WebdriverUtility {
	/**
	 * @return void
	 *
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * 
	 * @param driver
	 * @param expectedTitle
	 * @return booleanvalidation
	 */
	public boolean explicitWait(WebDriver driver, String expectedTitle) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean validation = wait.until(ExpectedConditions.titleIs(expectedTitle));
		return validation;
	}

	/**
	 * 
	 * @param driver
	 * @param frameIndex
	 * @return void
	 */
	public void switchToImmediateFrameByIndex(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public WebElement elementToBeClickble(WebDriver driver, WebElement element) {
		/**
		 * @param driver
		 * @param element
		 * @return boolean
		 * 
		 * 
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement validation = wait.until(ExpectedConditions.elementToBeClickable(element));
		return validation;
	}

	public WebElement elementTobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
		return ele;
	}

	public boolean xyz(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean ele = wait.until(ExpectedConditions.titleIs(""));
		return ele;
	}

	/**
	 * 
	 * @param driver
	 * @param sendKeys
	 */
	public void switchToActive(WebDriver driver, String sendKeys) {

		driver.switchTo().activeElement().sendKeys(sendKeys);

	}

	public void enums(WebDriver driver) {

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		driver.switchTo().activeElement().sendKeys(Keys.ENTER);

	}

}