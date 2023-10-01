package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JioMartMayurTest {

	public static void main(String[] args) throws Throwable {

    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.jiomart.com/");
    
    Thread.sleep(3000);
    String link = driver.findElement(By.cssSelector("a:hover")).getText();
   // System.out.println(link);
    
    List<WebElement> text = driver.findElements(By.xpath("//a[text()='"+link+"']/following-sibling:: div/ul/li[*]"));
     for(WebElement a:text)
     {
    	 String data=a.getText();
    	 System.out.println(data);
     }
 
    
	}

}
