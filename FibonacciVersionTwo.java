package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.stream.Stream;

public class FibonacciVersionTwo {
 
		public static void main(String[] args) {
			int num = 9;//0 1 1 2 3 5 8
			int array[] = new int[num-2];
			array[0]= 0;
			array[1]= 1;
			
			for (int i = 2; i < array.length; i++) {
				array[i] = array[i-1] + array[i-2];
			}
			
//			System.out.println(Arrays.toString(array));
			
			
			int a = 0, b = 1;
			System.out.print(a + " ");
			if (num > 1) System.out.print(b + " ");

			for (int i = 2; i < num; i++) {
			    int c = a + b; 
			    //0 1 1 2 3 5 8 13 21
			    //a b c
			    //   a b c
			//    System.out.print(c + " ");
			    a = b;
			    b = c;
			}
			
			System.out.println();
			
			Stream.iterate(new int[]{0, 1}, pair -> new int[]{pair[1], pair[0] + pair[1]})
		        .limit(10)
//		        .map(pair -> pair[0])
		        .forEach(n -> System.out.print(Arrays.toString(n) + " "));
		}
	}

