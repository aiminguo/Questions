package main;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

public class String2LongTest {
	String2Long s2i = new String2Long();
	
	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	//Valid test cases
	public void testStringToLong() {
		assertEquals(0, s2i.stringToLong("00")); //zero
		assertEquals(500, s2i.stringToLong("500")); //no sign number string
		assertEquals(500, s2i.stringToLong("+500")); //+ sign number string
		assertEquals(-500, s2i.stringToLong("-500")); //- sign number string
		//huge integer
		assertEquals(Integer.MAX_VALUE, s2i.stringToLong(Integer.toString(Integer.MAX_VALUE)));
		//small integer
		assertEquals(Integer.MIN_VALUE, s2i.stringToLong(Integer.toString(Integer.MIN_VALUE)));
		//huge long
		assertEquals(Long.MAX_VALUE, s2i.stringToLong(Long.toString(Long.MAX_VALUE)));
		//small long
		assertEquals(Long.MIN_VALUE, s2i.stringToLong(Long.toString(Long.MIN_VALUE)));		
	}

	@Test
	//IllegalArgument cases
	public void testStringToIntIllegalArgument() {
		
		exception.expect(IllegalArgumentException.class);
		s2i.stringToLong(""); //empty string
		s2i.stringToLong(null); //null string
	}
	
	@Test
	//NumberFormatException cases
	public void testStringToIntNumberFormatException() {
		exception.expect(NumberFormatException.class);
		
		s2i.stringToLong("e21");
		s2i.stringToLong("1.666");
		s2i.stringToLong("9zzaww");
		
		s2i.stringToLong("  ");
		assertEquals(500, s2i.stringToLong(" 500"));
		
		s2i.stringToLong(Long.toString(Long.MAX_VALUE) + "11");
		s2i.stringToLong(Long.toString(Long.MIN_VALUE) + "11");
	}	
}
