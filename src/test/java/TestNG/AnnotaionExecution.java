 package TestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotaionExecution {
	@Test(invocationCount = 3)
	public void zdemo()
	{
		System.out.println("---Execute the script1---");
	}
	
	
	@BeforeSuite
	public void configDB()
	{
		System.out.println("--- connect with data base--");
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("--- lauch the browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("--Open the broswer--");
		
	}
	
	@Test
	public void excecute()
	{
		System.out.println("---Execute the script2---");
		
	}
	@AfterMethod
	public void configAF()
	{
		System.out.println("---logout from applicaton---");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("---close the prowser----");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("-----close the database connection---");
	}

}
