package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class HackerRankExample1 {
	public static void main(String[] args) {
	List<Integer> myList = new ArrayList<>(Arrays.asList(12, 34, 23, 11, 41, 123));
		
		IntStream.range(0, myList.size())
						  .map(i -> myList.get(i))
						  .map(eachItem -> HackerRankExample1.countSumOfDigits(eachItem).apply(eachItem))
						  .boxed()
						  .collect(Collectors.toMap(
								  key -> key,
								  value -> 1,
								  Integer::sum,
								  LinkedHashMap::new
								  )).entrySet()
											.stream()
													.filter(eachEntry -> eachEntry.getValue() == 1)
													.map(eachEntry -> eachEntry.getKey())
													.collect(Collectors.toList())
															.stream()
																.sorted(Comparator.reverseOrder())
																.skip(1)
																.findFirst()
																.get();
			
	 }
	static Function<Integer, Integer> countSumOfDigits(Integer myInt){
		return (tempInt) ->{
			int myNum = myInt, sum = 0, temp = myNum;
			while(temp>0) {
				int r = temp % 10;
				sum = sum + r;
				temp = temp /10;
			}
			return sum;
		};
	}
}
