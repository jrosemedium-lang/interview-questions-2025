package JavaCodingExamplePkg;

public class PrimeNumbers {
	
	static boolean isPrime(int n) {
		if(n<=1)
			return false;
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				System.out.println("n="+n+" % "+i+" INSIDE - "+(n % i));
				return false;
			}
			System.out.println("n="+n+" % "+i+" OUTSIDE - "+(n % i));
		}
		return true;
	}
	
	static boolean isPrimeNBy2(int n) {
		if(n<=1)
			return false;
		
		for (int i = 2; i < n/2; i++) {
			if (n % i == 0) {
				System.out.println("n="+n+" % "+i+" INSIDE - "+(n % i));
				return false;
			}
			System.out.println("n="+n+" % "+i+" OUTSIDE - "+(n % i));
		}
		return true;
	}
	
	static boolean isPrimeOptmized(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
         // For n=2 or n=3 it will check
        if (n == 2 || n == 3)
            return true;
        // For multiple of 2 or 3 This will check 
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        // It will check all the others condition
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
	
	
	public static void main(String[] args) {
		if(isPrimeOptmized(36)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

}
