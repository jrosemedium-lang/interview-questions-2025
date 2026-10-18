package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CapgL1FindMissingNumber {
	public static void main(String[] args) {
		Integer myArray[] = new Integer[] {1,2,4,5,6,7};
		List<Integer> myArrayList = new ArrayList<>(Arrays.asList(myArray));
		
		Integer maxNumber = Stream.of(myArray).max(Comparator.naturalOrder()).get();
		Integer minNumber = Stream.of(myArray).min(Comparator.naturalOrder()).get();
		
		IntPredicate isIntAbsent = (x) -> !myArrayList.contains(x); 

		System.out.println(
			IntStream.rangeClosed(minNumber, maxNumber)
							   .filter(isIntAbsent)
							   .boxed()
							   .collect(Collectors.toList())
		);
		
		
		
		
		
		
		
		
		
		
		
		
		
		IntPredicate intPredicate = (i) -> {return myArray[i]+1 != myArray[i+1];};
		
		System.out.println(
			IntStream.range(0, myArray.length)
							  .map(i -> myArray[i])
							  .dropWhile(intPredicate)
							  .findFirst().getAsInt() + 1		  
				);
		
		
		IntSupplier myDefault = () -> {return -1;};
		System.out.println(
			IntStream.iterate(0, i ->i < myArray.length-1, i -> i+1)
							   .filter(i -> myArray[i+1] - myArray[i] >1)
							   .map(i -> myArray[i]+1)
							   .findFirst().orElseGet(myDefault)
				);
		
		
		
			
	}
}
