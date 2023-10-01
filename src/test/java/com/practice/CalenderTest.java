package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderTest {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='28']")).click();
	}

}
