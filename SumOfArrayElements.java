package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumOfArrayElements {
	public static void main(String[] args) {
		int myArray[]= new int[] {10,20,30,40,50,60,70,80};
		
		 int result = Stream.iterate(0,n-> n+1)
		 						.limit(myArray.length)
		 						.reduce(10000,(a, n)-> (a = (a+myArray[n])));
		 /*
		  * Incorrect code as the accumulator a should not be 2nd parameter
		  * Stream.iterate(0, n -> (n<myArray.length),n-> n+1).reduce(0,(n,a)-> (a = (a+myArray[n])));
		  * 
		  * */
		 System.out.println(result);
		 
		 result = Stream.iterate(0,n->(n<myArray.length),n-> n+1)
					.reduce(0,(a, n)-> (a = (a+myArray[n])));

		 System.out.println(result);
		 
		 
		 int[] numbers = {1, 2, 3, 4, 5};

		 int sum = Stream.of(numbers)
		                 .flatMapToInt(Arrays::stream)
		                 .reduce(0, (a, b) -> a + b);

		 System.out.println(sum); // Outputs the sum: 15
		 
		 
		 List<List<Integer>> listOfLists = new ArrayList<>();
	        listOfLists.add(Arrays.asList(1, 2, 3));
	        listOfLists.add(Arrays.asList(4, 5, 6));
	        listOfLists.add(Arrays.asList(7, 8, 9));

	        // Flatten the list of lists into a single stream of integers
	        IntStream flatStream = listOfLists.stream()
	                                          .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue));
	        
	        // Print each element of the flattened stream
	        flatStream.forEach(System.out::println);
	}
}
