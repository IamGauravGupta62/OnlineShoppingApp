package com.osa.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of methods to fetch common data from property file
 * @author Gaurav
 */
public class FileUtility {
	
	/**
	 * This method is used to fetch common data present inside the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fileInputStearm=new FileInputStream(IPathconstants.propertyPath);
		Properties prop=new Properties();
		prop.load(fileInputStearm);
		return prop.getProperty(key);
		
	}
	
	
	

}
