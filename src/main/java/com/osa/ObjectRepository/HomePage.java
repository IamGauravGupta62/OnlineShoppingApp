package com.osa.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutBtn;
	
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
	
	@FindBy(xpath = "//a[text()=' Fashion 888']")
    private WebElement fashion888Tab;
	
	@FindBy (xpath = "(//i[@class='icon fa fa-user'])[1]/parent::a")
	private WebElement userIcon;
	
	@FindBy(xpath = "product")
	private WebElement searchTbx;
	
	@FindBy(className = "search")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//a[contains(text(),' Television')]")
	private WebElement televisionCategoryLink;
	
}
