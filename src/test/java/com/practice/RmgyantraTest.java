package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RmgyantraTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://rmgtestingserver:8084/");
    driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
    driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
    driver.findElement(By.xpath("//button[text()='Sign in']")).click();
    driver.findElement(By.xpath("//a[text()='Projects']")).click();
    driver.findElement(By.xpath("//span[text()='Create Project']")).click();
    driver.findElement(By.name("projectName")).sendKeys("OSA_Gaurav");
    driver.findElement(By.name("createdBy")).sendKeys("GAurav Modanwal");
   // driver.findElement(By.xpath("//select[@name='status']")).click();
    WebElement projectStatus = driver.findElement(By.xpath("//select[@name='status']"));
    Select s=new Select(projectStatus);
    s.selectByVisibleText("Created");
	  
		
	}

}
