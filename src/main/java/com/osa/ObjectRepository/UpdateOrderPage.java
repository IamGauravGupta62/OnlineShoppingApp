package com.osa.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.osa.genericUtils.WebDriverUtility;

public class UpdateOrderPage extends WebDriverUtility{
	@FindBy (name = "status")
	private WebElement StatusDD;
	
	@FindBy(name = "remark")
	private WebElement RemarkTbx;
	
	@FindBy (name = "submit2")
	private WebElement UpdateBtn;
	
//initialize
	public UpdateOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getStatusDD() {
		return StatusDD;
	}

	public WebElement getRemarkTbx() {
		return RemarkTbx;
	}

	public WebElement getUpdateBtn() {
		return UpdateBtn;
	}

//Business Library
	public void updateOrder(WebDriver driver, HashMap<String, String> map, String status )
	{
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		selectDropDownByVisibleText(StatusDD, status);
		UpdateBtn.click();
		
	}
	
	
}
