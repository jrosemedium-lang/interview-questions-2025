package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class LargestOfArrayElements {
	public static void main(String[] args) {
		int myArray[]= new int[] {10,20,30,40,50,60,70,80};
		
		OptionalInt result = Stream.of(myArray)
							.flatMapToInt(Arrays::stream)
							.max();
		System.out.println(result);
		
		Arrays.stream(myArray).max();
		OptionalInt optional = OptionalInt.of(42);
        if (optional.isPresent()) {
            System.out.println("Value: " + optional.getAsInt());
        } else {
            System.out.println("No value present");
        }
        
        OptionalInt optionalEmpty = OptionalInt.empty();
        int value = optionalEmpty.orElse(0); // Returns 0 if no value is present
        System.out.println("Value: " + value);
        
        
	}
}
