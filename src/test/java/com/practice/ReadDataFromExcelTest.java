package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable  {

		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Organisation");
		int count = sh.getLastRowNum();
		int lastCell = sh.getRow(1).getLastCellNum();
		/*for(int i=1; i<=count; i++) {
		String data = sh.getRow(i).getCell(0).getStringCellValue();
		System.out.println(data);*/
		
		for(int i=1; i<=count; i++)//row
		{
			for(int j=0;j<lastCell; j++)//cell
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+"  ");
			}
			System.out.println();
		
		
		}
		
	}

}
