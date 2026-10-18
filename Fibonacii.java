package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacii {
	public static void main(String[] args) {
		int fibo = 0, location= 4;
		int num = 8, t1=0,t2=1,sum;
		List<Integer> myList = new ArrayList<>();
		myList.add(0);
		myList.add(1);
		
		for (int i = 1; i <= num; ++i) {
			sum = t1 + t2;
			myList.add(sum);
			t1 = t2;
			t2 = sum;
		}
		System.out.println(fibo);
		
		System.out.println(myList);
		

		int aa = Stream.iterate(0, i -> (i<myList.size()), i -> (i+2))
			.reduce(0, (a,b)->(a+b));
		System.out.println("aa "+ aa);
			
	Stream.iterate(new Integer[]{0}, n -> new Integer[]{n[0] + 2})
            .limit(10) // Limit to the first 10 even numbers
            .map(n -> n[0]) // Extract the single value from the array
            .reduce(0, (a, b) -> a + b); 
            
	 // Print even index items
			System.out.println("Print even index items - ");
    		IntStream.range(0, myList.size())
             .filter(i -> i % 2 == 0)
             .mapToObj(myList::get)
             .limit(5)
             .forEach(System.out::println);
	       
    		int ans= 
	        		IntStream.range(0, myList.size())
	                 .filter(i -> i % 2 == 0)
	                 .mapToObj(myList::get)
	                 .limit(5)
	                 .reduce(0, (a,b)->(a+b));//examples that tells how reduce works
    		
    		System.out.println("This "+ans);
    		
			int sumnew = IntStream
					.iterate(0, i -> i < myList.size(), i -> i + 2)
					.map(myList::get)
					.sum();
    		 
    		 System.out.println("sumnew -"+sumnew);
	        		 
	        		 //Syntax error on token ")", TypeElidedFormalParameter expected after this token
					
					Stream.iterate(new ArrayList<>(List.of(0)), listReference -> { return new ArrayList<>();})
										.limit(1);//avoid infinite loops
					Stream.iterate(new ArrayList<>(Arrays.asList(0)), listReference -> { return new ArrayList<>();})
										.limit(1);
					Stream.iterate(new Integer[]{0}, nIntArray -> new Integer[]{})
										.limit(1);
					Stream.iterate(new ArrayList<>(Arrays.asList(0)), listReference -> listReference)
										.limit(1)
										.forEach(System.out::println);
/*					
					Stream.iterate(new ArrayList<>(Arrays.asList(0)), listReference -> listReference.get(1))
					.limit(1)
					.forEach(System.out::println);
					
					Will give error as listReference.get(1) will not return a type same as ArrayList declared at the seed parameter
*/					
					Stream.iterate(new Integer[]{0}, nIntArray -> {nIntArray[0]= nIntArray[0] + nIntArray[1]; return nIntArray;})
					.limit(1)
					.forEach(nIntArray -> {
						System.out.println(Arrays.asList(nIntArray));
					});
					
					Stream.iterate(new Integer[]{0}, nIntArray -> {nIntArray[0]= nIntArray[0] + 2; return nIntArray;})
					.limit(10)
					.forEach(nIntArray -> {
						System.out.println("Over here -"+Arrays.asList(nIntArray));
					});
					
					/*
		Is re-initializing array elements 
[0]
[2]
[4]
[6]
[8]
[10]
[12]
[14]
[16]
[18]
					 * */
					System.out.println("------------------");
					Stream.iterate(new Integer[]{0}, nIntArray -> new Integer[]{nIntArray[0] + 2})//if u r lazy to return array explicitly
					.limit(10)
					.forEach(nIntArray -> {
						System.out.println(Arrays.asList(nIntArray));
					});
					
					
					System.out.println("00000000000000");
					Stream.iterate(new Integer[] {0,1}, nIntArray -> {
							nIntArray[0] =nIntArray[1]; nIntArray[1] = nIntArray[0]+ nIntArray[1]; return nIntArray; // adding in same array is chaotic
						})
						.limit(10)
						.map(nIntArray -> nIntArray[1])
						.forEach(nIntArray -> {
							System.out.println(Arrays.asList(nIntArray));
						});
					 
					

			        System.out.println("000000002222000000");
					Stream.iterate(new Integer[] {0,1}, nIntArray -> {
//							nIntArray[0] =nIntArray[1]; nIntArray[1] = nIntArray[0]+ nIntArray[1]; System.out.println("Intermediate - "+Arrays.asList(nIntArray)); return nIntArray;// adding in same array is chaotic
							return new Integer[] { nIntArray[1],  nIntArray[0]+ nIntArray[1]}; 
						})
						.limit(10)
						.map(nIntArray -> (nIntArray[1]*10)) //Send an Array to a map it will give Array(n) if u ask for it
						.forEach(nIntArray -> {
							System.out.println(nIntArray);
						});
	        		 
					
					System.out.println("0000000000000302333333330");
					 int ansIsThis = 0;
							 	Stream.iterate(new Integer[] {0,1}, newIntArray -> 
										{return new Integer[] {newIntArray[1], newIntArray[0]+newIntArray[1]};})
								 .limit(6)
								 .map(newIntArray -> newIntArray[1])
								 .forEach(System.out::println);
					
						ansIsThis = Stream.iterate(new Integer[] {0,1}, newIntArray -> 
								{return new Integer[] {newIntArray[1], newIntArray[0]+newIntArray[1]};})
						 .limit(6)
						 .map(newIntArray -> newIntArray[1])
						.reduce(0, (a,b)->(a+b));

					 System.out.println("ansIsThis="+ansIsThis);
	}
}
