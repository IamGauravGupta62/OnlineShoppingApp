package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest2 {

	@Test
	public void hardAssrt()
	{
		System.out.println("--test1--");
		System.out.println("--test2--");
		assertEquals("A", "B");
		System.out.println("--test3--");
		System.out.println("--test4--");


	}
}
