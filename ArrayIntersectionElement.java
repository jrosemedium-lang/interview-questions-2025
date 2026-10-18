package JavaCodingExamplePkg;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayIntersectionElement {
	public static void main(String[] args) {
		 int[] arr1 = {1, 2, 2, 3, 4};
	     int[] arr2 = {2, 2, 3, 5};
	     System.out.println(
		     Stream.iterate(0, n1-> n1<arr1.length, n1 -> n1+1)
		     			  .map(n1 -> arr1[n1])
		     			  .flatMap(stream2 ->	 Stream.iterate(0, n2 -> n2<arr2.length, n2 -> n2 + 1)
		    	     			  .map(n2 -> arr2[n2]))//flatMap is merging the elements of array1 with elements of array2 into a single stream?
		     			  .distinct().collect(Collectors.toList())
	    		 );
	     //by mistake this code only gives distinct elements of 2nd array
	     
	     /****
	      * 
	      * .flatMap(stream2 -> Stream of arr2)

	      * arr2 repeated arr1.length times
			[2,2,3,5]   // for 1
			[2,2,3,5]   // for 2
			[2,2,3,5]   // for 2
			[2,2,3,5]   // for 3
			[2,2,3,5]   // for 4

	      * 
	      * 
	      * all we did here was finding the unique elements from 2nd array
	      * 
	      */
	}
}
