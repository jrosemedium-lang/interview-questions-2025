package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DecimalToBinaryWithLambda {
	public static void main(String[] args) {
		int num = 11, temp = 0 ; String numBinary = "";
		while(num > 0) {
			temp = num % 2;
//			System.out.print(temp);
			numBinary = numBinary + temp + "";
			num = num/2;
		}
		
		System.out.println(new StringBuilder(numBinary).reverse());
		
		//-------------------------------LAMBDA
		
		int numLamda = 11;
        List<Integer> binaryDigits = new ArrayList<>();

        // Convert to binary and collect each bit in a list
        Stream.iterate(numLamda, n -> n > 0, n -> n / 2)
                .map(n -> n % 2)
                .forEach(binaryDigits::add);
        
        // Reverse the list to get the correct binary representation
        Collections.reverse(binaryDigits);
        System.out.println(binaryDigits);

        // Print the binary representation using lambda
        String binaryString = binaryDigits.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(binaryString);
	}
}
