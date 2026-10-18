package JavaCodingExamplePkg;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamInterviewQuestions {
	public static void main(String[] args) {
		//Bring the output where the list is partitioned - {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8]}
		List<Integer> intList = new ArrayList<>();
		intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Map<Boolean, List<Integer>>  partitionedMap =  intList.stream().collect(Collectors.partitioningBy(i -> i%2 == 0));
		System.out.println(partitionedMap);
		
		System.out.println();
		
		String inputString = "Vaishnavi";//count occurence of each letter
		Map<Character,Long> myMap = inputString.chars()
							 .mapToObj(c -> (char) c)
							 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(myMap);
		
		System.out.println();
		
		int n = 10;
		String result = IntStream.rangeClosed(1, n)
							    .mapToObj(Integer::toString)
							    .collect(Collectors.joining("x ", n + "! = ", ""));
							System.out.println(result);
		
		System.out.println();

		List<Integer> intList11 = new ArrayList<>();//Reverse Order - 19 , 18 , 17 , 16 , 15 , 14 , 13 , 12 , 11 , 
		intList11 = Arrays.asList(11,12,13,14,15,16,17,18,19, 20);		
		intList11.stream().sorted(Comparator.reverseOrder()).forEach(anyObj ->System.out.printf("%d , ",anyObj));
		
		System.out.println();//Print multiples of 5 in the list
		System.out.println();
		intList11.stream().filter(x -> (x % 5==0)).forEach(anyObj -> System.out.printf("%d ,", anyObj));
		
		IntStream.of(new int[] {1,2,3,4,5}).summaryStatistics().getMax();
		IntStream.of(new int[] {1,2,3,4,5}).summaryStatistics().getMin();
		IntStream.of(new int[] {1,2,3,4,5}).summaryStatistics().getCount();
		
		System.out.println();
		int myInt = intList11.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("2nd Bigjest Numer iz - "+myInt);
		
		System.out.println();
		
		System.out.println("Merge two unsorted arrays into a single array");
		
		int [] mySortedMergedArray = IntStream.concat(
					Arrays.stream(new int [] {12,45,3437,3334,223, 88 ,552,2,36}), 
					Arrays.stream(new int [] {21, 87 , 54, 88, 45, 321, 465, 2})
				).sorted().toArray();
		
		for (int j : mySortedMergedArray) {
			System.out.printf("%d , ",j);
		}
		
		int [] mySortedMergedDistinctArray = IntStream.concat(
				Arrays.stream(new int [] {12,45,3437,3334,223, 88 ,552,2,36}), 
				Arrays.stream(new int [] {21, 87 , 54, 88, 45, 321, 465, 2})
			).sorted().distinct().toArray();
		
		System.out.println();
		System.out.println("WITHOUT DUPLICATES Merge two unsorted arrays into a single array");
		
		for (int j : mySortedMergedDistinctArray) {
			System.out.printf("%d , ",j);
		}
		
		System.out.println();
		
		System.out.println();
		int sum = Arrays.stream(new int [] {12,45,3437,3334,223, 88 ,552,2,36}).sum();
		
		System.out.println("sum = "+ sum);
		
		System.out.println("/nReverse an Integer Array");
		
		int array[] = new int[] {12 ,454, 87 ,332, 454, 878,12}; 
		int newArray[] = IntStream.range(0, array.length)
						.map(i -> array[(array.length-1) - i])
						.toArray();
		for (int j : newArray) {
			System.out.printf("%d , ",j);
		}
		System.out.println();	System.out.println();

		
		
		System.out.println("Duplicate in Array  -"); 
		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> myListNew = new ArrayList();
		myListNew.add(10);		myListNew.add(10); 		myListNew.add(100);
		Set betterSet = myListNew.stream()
					.filter(i -> !set.add(i))
					.collect(Collectors.toSet());
		System.out.println(betterSet);
		System.out.println();
		
		
		
		System.out.println();
		IntStream.rangeClosed(0, 10);
		
		String palin = "malayalam";
		boolean answer = 
				IntStream.range(0, palin.length()/2)
				.noneMatch(i -> palin.charAt(i) != palin.charAt(palin.length() - i -1));
//				.noneMatch(i -> {System.out.println(palin.charAt(i)); return 1 == 1;});
//				.forEach(i -> {System.out.println(palin.charAt(i));});
		System.out.println(answer);
					
		boolean charAns = palin.chars().allMatch(each -> {System.out.println(each); return each == 1;});
		System.out.println(charAns);
		
		System.out.println();
		
		List<String>arrayList = Arrays.asList("Maya","1Daya","Via", "Jia");
		System.out.println(arrayList.stream().skip(arrayList.size()-1).toArray()[0]);
		arrayList.stream().filter(str -> Character.isDigit(str.charAt(0)))
						.forEach(System.out :: println);
		
		String hugeString = arrayList.stream().collect(Collectors.joining("|", "Starter -  ", "   <Termed"));
		System.out.println(hugeString);
		
		System.out.println();
		
		System.out.println("Age of person in Years");
		LocalDate birthdate = LocalDate.of(1928, 12, 9);
		LocalDate today = LocalDate.now();
		
		System.out.println(ChronoUnit.YEARS.between(birthdate, today));
		
		String s1 = "listen";
		String s2 = "silent";
		
//		for(String str:s1.split("")) {
//			System.out.println(str);
//		}
		
		System.out.println();
		
		String s1Res = Stream.of(s1.split(""))
				 .map(String::toUpperCase).sorted().collect(Collectors.joining());
		
		String s2Res = Stream.of(s2.split(""))
				 .map(String::toUpperCase).sorted().collect(Collectors.joining());

		System.out.println();
		System.out.println(s1Res);
		System.out.println(s2Res);
		
		System.out.println();
		
		System.out.println(
				IntStream.rangeClosed(1, 10).sum()
				);
		
		System.out.println("Number common in other list");
		
		 Optional<int[]> myRes = Arrays.asList(new int [] {12,45,3437,3334,223, 88 ,552,2,36})
					.stream()
					.filter(Arrays.asList(new int [] {12, 87 , 54, 88, 45, 321, 465, 2}) :: contains).findAny();

//		List<Integer> creepyList = Arrays.asList(new int [] {12,45,3437,3334,223, 88 ,552,2,36});
//		for (Integer intr : creepyList) {
//			System.out.println(intr.toString());
//		}
		
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
         
        list1.stream().filter(list2::contains).forEach(System.out::println);
        
        String strSentence = "This is a Sunday";
        
        String strSentenceToppled =  Arrays.stream(strSentence.split(" ")).map(word -> new StringBuffer(word).reverse())
        	.collect(Collectors.joining("-"));
        
        System.out.println(strSentenceToppled);
        
        Stream.iterate(new int[] {0,1}, f -> new int[] {f[1], f[0]+f[1]})
        		.limit(10)
        		.map(f -> f[0])
        		.forEach(i -> System.out.print(i + "  "));
	}
}
