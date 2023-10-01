package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboTest {

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 String monthOfYear = "December 2023";
		 int date=15;
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.goibibo.com/");
		 driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		 driver.findElement(By.xpath("//span[text()='Departure']")).click();
		 
		 
String actual = "//div[text()='"+monthOfYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		
		 driver.findElement(By.xpath("//span[text()='Done']"));
		 
		 for (;;) {
			 try {
				 driver.findElement(By.xpath(actual)).click();
				 break;
				
			} 
			 catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	

			}			
		}
		 driver.findElement(By.xpath("//span[text()='Done']")).click();
	}

}
