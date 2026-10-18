package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class JavaStreamsWorking {
	public static void main(String[] args) {
		List<Integer> favouriteNumberList = Arrays.asList(6,2,1,5,3,9);
		
		
		/*----    MAP Operation On the stream ------------*/
		/*Create a function Object and reference... */
		Function<Integer,Integer> myDoubleFunction = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t*2;
			}
		};
		 Stream<Integer> favNumStream = favouriteNumberList.stream(); /*Generate a stream using a collection*/
		 Stream<Integer> doubleNumStream = favNumStream.map(myDoubleFunction);/*Map the stream to a Function to make changes in it*/
		 doubleNumStream.forEach(System.out :: print);/*Print the newly generated stream*/
		 System.out.println();
		 
		 /*The Functional Way of Java-8-Stream-Map*/
		 favouriteNumberList.stream()
											  .map( t -> { return t*2; })
											  .forEach(u -> System.out.println("Oh wow! This is totally like Javascript!  : " + u ));
											  
		 
		 
		/**
		 * Don't reuse the earlier streams(favNumStream, doubleNumStream)
		 * java.lang.IllegalStateException: stream has already been operated upon or closed 
		 * will occur
		 **/
		 
		 /*-------- STREAM REDUCE OPERATION --------*/
		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		 Stream<Integer> streamForReduction = favouriteNumberList.stream();
		 Object additionOfStream = streamForReduction.reduce(10, binaryOperator); /*needs a java-8-function which takes in 2 arguments*/ 
		 System.out.println("The stream is reduced : "+additionOfStream.toString()); /*result is same as 10+6+2+1+5+3+9*/
		 
		 /*The Functional Way of Java-8-Stream-Reduce*/
		 System.out.println(
				 favouriteNumberList
				 .stream()
				 .reduce(10, (t, u) -> {
					 return t + u;
				 }).toString()
	     );
		 
		 System.out.println(favouriteNumberList.toString());
		 
		 System.out.println(
				 favouriteNumberList
				 .stream()
				 .map(i -> i*2) 
				 .reduce(10, (c,e) -> Integer.sum(c, e)) /*The Lambda Expression  + Daisy Chaining Java-8-functional-Programming Style */
	     );
		 
		 System.out.println(favouriteNumberList.toString());
		 
		 System.out.println(
				 favouriteNumberList
							.stream().map(i -> i * 2)
							.reduce(10, Integer::sum)); /* The Method Reference + Daisy Chaining Java-8-functional-Programming Style*/
		 
		 
		 
	}
}
