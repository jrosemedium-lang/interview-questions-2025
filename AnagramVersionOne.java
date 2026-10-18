package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramVersionOne {
	public static void main(String[] args) {
		//IBM Question
		 List<String> anagrams = Arrays.asList(
				 	"pizza",
		            "listen", "silent",//"earth", "heart","admirer", "married","stressed", "desserts",
		            "angel", "glean"//,"elbow", "below","dusty", "study","save", "vase","act", "cat","night", "thing"
		        );
		
		Map<String, String> myAnaMap = new HashMap();
		Map<String, List<Integer>> answerMap = new HashMap<String, List<Integer>>();		
		Map<String, List<Integer>> newAnaMap = new HashMap<>();
		
		//make a map of (String, List<Each char in String>)
		anagrams.stream().forEach((anagram) -> {
			newAnaMap.put(anagram, IntStream.range(0, anagram.length())
																					.map(i -> anagram.charAt(i))
																					.boxed()
																					.sorted()
																					.collect(Collectors.toList()));
		});
		System.out.println(newAnaMap);

		//Check two entries of string key with same List<Each char in String>
		newAnaMap.entrySet().forEach((entry) -> {
//			System.out.println("#"+entry.getKey());
			Optional<Map.Entry<String, List<Integer>>> myResult = 
					newAnaMap.entrySet().stream().filter((eachEntry) -> {
						return !eachEntry.getKey().equals(entry.getKey()) 
								&& eachEntry.getValue().containsAll(entry.getValue());
					}).findFirst();
			myAnaMap.put(entry.getKey(), myResult.isPresent() ? myResult.get().getKey() : "XX");
//			System.out.println("#");
		});
		
		System.out.println(myAnaMap);
	
		}
}
