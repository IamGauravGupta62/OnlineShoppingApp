package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryJDBC {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		//Step 1.
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema","root","root");
		Statement state = con.createStatement();
		String query = "Select * from CHARACTER_SETS;";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+"+===+"+result.getString(2));
		}
		con.close();
	}

}
