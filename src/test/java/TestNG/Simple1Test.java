package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.osa.genericUtils.BaseClass;

public class Simple1Test extends BaseClass {
	

	@Test
	public void simple1()
	{ 
		System.out.println("--simple 1--");
	}

}
