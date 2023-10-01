package com.osa.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.osa.genericUtils.WebDriverUtility;

public class InsertProductPage extends WebDriverUtility{

//declaration
	@FindBy(name = "category")
	private WebElement CategoryDD;
	
	@FindBy(id = "subcategory")
	private WebElement SubcategoryDD;
	
	@FindBy(name = "productName")
    private WebElement ProdNameTbx;
	
	@FindBy(name ="productCompany")
	private WebElement ProdCompTbx;
	
	@FindBy(name = "productpricebd")
	private WebElement ProdPriceTbx;
	
	@FindBy(name = "productprice")
	private WebElement prodPriceAfterTbx;
	
	@FindBy(name = "productDescription")
	private WebElement ProdDescTbx;
	
	@FindBy(name = "productShippingcharge")
	private WebElement ProdShipChargeTbx;
	
	@FindBy(name = "productAvailability")
	private WebElement prodAvailDD;
	
	@FindBy(name = "productimage1")
	private WebElement ProdImg1;
	
	@FindBy(name = "productimage2")
	private WebElement ProdImg2;
	
	@FindBy(name = "productimage3")
	private WebElement ProdImg3;
	
	@FindBy(xpath = "//button[text()='Insert']")
	private WebElement InsertBtn;
	
	//initialization
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	
//Utilization
	public WebElement getCategoryDD() {
		return CategoryDD;
	}

	public WebElement getSubcategoryDD() {
		return SubcategoryDD;
	}

	public WebElement getProdNameTbx() {
		return ProdNameTbx;
	}

	public WebElement getProdCompTbx() {
		return ProdCompTbx;
	}

	public WebElement getProdPriceTbx() {
		return ProdPriceTbx;
	}

	public WebElement getProdPriceAfterTbx() {
		return prodPriceAfterTbx;
	}

	public WebElement getProdDescTbx() {
		return ProdDescTbx;
	}

	public WebElement getProdShipChargeTbx() {
		return ProdShipChargeTbx;
	}

	public WebElement getProdAvailDD() {
		return prodAvailDD;
	}

	public WebElement getProdImg1() {
		return ProdImg1;
	}

	public WebElement getProdImg2() {
		return ProdImg2;
	}

	public WebElement getProdImg3() {
		return ProdImg3;
	}

	public WebElement getInsertBtn() {
		return InsertBtn;
	}
	
	//business library
		public void inserProduct(WebDriver driver, HashMap<String, String> map, String cate, String subCate, String prodAval)
		{
			for(Entry<String, String> set:map.entrySet())
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			
			
			selectDropDownByVisibleText(CategoryDD, cate);
			selectDropDownByVisibleText(SubcategoryDD, subCate);
			selectDropDownByVisibleText(prodAvailDD, prodAval);
		}
		
		
		public void clickOnInsertBtn()
		{
			InsertBtn.click();
		}
		
	
	
	
	

}
