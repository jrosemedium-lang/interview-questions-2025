package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TraditionalArrayRotation {
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8,9}; //arr.length=9
		int shift=2;
		
			
		int arrayResult[]= IntStream.range(0, array.length)
		.map(i ->array[(array.length-shift+i) % array.length])
		.toArray();
	
		System.out.println(Arrays.toString(arrayResult));
		
		
		arrayResult= IntStream.range(0, array.length)
				.map(i ->array[(shift+i) % array.length])
				.toArray();
			
		System.out.println(Arrays.toString(arrayResult));
		System.out.println();
		System.out.println();
		System.out.println();
		arrayResult = new int[array.length];
		int shiftNew=2;
		for (int j = 0; j < array.length; j++) {
			if(j+shiftNew < array.length) {
				arrayResult[j+shiftNew] = array[j];
			}
		}
		for (int j = shiftNew-1; j >= 0; j--) {
			arrayResult[j] = array[array.length-j-1];
			if(j > shiftNew) {
				break;
			}
		}
	    System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(arrayResult));
		
		arrayResult = new int[array.length];//[3, 4, 5, 6, 7, 8, 9, 1, 2]
		int shiftOpposite=2;
		for (int j = 0; j <= array.length; j++) {
			if(j+shiftOpposite < array.length) {
				arrayResult[j] = array[j+shiftOpposite];
			}
		}
		for (int j = 0, k=0; j < array.length; j++) {
			if(j>array.length-1-shiftNew) {
				arrayResult[j] = array[k];
				k = k+ 1;
			} else {
				continue;
			}
		}
	
		
		System.out.println();
		System.out.println();
		System.out.println();
	    System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(arrayResult));
	}
}
