package com.trello.MyProject.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloUserCreatedBoardsPage {
	WebDriver driver;

	public TrelloUserCreatedBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-testid='OverflowMenuHorizontalIcon']")
	private WebElement profileIcon;
	
	

	public WebElement getProfileIcon() {
		return  profileIcon;
	}
	@FindBy(xpath = "//span[@class='lyE6dN0zPcEtwe PXrUPxLInxAuOB UUXk7U_m2LcHHZ']")
	private WebElement profileIcon1;
	
	

	public WebElement getProfileIcon1() {
		return profileIcon1;
	}

	@FindBy(xpath = "//a[@class='open-card-composer js-open-card-composer']")
	private WebElement addCard;

	public WebElement getAddedCard() {
		return addCard;
	}

	@FindBy(xpath = "//ul/li/a[@class='board-menu-navigation-item-link js-open-more']")
	private WebElement moreOption;

	public WebElement getMoreOption() {
		return moreOption;
	}

	@FindBy(xpath = "//li[20]//button[1]")
	private WebElement closeBoard;

	public WebElement getCloseBoard() {
		return closeBoard;
	}

	@FindBy(xpath = "//button[normalize-space()='Close']")
	private WebElement closeBoardButton;

	public WebElement getCloseBoardButton() {
		return closeBoardButton;
	}

	@FindBy(xpath = "//button[normalize-space()='Permanently delete board']")
	private WebElement deletePermenantLinltext;

	public WebElement getDeletePermenantLinltext() {
		return deletePermenantLinltext;
	}

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	private WebElement deletePermanentButton;

	public WebElement getDeletePermanentButton() {
		return deletePermanentButton;
	}

	@FindBy(xpath = "//div/button[text()='Add list']")
	private WebElement addcardbutton;

	public WebElement getAddcardbutton() {
		return addcardbutton;
	}

}
