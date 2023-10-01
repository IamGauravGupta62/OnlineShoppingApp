package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryInfoPage {
	//declaration
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement cnfMsg;
	
	//initialization
	public CategoryInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCnfMsg() {
		return cnfMsg;
	}

	//utilize
	public void setCnfMsg(WebElement cnfMsg) {
		this.cnfMsg = cnfMsg;
	}
	
	
	//Business library
	public void verifyMsg()
	{
		String msg = cnfMsg.getText();
		if(msg.contains("Well done"))
		{
			System.out.println("Category is created.");
		}
		else {
			System.out.println("Category is not created.");
		}
	}
	

}
