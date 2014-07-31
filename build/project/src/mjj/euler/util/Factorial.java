package mjj.euler.util;

import java.math.BigInteger;

public class Factorial {
	
	private int seed;
	private BigInteger result;
	
	
	public Factorial(int seed) {
		this.seed = seed;
		result = BigInteger.ONE;		
		
	}

	public Factorial() {
		result = BigInteger.ONE;		
		
	}
	
	public int getInteger() {
		if (seed <= 0) return -1;
		
		for (int i=1;i<=seed;i++) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		
		return result.intValue();
	}

	public long getLong() {
		if (seed <= 0) return -1;
		
		for (int i=1;i<=seed;i++) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		
		return result.longValue();
	}

	public long getLong(int seed) {
		if (seed <= 0) return -1;
		
		for (int i=1;i<=seed;i++) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		
		return result.longValue();
	}
	
}
