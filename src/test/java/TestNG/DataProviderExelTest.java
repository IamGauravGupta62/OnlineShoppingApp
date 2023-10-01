package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.osa.genericUtils.ExcelUtility;

public class DataProviderExelTest {
	
	@Test(dataProvider = "dataFromExcel")
	public void dataProviderExcel(String pName, String price, String size)
	{
		System.out.println(pName+"-->"+price+"-->"+size);
	}
	
	
	
	
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.getMultipleSetOfData("DataProvider");
		return value;
		
	} 
	
	
//	
//	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
//	public void practice(String name, String price, String size)
//	{
//	
//		System.out.println(name+"-->"+price+"--->"+size);
//	}

}
