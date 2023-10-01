package TestNG;

import org.testng.annotations.Test;

public class PracticeTest {
	
	@Test (invocationCount = 0)
	public void createTest()
	{
		System.out.println("---data created---");
	}
	@Test (dependsOnMethods ="createTest" )
	public void editTest()
	{
		System.out.println("---data is edited---");
	}
	
	@org.testng.annotations.Test
	public void deleteTest()
	{
		System.out.println("---data is deleted---");
	}
	

}
