package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFIleTest {

	public static void main(String[] args) throws Throwable {
    
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\CommonData.properties.txt");
		
		Properties p=new Properties();
		p.load(fi);
		String data = p.getProperty("Browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		System.out.println(data);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);	
	}

}
