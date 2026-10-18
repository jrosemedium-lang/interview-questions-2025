package JavaCodingExamplePkg;

public class PermutationCombinationUsingFactorialFormula {
	public static long factorial(int n) {
		long fact = 1;
		for(int i=1; i<=n; i++) {
			fact = fact*i;
		}
		return fact;
	}
	public static long permutation(int n, int r) {
		return (
				factorial(n)/factorial(n-r)
		);
	}
	public static long combination(int n, int r) {
		return (
				factorial(n)/(factorial(r)*factorial(n-r))
		);
	}
	public static void main(String[] args) {
		int n = 5; // Total elements
        int r = 3; // Chosen elements

        // Calculate Permutations and Combinations
        long perm = permutation(n, r);
        long comb = combination(n, r);

        // Print results
        System.out.println("Permutation P(" + n + ", " + r + ") = " + perm);
        System.out.println("Combination C(" + n + ", " + r + ") = " + comb);
	}
}
