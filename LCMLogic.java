package JavaCodingExamplePkg;

public class LCMLogic {
	public static void main(String[] args) {
        int a = 15, b = 25;

        int ans = (a > b) ? a : b;
        System.out.println("ans = "+ans);
        // Checking for a smallest number that can be divided by both numbers
        while (true) {
        	System.out.println("ans ::"+ ans +" a ::" + a + " ans % a = " +(ans % a));
        	System.out.println("ans ::"+ ans +" b ::" + b + " ans % b = " +(ans % b));
            if (ans % a == 0 && ans % b == 0) {
            	System.out.println("ans ::"+ ans +" a ::" + a + " ans % a = " +(ans % a));
            	System.out.println("ans ::"+ ans +" b ::" + b + " ans % b = " +(ans % b));
            	break;
            }
            System.out.println("In Loop ans = "+ans);
            ans++;
        }

        // Printing the Result
        System.out.println("LCM of " + a + " and " + b + " : " + ans);
	}
}


/*
 * Step 1 - Find out the max of two numbers(a,b; say a is max)
 * Step 2 - Divide both numbers by the max of the two(say a) and take their remainder (a%a, a%b)
 * Step 3 - If Remainders of both modulo-divisions becomes Zero, we got it, that "a" value is LCM
 * Step 4 - If Remainder's of both modulo-divisions is NON-zero, then increment a by 1 and repeat from Step 2
 * 				Until we reach step 3
 * 
 * */
