package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		String monthOfYear="July 2024";
		int date=20;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");

		Actions a=new Actions(driver);
		a.doubleClick().perform();
		Thread.sleep(3000);
		a.moveByOffset(0,	500).click().perform();
		
//		a.scrollByAmount(0, 500).click().perform();
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String actual = "//div[text()='"+monthOfYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		for(;;) {
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
								
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}
		}
        
		
	}

}
