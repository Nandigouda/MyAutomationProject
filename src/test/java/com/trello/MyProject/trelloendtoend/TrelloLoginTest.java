package com.trello.MyProject.trelloendtoend;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.trello.MyProject.genericutility.BaseClass;
import com.trello.MyProject.pom.repository.TrelloBoardsPage;
import com.trello.MyProject.pom.repository.TrelloHomePage;
import com.trello.MyProject.pom.repository.TrelloLoginPage;
import com.trello.MyProject.pom.repository.TrelloLogoutPage;
import com.trello.MyProject.pom.repository.TrelloPasswordPage;
import com.trello.MyProject.pom.repository.TrelloUserCreatedBoardsPage;

public class TrelloLoginTest extends BaseClass {

	@Test
	public void homeCheck_01() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		utility.implicitWait(driver);
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals("Manage Your Team’s Projects From Anywhere | Trello", driver.getTitle());
		Reporter.log("Manage Your Team’s Projects From Anywhere | Trello");
		Reporter.log("Trello LoginPage Displayed");
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Reporter.log("Trello HomePage Displayed");
		assert1.assertEquals("https://trello.com/login", driver.getCurrentUrl());
		assert1.assertEquals("Log in to Trello", driver.getTitle());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEnterMail().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		loginPage.getLoginContinueButton().submit();
		Reporter.log("Trello Login with  Atlassian page is displayed");
		assert1.assertEquals("Log in to continue - Log in with Atlassian account", driver.getTitle());
		assert1.assertEquals("https://id.atlassian.com/", driver.getCurrentUrl());
		TrelloPasswordPage pwdPage = new TrelloPasswordPage(driver);
		Thread.sleep(1000);
		pwdPage.getEnterPwd().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		pwdPage.getClickOnPwdButton().click();
		Reporter.log("Boards Profile Home Page is displayed");
		assert1.assertEquals("Boards | Trello", driver.getTitle());
		assert1.assertEquals("https://trello.com/u/nikhilnandigoud/boards", driver.getCurrentUrl());
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		utility.elementToBeClickble(driver, boardsPage.getCreateBoard()).click();
		boardsPage.getBoadrTitle().sendKeys(fileUtils.readDataFromPropertyFile("boadrtitle"));
		utility.elementToBeClickble(driver, boardsPage.getCreatBoadrdClick()).click();
		TrelloUserCreatedBoardsPage created = new TrelloUserCreatedBoardsPage(driver);
		wait.until(ExpectedConditions.titleContains(fileUtils.readDataFromPropertyFile("title2")));
		
		driver.switchTo().activeElement().sendKeys("salar");
		created.getAddcardbutton().click();
		driver.switchTo().activeElement().sendKeys("kgf");
		created.getAddcardbutton().click();
		utility.elementToBeClickble(driver, created.getProfileIcon()).click();
		Reporter.log("Boardpage  clicked");
		WebElement closeBoard = wait.until(ExpectedConditions.visibilityOf(created.getCloseBoard()));
		closeBoard.click();
		utility.elementTobeVisible(driver, created.getCloseBoardButton()).click();
		Reporter.log("getCloseBoardButton closed");
		Thread.sleep(2000);
		utility.elementToBeClickble(driver, created.getProfileIcon()).click();
		Reporter.log("profileicon to delete board clicked");
		utility.elementToBeClickble(driver, created.getDeletePermenantLinltext()).click();
		Reporter.log("getDeletePermenantLinltext clicked");
		utility.elementToBeClickble(driver, created.getDeletePermanentButton()).click();
		Reporter.log("getDeletePermanentButton clicked");
		Reporter.log("BoardPage successfully deleted");
		wait.until(ExpectedConditions.elementToBeClickable(boardsPage.getBoards())).click();
		TrelloBoardsPage boardsPage1 = new TrelloBoardsPage(driver);
		utility.elementToBeClickble(driver, boardsPage1.getProfileIcon()).click();
		utility.elementToBeClickble(driver, boardsPage1.getLogoutoption()).click();
		wait.until(
				ExpectedConditions.titleContains("Log out of your Atlassian account - Log in with Atlassian account"));
		wait.until(ExpectedConditions.urlContains("https://id.atlassian.com/logout"));
		TrelloLogoutPage logout = new TrelloLogoutPage(driver);
		utility.elementToBeClickble(driver, logout.getLogoutButton()).click();

		Reporter.log("Successfully Logged Out of Application");

	}

}
