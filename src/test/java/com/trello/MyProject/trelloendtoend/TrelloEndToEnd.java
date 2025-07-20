package com.trello.MyProject.trelloendtoend;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trello.MyProject.genericutility.BaseClass;
import com.trello.MyProject.pom.repository.TrelloBoardsPage;
import com.trello.MyProject.pom.repository.TrelloHomePage;
import com.trello.MyProject.pom.repository.TrelloLoginPage;
import com.trello.MyProject.pom.repository.TrelloLogoutPage;
import com.trello.MyProject.pom.repository.TrelloPasswordPage;
import com.trello.MyProject.pom.repository.TrelloUserCreatedBoardsPage;

public class TrelloEndToEnd extends BaseClass {
	
	

	@Test
	public void check() throws Throwable {
		utility.implicitWait(driver);
		TrelloHomePage homePage = new TrelloHomePage(driver);
		Reporter.log("Home Page Displayed");
		homePage.getLoginOption().click();
		TrelloLoginPage loginpage = new TrelloLoginPage(driver);
		Reporter.log("Login Page Displayed");
		loginpage.getEnterMail().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		loginpage.getLoginContinueButton().click();
		TrelloPasswordPage passwordPage = new TrelloPasswordPage(driver);
		Reporter.log("Login to Continue Displayed");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(150));
        //utility.explicitWait(driver, fileUtils.readDataFromPropertyFile("title"));
		boolean validation = wait.until(ExpectedConditions.titleIs(fileUtils.readDataFromPropertyFile("title")));
		passwordPage.getEnterPwd().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		passwordPage.getClickOnPwdButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Reporter.log("Boards Displayed");
		boardsPage.getCreateBoard().click();
		boardsPage.getBoadrTitle().sendKeys("board");
		utility.elementToBeClickble(driver, boardsPage.getCreatBoadrdClick()).click();
		Reporter.log("Board created");
		Thread.sleep(2000);
		TrelloUserCreatedBoardsPage created = new TrelloUserCreatedBoardsPage(driver);
		//utility.explicitWait(driver, fileUtils.readDataFromPropertyFile("title1"));

		created.getProfileIcon().click();
		Reporter.log("Boardpage  clicked");
		// utility.elementToBeClickble(driver, created.getMoreOption()).click();
		created.getMoreOption().click();
		// utility.elementToBeClickble(driver, created.getCloseBoard()).click();
		created.getCloseBoard().click();
		// utility.elementToBeClickble(driver, created.getCloseBoardButton()).click();
		created.getCloseBoardButton().click();
		// utility.elementToBeClickble(driver,
		// created.getDeletePermenantLinltext()).click();
		created.getDeletePermenantLinltext().click();
		// utility.elementToBeClickble(driver,
		// created.getDeletePermanentButton()).click();
		created.getDeletePermanentButton().click();
		Reporter.log("BoardPage successfully deleted");
		boardsPage.getProfileIcon().click();
		boardsPage.getLogoutoption().click();
		TrelloLogoutPage logout = new TrelloLogoutPage(driver);
		logout.getLogoutButton().click();
		Reporter.log("Successfually LogedOut of Application");

	}

	// @BeforeClass
	public void beforeMethod() throws IOException {
		utility.implicitWait(driver);
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEnterMail().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		loginPage.getLoginContinueButton().submit();
		TrelloPasswordPage passwordPage = new TrelloPasswordPage(driver);
		utility.explicitWait(driver, fileUtils.readDataFromPropertyFile("title"));

		passwordPage.getEnterPwd().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		passwordPage.getClickOnPwdButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Reporter.log("Boards Displayed");
		boardsPage.getQasm6Board().click();
		TrelloUserCreatedBoardsPage CreatedBoardsPage = new TrelloUserCreatedBoardsPage(driver);
		CreatedBoardsPage.getAddedCard().click();
		utility.switchToActive(driver, "constructor");
		utility.enums(driver);
		utility.switchToActive(driver, "synchoronization");
		utility.enums(driver);
		utility.switchToActive(driver, "Actions");
		utility.enums(driver);
		utility.switchToActive(driver, "Inheritance");
		utility.enums(driver);
		utility.switchToActive(driver, "Weblelment");
		utility.enums(driver);
		utility.switchToActive(driver, "Select Class");

	}

	//@BeforeMethod
	public void Dra() throws IOException {
		utility.implicitWait(driver);
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEnterMail().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		loginPage.getLoginContinueButton().submit();
		TrelloPasswordPage passwordPage = new TrelloPasswordPage(driver);
		utility.explicitWait(driver, fileUtils.readDataFromPropertyFile("title"));

		passwordPage.getEnterPwd().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		passwordPage.getClickOnPwdButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Reporter.log("Boards Displayed");
		boardsPage.getQasm6Board().click();

	}

	@Test
	public void DragAndDrop() {

		utility.implicitWait(driver);
		Actions actions = new Actions(driver);
		// List<WebElement> allCardsInList =
		// driver.findElements(By.xpath("//div[@class='list-card-details
		// js-card-details']"));
		List<WebElement> allCardsTitle = driver.findElements(By.xpath(
				"//div[@class='list-card-details js-card-details']/span[@class='list-card-title js-card-name']"));
		WebElement seleniumContainer = driver.findElement(By.xpath(
				"//h2[text()='Selenium']/../..//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable']"));
		WebElement javaContainer = driver.findElement(By.xpath(
				"//h2[text()='Java']/../..//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable']"));
		for (WebElement cards : allCardsTitle) {
			if (cards.getText().contains("Selenium")) {
				actions.dragAndDrop(cards, seleniumContainer).perform();
				actions.pause(2000).perform();
			} else if (cards.getText().contains("Java")) {
				actions.dragAndDrop(cards, javaContainer).perform();
				actions.pause(2000).perform();
			}
		}
	}

	@Test
	public void sortWithoutDragAndDrop() {
		utility.implicitWait(driver);
		Actions actions = new Actions(driver);
		// List<WebElement> allCardsInList =
		// driver.findElements(By.xpath("//div[@class='list-card-details
		// js-card-details']"));
		List<WebElement> allCardsTitle = driver.findElements(By.xpath(
				"//div[@class='list-card-details js-card-details']/span[@class='list-card-title js-card-name']"));
		WebElement seleniumContainer = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[2]"));
		WebElement javaContainer = driver.findElement(By.xpath(
				"//h2[normalize-space()='Java']/../../..//div[contains(@class,'list-cards u-fancy-scrollbar js-list-cards js-sortable ui-sortable')]"));
		for (WebElement cards : allCardsTitle) {
			if (cards.getText().contains("Selenium")) {
				actions.clickAndHold(cards).moveToElement(seleniumContainer).release().build().perform();
				actions.pause(3000);
			} else if (cards.getText().contains("Java")) {
				actions.clickAndHold(cards).moveToElement(javaContainer).release().build().perform();
				actions.pause(3000);
			}
		}
	}

	@Test
	public void DragAndDrop1() throws Throwable {
		utility.implicitWait(driver);
		Actions actions = new Actions(driver);
		List<WebElement> allCardsInList = driver
				.findElements(By.xpath("//div[@class='list-card-details js-card-details']"));
		WebElement containerToDrop = driver.findElement(By.xpath(
				"//h2[text()='Selenium']/../..//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable']"));
		for (WebElement card : allCardsInList) {

			actions.dragAndDrop(card, containerToDrop).build().perform();
			actions.pause(2000);

		}
		Thread.sleep(5000);
	}

	// @AfterMethod
	public void AfterMethod() {
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getProfileIcon().click();
		boardsPage.getLogoutoption().click();
		TrelloLogoutPage logout = new TrelloLogoutPage(driver);
		logout.getLogoutButton().click();
		Reporter.log("Successfually LogedOut of Application");

	}
	@Test
	public void CreateBoardFromStaticBar() throws IOException {
		utility.implicitWait(driver);
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEnterMail().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		loginPage.getLoginContinueButton().submit();
		TrelloPasswordPage passwordPage = new TrelloPasswordPage(driver);
		utility.explicitWait(driver, fileUtils.readDataFromPropertyFile("title"));

		passwordPage.getEnterPwd().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		passwordPage.getClickOnPwdButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Reporter.log("Boards Displayed");
		boardsPage.gettCreateStaticBoard().click();
		utility.elementToBeClickble(driver, boardsPage.gettCreateStaticBoardclick()).click();
		
		boardsPage.getBoadrTitle().sendKeys("board");
		utility.elementToBeClickble(driver, boardsPage.getCreatBoadrdClick()).click();
		Reporter.log("Board created");
		TrelloUserCreatedBoardsPage created = new TrelloUserCreatedBoardsPage(driver);
		utility.explicitWait(driver, fileUtils.readDataFromPropertyFile("title1"));

		created.getProfileIcon().click();
		Reporter.log("Boardpage  clicked");
		// utility.elementToBeClickble(driver, created.getMoreOption()).click();
		created.getMoreOption().click();
		// utility.elementToBeClickble(driver, created.getCloseBoard()).click();
		created.getCloseBoard().click();
		// utility.elementToBeClickble(driver, created.getCloseBoardButton()).click();
		created.getCloseBoardButton().click();
		// utility.elementToBeClickble(driver,
		// created.getDeletePermenantLinltext()).click();
		created.getDeletePermenantLinltext().click();
		// utility.elementToBeClickble(driver,
		// created.getDeletePermanentButton()).click();
		created.getDeletePermanentButton().click();
		Reporter.log("BoardPage successfully deleted");
		boardsPage.getProfileIcon().click();
		boardsPage.getLogoutoption().click();
		TrelloLogoutPage logout = new TrelloLogoutPage(driver);
		logout.getLogoutButton().click();
		Reporter.log("Successfually LogedOut of Application");
		
		
		
		
		
	}

}
