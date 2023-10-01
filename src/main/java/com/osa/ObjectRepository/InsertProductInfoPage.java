package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.osa.genericUtils.WebDriverUtility;

public class InsertProductInfoPage {

//declaration
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confirmMsg;

//initialize
	public InsertProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//Utilization
	public WebElement getConfirmMsg() {
		return confirmMsg;
	}
	
//Business library
	public void confirmInsertProdMsg()
	{
		String msg = confirmMsg.getText();
		if(msg.contains("Well done"))
		{
			System.out.println("Product is inserted.");
		}
		else
			System.out.println("Product is not inserted.");
		
	}


	
	

}
