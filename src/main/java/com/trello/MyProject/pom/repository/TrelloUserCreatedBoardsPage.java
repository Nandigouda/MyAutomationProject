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

	@FindBy(xpath = "//span[@class='show-sidebar-button-react-root']")
	private WebElement profileIcon;

	public WebElement getProfileIcon() {
		return profileIcon;
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

	@FindBy(xpath = "//ul/li/a[contains(@class,' js-close-board')]")
	private WebElement closeBoard;

	public WebElement getCloseBoard() {
		return closeBoard;
	}

	@FindBy(xpath = "//p[text()='You can find and reopen closed boards at the bottom of ']/following-sibling::input[@type='submit']")
	private WebElement closeBoardButton;

	public WebElement getCloseBoardButton() {
		return closeBoardButton;
	}

	@FindBy(xpath = "//div/button[text()='Permanently delete board']")
	private WebElement deletePermenantLinltext;

	public WebElement getDeletePermenantLinltext() {
		return deletePermenantLinltext;
	}

	@FindBy(xpath = "//div/button[text()='Delete']")
	private WebElement deletePermanentButton;

	public WebElement getDeletePermanentButton() {
		return deletePermanentButton;
	}

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addcardbutton;

	public WebElement getAddcardbutton() {
		return addcardbutton;
	}

}
