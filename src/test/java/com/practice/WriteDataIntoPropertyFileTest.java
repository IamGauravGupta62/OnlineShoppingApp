package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		//Write data into property file
		Properties p=new Properties();
		p.setProperty("browser", "chrome");
		p.setProperty("url","http://rmgtestingserver/domain/Online_Shopping_Application/" );
		p.setProperty("username", "admin");
		p.setProperty("password", "Test@123");
		
		FileOutputStream fo=new FileOutputStream(".\\src\\test\\resources\\writeData.properties");
		p.store(fo, "write data");
		fo.close();
		
		//for reading the data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\writeData.properties");
		p.load(fis);
		System.out.println(p.getProperty("browser"));

	}

}
