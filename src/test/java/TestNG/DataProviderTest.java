package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.osa.genericUtils.IPathconstants;

public class DataProviderTest {
	
	@Test(dataProvider = "tv")
	public void getdata(String prodName, int price, String colour)
	{
		System.out.println(prodName+"--->"+price+"---->"+colour);
	}
	
	
	@DataProvider
	public Object[][] mobiles()
	{
      	Object[][] obj = new Object[2][3];
      	obj[0][0]="Redmi";
      	obj[0][1]=5000;
      
      	
      	obj[1][0]="Vivo";
      	obj[1][1]=10000;
      	
      	
      	
      	return obj;
	}
	
	@DataProvider
	public Object[] [] tv()
	{
		Object[][] obj = new Object[2][3];
      	obj[0][0]="Sumsung";
      	obj[0][1]=5000;
      	obj[0][2]= "White";
      	
      	obj[1][0]="LG";
      	obj[1][1]=10000;
      	obj[0][2]= "black";
      	return obj;
	}
	
	@DataProvider 
	public Object[][] dataFromExcel() throws Throwable
	{
		 FileInputStream fis = new FileInputStream(IPathconstants.excelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("DataProvider");
		 int lastRow = sh.getLastRowNum();
		 int lastCell = sh.getRow(0).getLastCellNum(); 
		 
		 Object[][] obj = new Object[lastRow+1][lastCell];
		 
		 for(int i=0; i<=lastRow; i++)
		 {
			 for(int j=0; j<lastCell; j++)
			 {
				 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			 }
		 }
		return obj;
		 
	}	
		

	
}




















