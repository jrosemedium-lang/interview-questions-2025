package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ITCInterviewL1 {
	public static void main(String[] args) {
		String str = "Times Of India";//semit fo aidnI
		
		StringBuilder sb = new StringBuilder();
		String result = "";
		String spacedArray[] = str.split(" ");
		for(String strItem :spacedArray) {
			//System.out.println(strItem);
			 sb = new StringBuilder(strItem);
			 System.out.print(sb.reverse());
			 System.out.print(" ");
		}
		
		Integer array[] = new Integer[] {9,1,3,5,7};
		
		for(int i=0;i<array.length;i++) {
			if(i >= 3) {
				break;
			}
			for(int j=0;j<array.length;j++) {
				if(i >= 3) {
					break;
				}
				if(array[i]<array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		
		Integer myArray[] = new Integer[] { 1, 3, 2, 6, 4, 5 };

		System.out.println(
				IntStream
					.range(0, myArray.length)
					.map(i -> myArray[i])
					.limit(myArray.length - 2)
					.sorted()
					.boxed()
					.collect(Collectors.toList())
		);
		
		
		String myString = "Times of India";
		String [] strArray = myString.split(" ");
	
		System.out.println(Arrays.toString(strArray));
		
		System.out.println(
		IntStream.iterate(0, i->i<strArray.length, i -> i+1)
					 .limit(strArray.length)
					 .mapToObj(i -> new StringBuilder(strArray[i]).reverse())
					 .collect(Collectors.joining(" "))
				);
	}
}
