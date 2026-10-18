package JavaCodingExamplePkg;

public class CoPrimeNumbers {
	 static int __gcd(int a, int b)
	    {
		 	/*
		 	 * THIS IS ACTUALLY ONLY THE ART OF SUBSTRACTION REPLACING THE MOD Refer EucledianAlgorithm.java
		 	 * gcd(5,6)
		 	 * 	=>  __gcd(a, b-a) => gcd(5,1);
		 	 * 	=>  __gcd(a-b, b) => gcd(4, 1);
		 	 *     =>  __gcd(a-b, b) => gcd(3, 1);
		 	 *     =>  __gcd(a-b, b) => gcd(2, 1);
		 	 *     =>  __gcd(a-b, b) => gcd(1, 1);
		 	 *     => return 1; THE END
		 	 * */
		 	System.out.println("gcd("+a+","+b+")");
	        // Everything divides 0 
	        if (a == 0 || b == 0)
	            return 0;
	        
	        // base case
	        if (a == b)
	            return a;
	        
	        // a is greater
	        if (a > b)
	            return __gcd(a-b, b);
	                
	        return __gcd(a, b-a);
	    }
	    
	    // function to check and print if 
	    // two numbers are co-prime or not 
	    static void coprime(int a, int b) {
	        if ( __gcd(a, b) == 1)
	            System.out.println("Co-Prime"); 
	        else
	            System.out.println("Not Co-Prime");     
	    }
	    
	    public static void main(String[] args) {
	    	 int a = 4, b = 3;
	         coprime(a, b); 
	         
	         a = 8; b = 16;
	         coprime(a, b); 
		}
}
