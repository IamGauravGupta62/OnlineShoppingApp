package com.AdminModule;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class ManageOrderByAdmin_Generic {

	public static void main(String[] args) throws IOException {
		
		//Create object for all generic utility
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//Fetch the data from property file
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String ADMINURL=fLib.getPropertyKeyValue("adminUrl");
		String ADMINUSERNAME = fLib.getPropertyKeyValue("adminUsername");
		String ADMINPASSWORD = fLib.getPropertyKeyValue("adminPassword");
		
		
		//Read the data from excel file
		String alertMsg = eLib.readDataFromExcelSheet("MAnage order_Admin", 1, 4);
						
		WebDriver driver=null;
		
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
		
		
		driver.get(ADMINURL);
		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();
		
	
		   
		
		driver.findElement(By.xpath("//a[@class='collapsed']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Pending Orders')]")).click();
		driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody/tr/td[1][text()='1']/../td[last()]/a")).click();

		wLib.switchToBasedOnTitle(driver, "Update Compliant");		
//		//switching to new window
//		Set<String> window = driver.getWindowHandles();
//		Iterator<String> it = window.iterator();
//		while(it.hasNext())
//		{
//			String win = it.next();
//			String titleOfWindow = driver.switchTo().window(win).getTitle();
//			if(titleOfWindow.contains("Update Compliant"))
//			{
//				break;
//			}
//		}
		
		//enter the details in new window
		WebElement status = driver.findElement(By.name("status"));
		
		wLib.selectDropDownByVisibleText(status, "Delivered");
//		s=new Select(status);
//		s.selectByVisibleText("Delivered");
		
		driver.findElement(By.name("remark")).sendKeys("delivered the pending product ");
		
		// click on the submit button
		driver.findElement(By.name("submit2")).click();
		

        wLib.acceptAlertPopup(driver, alertMsg);
//		//click on 'ok' button in popup
//		driver.switchTo().alert().accept();
		

	}

}
