package mjj.euler.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import mjj.euler.util.Mlib;

public class Problem024 {
	long solution = 0L;
	private long pBegin, pEnd;
	private Mlib mlib = new Mlib();
	private TreeSet<String> treeSet  = new TreeSet<String>();

	public Problem024() {
		int count = 0;
		String digits = "";
		
		pBegin = System.currentTimeMillis();

		String[] numeric0 = {"0","1","2","3","4","5","6","7","8","9"};
		String[] numeric1 = {"1","2","3","4","5","6","7","8","9","0"};
		String[] numeric2 = {"2","3","4","5","6","7","8","9","0","1"};
		String[] numeric3 = {"3","4","5","6","7","8","9","0","1","2"};
		String[] numeric4 = {"4","5","6","7","8","9","0","1","2","3"};
		String[] numeric5 = {"5","6","7","8","9","0","1","2","3","4"};
		String[] numeric6 = {"6","7","8","9","0","1","2","3","4","5"};
		String[] numeric7 = {"7","8","9","0","1","2","3","4","5","6"};
		String[] numeric8 = {"8","9","0","1","2","3","4","5","6","7"};
		String[] numeric9 = {"9","0","1","2","3","4","5","6","7","8"};

//		String[] numeric0 = { "0", "1", "2" };
//		String[] numeric1 = { "0", "1", "2" };
//		String[] numeric2 = { "0", "1", "2" };
//
//
//		for (int num0 = 0; num0 < 3; num0++)
//			permutations.add(Integer.toString(num0));

		loop:for (int p00=0;p00<=9;p00++)
		for (int p01=0;p01<=9-p00;p01++)
		for (int p02=0;p02<=9-p00;p02++)
		for (int p03=0;p03<=9-p00;p03++)
		for (int p04=0;p04<=9-p00;p04++)
		for (int p05=0;p05<=9-p00;p05++)
		for (int p06=0;p06<=9-p00;p06++)
		for (int p07=0;p07<=9-p00;p07++)
		for (int p08=0;p08<=9-p00;p08++)
		for (int p09=0;p09<=9-p00;p09++) {
			digits = numeric0[p00] + numeric1[p01] + numeric2[p02] + numeric3[p03] + numeric4[p04] + 
					 numeric5[p05] + numeric6[p06] + numeric7[p07] + numeric8[p08] + numeric9[p09] ;

			if (mlib.pandigitalIncludeZero(digits)) {
				count++;
				treeSet.add(digits);
				//System.out.println(count + " : true digits is " + digits);
				
				if (count == 1000000) {
					solution = Long.parseLong(treeSet.last());
					break loop; 
				}
			}
			 

		}

//		if (count == 10 ) break loop; 
		System.out.println("This factorial of problem024 is " + treeSet.size());
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem024 is " + solution
				+ " -- " + (pEnd - pBegin) + " ms");

	}

	public long getSolution() {
		return solution;
	}

}
