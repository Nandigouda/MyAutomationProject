package com.trello.MyProject.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Create new board']")
	private WebElement createBoard;

	public WebElement getCreateBoard() {
		return createBoard;
	}

	@FindBy(xpath = "//div[@title='qasm6']")
	private WebElement qasm6Board;

	public WebElement getQasm6Board() {
		return qasm6Board;
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement boadrTitle;

	public WebElement getBoadrTitle() {
		return boadrTitle;
	}

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement CreatBoadrdClick;

	public WebElement getCreatBoadrdClick() {
		return CreatBoadrdClick;
	}

	@FindBy(xpath = "//span[@class='lyE6dN0zPcEtwe PXrUPxLInxAuOB UUXk7U_m2LcHHZ']")
	private WebElement profileIcon;

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	@FindBy(xpath = "//button[@data-testid='account-menu-logout']//span[@class='bH80RvHHmoWYhk']")
	private WebElement Logoutoption;

	public WebElement getLogoutoption() {
		return Logoutoption;
	}
	
	@FindBy(xpath="//p[@class='szBTSFrvPTLGHM']")
	private WebElement CreateStaticboard;
	public WebElement gettCreateStaticBoard() {
		
		return CreateStaticboard;
	}
	
	@FindBy(xpath="//span[normalize-space()='Create board']")
	private WebElement CreateStaticboardclick;
	public WebElement gettCreateStaticBoardclick() {
		
		return CreateStaticboardclick;
	}
}
