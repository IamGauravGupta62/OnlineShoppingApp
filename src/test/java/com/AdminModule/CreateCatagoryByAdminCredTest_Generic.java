package com.AdminModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JavaUtility;
import com.osa.genericUtils.WebDriverUtility;

public class CreateCatagoryByAdminCredTest_Generic {

	public static void main(String[] args) throws Throwable, IOException {
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
     
     
	    //Fetching the data from Excel file
	    FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Create category_Admin");
	    int count = sh.getLastRowNum();
	    
		
		
		
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
		
		//Enter valid credentials
		driver.get(ADMINURL);
		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();
		
		//Click on create category
		driver.findElement(By.xpath("//a[contains(.,'Create Category')]")).click();
		
		//eLib.getMultipleDataFromExcel(driver, "Create category_Admin", 0,1, jLib);

//		HashMap<String, String> map=new HashMap<String, String>();//Empty HasMap
//		
//		//Adding the key-value pair in HasMap
//		for(int i=1; i<=count; i++)
//		{
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);	
//		}
//		
//		//Execute the script by taking data form excel
//		for(Entry<String, String> a:map.entrySet())
//		{
//			driver.findElement(By.name(a.getKey())).sendKeys(a.getValue());
//		}
		
		
		//Enter the details in the text field
//		driver.findElement(By.name("category")).sendKeys("Healthfy  ");
//		driver.findElement(By.name("description")).sendKeys("health and nutrition");
        
		//click on create button
		driver.findElement(By.name("submit")).click();
		
		
		String CateMsg = driver.findElement(By.xpath("//strong[contains(.,'Well done!')]")).getText();
		System.err.print(CateMsg);
		if(CateMsg.contains("Well done")) 
		{
			System.out.println("category is created");
		}
		else 
		{
			System.out.println("category is not created");
		}
	}

}
