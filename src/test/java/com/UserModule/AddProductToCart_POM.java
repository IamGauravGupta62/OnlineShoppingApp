  package com.UserModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class AddProductToCart_POM {

	public static void main(String[] args) throws IOException {
WebDriver driver=null;
		
		//create object for all generic library
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//Fetch the data from property file
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String USERPASSWORD=fLib.getPropertyKeyValue("userPassword");
		
		//launch the browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else
					System.out.println("Invalid browser");
				
				
				wLib.maximizeTheBrowser(driver);
				wLib.implicitWait(driver, 10);
				
				driver.get(URL);
				
		
	}
	
	
	
}
