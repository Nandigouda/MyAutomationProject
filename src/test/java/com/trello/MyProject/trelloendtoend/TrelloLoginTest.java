package com.trello.MyProject.trelloendtoend;

import java.io.IOException;

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

public class TrelloLoginTest extends BaseClass{

	
	@Test 
	public void homeCheck_01() throws IOException, InterruptedException {
	
		utility.implicitWait(driver);
SoftAssert assert1=new SoftAssert();
		assert1.assertEquals("Manage Your Team’s Projects From Anywhere | Trello", driver.getTitle());
			Reporter.log("Manage Your Team’s Projects From Anywhere | Trello");
			Reporter.log("Trello LoginPage Displayed");
			TrelloHomePage homePage=new TrelloHomePage(driver);
			homePage.getLoginOption().click();
			Reporter.log("Trello HomePage Displayed");
			assert1.assertEquals("https://trello.com/login", driver.getCurrentUrl());
			assert1.assertEquals("Log in to Trello", driver.getTitle());
			TrelloLoginPage loginPage=new TrelloLoginPage(driver);
			loginPage.getEnterMail().sendKeys(fileUtils.readDataFromPropertyFile("username"));
			loginPage.getLoginContinueButton().submit();
			Reporter.log("Trello Login with  Atlassian page is displayed");
			assert1.assertEquals("Log in to continue - Log in with Atlassian account", driver.getTitle());
			assert1.assertEquals("https://id.atlassian.com/", driver.getCurrentUrl());
			TrelloPasswordPage pwdPage=new TrelloPasswordPage(driver);
			Thread.sleep(1000);
			pwdPage.getEnterPwd().sendKeys(fileUtils.readDataFromPropertyFile("password"));
			pwdPage.getClickOnPwdButton().click();
			Reporter.log("Boards Profile Home Page is displayed");
			assert1.assertEquals("Boards | Trello", driver.getTitle());
			assert1.assertEquals("https://trello.com/u/nikhilnandigoud/boards", driver.getCurrentUrl());
			TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
			utility.elementToBeClickble(driver, boardsPage.getCreateBoard()).click();
			boardsPage.getBoadrTitle().sendKeys(fileUtils.readDataFromPropertyFile("boadrtitle"));
			utility.elementToBeClickble(driver,boardsPage.getCreatBoadrdClick()).click();
			TrelloUserCreatedBoardsPage created = new TrelloUserCreatedBoardsPage(driver);
			
			Thread.sleep(3000);
			utility.explicitWait(driver, driver.getTitle());
			driver.switchTo().activeElement().sendKeys("salar");
			created.getAddcardbutton().click();
			driver.switchTo().activeElement().sendKeys("kgf");
			created.getAddcardbutton().click();
			
			

			/*utility.elementToBeClickble(driver, created.getProfileIcon()).click();
			Reporter.log("Boardpage  clicked");
			utility.elementToBeClickble(driver, created.getMoreOption()).click();
			///created.getMoreOption().click();
			utility.elementToBeClickble(driver, created.getCloseBoard()).click();
			// created.getCloseBoard().click();
			utility.elementToBeClickble(driver, created.getCloseBoardButton()).click();
			// created.getCloseBoardButton().click();
			utility.elementToBeClickble(driver, created.getDeletePermenantLinltext()).click();
			//created.getDeletePermenantLinltext().click();
			//utility.explicitWait(driver, created.getDeletePermanentButton()).click();
			created.getDeletePermanentButton().click();
			Reporter.log("BoardPage successfully deleted");
			
			boardsPage.getProfileIcon().click();
			boardsPage.getLogoutoption().click();
			assert1.assertEquals("Log out of your Atlassian account - Log in with Atlassian account", driver.getTitle());
			assert1.assertEquals("https://id.atlassian.com/logout", driver.getCurrentUrl());
			TrelloLogoutPage logout = new TrelloLogoutPage(driver);
			logout.getLogoutButton().click();
			Reporter.log("Successfually LogedOut of Application");
*/
			
			
			
			
			
			
			
	}
	
	
	
	
}
