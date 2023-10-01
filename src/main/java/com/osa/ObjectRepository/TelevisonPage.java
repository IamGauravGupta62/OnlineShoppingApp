package com.osa.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelevisonPage {
	
	@FindBy (xpath = "//a[@href='category.php?pid=226&&action=wishlist']")
	private WebElement heartIcon;
	

}
