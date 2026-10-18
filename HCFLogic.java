package JavaCodingExamplePkg;

public class HCFLogic {
	static int gcd(int a, int b)
    {
        // stores minimum(a, b)
        int ans;
        ans = (a < b) ? a : b;
 
        // take a loop iterating through smaller number to 1
        for (; ans > 1; ans--) {
            if (a % ans == 0 && b % ans == 0) // check if the current value of i divides both // numbers with remainder 0 if yes, then i is // the GCD of a and b
                return ans;
        }
        
        return 1; // if there are no common factors for a and b other // than 1, then GCD of a and b is 1
    }
	
	static int gcdV2(int a, int b) //Opposite of LCMLogic.java
    {
        // stores minimum(a, b)
		 int ans = (a < b) ? a : b;
		 System.out.println("ans = "+ans);
        // take a loop iterating through smaller number to 1
        while (ans > 1) {
        	System.out.println("ans ::"+ ans +" a ::" + a + " a % ans = " +(a % ans));
        	System.out.println("ans ::"+ ans +" b ::" + b + " b % ans = " +(b % ans));
            if (a % ans == 0 && b % ans == 0) {             // check if the current value of i divides both // numbers with remainder 0 if yes, then i is // the GCD of a and b
            	System.out.println("ans ::"+ ans +" a ::" + a + " a % ans = " +(a % ans));
            	System.out.println("ans ::"+ ans +" b ::" + b + " b % ans = " +(b % ans));
            	break;
            } 
            System.out.println("In Loop ans = "+ans);
            ans --;
        }
        
        return ans; // if there are no common factors for a and b other // than 1, then GCD of a and b is 1
    }
	public static void main(String[] args) {
		System.out.println(gcd(36, 37));
		System.out.println(gcdV2(36, 37));
	}
}
