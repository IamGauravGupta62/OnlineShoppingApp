package com.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.CategoryAdminPage;
import com.osa.ObjectRepository.CategoryInfoPage;
import com.osa.ObjectRepository.DashboardAdminPage;
import com.osa.genericUtils.BaseClass;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class CreateCategoryByAdminTestNG extends BaseClass {
	
	@Test (groups = "smoke")      
	public void createCategory() throws Throwable
	{
	     
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
