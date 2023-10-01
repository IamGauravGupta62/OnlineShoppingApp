package com.AdminModule;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.DashboardAdminPage;
import com.osa.ObjectRepository.PendingOrdersPage;
import com.osa.ObjectRepository.UpdateOrderPage;
import com.osa.genericUtils.BaseClass;
import com.osa.genericUtils.DataBaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class ManageOrderByAdmin_TestNG extends BaseClass {
	
	@Test(groups = "regression")
	public void manageOrder() throws Throwable, Throwable, Throwable 
	{
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
	     		wLib.switchToBasedOnTitle(driver, "Pending Orders");
	}

}
