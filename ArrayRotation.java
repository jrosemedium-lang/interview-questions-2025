package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * 
 * 
In the expression 7 % 9:
Dividend: This is the number you are dividing. In this case, it is 7.
Divisor: This is the number you are dividing by. In this case, it is 9.
													  ___0____<---- Quotient
		   		 	Divisor---------->9   |    7	<-----------Dividend
		    											-  0
		    										````````````````````
		    											 	7 <-------------Remainder

 Input: arr[] = {1, 2, 3, 4, 5, 6, 7},  d = 2
 Output:  3 4 5 6 7 1 2
*/
public class ArrayRotation {
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8,9}; //arr.length=9
		int shift=2;
		
		
		for (int j = 0; j < array.length; j++) {
			System.out.println("j= "+j + ":"
		+" (array.length - shift + j)= "+(array.length - shift + j)+" :: => "
		+(array.length - shift + j) % array.length);
		}

		//Right Shift
		int newArray[]	= IntStream.range(0, array.length)
							  .map(i -> array[(array.length - shift + i) % array.length])
							  .toArray();
		/*
		 * 
		 * IntStream.range(0, arr.length).map(i -> array[someLocation]) 
		 * it means that arr[someLocation] is implicitly assigned to array[0] because i is in scope of map, 
		 * and is given an input from 0 using IntStream.range(0, arr.length)
		 * 
		 * 
		 * */
		System.out.println(Arrays.toString(newArray));	
		newArray.toString(); 
		
		//left Shift
		int[] shiftedArray = IntStream.range(0, array.length)
                .map(i -> array[(i + shift) % array.length])
                .toArray();
		
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("i= "+i + ":"
					+"(i + shift)= "+(i+shift)+" :: => "
					+ (i + shift) % array.length);
		}

		
        System.out.println(Arrays.toString(shiftedArray));
	}
}
