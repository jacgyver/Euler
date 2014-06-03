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

	public List<Integer> divisors(int n) {
		List<Integer> divisors = new ArrayList<Integer>();
		int quotient = 0;
		int remainder = 0;
		for (int i=1;i*i<=n;i++)	{
			quotient = n/i; 
			remainder = n%i;
			if ( remainder == 0) { 
				divisors.add(i);
				divisors.add(quotient);
			}
		}
		Collections.sort(divisors);
			
		return divisors;
	}

}
