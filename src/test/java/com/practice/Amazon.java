package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Amazon {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14");
		driver.findElement(By.id("nav-search-submit-button")).click();
				
		//driver.get("https://www.amazon.in/s?k=iphone+14&crid=2EW2RBNSU2OYV&sprefix=iphone%2Caps%2C291&ref=nb_sb_ss_inft-rank-pairwise-in-t1_2_6");
	//	String xpath2="(//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/child::div[@class='sg-row']/descendant::span[@class='a-price']/child::span[number(translate(text(),'₹,' ,''))>6000] )[1]";
		//String xpath = "//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/child::div[@class='sg-row']/descendant::span[@class='a-price']/child::span[number(translate(text(),'₹,',''))>70000]";
		String price = "//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/child::div[@class='sg-row']/descendant::span[@class='a-price']/child::span[number(translate(text(),'₹,,',' '))>70000]";
		List<WebElement> td = driver.findElements(By.xpath(price));
		for (WebElement web : td) {
			String text = web.getText();
			System.out.println( text);
		}
		//String xpath="//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/child::div[@class='sg-row']/descendant::span[@class='a-price']/child::span[number(translate(text(),'₹,' ,''))>6000]";
//		List<WebElement> iphone = driver.findElements(By.xpath(xpath));
//		
//		for(WebElement ds:iphone)
//		{
//			System.out.println("JAI HO");
//         	String data = ds.getText();
//			System.out.println(ds);
//		}
		
	}

}
