package com.UserModule;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class AddProductToCart_Generic {

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
		
		//Fetch the data from excel file
		String alertMsg = eLib.readDataFromExcelSheet("Add product to cart_User", 1, 0);
		
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
		//driver.manage().window().maximize();
		
		wLib.implicitWait(driver, 10);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("email")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(USERPASSWORD);
		driver.findElement(By.name("login")).click();
		
		// search a product
		driver.findElement(By.name("product")).sendKeys("Micromax Canvas Mega 4G");
        driver.findElement(By.name("search")).submit();
        
        driver.findElement(By.xpath("//a[.='Micromax Canvas Mega 4G']")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart inner-right-vs']")).click();
        
          wLib.acceptAlertPopup(driver, alertMsg);
          
          
//        String msg = driver.switchTo().alert().getText();
//        driver.switchTo().alert().accept();
        
        //confirm the message
//        if(msg.contains("Product has been added to the cart"))
//        {
//        	System.out.println("the product is added to cart." );
//        	
//        }
//        else
//        	System.out.println("The product is not added to cart." );
		
		
	}

}
