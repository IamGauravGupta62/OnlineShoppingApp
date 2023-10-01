package com.AdminModule;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ManageOrderByAdmin {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Select s;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[@class='collapsed']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Pending Orders')]")).click();
		driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tbody/tr/td[1][text()='1']/../td[last()]/a")).click();
		
		//switching to new window
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String titleOfWindow = driver.switchTo().window(win).getTitle();
			if(titleOfWindow.contains("Update Compliant"))
			{
				break;
			}
		}
		
		//enter the details in new window
		WebElement status = driver.findElement(By.name("status"));
		s=new Select(status);
		s.selectByVisibleText("Delivered");
		driver.findElement(By.name("remark")).sendKeys("delivered the pending product ");
		
		// click on the submit button
		driver.findElement(By.name("submit2")).click();
		
		
		//click on 'ok' button in popup
		driver.switchTo().alert().accept();
	
		
		

	}

}
