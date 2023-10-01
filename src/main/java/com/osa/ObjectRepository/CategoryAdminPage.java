package com.osa.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryAdminPage {
	//Declaration
	@FindBy(name = "category")
	private WebElement CategoryTbx;
	
	@FindBy(name = "description")
	private WebElement DescriptionTbx;
	
	@FindBy(name = "submit")
	private WebElement CreateBtn;
	
	//initialization
	public CategoryAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCategoryTbx() {
		return CategoryTbx;
	}

	public WebElement getDescriptionTbx() {
		return DescriptionTbx;
	}

	public WebElement getCreateBtn() {
		return CreateBtn;
	}
	
	//Business library
	public void createCategory(HashMap<String, String> map, WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
			
	}
	
	public void clickonCreateBtn()
	{
		CreateBtn.click();
	}



}

















