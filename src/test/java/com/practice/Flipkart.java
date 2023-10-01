package com.practice;

import java.security.Key;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
	public static void main(String[] args) { 
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone 14 pro");
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		//driver.findElement(By.className("_34RNph")).click();
		String iphone="//div[contains(text(),'APPLE iPhone 14 Pro')]/ancestor::div[@class='_3pLy-c row']/child::div[last()]/div/div/div[number(translate(text(),'₹,,',' '))>50000]";
	    List<WebElement> price = driver.findElements(By.xpath(iphone));
	    
	    for (WebElement webElement : price) {
	    	
			System.out.println(webElement.getText());
		}
	
	
	}

}
