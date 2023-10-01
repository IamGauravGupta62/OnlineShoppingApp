package com.UserModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("email")).sendKeys("anuj.lpu1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		// search a product
		driver.findElement(By.name("product")).sendKeys("Micromax Canvas Mega 4G");
        driver.findElement(By.name("search")).submit();
        
        driver.findElement(By.xpath("//a[.='Micromax Canvas Mega 4G']")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart inner-right-vs']")).click();
        
        String msg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        
        //confirm the message
        if(msg.contains("Product has been added to the cart"))
        {
        	System.out.println("the product is added to cart." );
        	
        }
        else
        	System.out.println("The product is not added to cart." );
           
	}

}
