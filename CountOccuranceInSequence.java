package JavaCodingExamplePkg;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccuranceInSequence {
	public static void main(String[] args) {
		String input ="asdashdyasebsazjshsgd";
		Map<Character, Integer> myMap = new LinkedHashMap<>();
		
		System.out.println(
			input
			.chars()
			.mapToObj(i -> (char)i)
			.collect(Collectors.toMap(
					Function.identity(),
					c -> 1,
					Integer::sum,
					LinkedHashMap::new
					))
		);
		
		
		System.out.println(
				(input.chars()
				.mapToObj(ch -> (char) ch)
				.collect(Collectors.toMap(
						key -> key,
						v -> 1,
						Integer::sum,
						LinkedHashMap::new
						))).entrySet()
							.stream()
							.filter(eachEntry -> eachEntry.getValue() == 1).findFirst().get()
					);
		
		
		
		
		String input2 = "aabbcc";
		System.out.println(
		input2
			.chars()
			.mapToObj(ch -> (char) ch)
			.collect(Collectors.toMap(
					key -> key,
					value -> 1,
					Integer::sum,
					LinkedHashMap::new
					))
			.entrySet()
					.stream()
					.filter(eachEntry -> eachEntry.getValue() == 1)
					.findFirst()
					.orElseGet(() -> Map.entry('_', 0))
				);
	}
}
