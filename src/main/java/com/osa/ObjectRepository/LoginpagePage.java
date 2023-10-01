package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePage {
	
	//declaration
	@FindBy(className = "email")
	private WebElement emailAddressTbx;
	
	@FindBy(className = "password")
	private WebElement passwordTbx;
	
	@FindBy(className = "login")
	private WebElement loginBtn;
	
	//initialization
	public LoginpagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getEmailAddressTbx() {
		return emailAddressTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business library
	
	
	
	
	

}
