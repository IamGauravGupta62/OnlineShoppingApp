package com.AdminModule;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.CategoryAdminPage;
import com.osa.ObjectRepository.CategoryInfoPage;
import com.osa.ObjectRepository.DashboardAdminPage;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class CreateCategoryPOM {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=null;
	    
	 	 //Create object for all utility classes
	     WebDriverUtility wLib=new WebDriverUtility();
	     JavaUtility jLib=new JavaUtility();
	     FileUtility fLib=new FileUtility();
	     ExcelUtility eLib=new ExcelUtility();
	     
	     //Fetching the data from property file
	     String BROWSER = fLib.getPropertyKeyValue("browser");
	     String ADMINURL = fLib.getPropertyKeyValue("adminUrl");
	     String ADMINUSERNAME = fLib.getPropertyKeyValue("adminUsername");
	     String ADMINPASSWORD = fLib.getPropertyKeyValue("adminPassword");
	     
//		    //Fetching the data from Excel file
//		    FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//		    Workbook wb = WorkbookFactory.create(fi);
//			Sheet sh = wb.getSheet("Createcategory_Admin");
//		    int count = sh.getLastRowNum();
		   
			//Open browser
		    if(BROWSER.equalsIgnoreCase("chrome"))
		    {
		    driver=new ChromeDriver();
		    }
		    else if(BROWSER.equalsIgnoreCase("Firefox"))
		    {
		    	driver=new FirefoxDriver();
		    }
		    else
		    	System.out.println("driver invalid");
		    
		   wLib.maximizeTheBrowser(driver);
		   wLib.implicitWait(driver, 10);

		   //login as Admin
		   driver.get(ADMINURL);
		   
		   AdminLoginPage lg=new AdminLoginPage(driver);
		   lg.login(ADMINUSERNAME, ADMINPASSWORD);
		   
		   DashboardAdminPage dap=new DashboardAdminPage(driver);
		   dap.clickOnCtCategory();
		   
		   CategoryAdminPage ca=new CategoryAdminPage(driver);
		   ca.createCategory(eLib.getMultipleDataFromExcel("Createcategory_Admin", 2, 3, jLib), driver);
		   Thread.sleep(5000);
		   ca.clickonCreateBtn();
		   
		   CategoryInfoPage cip=new CategoryInfoPage(driver);
		   cip.verifyMsg();
	}

}




















