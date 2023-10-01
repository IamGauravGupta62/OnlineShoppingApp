package TestNG;

import org.testng.annotations.Test;

public class DataProviderExcel2 {
	@Test(dataProviderClass = DataProviderExelTest.class,dataProvider = "dataFromExcel")
	public void dPExcel(String pName, String price, String size)
	{
		System.out.println(pName+"--->"+price+"--->"+size);
		
	}

}
