package JavaCodingExamplePkg;

public class DigitalRootProblemV2MathFormula {
	public static void main(String[] args) {
		System.out.println(
				//concatAndDigitalRoot(56, 3)
				concatAndDigitalRoot(12345, 3)
		);
		//Point to note is structure/pattern here concatenation of number is a pattern
	}
	static int concatAndDigitalRoot(long num, int k) {
	    int singleSum = 0;
	    //find sum of single number given
	    while (num > 0) {
	        singleSum += num % 10;
	        num /= 10;
	    }
	    //multiply the number with k 
	    int totalSum = singleSum * k;//30
	    
	  //find sum of ur 30, to pause at single digit, any two digit will be greater than 10
	  //should be summed again
	    while (totalSum >= 10) {
	        int s = 0;
	        System.out.println(totalSum);//see here the number can be a two digit needs to be summed again
	        while (totalSum > 0) {
	            s += totalSum % 10;
	            totalSum /= 10;
	        }
	        totalSum = s;
	    }

	    return totalSum;
	}

}
