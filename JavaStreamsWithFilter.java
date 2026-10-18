package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreamsWithFilter {
	public static void main(String[] args) {
		List<Integer> favNumList = Arrays.asList(11,12,20,22,40,42);
		
		/*Java-For-Each way of iterating using specific conditions*/
		System.out.println("1- Traditional java forEach approach :"+favNumList.toString());
		int result = 0;
		for(int i : favNumList)
			result = (i%5 == 0)? (result+i) : (result+0);
		
		System.out.println(result);
		
		/*Java-8 way of streaming a collection using filter*/
		System.out.println("\n2-Stream with Filter :"+favNumList.toString());
		System.out.println( 
											favNumList
															.stream()
															.filter(i -> (i % 5 == 0))
															.reduce(0, (c, e) -> c + e) );
		
		/*Java-8 way of streaming a collection using filter, sum of even numbers*/
		System.out.println("\n3-Stream with Filter(sum of even numbers) :"+favNumList.toString());
		System.out.println( 
											favNumList
															.stream()
															.filter(i -> (i % 2 == 0))
															.reduce(0, (c, e) -> c + e) );
		
		/*  Java-8 Predicates */
		Predicate<Integer> multipleOf5predicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				/* System.out.println("Inside Predicate: "+t); */
				return (t % 5 == 0) ? true : false;
			}
		};
		
		Predicate<Integer> multipleOf5predicateNew = (t) -> (t % 5 == 0) ? true : false;
			
	
		
		/*Java-8 way of streaming a collection using Filter With Predicate*/
		System.out.println("\n4-Filter With Predicate :"+favNumList.toString());
		System.out.println( 
											favNumList
															.stream()
															.filter(multipleOf5predicate)
															.reduce(0, (c, e) -> c + e) );
		
		
		/*Java-8 way of streaming a collection using Filter With Lambda Predicate*/
		System.out.println("\n5-Filter With Lambda Predicate New:"+favNumList.toString());
		System.out.println( 
											favNumList
															.stream()
															.filter(multipleOf5predicateNew)
															.reduce(0, (c, e) -> c + e) );
		
		/*Java-8 way of streaming a collection using Filter With Predicate +Lambda*/
		System.out.println("\n6-Filter With Predicate +Lambda :"+favNumList.toString());
		System.out.println( 
				favNumList
								.stream()
								.filter(i -> i%5 == 0)
								.reduce(0, (c, e) -> c + e) );

		System.out.println();
		System.out.println("7-Filter With Predicate +Lambda + findFirst() :"+favNumList.toString());
		System.out.println("8-First digit Divisible by five :" +
				favNumList
								.stream()
								.filter(i -> i%5 == 0)
								.findFirst().orElse(-1) );
		
		System.out.println("9-Any digit Divisible by 5 :" + 
				favNumList
								.stream()
								.filter(i -> i%5 == 0)
								.findAny().orElse(-1) );
		
		System.out.println("10-Any digit Divisible by 71 : " + 
				favNumList
								.stream()
								.filter(i -> i%71 == 0)
								.findAny().orElse(-1) );
		
		System.out.println();
		System.out.println("\n\n10.1-Any digit Divisible by 71 with lazy eval: " +
				favNumList
								.stream()
								.filter(i -> i%71 == 0)
								.findAny() );
		
		System.out.println();
		
		System.out.println("11-Method Reference with lazy eval: " +
				favNumList
								.stream()
								.filter(JavaStreamsWithFilter :: isDivisible)
								.map(JavaStreamsWithFilter :: mapDouble)
								.findAny().get() );
		
		
		System.out.println();
		System.out.println("12-Without Terminal operator they do no operation, Hence LAZY!\n " +
				favNumList
								.stream()
								.filter(JavaStreamsWithFilter :: isDivisible)
								.map(JavaStreamsWithFilter :: mapDouble)
								 );
		
		
		System.out.println();
		System.out.println();

		System.out.println("\n13-Stream with Filter :"+favNumList.toString());
		System.out.println("\n\n13-Map Example " +
				favNumList
								.stream()
								.map(JavaStreamsWithFilter :: mapDouble)
								.peek(System.out::println)
								.filter(JavaStreamsWithFilter :: isDivisible)
								.collect(Collectors.toMap((key)-> key+"_KEY", (value)->value))
								 );
		
		System.out.println("\n14-FlatMap Example for practice:\nfavList "+favNumList.toString());
		Map<String, List<Integer>> nestedCollection = new HashMap<>();
		favNumList.stream()
							.collect(Collectors.toMap((key)->"KEY_"+key, (value)->value*10));
	}
	public static boolean isDivisible(int i)
	{
		System.out.println("Inside isDivisible to 5 method : "+i+" Looking for next element...");
		return (i%5 == 0) ? true: false;
	}
	
	public static int mapDouble(int t)
	{
		System.out.println("Inside double method :"+t);
		return t*2;
	}
}
