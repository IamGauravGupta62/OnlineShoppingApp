package com.AdminModule;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.DashboardAdminPage;
import com.osa.ObjectRepository.InsertProductInfoPage;
import com.osa.ObjectRepository.InsertProductPage;
import com.osa.genericUtils.BaseClass;
import com.osa.genericUtils.DataBaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;


@Listeners(com.osa.genericUtils.ListenerImpClass.class)
public class InsertProductByAdmin_TestNg extends BaseClass {
	
	@Test
	public void insertProduct() throws EncryptedDocumentException, FileNotFoundException, IOException, Throwable
	{
		
		
	     		DashboardAdminPage das=new DashboardAdminPage(driver);
	     		das.clickOnIstProduct();
	     		 
	     		//Read data from excel
	     		String cate = eLib.readDataFromExcelSheet("Insert Product", 1, 4);
	     		String subCate = eLib.readDataFromExcelSheet("Insert Product", 1, 5);
	     		String prodAvail = eLib.readDataFromExcelSheet("Insert Product", 1, 6);
	     		
	     		
	     		InsertProductPage ipp=new InsertProductPage(driver);
	     		ipp.inserProduct(driver, eLib.getMultipleDataFromExcel("Insert Product", 0, 1, jLib), cate, subCate, prodAvail);
	     		Thread.sleep(3000);
	     		Assert.fail();
	     		ipp.clickOnInsertBtn();
	     		
	     		
	     		String actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	     		
	     		
	     		
	     		InsertProductInfoPage ipi=new InsertProductInfoPage(driver);
	     		ipi.confirmInsertProdMsg();
	     
	     		//wLib.selectDropDownByVisibleText(null, prodAvail);
	     		//wLib.selectDropDownByVisibleText(ipp.getProdAvailDD(), prodAvail);
	}

}
