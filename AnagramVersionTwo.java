package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramVersionTwo {
	public static void main(String[] args) {

		List<String> anagrams = Arrays.asList("pizza", "listen", "silent", "angel", "glean");
		//Two words are anagrams if their letters, when sorted, are identical
		// Step 1: Group words by their sorted characters
		Map<String, List<String>> groupedAnagrams =
				anagrams
				.stream().collect(Collectors.groupingBy(
				word -> word.chars().sorted()
								.mapToObj(c -> String.valueOf((char) c))
								.collect(Collectors.joining())
						));
			/**
			 * word.chars() --- get me a stream of integers generating from each char of this string
			 * .sorted() --- sort the stream of integers
			 * .mapToObj() --- convert the integer to char, char to string
			 * .collect(Collectors.joining()) --- join each string with each other respective to word, make key and collect
			 * 
			 * 
			 anagrams
				.stream().collect(Collectors.groupingBy(
				word -> word.chars().sorted()
								.mapToObj(c -> String.valueOf((char) c))
								.collect(Collectors.joining())
						));
			
			no downstream collector, only single Function passed, that means to groupingBy
			that here is the way to generate the key, value is the source from which the key is generated
			
			aipzz is generated from passed function, it is the key, value is pizza in List obj
			
			I am telling groupingBy how to generate the key. 
			Java automatically groups the original elements into lists under that key
			//simpler explanation -  Collectors.groupingBy(keyFn, Collectors.toList())


			the default value collector is toList().
			 * 
			 * 
			 */
		System.out.println(groupedAnagrams);System.out.println("666666666666");
		
		// Step 2: Create a mapping of each word to one of its anagrams
		Map<String, String> anagramMap = new HashMap<>();
		groupedAnagrams.forEach((key, value) -> {
			value.forEach(word -> { //value is a list, iterate on it!
				String match = value.stream().filter(wList -> !wList.equals(word)).findFirst().orElse("XX");
				anagramMap.put(word, match);
			});
		});
		
		System.out.println(anagramMap); System.out.println();
		// Step 3: Print the resulting anagram map
		/**
		 * Can i say -
			java8 streamy approach to iterate on map is to forget the world 
			and just take a map apply forEach directly 
			and it will accept a biConsumer with Key and Value available outofthebox
			Collections use Consumer — Maps use BiConsumer.
			
			anagramMap.forEach(System.out::println);

			 * Java 8 streams + Map API make iterating on a map super simple:
			 * 
			 * - You can forget about entrySet loops and iterators.
			 * - Just call map.forEach(...) directly.
			 * - It accepts a BiConsumer<Key, Value>, giving you both key and value out-of-the-box.
			 * 
			 * Quick mental rule:
			 *   Collections (List/Set) use Consumer<T> -> you get one element at a time.
			 *   Maps use BiConsumer<K, V> -> you get key and value directly.
		 * 
		 */
		anagramMap.forEach((wordKey, anagramValue) -> {
			if (!anagramValue.equals("XX")) {
				System.out.println(wordKey + " -> " + anagramValue);
			} else {
				System.out.println(wordKey + " has no anagram");
			}
		});
		
		System.out.println("----------------"
				+ "---Anything that returns a Collector can be used as a downstream collector."
				+ "--------------------");
		System.out.println();
		System.out.println(
				anagrams
				.stream().collect(Collectors.groupingBy(
				
				word -> word.chars().sorted()
								.mapToObj(c -> String.valueOf((char) c))
								.collect(Collectors.joining())//definition of key given, any two inputs passed generating the key automatically merge as objects for same generated key
								//,Collectors.groupingBy(Function.identity(),Collectors.toList())		was experimental and incorrect for anagram
								// The classifier defines the key.
					            // All stream elements producing the same key
					            // are automatically grouped into the same value List.
						))
				);
		
		System.out.println("---------------------------------------");
		////////////////////////////////////////////////////////
		
		String input1 = "listten";
		String input2 = "silentt";//Anagrams preserve character frequency
		System.out.println("---------------------before------------------");
		Function <String, LinkedHashMap<String, Long>> genMap = 
				(myString) -> myString.chars()
					.mapToObj(ch -> String.valueOf((char)ch))
					.collect(Collectors.groupingBy(
							Function.identity(), //the key is the input itself
							LinkedHashMap::new, //generate a linkedHashMap
							Collectors.counting() //value of linkedHashMap must be equal to occurrence of each letter
							));
		System.out.println("---------------------after------------------");
		System.out.println(genMap.apply(input1));
		 
		System.out.println(
				Objects.deepEquals(genMap.apply(input1), genMap.apply(input2))
		);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			Map<String, List<String>> myListyAnas =
					anagrams.stream().collect(Collectors.groupingBy(
							word -> word.chars().sorted()
											.mapToObj(letter ->String.valueOf((char)letter))
											.collect(Collectors.joining("-"))
							,Collectors.toList()
							));
			
			myListyAnas.entrySet().forEach(myAnas -> {
				System.out.println(myAnas);
			});
		
		
		
		
		
	}
}
