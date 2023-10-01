package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BisTest {
	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
				
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		ArrayList<String> al = new ArrayList<String>();
		
		for (int i = 0; i < links.size(); i++) {
			String eachLink = links.get(i).getAttribute("href");
			
			URL url=null;
			int statusCode=0;
			
			try {
				url=new URL(eachLink);
				
				HttpsURLConnection httpCon=(HttpsURLConnection)url.openConnection();
				statusCode=httpCon.getResponseCode();
				
				if(statusCode>=400) {
					al.add(eachLink+"======>>"+statusCode);
					System.out.println(eachLink+"======>>"+statusCode);
				}
			} 
			catch (Exception e) {
				al.add(eachLink);
			}
			
		}
	}

}
