package JavaCodingExamplePkg;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IsPrimeJava8 {
	public static void main(String[] args) {
		Predicate<Integer> isLessThan1 = n -> n<=1;//false
		Predicate<Integer> isEqualTo2Or3 = n -> (n==2 || n==3);//true
		Predicate<Integer> isModulo2Or3Eq0 = n -> (n%2 == 0 || n%3==0);//false
		Integer n = 1;
		
		
		boolean isPrime = 	(isLessThan1.negate().test(n) && 
												(isEqualTo2Or3.test(n)
															|| (isModulo2Or3Eq0.negate().test(n) 
																	&& 
																	IntStream.iterate(5, i -> (i <= Math.sqrt(n)), i -> i + 6)
																		   .noneMatch(i -> (n % i == 0 || n % (i + 2) == 0))
																  )
												)
											);
		
		if(isPrime) {
			System.out.println("n="+n+" Is Prime");
		} else {
			System.out.println("n="+n+" Is Not Prime");
		}
	
		
	}
}
