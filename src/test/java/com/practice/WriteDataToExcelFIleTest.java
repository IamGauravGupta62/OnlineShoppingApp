package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelFIleTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
    
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet("Organisation");
		sheet.createRow(10).createCell(0).setCellValue("Moment");
		
		FileOutputStream fo=new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wb.write(fo);
		wb.close();
		
	    
		
		
	}

}
