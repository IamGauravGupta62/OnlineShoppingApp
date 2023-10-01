package com.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.DashboardAdminPage;
import com.osa.ObjectRepository.InsertProductInfoPage;
import com.osa.ObjectRepository.InsertProductPage;
import com.osa.genericUtils.DataBaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class InsertProductByAdmin_POM {

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

     		
     		wLib.maximizeTheBrowser(driver);
     		wLib.implicitWait(driver, 10);
     		
     		driver.get(ADMINURL);
     		AdminLoginPage alp=new AdminLoginPage(driver);
     		alp.login(ADMINUSERNAME, ADMINPASSWORD);
     		
     		DashboardAdminPage das=new DashboardAdminPage(driver);
     		das.clickOnIstProduct();
     		
     		//Read data from excel
     		String cate = eLib.readDataFromExcelSheet("Insert Product", 1, 4);
     		String subCate = eLib.readDataFromExcelSheet("Insert Product", 1, 5);
     		String prodAvail = eLib.readDataFromExcelSheet("Insert Product", 1, 6);
     		
     		
     		InsertProductPage ipp=new InsertProductPage(driver);
     		ipp.inserProduct(driver, eLib.getMultipleDataFromExcel("Insert Product", 0, 1, jLib), cate, subCate, prodAvail);
     		Thread.sleep(10000);
     		ipp.clickOnInsertBtn();	
     		
     		InsertProductInfoPage ipi=new InsertProductInfoPage(driver);
     		ipi.confirmInsertProdMsg();
     
     		//wLib.selectDropDownByVisibleText(null, prodAvail);
     		//wLib.selectDropDownByVisibleText(ipp.getProdAvailDD(), prodAvail);
     		
     		
     		
     		
     		
	   
	   

		
	}

}
