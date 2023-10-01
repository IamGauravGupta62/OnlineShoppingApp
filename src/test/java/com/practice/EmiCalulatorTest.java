package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmiCalulatorTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		while(true)
		{
			try {
                driver.findElement(By.id("emibarchart")).click();
				//driver.findElement(By.xpath("//label[.='Schedule showing EMI payments starting from']")).click();
				break;
			} catch (Exception e) {
				js.executeScript("window.scrollBy(0, 500)");
				
			}
		}
		
		

	}

}
