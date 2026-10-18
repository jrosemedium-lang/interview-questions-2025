package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramVersionFour {
	public static void main(String[] args) {
		 List<String> anagrams = Arrays.asList(
				 	"pizza",
		            "listen", "silent",//"earth", "heart","admirer", "married","stressed", "desserts",
		            "angel", "glean"//,"elbow", "below","dusty", "study","save", "vase","act", "cat","night", "thing"
		        );
		
		 
		 LinkedHashMap<String, TreeMap<Character, Long>> myInnerMap = new LinkedHashMap<>();
		
		 
		 Function<String, TreeMap<Character,Long>> myCountMapBuilder = (myString) -> myString
				 			.chars()
				 			.mapToObj(ch -> (char)ch)
				 			.collect(Collectors.groupingBy(
				 					Function.identity(),//what should be the key
				 					TreeMap::new, //the type of final object to create
				 					Collectors.counting() //the count of key should be the value
				 					));
		 
//		 System.out.println(myCountMapBuilder.apply("pizza"));
		 
		 Consumer<String> myInnerMapFiller = (myString) ->  
		 			myInnerMap.put(myString, myCountMapBuilder.apply(myString)); //use a consumer to generate entries of map!
		 
		 
		 anagrams.stream().forEach(eachString -> myInnerMapFiller.accept(eachString));
		 
		 System.out.println("Map is=");
		 
		 System.out.println(myInnerMap);
		 
		 
		 myInnerMap.entrySet().stream().forEach(eachEntry -> {
			 String key = eachEntry.getKey();
			 TreeMap<Character, Long> valueMap = eachEntry.getValue();
			 Map.Entry<String,TreeMap<Character,Long>> answer = myInnerMap.entrySet().stream()
			     .filter(eachEntryInner -> {
			     String keyInner = eachEntryInner.getKey();
				 TreeMap<Character, Long> valueMapInner  = eachEntryInner.getValue();
				 if(!key.equals(keyInner) && Objects.deepEquals(valueMapInner, valueMap)) {
					 return true;
				 }
				 return false;
			 }).findFirst().orElseGet(() -> Map.entry("", new TreeMap<>()));
			 
			 System.out.println("Anagram Found - "+ key + "--" + answer);
		 });
	}
}
