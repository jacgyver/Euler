import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import mjj.euler.util.Factorial;
import mjj.euler.util.Mlib;

public class Problem {

private final int 	PROBLEM002_LIMIT 	= 4000000;	
private final String PROBLEM003_FACTOR 	= "600851475143"; 
private final String PROBLEM008_FACTOR 	= 	"73167176531330624919225119674426574742355349194934" +
											"96983520312774506326239578318016984801869478851843" +
											"85861560789112949495459501737958331952853208805511" +
											"12540698747158523863050715693290963295227443043557" +
											"66896648950445244523161731856403098711121722383113" +
											"62229893423380308135336276614282806444486645238749" +
											"30358907296290491560440772390713810515859307960866" +
											"70172427121883998797908792274921901699720888093776" +
											"65727333001053367881220235421809751254540594752243" +
											"52584907711670556013604839586446706324415722155397" +
											"53697817977846174064955149290862569321978468622482" +
											"83972241375657056057490261407972968652414535100474" +
											"82166370484403199890008895243450658541227588666881" +
											"16427171479924442928230863465674813919123162824586" +
											"17866458359124566529476545682848912883142607690042" +
											"24219022671055626321111109370544217506941658960408" +
											"07198403850962455444362981230987879927244284909188" +
											"84580156166097919133875499200524063689912560717606" +
											"05886116467109405077541002256983155200055935729725" +
											"71636269561882670428252483600823257530420752963450" ;

private final String[] PROBLEM013_SOURCE = {
	  "37107287533902102798797998220837590246510135740250"
	, "46376937677490009712648124896970078050417018260538"
	, "74324986199524741059474233309513058123726617309629"
	, "91942213363574161572522430563301811072406154908250"
	, "23067588207539346171171980310421047513778063246676"
	, "89261670696623633820136378418383684178734361726757"
	, "28112879812849979408065481931592621691275889832738"
	, "44274228917432520321923589422876796487670272189318"
	, "47451445736001306439091167216856844588711603153276"
	, "70386486105843025439939619828917593665686757934951"
	, "62176457141856560629502157223196586755079324193331"
	, "64906352462741904929101432445813822663347944758178"
	, "92575867718337217661963751590579239728245598838407"
	, "58203565325359399008402633568948830189458628227828"
	, "80181199384826282014278194139940567587151170094390"
	, "35398664372827112653829987240784473053190104293586"
	, "86515506006295864861532075273371959191420517255829"
	, "71693888707715466499115593487603532921714970056938"
	, "54370070576826684624621495650076471787294438377604"
	, "53282654108756828443191190634694037855217779295145"
	, "36123272525000296071075082563815656710885258350721"
	, "45876576172410976447339110607218265236877223636045"
	, "17423706905851860660448207621209813287860733969412"
	, "81142660418086830619328460811191061556940512689692"
	, "51934325451728388641918047049293215058642563049483"
	, "62467221648435076201727918039944693004732956340691"
	, "15732444386908125794514089057706229429197107928209"
	, "55037687525678773091862540744969844508330393682126"
	, "18336384825330154686196124348767681297534375946515"
	, "80386287592878490201521685554828717201219257766954"
	, "78182833757993103614740356856449095527097864797581"
	, "16726320100436897842553539920931837441497806860984"
	, "48403098129077791799088218795327364475675590848030"
	, "87086987551392711854517078544161852424320693150332"
	, "59959406895756536782107074926966537676326235447210"
	, "69793950679652694742597709739166693763042633987085"
	, "41052684708299085211399427365734116182760315001271"
	, "65378607361501080857009149939512557028198746004375"
	, "35829035317434717326932123578154982629742552737307"
	, "94953759765105305946966067683156574377167401875275"
	, "88902802571733229619176668713819931811048770190271"
	, "25267680276078003013678680992525463401061632866526"
	, "36270218540497705585629946580636237993140746255962"
	, "24074486908231174977792365466257246923322810917141"
	, "91430288197103288597806669760892938638285025333403"
	, "34413065578016127815921815005561868836468420090470"
	, "23053081172816430487623791969842487255036638784583"
	, "11487696932154902810424020138335124462181441773470"
	, "63783299490636259666498587618221225225512486764533"
	, "67720186971698544312419572409913959008952310058822"
	, "95548255300263520781532296796249481641953868218774"
	, "76085327132285723110424803456124867697064507995236"
	, "37774242535411291684276865538926205024910326572967"
	, "23701913275725675285653248258265463092207058596522"
	, "29798860272258331913126375147341994889534765745501"
	, "18495701454879288984856827726077713721403798879715"
	, "38298203783031473527721580348144513491373226651381"
	, "34829543829199918180278916522431027392251122869539"
	, "40957953066405232632538044100059654939159879593635"
	, "29746152185502371307642255121183693803580388584903"
	, "41698116222072977186158236678424689157993532961922"
	, "62467957194401269043877107275048102390895523597457"
	, "23189706772547915061505504953922979530901129967519"
	, "86188088225875314529584099251203829009407770775672"
	, "11306739708304724483816533873502340845647058077308"
	, "82959174767140363198008187129011875491310547126581"
	, "97623331044818386269515456334926366572897563400500"
	, "42846280183517070527831839425882145521227251250327"
	, "55121603546981200581762165212827652751691296897789"
	, "32238195734329339946437501907836945765883352399886"
	, "75506164965184775180738168837861091527357929701337"
	, "62177842752192623401942399639168044983993173312731"
	, "32924185707147349566916674687634660915035914677504"
	, "99518671430235219628894890102423325116913619626622"
	, "73267460800591547471830798392868535206946944540724"
	, "76841822524674417161514036427982273348055556214818"
	, "97142617910342598647204516893989422179826088076852"
	, "87783646182799346313767754307809363333018982642090"
	, "10848802521674670883215120185883543223812876952786"
	, "71329612474782464538636993009049310363619763878039"
	, "62184073572399794223406235393808339651327408011116"
	, "66627891981488087797941876876144230030984490851411"
	, "60661826293682836764744779239180335110989069790714"
	, "85786944089552990653640447425576083659976645795096"
	, "66024396409905389607120198219976047599490197230297"
	, "64913982680032973156037120041377903785566085089252"
	, "16730939319872750275468906903707539413042652315011"
	, "94809377245048795150954100921645863754710598436791"
	, "78639167021187492431995700641917969777599028300699"
	, "15368713711936614952811305876380278410754449733078"
	, "40789923115535562561142322423255033685442488917353"
	, "44889911501440648020369068063960672322193204149535"
	, "41503128880339536053299340368006977710650566631954"
	, "81234880673210146739058568557934581403627822703280"
	, "82616570773948327592232845941706525094512325230608"
	, "22918802058777319719839450180888072429661980811197"
	, "77158542502016545090413245809786882778948721859617"
	, "72107838435069186155435662884062257473692284509516"
	, "20849603980134001723930671666823555245252804609722"
	, "53503534226472524250874054075591789781264330331690"};

private final int 	PROBLEM020_INIT 	= 100;
private final int[] FACTORIAL 			= {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
//private final int[][] 	PROBLEM018_INIT = {
//		{75},
//		{95,64},
//		{17,47,82},
//		{18,35,87,10},
//		{20,04,82,47,65},
//		{19,01,23,75,03,34},
//		{88,02,77,73,07,63,67},
//		{99,65,04,28,06,16,70,92},
//		{41,41,26,56,83,40,80,70,33},
//		{41,48,72,33,47,32,37,16,94,29},
//		{53,71,44,65,25,43,91,52,97,51,14},
//		{70,11,33,28,77,73,17,78,39,68,17,57},
//		{91,71,52,38,17,14,91,43,58,50,27,29,48},
//		{63,66,04,68,89,53,67,30,73,16,69,87,40,31},
//		{04,62,98,27,23,09,70,98,73,93,38,53,60,04,23}};
private final String[][] 	PROBLEM011_INIT 	= {
			{"08","02","22","97","38","15","00","40","00","75","04","05","07","78","52","12","50","77","91","08"},
			{"49","49","99","40","17","81","18","57","60","87","17","40","98","43","69","48","04","56","62","00"},
			{"81","49","31","73","55","79","14","29","93","71","40","67","53","88","30","03","49","13","36","65"},
			{"52","70","95","23","04","60","11","42","69","24","68","56","01","32","56","71","37","02","36","91"},
			{"22","31","16","71","51","67","63","89","41","92","36","54","22","40","40","28","66","33","13","80"},
			{"24","47","32","60","99","03","45","02","44","75","33","53","78","36","84","20","35","17","12","50"},
			{"32","98","81","28","64","23","67","10","26","38","40","67","59","54","70","66","18","38","64","70"},
			{"67","26","20","68","02","62","12","20","95","63","94","39","63","08","40","91","66","49","94","21"},
			{"24","55","58","05","66","73","99","26","97","17","78","78","96","83","14","88","34","89","63","72"},
			{"21","36","23","09","75","00","76","44","20","45","35","14","00","61","33","97","34","31","33","95"},
			{"78","17","53","28","22","75","31","67","15","94","03","80","04","62","16","14","09","53","56","92"},
			{"16","39","05","42","96","35","31","47","55","58","88","24","00","17","54","24","36","29","85","57"},
			{"86","56","00","48","35","71","89","07","05","44","44","37","44","60","21","58","51","54","17","58"},
			{"19","80","81","68","05","94","47","69","28","73","92","13","86","52","17","77","04","89","55","40"},
			{"04","52","08","83","97","35","99","16","07","97","57","32","16","26","26","79","33","27","98","66"},
			{"88","36","68","87","57","62","20","72","03","46","33","67","46","55","12","32","63","93","53","69"},
			{"04","42","16","73","38","25","39","11","24","94","72","18","08","46","29","32","40","62","76","36"},
			{"20","69","36","41","72","30","23","88","34","62","99","69","82","67","59","85","74","04","36","16"},
			{"20","73","35","29","78","31","90","01","74","31","49","71","48","86","81","16","23","57","05","54"},
			{"01","70","54","71","83","51","54","69","16","92","33","48","61","43","52","01","89","19","67","48"}};


private long pBegin,pEnd;
private Mlib mlib;

	// 2014-05-22
	long problem001() {
		long solution = 0L;
		pBegin = System.currentTimeMillis();
		
		for (int i=0;i<1000;i++) {
			if (i%3==0 || i%5==0 ) {
				solution = solution + i;
			}
		}
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem001 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}	

	// 2014-05-22
	long problem002() {
		int i = 0;
		int check = 0;
		long solution = 0L;
		int[] fibo = new int[PROBLEM002_LIMIT];
		
		fibo[0] = 1;
		fibo[1] = 2;		

		solution = fibo[1];
		while (check < PROBLEM002_LIMIT) {
			fibo[i+2] = fibo[i+1] + fibo[i];
			check = fibo[i+2];
			
			if (check%2 == 0) {
				solution = solution + check;
			}
			i = i + 1;		
		}

		System.out.println("This soluntion of problem002 is " + solution);
		return solution;
	}

	long problem003() {	
		long solution = 0L;
		BigInteger source 		= new BigInteger(PROBLEM003_FACTOR);
		BigInteger denominator 	= BigInteger.ONE;
		BigInteger quotient 	= BigInteger.ONE;
		BigInteger remainder 	= BigInteger.ONE;
		int i=0;

		// denominator is started from TWO
		denominator = denominator.add(BigInteger.ONE);
		while (quotient.add(remainder).compareTo(BigInteger.ONE) != 0) { 

			
			// source is divided by denominator
			quotient 	= source.divideAndRemainder(denominator)[0];
			remainder 	= source.divideAndRemainder(denominator)[1];
		
			if (remainder.compareTo(BigInteger.ZERO) == 0) {
				source = quotient;
				denominator = denominator;				
			}
			else 
				denominator = denominator.add(BigInteger.ONE);

			if (quotient.compareTo(BigInteger.ONE) == 0 && remainder.compareTo(BigInteger.ZERO) == 0)  
				break;
		
		} 

		solution = denominator.longValue();
		System.out.println("This soluntion of problem003 is " + solution);
		
		return solution;
	}
	
	long problem004() {	
		long solution = 0L;	
		int product = 0;
		int max =0;
		String palindrome = null;
		
		for(int i=999;i>100;i--) {
			for (int j=999;j>100;j--) {
				product = i * j;
				
				if (product > 99999) {
					palindrome = Integer.toString(product);
					
					if ((palindrome.charAt(0) == palindrome.charAt(5)) &&
						(palindrome.charAt(1) == palindrome.charAt(4)) &&	
						(palindrome.charAt(2) == palindrome.charAt(3)) &&
						(max < product)						) {
						max = product;
					}
				}
			}
		}

		solution = max;
		System.out.println("This soluntion of problem004 is " + solution);
		return solution;
	}		
	long problem005() {	
		pBegin = System.currentTimeMillis();		
		long solution = 0L;	
		int smallest = 0;
		int remainder = 0;

		do {
			remainder = 0;
			smallest = smallest + 1;
			for (int i=1;i<=20;i++) {
				remainder = remainder + (smallest % i);   
			}
		
		}	while (remainder!=0);

		solution = smallest;	

		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem005 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}	
	long problem006() {	
		pBegin = System.currentTimeMillis();
		long solution = 0L;	
		long sum = 0L;
		long square = 0L;

		for (int i=1;i<=100;i++) {
			sum = sum + i;
			square = square + (i * i);
		}
		
		solution = sum * sum - square;
		 
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem006 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}		
	long problem007() {	
		pBegin = System.currentTimeMillis();
		long solution = 0L;	
		int seq = 1;
		int n = 3;
		
		mlib = new Mlib();
		int prime = 0;
		
		while (seq < 10001)  {
			if (mlib.isPrime(n)) {
				seq = seq + 1;
				prime = n;
			}
			
			n = n + 1;
		}
		
		solution = prime;
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem007 is " + solution + " -- " + (pEnd-pBegin) + " ms");
			
		return solution;
	}	
	long problem008() {	
		pBegin = System.currentTimeMillis();
		
		int adjacent = 13;
		long solution = 0L;	
		double productSum = 0;
		double tempSum = 1;
		String maxDigits = null;
		String tempDigits = null;
		
		
		for (int i=0;i<PROBLEM008_FACTOR.length()-adjacent+1;i++) {
			
			tempDigits = PROBLEM008_FACTOR.substring(i,i+adjacent);
			//System.out.println("tempDigits is " + tempDigits);
			
			for (int j=0;j<adjacent;j++) {
				tempSum = tempSum * Integer.parseInt(tempDigits.substring(j,j+1));
			//	System.out.println("tempDigits.substring(j,j+1) is " + (j+1) + " " + tempDigits.substring(j,j+1));
			}
			if (productSum < tempSum){
				productSum = tempSum;
				maxDigits = tempDigits;
			}
			
			tempSum = 1;
			
		}
	
		solution = Math.round(productSum);
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem008 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}		
	long problem009() {
		pBegin = System.currentTimeMillis();
		long solution = 0L;	
		int a = 1, b = 1, c = 1;

		for (a = 1; a < 1000; a++) {
			for (b = 1; b < 1000; b++) {
				for (c = 1; c < 1000; c++) {

					if ((a < b) && (b < c) && (a + b + c == 1000)
							&& (a * a + b * b == c * c)) {
						System.out.println("This soluntion of problem009 is " + a*b*c + " -- " + (pEnd-pBegin) + " ms");
						return  a*b*c;
					}
				}
			}
		}
	

		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem009 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}	

	long problem010() {	
		long solution = 0L;	
		long sum = 0;
		int LIMIT = 2000000;
		
		pBegin = System.currentTimeMillis();
		mlib = new Mlib();
		
		for (int i=2;i<=LIMIT;i++) {
			if (mlib.isPrime(i)) {
				sum = sum + i;
//				System.out.println(i + " This sum of problem010 is " + sum);
			}
		}
		
		solution = sum;
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem010 is " + solution + " -- " + (pEnd-pBegin) + " ms");

		return solution;
	}		
	long problem011() {	
		long solution = 0L;

		int GRID = 20;
		int readLength = 4;
		int hsum = 1;
		int vsum = 1;
		int dsum = 1;
		int rsum = 1;
		int max = 0;
	
		pBegin = System.currentTimeMillis();
	
		for(int i=0;i<GRID-readLength;i++) {
			for(int j=0;j<GRID-readLength;j++) {
				for (int k=0;k<readLength;k++) {

					hsum = hsum * Integer.parseInt(PROBLEM011_INIT[i  ][j+k  ]);
					vsum = vsum * Integer.parseInt(PROBLEM011_INIT[i+k][j    ]);
					dsum = dsum * Integer.parseInt(PROBLEM011_INIT[i+k][j+k  ]);
					rsum = rsum * Integer.parseInt(PROBLEM011_INIT[i+k][j+4-k]);
				
				}
				if (max < hsum) max = hsum;
				if (max < vsum) max = vsum;
				if (max < dsum) max = dsum;
				if (max < rsum) max = rsum;
				
//				System.out.println(y + " " + x + " This sum of problem011 is " + max );
				hsum = 1;
				vsum = 1;
				dsum = 1;
				rsum = 1;
			}
		}
		solution = max;
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem011 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}	
	long problem012() {	
		pBegin = System.currentTimeMillis();

		long solution = 0L;	
		int sum = 0;
		int divisors = 0;
		int trianguleNum = 0;
		do {
			sum = 0;
			divisors = 1;
			trianguleNum = trianguleNum + 1;
			for (int i=1;i<=trianguleNum;i++)
				sum = sum + i;
			
			for (int j=2;j*j<=sum;j++) {
				if (sum%j==0) divisors+=2;
			}
		} while (divisors < 500);
		
		solution = sum;
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem012 is " + solution + " -- " + (pEnd-pBegin) + " ms");

		return solution;
	}
	
	long problem013() {	
		pBegin = System.currentTimeMillis();
		
		long solution = 0L;	
		BigInteger sum = BigInteger.ZERO;

		for (int i = 0; i < PROBLEM013_SOURCE.length; i++) {
			BigInteger a = new BigInteger(PROBLEM013_SOURCE[i]);
			sum = a.add(sum);
		}
		
		solution = Long.parseLong(sum.toString().substring(0,10));
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem013 is " + solution + " -- " + (pEnd-pBegin) + " ms");

		return solution;
	}	
	long problem014() {	
		pBegin = System.currentTimeMillis();
		int LIMIT = 1000000;
		int option = 0;
		int max = 0;
		int terms = 0;
		long finish = 0;
		long solution = 0L;	
		
		for (int i=2;i<LIMIT;i++) {
			 		
			finish = i;
			terms = 1;
//			System.out.println(i + " " + terms + " This finish of problem014 is " + finish );

			do {
				if (finish%2==0) 
					finish = finish / 2;
				else 
					finish = finish*3 + 1;
				
				//if (finish > LIMIT) option++;
				//if (option > 1) break;
				terms ++;

			} while (finish>1);
			if (max < terms) { 
				max = terms;
				solution = i;
				//System.out.println(terms + " This i of problem014 is " + i );
			}
		}
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem014 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		return solution;
		
	}		
	long problem015() {	
		pBegin = System.currentTimeMillis();
		int n = 20, k = 20 ;
		long solution = 0L;	
		solution = mlib.cobination(n+k,n).longValue();
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem015 is " + solution + " -- " + (pEnd-pBegin) + " ms");

		return solution;
	}	
	long problem016() {
		pBegin = System.currentTimeMillis();
		long solution = 0L;	
		double sigma = 0;
		int sum = 0;
		String temp = null;
		
		sigma = Math.pow(2, 1000);
		
		temp = String.format("%.0f",new BigDecimal(sigma));
                                      


		for(int i=0;i<temp.length();i++) {
			sum = sum + Integer.parseInt(temp.substring(i,i+1));
		}

		solution = sum;
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem016 is " + solution + " -- " + (pEnd-pBegin) + " ms");

		return solution;
	}		
	long problem017() {	
		pBegin = System.currentTimeMillis();
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		int digit = 0;
		int sum = 0;
		int one = 0;
		int ten = 0;
		int hundred = 0;
		
		long solution = 0L;	
		
		hm.put(0,  0);
		hm.put(1,  3);
		hm.put(2,  3);
		hm.put(3,  5);
		hm.put(4,  4);
		hm.put(5,  4);
		hm.put(6,  3);
		hm.put(7,  5);
		hm.put(8,  5);
		hm.put(9,  4);
		hm.put(10, 3);
		hm.put(11, 6);
		hm.put(12, 6);
		hm.put(13, 8);
		hm.put(14, 8);
		hm.put(15, 7);
		hm.put(16, 7);
		hm.put(17, 9);
		hm.put(18, 8);
		hm.put(19, 8);
		hm.put(20, 6);
		hm.put(30, 6);
		hm.put(40, 5);
		hm.put(50, 5);
		hm.put(60, 5);
		hm.put(70, 7);
		hm.put(80, 6);
		hm.put(90, 6);
		hm.put(100,10);
		hm.put(200,10);
		hm.put(300,12);
		hm.put(400,11);
		hm.put(500,11);
		hm.put(600,10);
		hm.put(700,12);
		hm.put(800,12);
		hm.put(900,11);
		hm.put(1000,11);

		for (int i=1;i<=1000;i++) {
			one = i%10;     // 1-digit
			ten = (i/10)%10;
			hundred = i/100;
			digit = Integer.toString(i).length();
			switch (digit) {
				case 1:
					sum = sum + hm.get(i);
					break;
				case 2:
					if ((i>20) && (one > 0))	sum = sum + (hm.get(10*ten) + hm.get(one));
					else
						sum = sum + hm.get(i);
					break;
				case 3:
					if (i%100 ==0) sum = sum + hm.get(i);
					else if ((i%100 > 20) && (one > 0))
								sum = sum + (hm.get(hundred) + hm.get(100) + hm.get(10*ten) + hm.get(one));
						else 
								sum = sum + (hm.get(hundred) + hm.get(100) + hm.get(i%100));
					break;
				default:
					sum = sum + hm.get(1000);
					break;
			}
			//System.out.println(i + " : " + "This sum of problem018 is " + (hundred*hm.get(100)+ten*hm.get(ten*10)+hm.get(one)) + " " + sum);			
		}
		
		solution = sum ;  
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem017 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		return solution;
	}	
	long problem018() {	
		pBegin = System.currentTimeMillis();
		int[][] source = {
				{75, 0 , 0,	 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
				{95, 64, 0,	 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
				{17, 47,82,  0,	 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
				{18, 35,87, 10,  0,	 0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
				{20, 04,82, 47, 65,  0,	 0,  0,  0,  0,  0,  0,  0,  0,  0},
				{19, 01,23, 75, 03, 34,  0,	 0,  0,  0,  0,  0,  0,  0,  0},
				{88, 02,77, 73, 07, 63, 67,  0,	 0,  0,  0,  0,  0,  0,  0},
				{99, 65,04, 28, 06, 16, 70, 92,  0,	 0,  0,  0,  0,  0,  0},
				{41, 41,26, 56, 83, 40, 80, 70, 33,  0,	 0,  0,  0,  0,  0},
				{41, 48,72, 33, 47, 32, 37, 16, 94, 29,  0,	 0,  0,  0,  0},
				{53, 71,44, 65, 25, 43, 91, 52, 97, 51, 14,  0,	 0,  0,  0},
				{70, 11,33, 28, 77, 73, 17, 78, 39, 68, 17, 57,  0,	 0,  0},
				{91, 71,52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,  0 , 0},
				{63, 66,04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31,  0},
				{ 4, 62,98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}};
		
		int comp = 0;
		int temp1=0,temp2=0,temp3=0;;
		long solution = 0L;	
				
		for (int y=13;y>=0;y--) {		
			for (int x=13;x>=0;x--) {
				temp1 = source[x][y];
				temp2 = source[x+1][y];
				temp3 = source[x+1][y+1];

				comp = Math.max((temp1 + temp2), (temp1 + temp3));
				
				source[x][y] = comp;
			}
		}
		
		solution = source[0][0];
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem018 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}		
	long problem019() {	
		pBegin = System.currentTimeMillis();

		int last = 0;
		int count = 0;
		int accumulate = 0;
		long solution = 0L;	
		for (int year=1900;year<=2000;year++) {
			for (int month=1;month<=12;month++) {
				switch (month) {
					case 1:		last = 31; 	break;
					case 2:		if (year%4==0 && year%400==0)	
									last = 29;
								else 
									last = 28;	
											break;
					case 3:		last = 31; 	break;
					case 4:		last = 30; 	break;
					case 5:		last = 31; 	break;
					case 6:		last = 30; 	break;
					case 7:		last = 31; 	break;
					case 8:		last = 31; 	break;
					case 9:		last = 30; 	break;
					case 10:	last = 31; 	break;
					case 11:	last = 30; 	break;
					case 12:	last = 31; 	break;
					default:	break;
				};
				for (int day=1;day<=last;day++) {
					accumulate = accumulate + 1;
					if (day == 1 && accumulate % 7 == 1) {
						count++;
					}
				}
			}
		}
		
		solution = count-2;
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem019 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}
	
	// 2014-05-22	
	long problem020() {
		long solution = 0L;
		BigInteger sum = BigInteger.ONE;

		
		pBegin = System.currentTimeMillis();
		
		
		for (int i = 1; i <= PROBLEM020_INIT; i++) {
			sum = sum.multiply(new BigInteger((String.valueOf(i))));
		}

		solution = new Mlib().digitsSum(sum.toString());
 		//System.out.println("This       sum of problem020 is " + sum);		

		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem020 is " + solution + " -- " + (pEnd-pBegin) + " ms");
 		
		return solution;
	}	
	long problem021() {	
		pBegin = System.currentTimeMillis();
		int divisor1 = 0;
		int divisor2 = 0;
		int sum = 0;
		
		int temp = 0;
		long solution = 0L;	
		
		for (int i=1;i<=10000;i++) {
			for (int j=1;2*j<=i;j++) {
				temp = i%j;
				if (temp==0) divisor1 = divisor1 + j;
			}
			
			for (int k=1;2*k<=divisor1;k++) {
				temp = divisor1%k;
				if (temp==0) divisor2 = divisor2 + k;
			}
			
			if (i == divisor2 && (divisor1 != divisor2)) {
				sum+=i;
			}
			
			divisor1 = 0;
			divisor2 = 0;			
		}
		
		solution = sum;
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem021 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}
	long problem022() {	
		pBegin = System.currentTimeMillis();
		int count = 1;
		int score = 0;
		String currentLine;

		StringTokenizer st;
		long solution = 0L;	
		ArrayList<String> al = new ArrayList<String>();
		Mlib mlib = new Mlib();

		try (BufferedReader br = new BufferedReader(new FileReader("c:\\workspace\\Euler\\names.txt")))
		{		
			while ((currentLine = br.readLine()) != null) {
				//System.out.println(currentLine);
				st = new StringTokenizer(currentLine, ",");
				while (st.hasMoreElements()) {
					al.add(((String) st.nextElement()).replace("\"", ""));
				}
				
				Collections.sort(al);
				
				for(String temp:al) {
					score = count * mlib.charsSum(temp);

					solution =  solution + score;
					//System.out.println(count + " : " + temp + " = " + score + " [" + solution );

					count++;
					score = 0;
				
				}
			}
		}	catch(IOException e) {
				e.printStackTrace();
		}
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem022 is " + solution + " -- " + (pEnd-pBegin) + " ms"  );
		
		return solution;
	}
	
	long problem023() {	
		pBegin = System.currentTimeMillis();
		final int  LIMIT = 28123; 
		List<Integer> li = new ArrayList<Integer>();
		List<Integer> abundant = new ArrayList<Integer>();	
		
		long solution = 0L;
		int sum = 0;
		Mlib mlib = new Mlib();
		
		for (int i=5;i<LIMIT;i++) {
			li = mlib.divisors(i);

			for (int j=0;j<li.size()-1;j++)
				sum = sum + li.get(j);
			
			if (i<sum) abundant.add(i);
			
			sum = 0;
		}
		System.out.println("This list of problem023 is " + abundant);		

		for (int k=LIMIT-1;k>0;k--) {
//			li = mlib.divisors(i);

			for (int j=0;j<li.size()-1;j++)
				sum = sum + li.get(j);
			
//			if (i<sum) abundant.add(i);
			
			sum = 0;
		}

		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem023 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}
	
	long problem024() {	
		pBegin = System.currentTimeMillis();

		long solution = 0L;	
		Mlib mlib = new Mlib();
		
		System.out.println("This factorial of problem024 is " + mlib.factorial(new BigInteger("10")));
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem024 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}

	long problem025() {	
		pBegin = System.currentTimeMillis();
		int PROBLEM025_LIMIT = 1000;
		
		int i = 0;
		int digits = 0;
		long solution = 0L;
		BigInteger fibo1 = BigInteger.ONE;
		BigInteger fibo2 = fibo1.add(BigInteger.ZERO);
		BigInteger fibo3 = fibo2.add(fibo1);

		solution = 3L;
		while (digits < PROBLEM025_LIMIT) {
			fibo1 = fibo2;
			fibo2 = fibo3;
			fibo3 = fibo2.add(fibo1);
			
			digits = fibo3.toString().length();
			solution++;
		}
		
	
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem025 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}


	long problem026() {	long solution = 0L;	return solution;}		
	long problem027() {	long solution = 0L;	return solution;}	
	long problem028() {	
		pBegin = System.currentTimeMillis();
		int sum = 0;
		int x=0,y=0;
		int s=-1;
		long solution = 0L;	
		int[][] al = new int[5][5];
		
		for (int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				sum ++;
				s = s * -1;
				x = 2 + s*i ;
				y = 2 + s*j ;
				//al[x][y] = sum;
				System.out.print("[" + i + "," + j + "]");
			}
			System.out.println();
		}

		for (int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%2d",al[i][j]);
			}
			System.out.println();
		}
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem030 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}		
	long problem029() {	long solution = 0L;	return solution;}	
	long problem030() {	
		pBegin = System.currentTimeMillis();
		long count = 0;
		long sum = 0;
		long solution = 0L;	
		Mlib mlib = new Mlib();
		
		for(int i=1;i<10000;i++) {
			sum = mlib.digitsPowerSum(Integer.toString(i),5);
			if (i==sum) count+=sum;
			
			sum = 0;
		}
		
		solution = count;
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem030 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		return solution;
	}		
	long problem031() {	long solution = 0L;	return solution;}	
	long problem032() {	long solution = 0L;	return solution;}		
	long problem033() {	long solution = 0L;	return solution;}
	
	// 2014-05-23
	long problem034() {
		int sum = 0,count = 0;
		long solution = 0L;
		String strI = null;
		
		pBegin = System.currentTimeMillis();
	
		for (int i = 3; i <= 10000000; i++) {
			strI = Integer.toString(i);

			for (int j=0;j<=strI.length()-1;j++) {
				sum = sum + FACTORIAL[(int)strI.charAt(j)-48];
			}
			
			if (i == sum) {
				count = count + 1;
				solution = solution + sum;
			}
			sum = 0;
		}

		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem034 is " + solution + " -- " + (pEnd-pBegin) + " ms");
 		
		return solution;
	}	
	long problem035() {	long solution = 0L;	return solution;}	
	long problem036() {	long solution = 0L;	return solution;}		
	long problem037() {	long solution = 0L;	return solution;}	
	long problem038() {	long solution = 0L;	return solution;}		
	long problem039() {	long solution = 0L;	return solution;}	
	long problem040() {	long solution = 0L;	return solution;}		
	long problem041() {	long solution = 0L;	return solution;}	
	long problem042() {	long solution = 0L;	return solution;}		
	long problem043() {	long solution = 0L;	return solution;}	
	long problem044() {	long solution = 0L;	return solution;}		
	long problem045() {	long solution = 0L;	return solution;}	
	long problem046() {	long solution = 0L;	return solution;}		
	long problem047() {	long solution = 0L;	return solution;}	
	long problem048() {	
		long solution = 0L;	
		BigInteger sum = BigInteger.ZERO;
		BigInteger temp = BigInteger.ONE;
		BigInteger GrandTotal = BigInteger.ZERO;

		pBegin = System.currentTimeMillis();
		
		for (int i = 1; i <= 1000; i++)
		{
			//System.out.println("temp is :" + temp + " " + "temp.pow(i) is " + temp.pow(i) + " " + "GrandTotal is :" +GrandTotal);
			sum = temp.pow(i);
			temp = temp.add(BigInteger.ONE);
			GrandTotal = GrandTotal.add(sum);

		}
 
		solution = Long.parseLong(GrandTotal.toString().substring(GrandTotal.toString().length()-10));
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem048 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;}		
	long problem049() {	long solution = 0L;	return solution;}	
	long problem050() {	
		long solution = 0L;
		int LIMIT = 1000000;
		int [] primeSet = new int[100000];
		int seq = 0;
		long sum = 0;
		long max = 0;
		
		
		pBegin = System.currentTimeMillis();

		for (int i=2;i<LIMIT;i++) {
			if (mlib.isPrime(i)) {
				primeSet[seq] = i;
				seq = seq + 1;
			}
		}
		System.out.println(" This seq of problem050 is " + seq);
		
		for (int i=seq;i>2;i--) {
			for (int j=0;j<seq-i;j++) {
				for (int k=j;k<j+i;k++) {
					sum = sum + primeSet[k];
					if (sum > LIMIT) {sum = 0; break;} 
				}

				if (max < i) {
					if (mlib.isPrime(sum)) {
						max = i;
						solution = sum;
						System.out.println(i + " This sum of problem050 is "
								+ sum);
						return solution;
					}
				}
				sum = 0;
			}
			//System.out.println(i + " This sum of problem050 is " + sum);
		}
		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem050 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}		
	long problem051() {	long solution = 0L;	return solution;}	
	long problem052() {	long solution = 0L;	return solution;}		

	long problem053() {	
		pBegin = System.currentTimeMillis();
		int count = 0;
		long solution = 0L;	

		Mlib mlib = new Mlib();
		
		for (int i=1;i<=100;i++)
			for (int j=1;j<=i;j++) {
				if (mlib.cobination(i,j).compareTo(new BigInteger("1000000")) == 1) count++;
			}
		
		solution = count;
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem053 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}
	long problem054() {	long solution = 0L;	return solution;}		
	long problem055() {	long solution = 0L;	return solution;}	
	long problem056() {	long solution = 0L;	return solution;}		
	long problem057() {	long solution = 0L;	return solution;}	
	long problem058() {	long solution = 0L;	return solution;}		
	long problem059() {	long solution = 0L;	return solution;}	
	long problem060() {	long solution = 0L;	return solution;}		
	long problem061() {	long solution = 0L;	return solution;}
	// 2014-05-22
	long problem063() {
		pBegin = System.currentTimeMillis();
		
		int n = 0,len =0;
		long solution = 0L;
		BigInteger sum = BigInteger.ZERO;

		for (int y = 1; y < 100; y++) {
			for (int x = 1; x < 10; x++) {
				sum = new BigInteger((String.valueOf(x))).pow(y);
				len = String.valueOf(sum).length();
				if (y == len) n++;
			}
		}

		solution = n;		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem063 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
 		
		return solution;
	}	
	long problem062() {	long solution = 0L;	return solution;}		
	long problem064() {	long solution = 0L;	return solution;}		
	long problem065() {	long solution = 0L;	return solution;}	
	long problem066() {	long solution = 0L;	return solution;}		
	long problem067() {
		pBegin = System.currentTimeMillis();
		int[][] source = new int[100][100];
		List<List<Integer>> al = new ArrayList<List<Integer>>(); 
		String currentLine = null;
		StringTokenizer st;
		int n=0,i=0,j=0;
		long solution = 0L;

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\workspace\\Euler\\triangle.txt")))
		{
				while ((currentLine = br.readLine()) != null) {
					st = new StringTokenizer(currentLine," ");
					while (st.hasMoreElements()) {
						//al.add((int)(st.nextElement()));
						//System.out.println( n++ + "This soluntion of problem063 is " + st.nextElement());
						source[i][j++] = Integer.parseInt(st.nextElement().toString());
					}
					j=0;
					i++;
				}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (i=0;i<100;i++) {
			for(j=0;j<100;j++) {
				System.out.println("This soutce[i][j] of problem063 is " + source[i][j]);
			}
		}
//		solution = n;		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem063 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		return solution;
	}	
	long problem068() {	long solution = 0L;	return solution;}		
	long problem069() {	long solution = 0L;	return solution;}	
	long problem070() {	long solution = 0L;	return solution;}		
	long problem071() {	long solution = 0L;	return solution;}	
	long problem072() {	long solution = 0L;	return solution;}		
	long problem073() {	long solution = 0L;	return solution;}	
	long problem074() {	long solution = 0L;	return solution;}		
	long problem075() {	long solution = 0L;	return solution;}	
	long problem076() {	long solution = 0L;	return solution;}		
	long problem077() {	long solution = 0L;	return solution;}	
	long problem078() {	long solution = 0L;	return solution;}		
	long problem079() {	long solution = 0L;	return solution;}	
	long problem080() {	long solution = 0L;	return solution;}		
	long problem081() {	long solution = 0L;	return solution;}	
	long problem082() {	long solution = 0L;	return solution;}		
	long problem083() {	long solution = 0L;	return solution;}	
	long problem084() {	long solution = 0L;	return solution;}		
	long problem085() {	long solution = 0L;	return solution;}	
	long problem086() {	long solution = 0L;	return solution;}		
	long problem087() {	long solution = 0L;	return solution;}	
	long problem088() {	long solution = 0L;	return solution;}		
	long problem089() {	long solution = 0L;	return solution;}	
	long problem090() {	long solution = 0L;	return solution;}		
	long problem091() {	long solution = 0L;	return solution;}	
	long problem092() {	long solution = 0L;	return solution;}		
	long problem093() {	long solution = 0L;	return solution;}	
	long problem094() {	long solution = 0L;	return solution;}		
	long problem095() {	long solution = 0L;	return solution;}	
	long problem096() {	long solution = 0L;	return solution;}		
	long problem097() {	
		pBegin = System.currentTimeMillis();
		
		long solution = 0L;	
		BigInteger MersennePrime =  BigInteger.ONE;  
		//28433¡¿27830457+1
		
		String mon = "28433";
		MersennePrime = MersennePrime.add(BigInteger.ONE);			// 2
		System.out.println("This MersennePrime of problem097 is " + MersennePrime);

		MersennePrime = MersennePrime.pow(7830457);					// 2^7830457
		System.out.println("This MersennePrime of problem097 is " + MersennePrime);
		MersennePrime = MersennePrime.multiply(new BigInteger(mon));// 28433 * 2^7830457
		System.out.println("This MersennePrime of problem097 is " + MersennePrime);
		MersennePrime = MersennePrime.add(BigInteger.ONE);			// 28433 * 2^7830457 + 1
		System.out.println("This MersennePrime of problem097 is " + MersennePrime);
		
		solution =Long.parseLong(MersennePrime.toString().substring(MersennePrime.toString().length()-10));
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem097 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}	
	long problem098() {	long solution = 0L;	return solution;}		
	long problem099() {	long solution = 0L;	return solution;}	
	long problem100() {	long solution = 0L;	return solution;}		
	long problem101() {	long solution = 0L;	return solution;}	
	long problem102() {	long solution = 0L;	return solution;}		
	long problem103() {	long solution = 0L;	return solution;}	
	long problem104() {	long solution = 0L;	return solution;}		
	long problem105() {	long solution = 0L;	return solution;}	
	long problem106() {	long solution = 0L;	return solution;}		
	long problem107() {	long solution = 0L;	return solution;}	
	long problem108() {	long solution = 0L;	return solution;}		
	long problem109() {	long solution = 0L;	return solution;}	
	long problem110() {	long solution = 0L;	return solution;}		
	long problem111() {	long solution = 0L;	return solution;}	
	long problem112() {	long solution = 0L;	return solution;}		
	long problem113() {	long solution = 0L;	return solution;}	
	long problem114() {	long solution = 0L;	return solution;}		
	long problem115() {	long solution = 0L;	return solution;}	
	long problem116() {	long solution = 0L;	return solution;}		
	long problem117() {	long solution = 0L;	return solution;}	
	long problem118() {	long solution = 0L;	return solution;}		
	long problem119() {	long solution = 0L;	return solution;}	
	long problem120() {	long solution = 0L;	return solution;}		
	long problem121() {	long solution = 0L;	return solution;}	
	long problem122() {	long solution = 0L;	return solution;}		
	long problem123() {	long solution = 0L;	return solution;}	
	long problem124() {	long solution = 0L;	return solution;}		
	long problem125() {	long solution = 0L;	return solution;}	
	long problem126() {	long solution = 0L;	return solution;}		
	long problem127() {	long solution = 0L;	return solution;}	
	long problem128() {	long solution = 0L;	return solution;}		
	long problem129() {	long solution = 0L;	return solution;}	
	long problem130() {	long solution = 0L;	return solution;}		
	long problem131() {	long solution = 0L;	return solution;}	
	long problem132() {	long solution = 0L;	return solution;}		
	long problem133() {	long solution = 0L;	return solution;}	
	long problem134() {	long solution = 0L;	return solution;}		
	long problem135() {	long solution = 0L;	return solution;}	
	long problem136() {	long solution = 0L;	return solution;}		
	long problem137() {	long solution = 0L;	return solution;}	
	long problem138() {	long solution = 0L;	return solution;}		
	long problem139() {	long solution = 0L;	return solution;}	
	long problem140() {	long solution = 0L;	return solution;}		
	long problem141() {	long solution = 0L;	return solution;}	
	long problem142() {	long solution = 0L;	return solution;}		
	long problem143() {	long solution = 0L;	return solution;}	
	long problem144() {	long solution = 0L;	return solution;}		
	long problem145() {	long solution = 0L;	return solution;}	
	long problem146() {	long solution = 0L;	return solution;}		
	long problem147() {	long solution = 0L;	return solution;}	
	long problem148() {	long solution = 0L;	return solution;}		
	long problem149() {	long solution = 0L;	return solution;}	
	long problem150() {	long solution = 0L;	return solution;}		
	long problem151() {	long solution = 0L;	return solution;}	
	long problem152() {	long solution = 0L;	return solution;}		
	long problem153() {	long solution = 0L;	return solution;}	
	long problem154() {	long solution = 0L;	return solution;}		
	long problem155() {	long solution = 0L;	return solution;}	
	long problem156() {	long solution = 0L;	return solution;}		
	long problem157() {	long solution = 0L;	return solution;}	
	long problem158() {	long solution = 0L;	return solution;}		
	long problem159() {	long solution = 0L;	return solution;}	
	long problem160() {	long solution = 0L;	return solution;}		
	long problem161() {	long solution = 0L;	return solution;}	
	long problem162() {	long solution = 0L;	return solution;}		
	long problem163() {	long solution = 0L;	return solution;}	
	long problem164() {	long solution = 0L;	return solution;}		
	long problem165() {	long solution = 0L;	return solution;}	
	long problem166() {	long solution = 0L;	return solution;}		
	long problem167() {	long solution = 0L;	return solution;}	
	long problem168() {	long solution = 0L;	return solution;}		
	long problem169() {	
		pBegin = System.currentTimeMillis();
		
		String INIT = "10000";
		long solution = 0L;	
		Mlib mlib = new Mlib();
		
		
		System.out.println("This soluntion of problem169 is " + mlib.factorial(new BigInteger(INIT)).toString().subSequence(0, 5));

		
		pEnd = System.currentTimeMillis();
		System.out.println("This soluntion of problem169 is " + solution + " -- " + (pEnd-pBegin) + " ms");
		
		return solution;
	}	
	long problem170() {	long solution = 0L;	return solution;}		
	long problem171() {	long solution = 0L;	return solution;}	
	long problem172() {	long solution = 0L;	return solution;}		
	long problem173() {	long solution = 0L;	return solution;}	
	long problem174() {	long solution = 0L;	return solution;}		
	long problem175() {	long solution = 0L;	return solution;}	
	long problem176() {	long solution = 0L;	return solution;}		
	long problem177() {	long solution = 0L;	return solution;}	
	long problem178() {	long solution = 0L;	return solution;}		
	long problem179() {	long solution = 0L;	return solution;}	
	long problem180() {	long solution = 0L;	return solution;}		
	long problem181() {	long solution = 0L;	return solution;}	
	long problem182() {	long solution = 0L;	return solution;}		
	long problem183() {	long solution = 0L;	return solution;}	
	long problem184() {	long solution = 0L;	return solution;}		
	long problem185() {	long solution = 0L;	return solution;}	
	long problem186() {	long solution = 0L;	return solution;}		
	long problem187() {	long solution = 0L;	return solution;}	
	long problem188() {	long solution = 0L;	return solution;}		
	long problem189() {	long solution = 0L;	return solution;}	
	long problem190() {	long solution = 0L;	return solution;}		
	long problem191() {	long solution = 0L;	return solution;}	
	long problem192() {	long solution = 0L;	return solution;}		
	long problem193() {	long solution = 0L;	return solution;}	
	long problem194() {	long solution = 0L;	return solution;}		
	long problem195() {	long solution = 0L;	return solution;}	
	long problem196() {	long solution = 0L;	return solution;}		
	long problem197() {	long solution = 0L;	return solution;}	
	long problem198() {	long solution = 0L;	return solution;}		
	long problem199() {	long solution = 0L;	return solution;}	
	long problem200() {	long solution = 0L;	return solution;}		
	long problem201() {	long solution = 0L;	return solution;}	
	long problem202() {	long solution = 0L;	return solution;}		
	long problem203() {	long solution = 0L;	return solution;}	
	long problem204() {	long solution = 0L;	return solution;}		
	long problem205() {	long solution = 0L;	return solution;}	
	long problem206() {	long solution = 0L;	return solution;}		
	long problem207() {	long solution = 0L;	return solution;}	
	long problem208() {	long solution = 0L;	return solution;}		
	long problem209() {	long solution = 0L;	return solution;}	
	long problem210() {	long solution = 0L;	return solution;}		
	long problem211() {	long solution = 0L;	return solution;}	
	long problem212() {	long solution = 0L;	return solution;}		
	long problem213() {	long solution = 0L;	return solution;}	
	long problem214() {	long solution = 0L;	return solution;}		
	long problem215() {	long solution = 0L;	return solution;}	
	long problem216() {	long solution = 0L;	return solution;}		
	long problem217() {	long solution = 0L;	return solution;}	
	long problem218() {	long solution = 0L;	return solution;}		
	long problem219() {	long solution = 0L;	return solution;}	
	long problem220() {	long solution = 0L;	return solution;}		
	long problem221() {	long solution = 0L;	return solution;}	
	long problem222() {	long solution = 0L;	return solution;}		
	long problem223() {	long solution = 0L;	return solution;}	
	long problem224() {	long solution = 0L;	return solution;}		
	long problem225() {	long solution = 0L;	return solution;}	
	long problem226() {	long solution = 0L;	return solution;}		
	long problem227() {	long solution = 0L;	return solution;}	
	long problem228() {	long solution = 0L;	return solution;}		
	long problem229() {	long solution = 0L;	return solution;}	
	long problem230() {	long solution = 0L;	return solution;}		
	long problem231() {	long solution = 0L;	return solution;}	
	long problem232() {	long solution = 0L;	return solution;}		
	long problem233() {	long solution = 0L;	return solution;}	
	long problem234() {	long solution = 0L;	return solution;}		
	long problem235() {	long solution = 0L;	return solution;}	
	long problem236() {	long solution = 0L;	return solution;}		
	long problem237() {	long solution = 0L;	return solution;}	
	long problem238() {	long solution = 0L;	return solution;}		
	long problem239() {	long solution = 0L;	return solution;}	
	long problem240() {	long solution = 0L;	return solution;}		
	long problem241() {	long solution = 0L;	return solution;}	
	long problem242() {	long solution = 0L;	return solution;}		
	long problem243() {	long solution = 0L;	return solution;}	
	long problem244() {	long solution = 0L;	return solution;}		
	long problem245() {	long solution = 0L;	return solution;}	
	long problem246() {	long solution = 0L;	return solution;}		
	long problem247() {	long solution = 0L;	return solution;}	
	long problem248() {	long solution = 0L;	return solution;}		
	long problem249() {	long solution = 0L;	return solution;}	
	long problem250() {	long solution = 0L;	return solution;}		
	long problem251() {	long solution = 0L;	return solution;}	
	long problem252() {	long solution = 0L;	return solution;}		
	long problem253() {	long solution = 0L;	return solution;}	
	long problem254() {	long solution = 0L;	return solution;}		
	long problem255() {	long solution = 0L;	return solution;}	
	long problem256() {	long solution = 0L;	return solution;}		
	long problem257() {	long solution = 0L;	return solution;}	
	long problem258() {	long solution = 0L;	return solution;}		
	long problem259() {	long solution = 0L;	return solution;}	
	long problem260() {	long solution = 0L;	return solution;}		
	long problem261() {	long solution = 0L;	return solution;}	
	long problem262() {	long solution = 0L;	return solution;}		
	long problem263() {	long solution = 0L;	return solution;}	
	long problem264() {	long solution = 0L;	return solution;}		
	long problem265() {	long solution = 0L;	return solution;}	
	long problem266() {	long solution = 0L;	return solution;}		
	long problem267() {	long solution = 0L;	return solution;}	
	long problem268() {	long solution = 0L;	return solution;}		
	long problem269() {	long solution = 0L;	return solution;}	
	long problem270() {	long solution = 0L;	return solution;}		
	long problem271() {	long solution = 0L;	return solution;}	
	long problem272() {	long solution = 0L;	return solution;}		
	long problem273() {	long solution = 0L;	return solution;}	
	long problem274() {	long solution = 0L;	return solution;}		
	long problem275() {	long solution = 0L;	return solution;}	
	long problem276() {	long solution = 0L;	return solution;}		
	long problem277() {	long solution = 0L;	return solution;}	
	long problem278() {	long solution = 0L;	return solution;}		
	long problem279() {	long solution = 0L;	return solution;}	
	long problem280() {	long solution = 0L;	return solution;}		
	long problem281() {	long solution = 0L;	return solution;}	
	long problem282() {	long solution = 0L;	return solution;}		
	long problem283() {	long solution = 0L;	return solution;}	
	long problem284() {	long solution = 0L;	return solution;}		
	long problem285() {	long solution = 0L;	return solution;}	
	long problem286() {	long solution = 0L;	return solution;}		
	long problem287() {	long solution = 0L;	return solution;}	
	long problem288() {	long solution = 0L;	return solution;}		
	long problem289() {	long solution = 0L;	return solution;}	
	long problem290() {	long solution = 0L;	return solution;}		
	long problem291() {	long solution = 0L;	return solution;}	
	long problem292() {	long solution = 0L;	return solution;}		
	long problem293() {	long solution = 0L;	return solution;}	
	long problem294() {	long solution = 0L;	return solution;}		
	long problem295() {	long solution = 0L;	return solution;}	
	long problem296() {	long solution = 0L;	return solution;}		
	long problem297() {	long solution = 0L;	return solution;}	
	long problem298() {	long solution = 0L;	return solution;}		
	long problem299() {	long solution = 0L;	return solution;}	
	long problem300() {	long solution = 0L;	return solution;}		
	long problem301() {	long solution = 0L;	return solution;}	
	long problem302() {	long solution = 0L;	return solution;}		
	long problem303() {	long solution = 0L;	return solution;}	
	long problem304() {	long solution = 0L;	return solution;}		
	long problem305() {	long solution = 0L;	return solution;}	
	long problem306() {	long solution = 0L;	return solution;}		
	long problem307() {	long solution = 0L;	return solution;}	
	long problem308() {	long solution = 0L;	return solution;}		
	long problem309() {	long solution = 0L;	return solution;}	
	long problem310() {	long solution = 0L;	return solution;}		
	long problem311() {	long solution = 0L;	return solution;}	
	long problem312() {	long solution = 0L;	return solution;}		
	long problem313() {	long solution = 0L;	return solution;}	
	long problem314() {	long solution = 0L;	return solution;}		
	long problem315() {	long solution = 0L;	return solution;}	
	long problem316() {	long solution = 0L;	return solution;}		
	long problem317() {	long solution = 0L;	return solution;}	
	long problem318() {	long solution = 0L;	return solution;}		
	long problem319() {	long solution = 0L;	return solution;}	
	long problem320() {	long solution = 0L;	return solution;}		
	long problem321() {	long solution = 0L;	return solution;}	
	long problem322() {	long solution = 0L;	return solution;}		
	long problem323() {	long solution = 0L;	return solution;}	
	long problem324() {	long solution = 0L;	return solution;}		
	long problem325() {	long solution = 0L;	return solution;}	
	long problem326() {	long solution = 0L;	return solution;}		
	long problem327() {	long solution = 0L;	return solution;}	
	long problem328() {	long solution = 0L;	return solution;}		
	long problem329() {	long solution = 0L;	return solution;}	
	long problem330() {	long solution = 0L;	return solution;}		
	long problem331() {	long solution = 0L;	return solution;}	
	long problem332() {	long solution = 0L;	return solution;}		
	long problem333() {	long solution = 0L;	return solution;}	
	long problem334() {	long solution = 0L;	return solution;}		
	long problem335() {	long solution = 0L;	return solution;}	
	long problem336() {	long solution = 0L;	return solution;}		
	long problem337() {	long solution = 0L;	return solution;}	
	long problem338() {	long solution = 0L;	return solution;}		
	long problem339() {	long solution = 0L;	return solution;}	
	long problem340() {	long solution = 0L;	return solution;}		
	long problem341() {	long solution = 0L;	return solution;}	
	long problem342() {	long solution = 0L;	return solution;}		
	long problem343() {	long solution = 0L;	return solution;}	
	long problem344() {	long solution = 0L;	return solution;}		
	long problem345() {	long solution = 0L;	return solution;}	
	long problem346() {	long solution = 0L;	return solution;}		
	long problem347() {	long solution = 0L;	return solution;}	
	long problem348() {	long solution = 0L;	return solution;}		
	long problem349() {	long solution = 0L;	return solution;}	
	long problem350() {	long solution = 0L;	return solution;}		
	long problem351() {	long solution = 0L;	return solution;}	
	long problem352() {	long solution = 0L;	return solution;}		
	long problem353() {	long solution = 0L;	return solution;}	
	long problem354() {	long solution = 0L;	return solution;}		
	long problem355() {	long solution = 0L;	return solution;}	
	long problem356() {	long solution = 0L;	return solution;}		
	long problem357() {	long solution = 0L;	return solution;}	
	long problem358() {	long solution = 0L;	return solution;}		
	long problem359() {	long solution = 0L;	return solution;}	
	long problem360() {	long solution = 0L;	return solution;}		
	long problem361() {	long solution = 0L;	return solution;}	
	long problem362() {	long solution = 0L;	return solution;}		
	long problem363() {	long solution = 0L;	return solution;}	
	long problem364() {	long solution = 0L;	return solution;}		
	long problem365() {	long solution = 0L;	return solution;}	
	long problem366() {	long solution = 0L;	return solution;}		
	long problem367() {	long solution = 0L;	return solution;}	
	long problem368() {	long solution = 0L;	return solution;}		
	long problem369() {	long solution = 0L;	return solution;}	
	long problem370() {	long solution = 0L;	return solution;}		
	long problem371() {	long solution = 0L;	return solution;}	
	long problem372() {	long solution = 0L;	return solution;}		
	long problem373() {	long solution = 0L;	return solution;}	
	long problem374() {	long solution = 0L;	return solution;}		
	long problem375() {	long solution = 0L;	return solution;}	
	long problem376() {	long solution = 0L;	return solution;}		
	long problem377() {	long solution = 0L;	return solution;}	
	long problem378() {	long solution = 0L;	return solution;}		
	long problem379() {	long solution = 0L;	return solution;}	
	long problem380() {	long solution = 0L;	return solution;}		
	long problem381() {	long solution = 0L;	return solution;}	
	long problem382() {	long solution = 0L;	return solution;}		
	long problem383() {	long solution = 0L;	return solution;}	
	long problem384() {	long solution = 0L;	return solution;}		
	long problem385() {	long solution = 0L;	return solution;}	
	long problem386() {	long solution = 0L;	return solution;}		
	long problem387() {	long solution = 0L;	return solution;}	
	long problem388() {	long solution = 0L;	return solution;}		
	long problem389() {	long solution = 0L;	return solution;}	
	long problem390() {	long solution = 0L;	return solution;}		
	long problem391() {	long solution = 0L;	return solution;}	
	long problem392() {	long solution = 0L;	return solution;}		
	long problem393() {	long solution = 0L;	return solution;}	
	long problem394() {	long solution = 0L;	return solution;}		
	long problem395() {	long solution = 0L;	return solution;}	
	long problem396() {	long solution = 0L;	return solution;}		
	long problem397() {	long solution = 0L;	return solution;}	
	long problem398() {	long solution = 0L;	return solution;}		
	long problem399() {	long solution = 0L;	return solution;}	
	long problem400() {	long solution = 0L;	return solution;}		
	long problem401() {	long solution = 0L;	return solution;}	
	long problem402() {	long solution = 0L;	return solution;}		
	long problem403() {	long solution = 0L;	return solution;}	
	long problem404() {	long solution = 0L;	return solution;}		
	long problem405() {	long solution = 0L;	return solution;}	
	long problem406() {	long solution = 0L;	return solution;}		
	long problem407() {	long solution = 0L;	return solution;}	
	long problem408() {	long solution = 0L;	return solution;}		
	long problem409() {	long solution = 0L;	return solution;}	
	long problem410() {	long solution = 0L;	return solution;}		
	long problem411() {	long solution = 0L;	return solution;}	
	long problem412() {	long solution = 0L;	return solution;}		
	long problem413() {	long solution = 0L;	return solution;}	
	long problem414() {	long solution = 0L;	return solution;}		
	long problem415() {	long solution = 0L;	return solution;}	
	long problem416() {	long solution = 0L;	return solution;}		
	long problem417() {	long solution = 0L;	return solution;}	
	long problem418() {	long solution = 0L;	return solution;}		
	long problem419() {	long solution = 0L;	return solution;}	
	long problem420() {	long solution = 0L;	return solution;}		
	long problem421() {	long solution = 0L;	return solution;}	
	long problem422() {	long solution = 0L;	return solution;}		
	long problem423() {	long solution = 0L;	return solution;}	
	long problem424() {	long solution = 0L;	return solution;}		
	long problem425() {	long solution = 0L;	return solution;}	
	long problem426() {	long solution = 0L;	return solution;}		
	long problem427() {	long solution = 0L;	return solution;}	
	long problem428() {	long solution = 0L;	return solution;}		
	long problem429() {	long solution = 0L;	return solution;}	
	long problem430() {	long solution = 0L;	return solution;}		
	long problem431() {	long solution = 0L;	return solution;}	
	long problem432() {	long solution = 0L;	return solution;}		
	long problem433() {	long solution = 0L;	return solution;}	
	long problem434() {	long solution = 0L;	return solution;}		
	long problem435() {	long solution = 0L;	return solution;}	
	long problem436() {	long solution = 0L;	return solution;}		
	long problem437() {	long solution = 0L;	return solution;}	
	long problem438() {	long solution = 0L;	return solution;}		
	long problem439() {	long solution = 0L;	return solution;}	
	long problem440() {	long solution = 0L;	return solution;}		
	long problem441() {	long solution = 0L;	return solution;}	
	long problem442() {	long solution = 0L;	return solution;}		
	long problem443() {	long solution = 0L;	return solution;}	
	long problem444() {	long solution = 0L;	return solution;}		
	long problem445() {	long solution = 0L;	return solution;}	
	long problem446() {	long solution = 0L;	return solution;}		
	long problem447() {	long solution = 0L;	return solution;}	
	long problem448() {	long solution = 0L;	return solution;}		
	long problem449() {	long solution = 0L;	return solution;}	
	long problem450() {	long solution = 0L;	return solution;}		
	long problem451() {	long solution = 0L;	return solution;}	
	long problem452() {	long solution = 0L;	return solution;}		
	long problem453() {	long solution = 0L;	return solution;}	
	long problem454() {	long solution = 0L;	return solution;}		
	long problem455() {	long solution = 0L;	return solution;}	
	long problem456() {	long solution = 0L;	return solution;}		
	long problem457() {	long solution = 0L;	return solution;}	
	long problem458() {	long solution = 0L;	return solution;}		
	long problem459() {	long solution = 0L;	return solution;}	
	long problem460() {	long solution = 0L;	return solution;}		
	long problem461() {	long solution = 0L;	return solution;}	
	long problem462() {	long solution = 0L;	return solution;}		
	long problem463() {	long solution = 0L;	return solution;}	
	long problem464() {	long solution = 0L;	return solution;}		
	long problem465() {	long solution = 0L;	return solution;}	
	long problem466() {	long solution = 0L;	return solution;}		
	long problem467() {	long solution = 0L;	return solution;}	
	long problem468() {	long solution = 0L;	return solution;}		
	long problem469() {	long solution = 0L;	return solution;}	
	long problem470() {	long solution = 0L;	return solution;}		
	long problem471() {	long solution = 0L;	return solution;}	
	long problem472() {	long solution = 0L;	return solution;}	
	
}

