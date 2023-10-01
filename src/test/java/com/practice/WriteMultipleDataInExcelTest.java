package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataInExcelTest {

	public static void main(String[] args) throws Throwable  {
     
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Giri.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet("Giri");
		sheet.createRow(12).createCell(0).setCellValue("Qspiders");
		sheet.getRow(12).createCell(1).setCellValue("Bengalore");
		sheet.getRow(12).createCell(2).setCellValue("Karanataka");
		
		
		FileOutputStream fo=new FileOutputStream(".\\src\\test\\resources\\Giri.xlsx");
		wb.write(fo);
		wb.close();
	}

}
