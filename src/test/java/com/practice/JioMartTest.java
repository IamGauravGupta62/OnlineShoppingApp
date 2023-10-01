package com.practice;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class JioMartTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jiomart.com/");
		WebElement src = driver.findElement(By.xpath("//a[text()='Groceries']"));
		WebElement dest = driver.findElement(By.xpath("//a[text()='Fruits & Vegetables']"));
		Actions a=new Actions(driver);
		a.moveToElement(src).perform();
		a.moveToElement(dest).perform();
        
		List<WebElement> options = driver.findElements(By.xpath("//a[@id='nav_level3_229']/../../child::li[text()]"));
		for (WebElement ele : options) {
			System.out.println(ele.getText());
			
		}
		

	}

}
