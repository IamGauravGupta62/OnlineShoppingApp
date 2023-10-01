package com.osa.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class consists java related methods
 * @author Gaurav
 */
public class JavaUtility {
	
	/**
	 * This method is used to get the random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int randNum = ran.nextInt(1000);
		return randNum;
	}
	
	/**
	 * This method will fetch system date in IST format
	 */
	public String getSystemDate()
	{
		Date date=new Date();
		return date.toString();
	}
	
	/**
	 * This method is used to fetch system date in required format 
	 * @return
	 */
	public String getSystemDateInFOrmat()
	{
		Date dateTime=new Date();
		
		String[] d = dateTime.toString().split(" ");
		
		String day = d[0];
		String month = d[1];
		Object date = d[2];
		String year = d[5];
		
		String finalFormat = day+" "+month+" "+date+" "+year;
		return finalFormat;
		
	}

}
