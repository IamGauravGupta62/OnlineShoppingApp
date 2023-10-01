package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingOrdersPage {
//declaration	
	@FindBy(xpath = "//table[@id='DataTables_Table_0']//tbody/tr/td[1][text()='1']/../td[last()]/a")
	private WebElement PendingOrderIcon;
//initialization	
//	public PendingOrdersPage(WebDriver driver)
//	{
//		PageFactory.initElements(driver, this);
//	}

public PendingOrdersPage(WebDriver driver) {

PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getPendingOrderIcon() {
		return PendingOrderIcon;
	}
	
//Business libraries
	public void clickOnUpdateOrderIcon()
	{
		PendingOrderIcon.click();
	}
	
	
}
