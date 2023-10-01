package com.AdminModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class InsertProductByAdminCredTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		//Fetch the data from common data property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties.txt"); 
		Properties p=new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String ADMINURL = p.getProperty("adminUrl");
		String ADMINUSERNAME = p.getProperty("adminUsername");
		String ADMINPASSWORD = p.getProperty("adminPassword");
		
		//Fetch the data from excel sheet
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Insert Product");
	    int	count=sh.getLastRowNum();
	    String category = sh.getRow(1).getCell(4).getStringCellValue();
	    String subCategory = sh.getRow(1).getCell(5).getStringCellValue();
		String prodAvail = sh.getRow(1).getCell(6).getStringCellValue();
		
		
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
		
		
		driver.manage().window().maximize();
		Select s;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login as Admin 
		driver.get(ADMINURL);
		//Enter valid username and password
		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUSERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("submit")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		
		WebElement cate = driver.findElement(By.name("category"));
		WebElement subcCate=driver.findElement(By.id("subcategory"));
		
		s=new Select(cate);
		s.selectByVisibleText(category);
		
		s=new Select(subcCate);
		s.selectByVisibleText(subCategory);
		
		//Enter the values in the text feilds
		HashMap<String , String> map=new HashMap<String, String>();// Empty map
		
		//storing the key-vlaue pair into empty map
		for(int i=1; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		//Entering the values in the fields 
		for(Entry<String, String> s1:map.entrySet())
		{
		
			driver.findElement(By.name(s1.getKey())).sendKeys(s1.getValue());
			
		}
		Thread.sleep(5000);
//		driver.findElement(By.name("productCompany")).sendKeys("Westside Product");
//		driver.findElement(By.name("productpricebd")).sendKeys("2000");
//		driver.findElement(By.name("productprice")).sendKeys("1500 ");
//		driver.findElement(By.name("productDescription")).sendKeys("colourful dress Product");
//		driver.findElement(By.name("productShippingcharge")).sendKeys("200");
		
		WebElement prodAvailable = driver.findElement(By.id("productAvailability"));
		
		s=new Select(prodAvailable);
		s.selectByVisibleText(prodAvail);
		
//		File f=new File("C:\\Users\\user\\Desktop\\kidsimgpng.png");
//		String absPath = f.getAbsolutePath();
//		driver.findElement(By.name("productimage1")).sendKeys(absPath);
//		driver.findElement(By.name("productimage2")).sendKeys(absPath);
//		driver.findElement(By.name("productimage3")).sendKeys(absPath);
		
		driver.findElement(By.name("submit")).click();
		

		String confirmMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        
		
		if(confirmMsg.contains("Well done! Product"))
        {
        	System.out.println("Product is successfully inserted");
        	
        }
        else
        	System.out.println("Product is not successfully inserted");
	
	}

}
