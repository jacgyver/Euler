package mjj.euler.problems;

import java.util.ArrayList;
import java.util.List;
import mjj.euler.util.Mlib;

public class Problem023 {

	final int LIMIT = 28123;
	private long pBegin, pEnd;
	private long solution = 0L;
	private Mlib mlib = new Mlib();
	private List<Integer> abundantNumber = new ArrayList<Integer>();

	public void getAbundent() {
		int sum = 0;
		List<Integer> divisorsList = new ArrayList<Integer>();

		for (int i = 1; i <= LIMIT; i++) {
			sum = 0;
			divisorsList = mlib.getDivisors(i);

			for (int j = 0; j < divisorsList.size() - 1; j++) { // divisorsList.size()-1 : except itself
				sum += divisorsList.get(j);
			}
			if (i < sum)	abundantNumber.add(i);
		}	

	}

	public Problem023() {
		pBegin = System.currentTimeMillis();

		List<Integer> divisors = new ArrayList<Integer>();
		List<Integer> tempNumber = new ArrayList<Integer>();

		Object[] abundantArray; // = new int[100000];

		int divisorsSum = 0;
		int index = 0;
		int temp = 0;
		int sum = 0;
		int count = 0;

		
		getAbundent(); 
		
		for (int i = 0; i <= LIMIT; i++) {
			tempNumber.add(i);
		}
//		abundantArray = new Object[abundantNumber.size()];
//		abundantArray = abundantNumber.toArray();
//
		for (int j = 0; j < abundantNumber.size(); j++) {
			int add1 = abundantNumber.get(j);
			for (int k = 0; k < abundantNumber.size(); k++) {
				temp = add1 + abundantNumber.get(k);
				if (temp > LIMIT)	break;

				//System.out.println(j + ":" + k + ":" + " temp is " + temp);
				// index = tempNumber.indexOf(temp);
				// if (index != -1)
				tempNumber.remove((Integer) temp); // remove abundantNumber
				//
				// //abundantArray[count++] = temp;

			}
		}
//
		System.out.println(" tempNumber.size( is " + tempNumber.size());
		for (int x = 0; x < tempNumber.size(); x++) {
			sum = sum + tempNumber.get(x);
			// System.out.println(sum + ":" + x + " = " + tempNumber.get(x));
		}
		solution = sum;

		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem023 is " + solution
				+ " -- " + (pEnd - pBegin) + " ms");

	}

	public long getSolution() {
		return solution;
	}

}
