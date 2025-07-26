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

	@FindBy(xpath = "//span[@class='nch-icon hChYpzFshATQo8 FQRfhpoLVAyxHI r1ljm7etlgUs0w']//span[@class='_1e0c1o8l _1o9zidpf _vyfuvuon _vwz4kb7n _1szv15vq _1tly15vq _rzyw1osq _17jb1osq _1ksvoz0e _3se1x1jp _re2rglyw _1veoyfq0 _1kg81r31 _jcxd1r8n _gq0g1onz _1trkwc43']")
	private WebElement profileIcon;
	
	

	public WebElement getProfileIcon() {
		return profileIcon;
	}
	@FindBy(xpath = "//span[@title='Nikhil Nandigoud (nikhilnandigoud)']")
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

	@FindBy(xpath = "//li/button[text()='Permanently delete board']")
	private WebElement deletePermenantLinltext;

	public WebElement getDeletePermenantLinltext() {
		return deletePermenantLinltext;
	}

	@FindBy(xpath = "//button[normalize-space()='Permanently delete board']")
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
