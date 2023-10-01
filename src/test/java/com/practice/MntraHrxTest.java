package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MntraHrxTest {

	public static void main(String[] args) {


		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/hrx?rawQuery=hrx");
		
		List<WebElement> prices = driver.findElements(By.xpath("//h3[text()='HRX by Hrithik Roshan']/following-sibling::div/descendant::span[@class='product-discountedPrice']"));
		
		int count=0;
		for(WebElement ele:prices) {
			System.out.println(ele.getText());
			count++;
		}
		System.out.println(count);
		
	}

}
