package main;

public class String2Long {

	public long stringToLong(String s) {
		if (null == s) {
			throw new IllegalArgumentException("Null string.");
		}
		
		int len = s.length();
		boolean isNagtive = false;
	
		if(0 == len) {
			throw new IllegalArgumentException("Empty string.");
		}
		
		//Get the first character and check the sign
		if(s.charAt(0) == '-')
		{
			s = s.substring(1);
			isNagtive = true;
		}
		else if(s.charAt(0) == '+')
		{
			s = s.substring(1);
		}

		//try to convert the rest of string to long
		
		//define result as long to make sure it won't overflow
		long result = 0;
		for (int i = 0; i < s.length(); i++)
		{
			int value = s.charAt(i) - '0';				
			//check the invalid character
			if(value < 0 || value > 9)
				throw new NumberFormatException("Invalid string.");
			result *= 10;

			//check the Overflow case
			if(result > Long.MAX_VALUE)
				throw new NumberFormatException("Number Overflow."); 
			result += value;   

			}			
		
		//covert the result to long based on sign
		return (isNagtive ? -1 : 1) * (long) result;
	}
}
