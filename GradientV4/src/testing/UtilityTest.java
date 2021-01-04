package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.Utility;

class UtilityTest 
{

	@Test
	void test() 
	{
		int x = -1;
		int y = -2;
		
		int x2 = -3;
		
		Utility heyUtility = new Utility();
		
		heyUtility.calculate(x, y);
		
		heyUtility.calculate(x2, y);
		
		
	}

}
