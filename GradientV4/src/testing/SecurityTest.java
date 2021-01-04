package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.Security;

class SecurityTest 
{

	@Test
	void test()
	{
		assertEquals("Default",     Security.obfuscate("", "Default"));
	  assertEquals("********...",         Security.obfuscate("Just Tuck and Roll", "Default"));
	  assertEquals("***",                  Security.obfuscate("345", "Default"));
	  assertEquals("Default",                  Security.obfuscate(null, "Default"));
		
		
	}

}
