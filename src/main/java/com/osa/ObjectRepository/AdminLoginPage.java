package com.osa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	@FindBy(id = "inputEmail")
	private WebElement AUsernameTbx;
	
	@FindBy(id = "inputPassword")
	private WebElement APasswordTbx;
	
	@FindBy(name = "submit")
	private WebElement loginBtn;
	
	
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAUsernameTbx() {
		return AUsernameTbx;
	}

	public WebElement getAPasswordTbx() {
		return APasswordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//business library
	public void login(String user,String pass)
	{
		AUsernameTbx.sendKeys(user);
		APasswordTbx.sendKeys(pass);
		loginBtn.click();
	}

	
	
	
	
	
	

}
