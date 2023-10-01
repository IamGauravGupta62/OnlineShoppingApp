package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.osa.genericUtils.WebDriverUtility;

public class DashboardAdminPage {

	//Declaration
	@FindBy(xpath = "//img[@class='nav-avatar']")
	private WebElement logoutIcon;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	
	
	@FindBy(xpath = "//a[contains(.,'Create Category')]")
	private WebElement CtCategoryLink;
	
	@FindBy(xpath = "//a[text()='Insert Product ']")
	private WebElement IstProduct;
	
	@FindBy(xpath = "//a[@class='collapsed']")
	private WebElement OrderManagementTab;
	
	@FindBy (xpath = "//a[contains(.,'Pending Orders')]")
	private WebElement PendingorderLink;
	
	
	
	//Initialization
	public DashboardAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCtCategoryLink() {
		return CtCategoryLink;
	}	
	
	public WebElement getIstProduct() {
		return IstProduct;
	}
	public WebElement getOrderManagementTab() {
		return OrderManagementTab;
	}

	public WebElement getPendingorderLink() {
		return PendingorderLink;
	}


	//Business Library
	public void clickOnCtCategory()
	{
		CtCategoryLink.click();
	}
	
	public void clickOnIstProduct() {
		IstProduct.click();
	}
	
	public void clickOnorderManagement()
	{
		OrderManagementTab.click();
	}
	public void clickOnPendingOrder()
	{
		PendingorderLink.click();
	}
	
	
	public void logout(WebDriver driver)
	{
		logoutIcon.click();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.mouseOverOnTheElement(logout, driver);
		logout.click();
		
	}
	

	

}
