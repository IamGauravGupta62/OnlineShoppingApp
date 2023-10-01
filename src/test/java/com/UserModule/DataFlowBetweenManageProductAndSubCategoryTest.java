package com.UserModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataFlowBetweenManageProductAndSubCategoryTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin");
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		

	}

}
