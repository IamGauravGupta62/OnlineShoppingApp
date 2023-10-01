package assignment1sep;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJet {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.spicejet.com/search?from=BLR&to=DEL&tripType=2&departure=2023-09-16&adult=1&child=0&srCitizen=0&infant=0&return=2023-10-10&currency=INR&redirectTo=/");
	    
	    String allPrice="(//div[text()='Select your'])[1]/../../../../child::div[last()-1]/div[1]/following-sibling::div[*]/div/div[2]/div/div/div/div/child::div[2]";
	    
	 List<WebElement> prices = driver.findElements(By.xpath(allPrice));
	 for (WebElement webElement : prices) {
		 System.out.println(webElement.getText());
		
	}
	}

}
