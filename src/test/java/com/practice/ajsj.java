package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ajsj {
	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/category.php");
	    System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
	
	    driver.findElement(By.xpath("ss")).sendKeys(Keys.CONTROL+"AV");
	    }

}
