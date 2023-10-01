package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void softAssert()
	{
		String expected="Online site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 String actual = driver.getTitle();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual, expected);
		System.out.println("--app launched--");
		System.out.println("--execution ends--");
		sa.assertAll(); 
	}
}
