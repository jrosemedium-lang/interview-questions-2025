package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;


public class GroupBySecrets {

	public static void main(String[] args) {
		String s1 = "listen";
		String s2 = "silent";
		
		List<String> words = Arrays.asList(
			    "eat", "tea", "tan", "ate", "nat", "bat",
			    "silent", "listen", "enlist", "google", "gogole"
			);
		
		TreeMap<Character, Long> lhm1 = GroupBySecrets.getLHM(s1);
		TreeMap<Character, Long> lhm2 = GroupBySecrets.getLHM(s2);
		
		Boolean result = Objects.deepEquals(lhm1, lhm2);
		System.out.println(result);
		
		/*
		 run LHM over a list of array items, and groupBy Function.identity, 
		 every word will have value for LHM, then step1 result would be 
		 LHM<String, LHM<Character, Long>>
		 * */
		TreeMap<String, TreeMap<Character, Long>> mapL1 = new TreeMap<>();
		TreeMap<String, List<String>> mapL2 = new TreeMap<>();
		TreeMap<String, List<String>> mapL3 = new TreeMap<>();
		TreeMap<String, List<String>> mapL4 = new TreeMap<>();
		words.stream().forEach(eachWord -> {
			mapL1.put(eachWord, GroupBySecrets.getLHM(eachWord));
		});
		
		System.out.println(mapL1 + "\n\n");
		
		mapL1.entrySet().stream().forEach(
				(eachEntryMain) ->{
					//find all keys for the values which match the value of main entry
					//put the keys found above in a list
					List<String> list = mapL1.entrySet().stream().filter(each -> Objects.deepEquals(each.getValue(), eachEntryMain.getValue()))
					.map(each -> each.getKey())
					.collect(Collectors.toList());					
					System.out.println(list);
					mapL3.put(list.get(0), list);
				}
				);
		;
		
		System.out.println("\n\n" + mapL3);
		
		
		
		String str = "cba";
		System.out.println(
				"cba becomes --- " +
						str.chars().mapToObj(ch -> (char) ch)
						.sorted(Comparator.naturalOrder())
						.map(ch -> Character.toString(ch)).collect(Collectors.joining())
				);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		words = Arrays.asList(
			    "eat", "tea", "tan", "ate", "nat", "bat",
			    "silent", "listen", "enlist", "google", "gogole"
			);
		System.out.println(
				words.stream().collect(Collectors.groupingBy(
						eachEntryKstr -> eachEntryKstr.chars().mapToObj(ch -> (char) ch)
						.sorted(Comparator.naturalOrder())
						.map(ch -> Character.toString(ch)).collect(Collectors.joining()), 
						TreeMap::new,
						Collectors.mapping(
								eachEntryVstr -> eachEntryVstr, 
								Collectors.toList())
						))
				);
		List<String> fruits = List.of("apple", "avocado", "banana", "blueberry", "cherry");

		Map<Character, List<String>> resultMap = fruits.stream()
		    .collect(Collectors.groupingBy(fruit -> fruit.charAt(0)));
		System.out.println(resultMap);
		
		resultMap = new HashMap<>();
		for (String fruit : fruits) {
		    char label = fruit.charAt(0);
		    resultMap.computeIfAbsent(label, k -> new ArrayList<>()).add(fruit);
		}
		System.out.println(result);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println(
				words.stream().collect(Collectors.groupingBy(
						eachEntryKstr -> eachEntryKstr.chars().mapToObj(ch -> (char) ch)
						.sorted(Comparator.naturalOrder())
						.map(ch -> Character.toString(ch)).collect(Collectors.joining()), 
						TreeMap::new,
						Collectors.toList()
						))
				);

	}
	
	public static TreeMap<Character, Long> getLHM(String str) {
		return str.chars().mapToObj(ch -> (char) ch).collect(
				Collectors.groupingBy(Function.identity(),
						TreeMap::new,
						Collectors.counting()
						)
				);
	}
	
	public static Boolean areLHMsDeepEqual(TreeMap<Character, Long> lhm1, TreeMap<Character, Long> lhm2) {
		return Objects.deepEquals(lhm1, lhm2);
	}

}
