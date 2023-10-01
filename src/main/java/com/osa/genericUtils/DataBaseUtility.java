package com.osa.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This  class contains methods of JDBC 
 * @author Gaurav
 */
public class DataBaseUtility {

	Connection con=null;
	
	/**
	 * This method is used to connect to Database.
	 */
	public void connectToDB() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathconstants.dbURL, IPathconstants.dbUsername, IPathconstants.dbPassword);
		}
	/**
	 * This method will execute the query.
	 * @param query
	 * @param columnNo
	 * @param ExpData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, int columnNo, String ExpData) throws SQLException
	{
		ResultSet result=con.createStatement().executeQuery(query);
		Boolean flag=false;
		while(result.next())
		{
			String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("-- Data is verified");
			return ExpData;
		}
		else
		{
			System.out.println("-- Data is not verified");
			return "";
		}
	}
	
	/**
	 * This method is used close Database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
		}

}
