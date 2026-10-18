package JavaCodingExamplePkg;

import java.util.stream.Stream;

public class Factorial {
	public static void main(String[] args) {
		int fact =1;
		int num = 5;
		for (int i = 2; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
		
		
		//----------Using While
		int num2 = 5;
		int i = 1, fact2 = 1;
		while(i <= num2) {
			fact2 = fact2 * i;
			i++;
		}
		System.out.println(fact);
		
		//----------------------Using Lambda-----------------------------------
        int factorial = Stream.iterate(1, ii -> ii<=num, ii -> ii + 1)
        .reduce(1, (a, b) -> a * b);
        
        System.out.println(factorial);

//        Stream.iterate(1, ii -> ii <= num, ii -> ii + 1)
//        .map(facto -> facto * ii)  // This line has an issue
//        .forEach(System.out::println);
        
	}
}
