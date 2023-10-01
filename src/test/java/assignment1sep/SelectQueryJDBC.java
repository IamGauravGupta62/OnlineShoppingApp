package assignment1sep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryJDBC {

	public static void main(String[] args) throws SQLException {
     Driver driver=new Driver();
     Connection con;
     DriverManager.registerDriver(driver);
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema","root","root");
     Statement state = con.createStatement();
     String query="Select * from CHARACTER_SETS;";
     


	}

}
