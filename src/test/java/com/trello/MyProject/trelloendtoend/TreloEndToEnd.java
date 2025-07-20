package com.trello.MyProject.trelloendtoend;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.trello.MyProject.genericutility.BaseClass;
import com.trello.MyProject.genericutility.FileUtility;
import com.trello.MyProject.pom.repository.TrelloBoardsPage;
import com.trello.MyProject.pom.repository.TrelloHomePage;
import com.trello.MyProject.pom.repository.TrelloLoginPage;
import com.trello.MyProject.pom.repository.TrelloLogoutPage;
import com.trello.MyProject.pom.repository.TrelloPasswordPage;
import com.trello.MyProject.pom.repository.TrelloUserCreatedBoardsPage;

public class TreloEndToEnd extends BaseClass {

	@Test
	public void check() throws Throwable {
		utility.implicitWait(driver);
		FileUtility file = new FileUtility();
		TrelloHomePage homePage = new TrelloHomePage(driver);
		Reporter.log("Home Page Displayed");
		homePage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		Reporter.log("Login Page Displayed");
		loginPage.getEnterMail().sendKeys(file.readDataFromPropertyFile("username"));
		loginPage.getLoginContinueButton().click();

		TrelloPasswordPage passwordPage = new TrelloPasswordPage(driver);
		Reporter.log("Login to Continue Displayed");

		Thread.sleep(2000);
		passwordPage.getEnterPwd().sendKeys(file.readDataFromPropertyFile("password"));
		passwordPage.getClickOnPwdButton().click();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Reporter.log("Boards Displayed");

		boardsPage.getCreateBoard().click();

		boardsPage.getBoadrTitle().sendKeys("board");
		Thread.sleep(1000);
		boardsPage.getCreatBoadrdClick().click();
		Thread.sleep(1000);
		Reporter.log("Board created");

		TrelloUserCreatedBoardsPage createdPage = new TrelloUserCreatedBoardsPage(driver);
		Thread.sleep(1000);
		driver.navigate().refresh();

		createdPage.getProfileIcon().click();
		createdPage.getMoreOption().click();
		createdPage.getCloseBoard().click();
		createdPage.getCloseBoardButton().click();
		createdPage.getDeletePermenantLinltext().click();
		createdPage.getDeletePermanentButton().click();
		Reporter.log("BoardPage successfully deleted");

		boardsPage.getProfileIcon().click();
		boardsPage.getLogoutoption().click();
		TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().click();
		Reporter.log("Successfully Logged Out of Application");

		Thread.sleep(1000);
	}
}
