package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;


public class JDBCEnterNameTest {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
		 
		 Statement state=con.createStatement();
		 String query = "select * from tyss2;";
		 ResultSet result = state.executeQuery(query);
		 
		 int count=0;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the name");
		 String name = sc.nextLine();
		 while(result.next())
		 {
			 if(result.getString(2).contains(name))
			 {
				 count++;
			 }
	     }
		 if(count==0)
		 {
			 String query1 = "insert into tyss2 values(102,'"+name+"')";
			 int res = state.executeUpdate(query1);
			 System.out.println(""+name+" is  inserted");
		 }
		 else
			 System.out.println(""+name+" is not inserted");
	}

}
