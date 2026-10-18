package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransposeOfMatrix {
	public static void main(String[] args) {
		int rows = 4;
		int columns = 3;
		int aArray [] [] = 
			{	{1,2,3}, 
				{1,2,3}, 
				{1,2,3}, 
				{1,2,3}	 };
		int bArray [] [] = new int[columns][rows];
		
		for (int i = 0; i < rows; i++) {
			System.out.println(Arrays.toString(aArray[i]));
		}
		
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(aArray[j][i]);
				bArray[i][j] = aArray[j][i];
			}
			System.out.println();
		}
		
		int[][] transposedMatrix = IntStream.range(0, aArray[0].length)//Counter from 0 to length-1
				.mapToObj(
										i -> IntStream.range(0, aArray.length)//i is taken in scope, 
											 						.map(j -> aArray[j][i])//
											 						.toArray()
									)
				.toArray(int[][]::new);

		
		Arrays.stream(transposedMatrix)
					.map(row -> Arrays.toString(row))
					.forEach(System.out::println);
		
		
		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = Arrays.asList("d", "e", "f");
		List<String> list3 = Arrays.asList("g", "h", "i");

		Stream.of(list1, list2, list3)   			// Stream of lists [[a, b, c], [d, e, f], [g, h, i]]
		      .flatMap(Collection::stream)  // Flatten into a single stream [a, b, c, d, e, f, g, h, i]
		      .forEach(System.out::println); // Prints each element
		
		System.out.println("-------------------------");
		
		List<String> list11 = Arrays.asList("a", "b", "c");
		List<Integer> list22 = Arrays.asList(11,22,33);
		List<Boolean> list33 = Arrays.asList(true,false);

		Stream.of(list11, list22, list33)      // Stream of lists [[a, b, c], [d, e, f], [g, h, i]]
		      .flatMap(Collection::stream)  // Flatten into a single stream [a, b, c, d, e, f, g, h, i]
		      .forEach(System.out::println); // Prints each element
		
		
		
	}
}
