package com.AdminModule;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.DashboardAdminPage;
import com.osa.ObjectRepository.PendingOrdersPage;
import com.osa.ObjectRepository.UpdateOrderPage;
import com.osa.genericUtils.DataBaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class ManageOrderByAdmin_POM {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		DataBaseUtility dLib=new DataBaseUtility();
		   ExcelUtility eLib=new ExcelUtility();
		   FileUtility fLib=new FileUtility();
		   JavaUtility jLib=new JavaUtility();
		   WebDriverUtility wLib=new WebDriverUtility();
		   
		   //Property file
		   String BROWSER = fLib.getPropertyKeyValue("browser");
		   String ADMINURL = fLib.getPropertyKeyValue("adminUrl");
	       String ADMINUSERNAME = fLib.getPropertyKeyValue("adminUsername");
	       String ADMINPASSWORD = fLib.getPropertyKeyValue("adminPassword");
	       
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
	     		
	     		driver.get(ADMINURL);
	     		wLib.maximizeTheBrowser(driver);
	     		wLib.implicitWait(driver, 10);
	     		
	     		AdminLoginPage alp=new AdminLoginPage(driver);
	     		alp.login(ADMINUSERNAME, ADMINPASSWORD);
	     		
	     		DashboardAdminPage dap=new DashboardAdminPage(driver);
	     		dap.clickOnorderManagement();
	     		dap.clickOnPendingOrder();
	     		
	     		PendingOrdersPage pop=new PendingOrdersPage(driver);
	     		pop.clickOnUpdateOrderIcon();
	     		
	     		wLib.switchToBasedOnTitle(driver, "Update Compliant");
	     		
	     		String sts = eLib.readDataFromExcelSheet("UpdateOrderAdmin", 1, 4);
	     		
	     		UpdateOrderPage uop=new UpdateOrderPage(driver);
	     		uop.updateOrder(driver, eLib.getMultipleDataFromExcel("UpdateOrderAdmin", 0, 1, jLib), sts);
	     		
	     		wLib.acceptAlertPopup(driver, "Order updated ");
	     		
	     		

	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		
	     		

	}

}
