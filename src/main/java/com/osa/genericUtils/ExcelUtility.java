package com.osa.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * This is used to deal with excel sheet
 * @author Gaurav
 */
public class ExcelUtility {
	/**
	 * This method is used fetch data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row=sheet.getRow(rowNo);
		Cell cell=row.getCell(cellNo);
		String data=cell.toString();
		return data;
		
	}
	
	/**
	 * This method is used to write data inside excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeDataIntoExcelSheet(String sheetName, int rowNo, int cellNo, String value) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fout=new FileOutputStream(IPathconstants.excelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * This method will fetch count row created in excel
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook wb=WorkbookFactory.create(new FileInputStream(IPathconstants.excelPath));
		Sheet sheet = wb.getSheet(sheetName);
		int row=sheet.getLastRowNum();
		return row;
		
	}
	
	/**
	 * This method will get multiple data into excel sheet.
	 * @param driver
	 * @param sheetName
	 * @param keyColumn
	 * @param valueColumn
	 * @param jLib
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String , String> getMultipleDataFromExcel( String sheetName, int keyColumn, int valueColumn, JavaUtility jLib) throws Throwable
	{
		//Fetching data from excel
		FileInputStream fi=new FileInputStream(IPathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String , String> map=new HashMap<String, String>();// empty map
		
		for(int i=1; i<=count; i++)
		{
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
		
	}
	
	/**
	 * This method will fetch set of  data from excel for dataProvider
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getMultipleSetOfData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathconstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(0).getLastCellNum();
		
		Object [][] obj=new Object[lastRow+1][lastCell];
		
		for(int i=0; i<=lastRow;i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
		
	}
	
	

}
























