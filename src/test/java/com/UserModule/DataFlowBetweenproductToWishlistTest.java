package com.UserModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataFlowBetweenproductToWishlistTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("email")).sendKeys("anuj.lpu1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//a[text()=' Electronics']")).click();
		driver.findElement(By.xpath("//a[contains(text(),' Television')]")).click();
		driver.findElement(By.xpath("//a[@href='category.php?pid=226&&action=wishlist']")).click();
		
		String wishlistmsg = driver.findElement(By.xpath("//th[.='my wishlist']")).getText();
		System.err.println(wishlistmsg +"<<.....>>");
		
		if(wishlistmsg.contains("MY WISHLIST"))
		{
			System.out.println("product is added to my wishlist page.");
		}
		else
			System.out.println("product is not added to my wishlist page.");

	}

}
