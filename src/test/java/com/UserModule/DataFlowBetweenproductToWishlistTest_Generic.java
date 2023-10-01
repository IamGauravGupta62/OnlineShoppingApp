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

public class DataFlowBetweenproductToWishlistTest_Generic {

	public static void main(String[] args) throws IOException {
		

		WebDriver driver=null;
		//Create Object for all generic utility file
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//Fetch the data from property file
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("userPassword");
		
		//Fetch data from excel file
		String condition = eLib.readDataFromExcelSheet("DrtaFlowBtProductToWishlistUser", 1, 0);
		

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
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//a[text()=' Electronics']")).click();
		driver.findElement(By.xpath("//a[contains(text(),' Television')]")).click();
		driver.findElement(By.xpath("//a[@href='category.php?pid=226&&action=wishlist']")).click();
		
		String wishlistmsg = driver.findElement(By.xpath("//th[.='my wishlist']")).getText();
		
		
		if(wishlistmsg.contains(condition))
		{
			System.out.println("product is added to my wishlist page.");
		}
		else
			System.out.println("product is not added to my wishlist page.");
	}

}
