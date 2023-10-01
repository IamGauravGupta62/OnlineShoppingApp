package com.osa.genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.osa.ObjectRepository.AdminLoginPage;
import com.osa.ObjectRepository.DashboardAdminPage;

public class BaseClass {
	
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
    public  WebDriver driver;
    
    public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configDB() throws Throwable
	{
	
		dLib.connectToDB();
		System.out.println("--Connect to DB--");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		System.out.println("--Launch the browser--");
		
		sdriver=driver;
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String URL = fLib.getPropertyKeyValue("adminUrl");
		String ADMINUSERNAME = fLib.getPropertyKeyValue("adminUsername");
		String ADMINPASSWORD = fLib.getPropertyKeyValue("adminPassword");
		
		driver.get(URL);
		
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.login(ADMINUSERNAME, ADMINPASSWORD);
		System.out.println("--login to app--");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		DashboardAdminPage dap=new DashboardAdminPage(driver);
		dap.logout(driver);
		System.out.println("--logout from app--");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("--close the browser--");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dLib.closeDB();
		System.out.println("--close the database connection--");
	}
	

}

















