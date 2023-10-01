package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	//declaration
	@FindBy(xpath ="//a[text()='Login']")
	private WebElement loginLink;
	
	@FindBy(xpath ="//a[text()='My Cart']" )
	private WebElement myCartLink;
	
	@FindBy(xpath = "//a[text()='Wishlist']")
	private WebElement wishlistLink;
	
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//span[text()='Track Order']")
	private WebElement trackOrderBtn;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeTab;
	
	@FindBy(xpath = "//a[text()=' Electronics']")
	private WebElement electronicsTab;
	
	
	//initialization
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	//utilization
	public WebElement getLoginLink() {
		return loginLink;
	}


	public WebElement getMyCartLink() {
		return myCartLink;
	}


	public WebElement getWishlistLink() {
		return wishlistLink;
	}


	public WebElement getMyAccountLink() {
		return myAccountLink;
	}


	public WebElement getTrackOrderBtn() {
		return trackOrderBtn;
	}


	public WebElement getHomeTab() {
		return homeTab;
	}


	public WebElement getElectronicsTab() {
		return electronicsTab;
	}
	
	
	
	
	

}
