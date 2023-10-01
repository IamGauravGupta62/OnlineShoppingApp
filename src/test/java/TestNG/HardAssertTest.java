package TestNG;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void hardAssert()
	{
		System.out.println("--test1--");
		System.out.println("--test2--");
	     
		Assert.assertEquals("A", "B", "B is expected result.");
		//Assert.assertEquals("A","B", "B is expected result.");
		
		
		System.out.println("--test3--");
		System.out.println("--test4--");
		
	}

}
