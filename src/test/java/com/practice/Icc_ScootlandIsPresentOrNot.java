package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc_ScootlandIsPresentOrNot {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teamName = driver.findElements(By.xpath("//span[text()='India']/../../../tr[*]/td[2]/span[2][text()!='Pakistan']"));
	    for (WebElement element : teamName) {
	    	System.out.println(element.getText());;
		}
	
	}

}
