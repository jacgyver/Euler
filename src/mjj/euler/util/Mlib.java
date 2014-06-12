/*
 * 	MLib Class
 * 	Library for Euler Project
 * 
 */
package mjj.euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mlib {

	// each digits sum
	public int digitsSum(String digits) {
		int result = 0;
		
		for (int i=0;i<digits.length();i++) {
			result = result + digits.charAt(i) - 48;
		}
		
		return result;
	}	

	public long digitsPowerSum(String digits,int power) {
		long result = 0;
		
		for (int i=0;i<digits.length();i++) {
			result = result + (long)Math.pow((digits.charAt(i) - 48),power);
			
		}
		
		return result;
	}	

	// each digits sum
	public int charsSum(String chars) {
		int result = 0;
		
		for (int i=0;i<chars.length();i++) {
			result = result + chars.charAt(i) - 64;
		}
		
		return result;
	}	
	
	// check for prime
	public boolean isPrime(long n){
		if (n   == 2)	return true;  // n = 2
		if (n%2 == 0)	return false; // n > 2
		
		for(int i=3;i*i<=n;i=i+2) {
			if (n%i == 0) return false; 
		}
		return true;
		
		
	}

	public boolean isPrime(int n) {
		if (n   == 2)	return true;  // n = 2
		if (n%2 == 0)	return false; // n > 2
		
		for(int i=3;i*i<=n;i=i+2) {
			if (n%i == 0) return false; 
		}
		return true;
	}

	public BigInteger cobination(int possibilities,int subsets) {
		BigInteger result = BigInteger.ZERO;
		int diff = possibilities - subsets;
		
		result =
				factorial(new BigInteger(Integer.toString(possibilities))).divide( 
				factorial(new BigInteger(Integer.toString(subsets))).multiply(
				factorial(new BigInteger(Integer.toString(diff)))));

		return result;
	}
	
	public BigInteger factorial(BigInteger n) {
	
		if (n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
		
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}


/*
 * 	str length is not exceed 10
 */
	/**
	 * @param str
	 * @return
	 */
	public boolean pandigital (String str) {
		final String PANDIGITAL_PATTERN  = "^(?!.*(.).*\\1)[1-9]{9}";

		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile(PANDIGITAL_PATTERN);
		matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
	public List<Integer> getDivisors(int n) {
		int quotient = 0;
		int remainder = 0;
		List<Integer> divisors = new ArrayList<Integer>();

		for (int i=1;i*i<=n;i++)	{
			quotient  = n/i; 
			remainder = n%i;
			if ( remainder == 0 ) { 
				divisors.add(i);
				if (!divisors.contains(quotient)) divisors.add(quotient);
			}
		}
		Collections.sort(divisors);
			
		return divisors;
	}	
/*
 *  Get abundent number	
 */
	public boolean getAbundent (int number) {
		int sum = 0;
		List<Integer> divisorsList = new ArrayList<Integer>();
		
		divisorsList = getDivisors(number);

		for (int i=0;i<divisorsList.size()-1;i++) {	//divisorsList.size()-1 : except itself
			sum += divisorsList.get(i);
		}
		if (number < sum) 	return true; 
		
		return false;
	}	
	
	
	
}
